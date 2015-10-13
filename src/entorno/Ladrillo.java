package entorno;
import misc.Posicion;

public class Ladrillo {
	private Posicion posicionl;
	private int velocidad;
	private boolean visible;

	//al ser prueba se comenta Sprite
//	private Sprite imagen;

	//metodo de creacion de ladrillo
	public Ladrillo(Posicion posl, int vel){
		setPosicionl(posl);
		setVelocidad(vel);
		setVisible(false);
	}

	public Posicion getPosicionl() {
		return posicionl;
	}

	//metodo a ejecutar para mover al ladrillo
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
	
	//metodo para definir velocidad de caida del ladrillo
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	//metodo a ejecutar para que el ladrillo caiga un piso
	public void caer(){
//		if(!visible){
//			setVisible(true);
//			setImagen(posicion);
//		}
		if(posicionl.getY() > 0){
			Posicion tmp = new Posicion(posicionl.getX(),posicionl.getY()-1);
			setPosicionl(tmp);
			//setPosicionl();
		}
		//		setImagen(posicion);
<<<<<<< HEAD
		//System.out.println(" ");
		//System.out.println("El ladrillo cayo a la posicion ["+posicionl.getX()+" , "+posicionl.getY()+"]");
=======
	//	System.out.println(" ");
	//	System.out.println("El ladrillo cayo a la posicion ["+posicionl.getX()+" , "+posicionl.getY()+"]");
>>>>>>> 3f6b05bdb6dd26870a3647b147c244b621bf1d10
	}
}
