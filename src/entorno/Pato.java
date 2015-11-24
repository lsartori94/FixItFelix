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
	private boolean derecha;
	private boolean destruir= false;

	public Pato(Posicion pos, int vel){
		posicion = pos;
		double ran= Math.random();
		derecha= (ran < 0.5) ? true : false;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public boolean derecha(){
		return derecha;
	}
	
	public void setDerecha(boolean bol){
		derecha= bol;
	}
	
	public boolean setPosicion(Posicion pos) {
		if((pos.getX() > 0)||(pos.getX() < 4)){
			this.posicion = pos;
			return true;
		}else{
			destruir= true;
			return false;
		}
	}

	/**
	 * Mueve al pato por la fila.
	 * 
	 * @param dir = direccion a la cual se movera el pato.
	 */
	public boolean mover(Direccion dir){
		Posicion tmp= posicion;
		boolean bol= false;
		switch(dir.getValue()){
		case 3:
			tmp.setX(tmp.getX()-1);
			if (tmp.getX() >= 0){
				bol= setPosicion(tmp);
				System.out.println("Pato se movio a la izquierda.");
			}else
				System.out.println("Pato no puede acceder a esa posicion");
			break;
		
		case 4:
			tmp.setX(tmp.getX()+1);
			if (tmp.getX() < 5){
				bol= setPosicion(tmp);
				System.out.println("Pato se movio a la derecha.");
			}else
				System.out.println("Pato no puede acceder a esa posicion");
			break;
		
		default:
			System.out.println("Direction Error PATO.");
			break;
		}
		return bol;
	}
	
	public boolean getDestruir(){
		return destruir;
	}
}
