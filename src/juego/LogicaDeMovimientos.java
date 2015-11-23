package juego;
import java.util.Timer;
import java.util.TimerTask;

import misc.Direccion;
import entorno.Pato;
import personajes.Ralph;

public class LogicaDeMovimientos extends TimerTask {
	private boolean stop;
	private int vuelta;
	private boolean hayPato;
	private Timer timer;
	private Ralph ralph;
	private Pato pato;
	
	public LogicaDeMovimientos(Timer timr){
		this.timer= timr;
		vuelta= 0;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(!stop){
			vuelta= vuelta+1;
			if(hayPato){
				hayPato= moverPato() ;
			}
			Direccion dirRan= (Math.random() < 0.5) ? Direccion.LEFT : Direccion.RIGHT;
			moverRalph(dirRan);
			if(vuelta%2 == 0){
				ralph.shoot();
			}
			for(int i= 0; i < ralph.getLadrilloAct(); i++){
				ralph.getLadrillo(i).caer();
			}
		}
		timer.cancel();
	}
	
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

	private boolean moverPato(){
		boolean bol= false;
		if(pato.derecha()){
			bol= pato.mover(Direccion.LEFT);
		}else{
			bol= pato.mover(Direccion.RIGHT);
		}
		return bol;
	}
	
}
