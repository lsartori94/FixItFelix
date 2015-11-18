package juego;
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
	private int d = 0;
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
//	private Tiempo tiempo;
	private HighScores highscores;

	/**
	 * Es el metodo que da el esqueleto a la prueba.
	 * Es un loop del cual se sale si ralph se queda sin ladrillos o si felix muere.
	 * Cada iteracion del loop representa un turno de movimientos.
	 * Primero fuera del loop se inicia el mapa y los personajes.
	 * Cada iteracion es un lanzamiento de ladrillo de Ralph, un martilleo de Felix (si la ventana esta rota)
	 * un movimiento de Felix, un movimiento de Ralph y un chequeo de condiciones.
	 */
	public void go() {
	
		comenzar();
		while(ralph.getCantLadrillos() != 0){
			ralph.shoot();
			if(mapa.getSeccion(0).getVentana(felix.getPosicion()).rota()){
				fMartillar();
			}else{
				fMove();
			}
				rMove();
			if(checkGameFin())
				break;
			System.out.println("");
		}
		int vfinal= felix.vidasInicio-felix.getVidas();
		System.out.println("Ralph acerto "+vfinal+ " ladrillos luego de lanzar "+(50-ralph.getCantLadrillos()));
		System.out.println("Fin de simulacion.");
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
	private void comenzar(){
		// codigo a ejecutar para iniciar el juego
		
		if( level > 0 && level < 10){
			factVentRota = factVentRota * Math.pow((1+0.15),level);
			factObsVent = factObsVent * Math.pow((1+0.15),level);
		}
		System.out.println("Factoriales "+factVentRota+" , "+factObsVent);
		
		Seccion [] sec= new Seccion [3];
		for(indiceSec = 0; indiceSec < 3; indiceSec++){
			System.out.println("Seccion "+indiceSec);
			Ventana [][] ventanas = inicializarVentanas();
			sec[indiceSec]= new Seccion((filas - 2), colum, cantRota, obstaculos, ventanas, indiceSec);
		}
		mapa= new Mapa(sec, 3);
		//mapa= map;   //atada con alambre
				
		System.out.println("");
		System.out.println("Se va a inicializar Felix");
		
		felix= new Felix();
		felix.iniciar();
		
		Posicion posR= new Posicion(0, 4);
		ralph= new Ralph(50, 1, 1, 1, posR, sec[0]);

	}
	
	private Ventana [][] inicializarVentanas(){
		double check, check2;
		cantRota = 0;
		int maceta = 0;
		int moldura = 0;
		int dobleObs = 0;
		
		Ventana [][] vent = new Ventana[colum][filas];
		for(int i=1; i<filas-1; i++){
				for(int j=0; j<colum; j++){
					check = Math.random();
					check2 = Math.random();
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
							}else{
								vent[j][i]= new DoblePanel(check2 <= factObsVent,check >= (1-factObsVent), false);
								if(check2 <= factObsVent)
									if(check >= (1-factObsVent))
										dobleObs++;
									else
										moldura++;
								else if(check >= (1-factObsVent))		
									maceta++;	
							}
						}else{
							vent[j][i]= new DoblePanel(check2 <= factObsVent,check >= (1-factObsVent), false);
							if(check2 <= factObsVent)
								if(check >= (1-factObsVent))
									dobleObs++;
								else
									moldura++;
							else if(check >= (1-factObsVent))		
								maceta++;	
						}
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
							}else{
								vent[j][i]= new DoblePanel(check2 <= factObsVent,check >= (1-factObsVent), false);
								if(check2 <= factObsVent)
									if(check >= (1-factObsVent))
										dobleObs++;
									else
										moldura++;
								else if(check >= (1-factObsVent))		
									maceta++;	
							}
						}else{
							vent[j][i]= new DoblePanel(check2 <= factObsVent,check >= (1-factObsVent), false);
							if(check2 <= factObsVent)
								if(check >= (1-factObsVent))
									dobleObs++;
								else
									moldura++;
							else if(check >= (1-factObsVent))		
								maceta++;	
						}
						cantRota++;
					}
			}
			obstaculos = moldura + maceta + dobleObs;
		}
		System.out.println("Se crearon "+moldura+" ventanas con molduras, "+maceta+" con macetas y "+dobleObs+" con doble obstaculo.");
		System.out.println("De las cuales "+cantRota+" estan rotas (contando puerta y balcon)");
		return vent;
	}

	private final void pasarNivel(){
		// codigo a ejecutar para pasar de nivel
	}

	private final void gameover(){
		//codigo a ejecutar al perder
	}

	private final void win(){
		//codigo a ejecutar al ganar el juego
	}

	/**
	 * Metodo que chequea los golpes a felix, y hace que los ladrillos caigan
	 * de a 1 piso.
	 * Si se descomenta la linea 150 se puede obtener en consola un log de caida
	 * de los ladrillos.
	 * 
	 * @return devuelve si se debe finalizar la simulacion (felix muere)
	 */
	private boolean checkGameFin(){
		int l_act= ralph.getLadrilloAct();
		//evalua los ladrillos tirados para ver si golpearona felix
		for(int i= 0; i < l_act; i++){
			Ladrillo lad= ralph.getLadrillo(i);
			//System.out.println("Posicion del ladrillo "+i+" "+lad.getPosicionl().getX()+" "+lad.getPosicionl().getY());
			if(lad.getPosicionl().compareTo(felix.getPosicion())==0){
				felix.golpe();
			}
			if(felix.getVidas() == 0)
				return true;
			lad.caer();
		}
		return false;
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
						System.out.println("Felix llego al final de su recorrido.");
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
	 * Metodo que realiza los movimientos de Ralph.
	 * Recorre toda la fila 4 (exclusiva de Ralph)
	 */
	private void rMove(){
	switch( d ){
		case 0:
			if(ralph.getPosicion().getX()<3){
				ralph.move(Direccion.RIGHT);
			}else if((ralph.getPosicion().getX()) == 3){
				ralph.move(Direccion.RIGHT);
				d = 1;
			}
			break;
		case 1:
			if(ralph.getPosicion().getX()>1){
				ralph.move(Direccion.LEFT);
			}else if(ralph.getPosicion().getX()==1){
				ralph.move(Direccion.LEFT);
				d = 0;
			}
	}
	}

	/**
	 * Metodo que realiza el martilleo de felix y el arreglo de ventana
	 * Suma al puntaje el puntaje de arreglar la ventana
	 */
	private void fMartillar(){
		puntaje=puntaje + felix.martillar();
	}
}
