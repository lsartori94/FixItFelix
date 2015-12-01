package juego;
import java.util.Timer;
import java.util.TimerTask;

import personajes.Ralph;
import userInterface.Renderizable;

public class LogicaDeLadrillos extends TimerTask {
	private Ralph ralphie;
	private boolean stop= false;
	private Renderizable render;
	private Timer timer;
	
	public LogicaDeLadrillos(Timer timr){
		this.timer= timr;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(!stop){
			for(int i=0; i<ralphie.getCantLadrillos(); i++){
				ralphie.getLadrillo(i).caer();
				if(ralphie.getLadrillo(i).getDestruir() == true)
					//render.setDestruirLadrillo(true);
				if(ralphie.getLadrilloAct() == ralphie.getCantLadrillos()-1)
					stop= true;
			}
		}
		timer.cancel();
	}

}
