package personajes;

public class Ralph {

	// falta agregar posicion 
	private int cant_ladrillos;
	private int time_ladrillo;
	private int velocidad;
	private Ladrillo ladrillo;
	private Sprite imagen;
	private Seccion seccion;
	private Posicion posicion;

	public void mover(Direccion dir){
		
	}

	public void shoot(){
		
	}

	public int getPosicion(){
		return posicion;
	}

	public Sprite getImagen(){
		return imagen;
	}

	public int getCantLadrillos(){
		return cant_ladrillos;
	}

	public int getTimeLadrillo(){
		return time_ladrillos;
	}

	public int getVelocidad(){
		return velocidad;
	}

	public void setPosicion(Posicion pos){
		posicion= pos;
	}

	public void setImagen(Sprite img){
		imagen= img;
	}

	public void setCantLadrillos(int lad){
		cant_ladrillos= lad;
	}

	public void setTimeLadrillo(int tlad){
		time_ladrillo= tlad;
	}

	public void setVelocidad(int vel){
		velocidad= vel;
	}

}