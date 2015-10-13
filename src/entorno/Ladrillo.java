package entorno;
import misc.Posicion;

public class Ladrillo {
	private Posicion posicionl;
	private int velocidad;
	private boolean visible;

	//al ser prueba se comenta Sprite
//	private Sprite imagen;

	//metodo de creacion de ladrillo
	public Ladrillo(Posicion pos, int vel){
		setPosicion(pos);
		setVelocidad(vel);
		setVisible(false);
		//al ser prueba se informa creacion
		System.out.println(" ");
		System.out.println("Se creo ladrillo de posicion ["+getPosicion().getX()+" , "+getPosicion().getY()+"] y de velocidad de caida "+getVelocidad());
	}

	public Posicion getPosicion() {
		return posicionl;
	}

	//metodo a ejecutar para mover al ladrillo
	public void setPosicion(Posicion posicion) {
		posicionl = posicion;
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
		if(!visible){
			setVisible(true);
//			setImagen(posicion);
		}
		Posicion tmp_pos= getPosicion();
		System.out.println("tmp_pos "+tmp_pos.getX()+" "+tmp_pos.getY() );
		tmp_pos.setY(tmp_pos.getY()-1);
		setPosicion(tmp_pos);
//		setImagen(posicion);
		System.out.println(" ");
		System.out.println("El ladrillo cayo a la posicion ["+posicionl.getX()+" , "+posicionl.getY()+"]");
	}
}
