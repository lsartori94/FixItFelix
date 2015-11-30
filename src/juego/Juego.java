package juego;
import java.util.Timer;
import misc.*;
import personajes.Felix;
import personajes.Ralph;
import entorno.*;
/**
 * Clase que representa la entidad Juego que controla todo.
 * Conoce a Ralph, a Felix y al mapa.
 * Conoce los puntajes, el tiempo y los historiales de puntajes.
 * 
 * @author lsartori Agustín Liébana
 *
 */
public final class Juego {
	private Ralph ralph;
	private Felix felix;
	private Mapa mapa;
	private double factVentRota = 0.2;
	private double factObsVent = 0.1;
	private int cantRota;
	private int indiceSec;
	private int level = 0;
	private int obstaculos;
	int filas= 5;
	int colum= 5;
	private int puntaje= 0;
	private double vel = 1;
	private HighScores highscores;
	boolean gameon = true;
	private EstadoJuego estado;
	int iSec = 0;
	int vidaTot;
	private final int vidaInicial = 3000;
	Posicion tmp, posR;
//	private Seccion [] sec;

	/**
	 * Es el metodo que da el esqueleto a la prueba.
	 * Es un loop del cual se sale si ralph se queda sin ladrillos o si felix muere.
	 * Cada iteracion del loop representa un turno de movimientos.
	 * Primero fuera del loop se inicia el mapa y los personajes.
	 * Cada iteracion es un lanzamiento de ladrillo de Ralph, un martilleo de Felix (si la ventana esta rota)
	 * un movimiento de Felix, un movimiento de Ralph y un chequeo de condiciones.
	 */
	
	private void checkColisiones(){
		int l_act= ralph.getLadrilloAct();
		//evalua los ladrillos tirados para ver si golpearona felix
		for(int i= 0; i < l_act; i++){
			Ladrillo lad= ralph.getLadrillo(i);
			lad.caer();
			if(lad.getPosicionl().compareTo(felix.getPosicion())==0){
				felix.golpe();
				System.out.println("Ladrillazo en "+felix.getPosicion().getX()+" * "+felix.getPosicion().getY());
			}
		}
	}
	
	public void go() {
			
		tmp = new Posicion(0,1);
		//Timer tim= new Timer();
		//LogicaDeMovimientos timer= new LogicaDeMovimientos(tim);
		//tim.schedule(timer, 0, levelRate);
		vidaTot = vidaInicial;
		felix= new Felix();
		felix.setVidas(vidaInicial);
		posR= new Posicion(0, 4);
		ralph= new Ralph( posR );
		
		comenzar(level);
		
		while ( gameon ){
			
			iniPersonajes(iSec);
					
			while( gameon && (felix.getVidas() > 0) && (mapa.getSeccion(iSec).getCantRotas() > 0) ){
				ralph.shoot();
				if(mapa.getSeccion(iSec).getVentana(felix.getPosicion()).rota()){
					fMartillar();
				}else{
					fMove();
				}
				checkColisiones();
			}
			
			if( felix.getVidas() > 0 ){
				if( iSec < 2 ){
					iSec++;
				}else if( level < 9 ){
					pasarNivel();
				}else
					win();
			}else 
				gameover();
		}
	}
	
	public void iniPersonajes(int secc){
		System.out.println("Level "+level+", seccion "+iSec);
		System.out.println("Se van a inicializar Felix y Ralph");
		felix.iniciar(mapa.getSeccion(secc));
		//felix.setPosicion(posR);
		System.out.println(" ");
		System.out.println("Felix se creo en la posicion "+felix.getPosicion().getX()+", "+felix.getPosicion().getY()+" con "+felix.getVidas()+" vidas");
		System.out.println("Poder de Felix= "+felix.Poder());
		ralph.newLevel( vel, mapa.getSeccion(secc) );
		System.out.println(" ");
		System.out.println("Ralph se inicio en la Seccion " +ralph.getSeccion().getId()+ " en la posicion "+ralph.getPosicion().getX()+ ", "+ralph.getPosicion().getY());
		System.out.println("Ralph tiene "+ralph.getCantLadrillos()+ " ladrillos, con una velocidad de lanzamiento de "+ralph.getVelocidad());
		System.out.println("Ralph se mueve on velocidad "+ralph.getVelocidad());
	}
	

