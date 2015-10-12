package entorno;
import misc.Posicion;

public class Ladrillo {
	private Posicion posicion;
	private int velocidad;

	public Posicion getPosicion() {
		return posicion;
	}

	//metodo a ejecutar para mover al ladrillo
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public int getVelocidad() {
		return velocidad;
	}

	//metodo para definir velocidad de caida del ladrillo
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	//metodo a ejecutar para que el ladrillo caiga un piso
	public void caer(){
		Posicion tmp_pos= getPosicion();
		tmp_pos.setY(tmp_pos.getY()-1);
		setPosicion(tmp_pos);
	}
}
