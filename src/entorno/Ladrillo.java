package entorno;
import misc.Posicion;

/**
 * Clase que simula un Ladrillo.
 * Posee una posicion, una velocidad, una imagen
 * y visibilidad (o no) en pantalla.
 * 
 * @author lsartori
 */
public class Ladrillo {
	private Posicion posicionl;
	private int velocidad;
	private boolean visible;
//	private Sprite imagen;

	/**
	 * Metodo de cracion de Ladrillo.
	 * Setea por default al ladrillo en invisible.
	 * 
	 * @param posl = posicion inicial del ladrillo.
	 * @param vel = velocidad de caida del ladrillo (pisos/seg).
	 */
	public Ladrillo(Posicion posl, int vel){
		setPosicionl(posl);
		setVelocidad(vel);
		setVisible(false);
	}

	public Posicion getPosicionl() {
		return posicionl;
	}

	/**
	 * Metodo a ejecutar para hacer efectivo el 
	 * movimiento del ladrillo modificando su posicion
	*/
	private void setPosicionl(Posicion posi) {
		posicionl = posi;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVisible(boolean b){
		visible= b;
	}

	public boolean getVisible(){
		return visible;
	}

//	public setImagen(Sprite img){
//		imagen= img;
//	}

//	public Sprite getImagen(){
//		return imagen;
//	}
	
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	
	/**
	 * Metodo a ejecutar para que el ladrillo caiga 1 piso.
	 * Chequea si la posicion actual es mayor que 0 y si lo es
	 * realiza la caida.
	 * Luego de setear la posicion realiza el cambio de imagen.
	 */
	public void caer(){
//		if(!visible){
//			setVisible(true);
//			setImagen(posicion);
//		}
		if(posicionl.getY() > 0){
			Posicion tmp = new Posicion(posicionl.getX(),posicionl.getY()-1);
			setPosicionl(tmp);
		}
//		setImagen(posicion);
	}
}