	/**
	 *Inicia el mapa y los personajes.
	 *Posee una cantidad de filas y columnas.
	 *Check es una variable de Random para el seteo de las ventanas rotas.
	 *Hay un contador de ventanas rotas para el control.
	 *
	 * ACLARACION
	 * Si bien la seccion correspondiente de ventanas es de 3*5 nosotos
	 * utilizamos 5*5 porque sumamos una fila exclusiva de moviento de ralph(fila 4)
	 * y una fila de "desechos de ladrillos" (fila 0) para que caigan a una seccion
	 * a la que no puede ir felix.
	 * Felix se desplaza por las filas 1 a 3
	 * i= filas; j= columnas
	 * 
	 * Las 2 iteraciones anidadas corresponden a los indices de la matriz de ventanas.
	 * Cuando check es <0.5 las ventanas se inicilizan rotas. Caso contrario sanas.
	 * A su vez cuando j=2 e i=1 y i=2 se intancian puerta y balcon respectivamente.
	 * Luego se suman las ventanas rotas.
	 * 
	 * Se crea una seccion unica con esa matriz , luego con eso el mapa.
	 * Finalmente se instancian felix y ralph.
	 */
	
	private void comenzar(int lvl){
		// codigo a ejecutar para iniciar el juego
		
		estado = EstadoJuego.INGAME;
		
		if( lvl > 0 && lvl < 10){
			factVentRota = factVentRota * Math.pow((1+0.15),lvl);
			factObsVent = factObsVent * Math.pow((1+0.15),lvl);
			vel = vel * Math.pow((1+0.15),lvl);
		}
		System.out.println("Factoriales "+factVentRota+" , "+factObsVent);
		
		Seccion [] sec= new Seccion [3];
		//sec = sec2;
		for(indiceSec = 0; indiceSec < 3; indiceSec++){
			System.out.println("Seccion "+indiceSec);
			Ventana [][] ventanas = inicializarVentanas();
			sec[indiceSec]= new Seccion((filas - 2), colum, cantRota, obstaculos, ventanas, indiceSec);
		}
		Mapa map = new Mapa(sec, lvl);
		mapa = map;   //atada con alambre
	}
	
	private Ventana [][] inicializarVentanas(){
		double check, check2;
		cantRota = 0;
		int maceta = 0;
		int moldura = 0;
		int hoja = 0;
		Coin luck;
		Hoja oja;
		
		
		Ventana [][] vent = new Ventana[colum][filas];
		for(int i=1; i<filas-1; i++){
				for(int j=0; j<colum; j++){
					check = Math.random();
					check2 = Math.random();
					luck = Coin.getRandom();
					if(check > factVentRota){
						if(j == 2){
							if(i == 1 ){
								if(indiceSec == 0){
									vent[j][i]= new Puerta(false);
									System.out.println("Puerta sana creada en "+j+" , "+i);
								}
							}else if(i == 2){
								if(indiceSec == 0){
									vent[j][i]= new Balcon(false);
									System.out.println("Balcon sano creado en "+j+" , "+i);
								}
							}else if( check2 <= factObsVent ){
								switch( luck ){
									case MOLDURA:
										vent[j][i]= new DoblePanel( true, false, false);
										moldura++;
										break;
									
									case MACETA:
										vent[j][i]= new DoblePanel( false, true, false);
										maceta++;
										break;
									
									case HOJA:
										oja = Hoja.getRandom();
										vent[j][i]= new DoblePanel( false, false, false);
										vent[j][i].setHoja(oja);
										if( oja != Hoja.NO )
											hoja++;
										break;
									
									default:
										System.out.println("Error en el tipo de HOJA al crear.");
									}
							}else
								vent[j][i]= new DoblePanel( false, false, false);
						}else if( check2 <= factObsVent ){
							switch( luck ){
								case MOLDURA:
									vent[j][i]= new DoblePanel( true, false, false);
									moldura++;
									break;
							
								case MACETA:
									vent[j][i]= new DoblePanel( false, true, false);
									maceta++;
									break;
							
								case HOJA:
									oja = Hoja.getRandom();
									vent[j][i]= new DoblePanel( false, false, false);
									vent[j][i].setHoja(oja);
									if( oja != Hoja.NO )
										hoja++;
									break;
							
								default:
									System.out.println("Error en el tipo de HOJA al crear.");
								}
						}else
							vent[j][i]= new DoblePanel( false, false, false);							
					}else{
						if(j == 2){
							if(i == 1){
								if(indiceSec == 0){
									vent[j][i]= new Puerta(true);
									System.out.println("Puerta rota creada en "+j+" , "+i);
								}
							}else if(i == 2){
								if(indiceSec == 0){
									vent[j][i]= new Balcon(true);
									System.out.println("Balcon roto creado en "+j+" , "+i);
								}
							}else if( check2 <= factObsVent ){
								switch( luck ){
									case MOLDURA:
										vent[j][i]= new DoblePanel( true, false, true );
										moldura++;
										break;
								
									case MACETA:
										vent[j][i]= new DoblePanel( false, true, true );
										maceta++;
										break;
								
									case HOJA:
										vent[j][i]= new DoblePanel( false, false, true );
										vent[j][i].setHoja(Hoja.NO);
										break;
								
									default:
										System.out.println("Error en el tipo de HOJA al crear.");
									}
							}else
								vent[j][i]= new DoblePanel( false, false, true);
							
						}else if( check2 <= factObsVent ){
							switch( luck ){
								case MOLDURA:
									vent[j][i]= new DoblePanel( true, false, true );
									moldura++;
									break;
							
								case MACETA:
									vent[j][i]= new DoblePanel( false, true, true );
									maceta++;
									break;
							
								case HOJA:
									vent[j][i]= new DoblePanel( false, false, true );
									vent[j][i].setHoja(Hoja.NO);
									break;
							
								default:
									System.out.println("Error en el tipo de HOJA al crear.");
								}
						}else
							vent[j][i]= new DoblePanel( false, false, true);
						cantRota++;
					}
			}
			obstaculos = moldura + maceta + hoja;
		}
		System.out.println("Se crearon "+moldura+" ventanas con molduras, "+maceta+" con macetas y "+hoja+" con hojas.");
		System.out.println("De las cuales "+cantRota+" estan rotas (contando puerta y balcon)");
		return vent;
	}
	
