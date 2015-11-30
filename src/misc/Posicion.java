package misc;

/*
 * Esta clase se encarga simplemente mantener el estado y proveer 
 * los metodos necesarios para manejar las posiciones de los demas
 * objetos. Se incluye un comparador para poder hacer los checkeos.
 * 
 * @author Agustín Líebana lsartori
 */
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
	public void setX(int x2) {
		x = x2;
	}

	//devuelve posicion vertical
	public int getY() {
		return y;
	}

	//setea posicion vertical
	public void setY(int y2) {
		y = y2;
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
	
	public void clone( Posicion clon ){
		clon = new Posicion(x,y);
		//clon = temp;
	}

}
