package entorno;
import misc.Direccion;
import misc.Posicion;
/**
 * Clase que representa a un Pato.
 * Vuela por una fila.
 * Posee posicion, imagen y velocidad (ventanas/seg).
 * 
 * @author lsartori Agustín Liébana
 */
public class Pato {
	private Posicion posicion;
	private int velocidad;
//	private Sprite imagen;

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

//	public Sprite getImagen() {
//		return imagen;
//	}

//	public void setImagen(Sprite imagen) {
//		this.imagen = imagen;
//	}

	/**
	 * Mueve al pato por la fila.
	 * 
	 * @param dir = direccion a la cual se movera el pato.
	 */
	public void mover(Direccion dir){

	}

}
