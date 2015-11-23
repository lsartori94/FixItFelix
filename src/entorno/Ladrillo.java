package entorno;
import misc.Posicion;

/**
 * Clase que simula un Ladrillo.
 * Posee una posicion, una velocidad, una imagen
 * y visibilidad (o no) en pantalla.
 * 
 * @author lsartori Agustín Liébana
 */
public class Ladrillo {
	private Posicion posicionl;
	private double velocidad;
	private boolean visible;

	/**
	 * Metodo de cracion de Ladrillo.
	 * Setea por default al ladrillo en invisible.
	 * 
	 * @param posl = posicion inicial del ladrillo.
	 * @param vel = velocidad de caida del ladrillo (pisos/seg).
	 */
	public Ladrillo(Posicion posl, double vel){
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

	public double getVelocidad() {
		return velocidad;
	}

	public void setVisible(boolean b){
		visible= b;
	}

	public boolean getVisible(){
		return visible;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	
	/**
	 * Metodo a ejecutar para que el ladrillo caiga 1 piso.
	 * Chequea si la posicion actual es mayor que 0 y si lo es
	 * realiza la caida.
	 */
	public void caer(){
		if(posicionl.getY() > 0){
			Posicion tmp = new Posicion(posicionl.getX(),posicionl.getY()-1);
			setPosicionl(tmp);
		}else{
			destruir();
		}
	}

	private void destruir(){
		
	}
}
