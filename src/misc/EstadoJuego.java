package misc;

public enum EstadoJuego {
		GAMEOVER(0),
		WIN(1),
		INGAME(2),
		MENU(3),
		HIGHSCORE(4),
		HELP(5);
	
		private int value;
	
		public int getValue(){
			return value;
		}
	
		private EstadoJuego(int v){
			this.value = v;
		}
}