	private final void pasarNivel(){
		// codigo a ejecutar para pasar de nivel
		level++;
		iSec = 0;
		felix.setVidas(felix.getVidas()+1);
		comenzar(level);
	}

	private final void gameover(){
		//codigo a ejecutar al perder
		gameon = false;
		estado = EstadoJuego.GAMEOVER;
		int vfinal= vidaTot - felix.getVidas();
		System.out.println("Ralph acerto "+vfinal+ " ladrillos luego de lanzar "+(50-ralph.getCantLadrillos()));
		System.out.println("Fin de simulacion.");
//		ejecutar grafica de fin de juego perdedor
	}

	private final void win(){
		estado = EstadoJuego.WIN;
		gameon = false;
		//codigo a ejecutar al ganar el juego
//		ejecutar grafica de fin de juego ganador
	}

	/**
	 * Metodo que reliza los movimientos de Felix.
	 * Los movimientos son en base a lo indicado, del centro a la derecha
	 * en el piso 1 y luego recorre el piso 2 hacia izquierda y el 3 a derecha.
	 * Si uno aumenta las vidas de Felix en sus atributos
	 * se puede llegar al punto del fin de recorrido. En ese caso Felix no se moviliza
	 * y se avisa por consola. Igualmente la simulacion termina cuando Felix muera
	 * o cuando Ralph no tenga mas ladrillos.
	 */
	private void fMove(){
		if(felix.getPosicion().getY() < 4 ){
			if(felix.getPosicion().getY() % 2 != 0){
				if(felix.getPosicion().getX()<4){
					felix.move(Direccion.RIGHT);
				}else if(felix.getPosicion().getX()==4){
					if(felix.getPosicion().getY()==3){
						if(mapa.getSeccion(iSec).getCantRotas() > 0){
							felix.setPosicion(tmp);
							System.out.println("Felix regreso a 0 * 1.");
						}
						//gameon = false;
						//System.out.println("Felix llego al final de su recorrido.");
					}else{
						felix.move(Direccion.UP);
					}
				}
				}else{
				if(felix.getPosicion().getX()>0 ){
					felix.move(Direccion.LEFT);
				}
				else if((felix.getPosicion().getX()) == 0){
					felix.move(Direccion.UP);
				}
			}
		}
	}

	/**
	 * Metodo que realiza el martilleo de felix y el arreglo de ventana
	 * Suma al puntaje el puntaje de arreglar la ventana
	 */
	private void fMartillar(){ 
		felix.martillar();
		felix.getSec().getVentana(felix.getPosicion()).setPuntaje(puntaje+1);
	}
		
	public void setEstado( EstadoJuego status){
		estado = status;
	}
	
	public EstadoJuego getEstado(){
		return estado;
	}
}
