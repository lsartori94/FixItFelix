package juego;
import misc.*;
import personajes.Felix;
import personajes.Ralph;
import entorno.*;

public final class Juego {
	private Ralph ralph;
	private Felix felix;
	private int d = 0;
	private Mapa mapa;
//	private Puntaje puntaje;
//	private Tiempo tiempo;
//	private Highscore highscores;

	public void go() {
		// TODO Auto-generated method stub
		comenzar();
		while(true){
			ralph.shoot();
			if(mapa.getSeccion(0).getVentana(felix.getPosicion()).rota()){
				f_martillar();
			}else{
				f_move();
			}
				r_move();
			if(checkGameFin())
				break;
			System.out.println("");
		}
	}

	private void comenzar(){
		// codigo a ejecutar para iniciar el juego
		int filas= 5;
		int colum= 5;
		Ventana [][] vent = new Ventana[colum][filas];
		for(int i=1; i<filas-1; i++){
			for(int j=0; j<colum; j++){
				if(j % 2 == 0)
					vent[j][i]= new Doble_panel(false, false, false);
				else
					vent[j][i]= new Doble_panel(false, false, true);

			}
		}
		System.out.println("Se crearon "+(filas*colum)+" ventanas de doble panel sin modificadores");
		
		Seccion [] sec= new Seccion [1];
		sec[0]= new Seccion(3,5,7,0, vent);
		Mapa map= new Mapa(sec, 1);
		mapa= map;
				
		System.out.println("");
		System.out.println("Se va a inicializar Felix");
		
		felix= new Felix();
		felix.iniciar();
		
		Posicion posR= new Posicion(0, 4);
		ralph= new Ralph(50, 1, 1, 1, posR, sec[0]);

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

	private boolean checkGameFin(){
		int l_act= ralph.getLadrillo_act();
		//evalua los ladrillos tirados para ver si golpearona felix
		for(int i= 0; i < l_act; i++){
			Ladrillo lad= ralph.getLadrillo(i);
			System.out.println("Posicion del ladrillo "+i+" "+lad.getPosicionl().getX()+" "+lad.getPosicionl().getY());
			if(lad.getPosicionl().compareTo(felix.getPosicion())==0){
				felix.golpe();
			}
			if(felix.getVidas() == 0)
				return true;
			lad.caer();
		}
		return false;
	}

	private void f_move(){
		if(felix.getPosicion().getY() < 4 ){
			if(felix.getPosicion().getY() % 2 != 0){
				if(felix.getPosicion().getX()<4){
					felix.move(Direccion.RIGHT);
				}else if(felix.getPosicion().getX()==4)
					felix.move(Direccion.UP);
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

	private void r_move(){
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

	private void f_martillar(){
		felix.martillar();
		mapa.getSeccion(0).getVentana(felix.getPosicion()).arreglar();
	}
}
