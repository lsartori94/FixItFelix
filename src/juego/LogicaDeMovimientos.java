package juego;
import java.util.Timer;
import java.util.TimerTask;

import misc.Direccion;
import entorno.Ladrillo;
import entorno.Mapa;
import entorno.Pato;
import personajes.Felix;
import personajes.Ralph;

public class LogicaDeMovimientos extends TimerTask {
	private boolean stop;
	private int vuelta;
	private boolean hayPato;
	private Timer timer;
	private Ralph ralph;
	private Pato pato;
	private Felix felix;
	private Mapa map;
	
	public LogicaDeMovimientos(Timer timr){
		this.timer= timr;
		vuelta= 0;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(!stop){
			if(map.getRotas() != 0){
				vuelta= vuelta+1;
				if(hayPato){
					hayPato= moverPato() ;
				}
				Direccion dirRan= (Math.random() < 0.5) ? Direccion.LEFT : Direccion.RIGHT;
				moverRalph(dirRan);
				if(vuelta%2 == 0){
					ralph.shoot();
				}
				checkColisiones();
			}else{
				stop=true;
			}
		}
		timer.cancel();
	}
	
	/**
	 * Metodo que se encarga de mover a Ralph
	 * @param dir = direccion a la que se mueve
	 */
	private void moverRalph(Direccion dir){
		switch(dir.getValue()){
		case 0:
			if(ralph.getPosicion().getX()<3){
				ralph.move(Direccion.RIGHT);
			}else if((ralph.getPosicion().getX()) == 3){
				ralph.move(Direccion.RIGHT);
			}
		break;
		case 1:
			if(ralph.getPosicion().getX()>1){
				ralph.move(Direccion.LEFT);
			}else if(ralph.getPosicion().getX()==1){
				ralph.move(Direccion.LEFT);
			}
		}
	}

	/**
	 * Metodo que se encarga de mover al pato
	 * @return true= se movio. false= pato salio del mapa
	 */
	private boolean moverPato(){
		boolean bol= false;
		if(pato.derecha()){
			bol= pato.mover(Direccion.LEFT);
		}else{
			bol= pato.mover(Direccion.RIGHT);
		}
		return bol;
	}

	/**
	 * Metodo que controla las colisiones de ladrillos con felix y los hace caer
	 */
	private void checkColisiones(){
		int l_act= ralph.getLadrilloAct();
		//evalua los ladrillos tirados para ver si golpearona felix
		for(int i= 0; i < l_act; i++){
			Ladrillo lad= ralph.getLadrillo(i);
			if(lad.getPosicionl().compareTo(felix.getPosicion())==0)
				stop= felix.golpe();
			lad.caer();
		}
	}
}
