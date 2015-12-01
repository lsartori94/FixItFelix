package misc;
/**
 * Esta clase representa los estados de juego
 * @author Luca Sartori, Agutín Liébana
 *
 */
public enum EstadosJuego {
	ONMENU(0),
	INSTRUCCIONES(1),
	HIGHSCORE(2),
	INGAME(3),
	WIN(4),
	GAMEOVER(5);
	
	private int value;
	
	public int getValue(){
		return value;
	}
	
	private EstadosJuego(int v){
		this.value = v;
	}
}
