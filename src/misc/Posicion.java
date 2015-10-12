package misc;

public class Posicion {
	private int x;	//posicion horizontal
	private int y;	//posicion vertical
	
	//inicia posicion
	public Posicion(int col, int fil){
		setX(fil);
		setY(col);
	}

	//devuelve posicion horizontal
	public int getX() {	
		return x;
	}


	//setea posicion horizontal
	public void setX(int x) {
		this.x = x;
	}

	//devuelve posicion vertical
	public int getY() {
		return y;
	}

	//setea posicion vertical
	public void setY(int y) {
		this.y = y;
	}

}
