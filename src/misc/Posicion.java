package misc;

public class Posicion implements Comparable<Posicion>{
	private int x;	//posicion horizontal
	private int y;	//posicion vertical
	
	//inicia posicion
	public Posicion(int col, int fil){
		setX(col);
		setY(fil);
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

	//si son iguales devuelve 0, caso contrario es indistinto
	public int compareTo(Posicion o) {
		// TODO Auto-generated method stub
		if(x == o.x){
			if(y == o.y)
				return 0;
		}
		return -1;
	}

}
