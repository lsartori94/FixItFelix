package entorno;

public class Pato {
	private Posicion posicion;
	private int velocidad;
	private Sprite imagen;

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

	public Sprite getImagen() {
		return imagen;
	}

	public void setImagen(Sprite imagen) {
		this.imagen = imagen;
	}

	public void mover(Direccion dir){

	}

}
