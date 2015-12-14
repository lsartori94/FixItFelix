package personajes;
import entorno.Ladrillo;
import entorno.Seccion;
import misc.Direccion;
import misc.Posicion;

public class Ralph {
	
	private static final int ladrilloInicial= 0;
	private int cantLadrillos;
	//espera entre cambio de posicion
	private double velocidad = 1;
	private Ladrillo [] ladrillos;
	private int ladrilloAct;
	//tiempo de espera entre ladrillos
	private Seccion seccion;
	//boleano de control de sentido de movimiento
	private boolean derecha;
	private Posicion posicion;

	/*
	 * En el constructor de Ralph, inicializamos su posicion inicial, ademas
	 * seteamos los atributos relativos a los ladrillos que Ralph lanzará, como
	 * su cantidad y velocidad y el intervalo de lanzamiento de cada uno.
	 * 
	 * @author Agustín Liébana lsartori
	 */
	
	public Ralph( Posicion pos ){
		setPosicion( pos );
		}

	/*
	 * Este metodo se encarga de lanzar un ladrillo. Cada vez que se
	 * ejecute el mismo, se desencadena el metodo Caer de la clase ladrillo
	 * asi como se incrementa en uno la cantidad de ladrillos activos, que se
	 * corresponde con la cantidad de ladrillos que fueron lanzados y se encuentran
	 * en movimiento decencente, asi como se decrementa la cantidad de ladrillos
	 * restantes que dispone Ralph para lanzar.
	 */
	
	public void shoot(){
		if(getCantLadrillos() != 0){
			ladrillos[getLadrilloAct()].caer();
			setCantLadrillos(getCantLadrillos()-1);
			setLadrillo_act(getLadrilloAct()+1);
		}
	}

	public Posicion getPosicion(){
		return posicion;
	}

	public int getCantLadrillos(){
		return cantLadrillos;
	}

	public double getVelocidad(){
		return velocidad;
	}

	public void setPosicion(Posicion pos){
		posicion= pos;
	}

	public void setCantLadrillos(int lad){
		cantLadrillos= lad;
	}

	public void setVelocidad(double vel){
		velocidad= vel;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	public boolean Derecha() {
		return derecha;
	}

	public void setDerecha(boolean derecha) {
		this.derecha = derecha;
	}
	
	public void newLevel( double velocidad, Seccion secc){
		setVelocidad(velocidad);
		setSeccion(secc);
		setCantLadrillos( 50 );
		setLadrillo_act(ladrilloInicial);
		crearLadrillos(getCantLadrillos(), getPosicion());
	}
	
	/*
	 * Con el metodo crearLadrillos inicializamos el arreglo de
	 * ladrillos que posee Ralph. Este contiene todos los ladrillos
	 * que dispone por nivel para lanzar, y cada uno con sus atributos
	 * y estados particulares. Para el caso del ejemplo son todos
	 * iguales en cuanto a sus caracteristicas.
	 */
	
	private void crearLadrillos(int cant, Posicion pos){
		Ladrillo [] tmp= new Ladrillo[cant];
		for(int i= 0; i<cant; i++){
			tmp[i]= new Ladrillo(pos, getVelocidad());
		}
		ladrillos= tmp;
		System.out.println("");
		System.out.println("Se crearon "+cant+" ladrillos de posicion ["+pos.getX()+" , "+pos.getY()+"] con velocidad de caida "+getVelocidad());
	}

	public Ladrillo getLadrillo(int i){
		return ladrillos[i];
	}
	
	public void setLadrillo_act(int act){
		ladrilloAct= act;
	}

	public int getLadrilloAct(){
		return ladrilloAct;
	}
	
	/*
	 * Al igual que felix, este metodo permite el movimiento de Ralph.
	 */
	
	public void move(Direccion d){
		Posicion tmp= posicion;
		switch (d.getValue()) {
		case 1:
			tmp.setY(tmp.getY()+1);
			if (tmp.getY() < 4){
				setPosicion(tmp);
			}
			break;
		
		case 2:
			tmp.setY(tmp.getY()-1);
			if (tmp.getY() > 1){
				setPosicion(tmp);
			}
			break;
	
		case 3:
			tmp.setX(tmp.getX()-1);
			if (tmp.getX() >= 0){
				setPosicion(tmp);
				setDerecha(false);
			}
			break;
		
		case 4:
			tmp.setX(tmp.getX()+1);
			if (tmp.getX() < 5){
				setPosicion(tmp);
				setDerecha(true);
			}
			break;
		
		default:
			System.out.println("Direction Error.");
			break;
		}
	}

}