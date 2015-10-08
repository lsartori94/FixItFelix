package entorno;

public class Ladrillo {
	private Posicion posicion;
	private int velocidad;
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public void caer(){
		// a ejecutar cuando el ladrillo cae
	}
}
