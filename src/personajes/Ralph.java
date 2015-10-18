package personajes;
import entorno.Ladrillo;
import entorno.Seccion;
import misc.Direccion;
import misc.Posicion;

public class Ralph {

	private int cant_ladrillos;
	private int time_ladrillo;
	//espera entre cambio de posicion
	private int velocidad;
	private Ladrillo [] ladrillos;
	private int ladrillo_act;
	//tiempo de espera entre ladrillos
	private int intervalo_lad;
	//Sprite se comenta por ser prueba
	//private Sprite imagen;
	private Seccion seccion;
	private Posicion posicion;

	//metodo para iniciar a Ralph por nivel. no se asume Sprite por ser prueba
	/*
	 * En el constructor de Ralph, inicializamos su posicion inicial, ademas
	 * seteamos los atributos relativos a los ladrillos que Ralph lanzará, como
	 * su cantidad y velocidad y el intervalo de lanzamiento de cada uno.
	 * 
	 * @author Agustín Liébana lsartori
	 */
	public Ralph(int cant_lad, int tiempo_lad, int vel_lad, int vel_ralph, Posicion pos, Seccion sec/*, Sprite img*/){
		setPosicion(pos);
		setCantLadrillos(cant_lad);
		crearLadrillos(cant_lad, vel_lad, getPosicion());
		setTimeLadrillo(tiempo_lad);
		setLadrillo_act(0);
		setVelocidad(vel_ralph);
		setSeccion(sec);
		//setImagen(img);
		//por ser prueba se informa lo realizado
		System.out.println(" ");
		System.out.println("Ralph se inicio en la Seccion " +seccion.getId()+ " en la posicion "+getPosicion().getX()+ ", "+getPosicion().getY());
		System.out.println("Ralph tiene "+getCantLadrillos()+ " ladrillos, con un espacio de lanzamiento de "+getTimeLadrillo()+" segundos");
		System.out.println("Ralph se mueve de lugar cada "+getVelocidad()+" segundos");
	}
	
	//metodo a ejecutar para mover a Ralph en una direccion
	//direccion no se utiliza por ser prueba
//	public void mover(Direccion dir){
//		
//	}

	//metodo a ejecutar para que Ralph tire un ladrillo
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
			System.out.println("Ralph lanzo un ladrillo");
			ladrillos[getLadrillo_act()].caer();
			setCantLadrillos(getCantLadrillos()-1);
			setLadrillo_act(getLadrillo_act()+1);
		}
	}

	public Posicion getPosicion(){
		return posicion;
	}

//	public Sprite getImagen(){
//		return imagen;
//	}

	public int getCantLadrillos(){
		return cant_ladrillos;
	}

	public int getTimeLadrillo(){
		return time_ladrillo;
	}

	public int getVelocidad(){
		return velocidad;
	}

	public void setPosicion(Posicion pos){
		posicion= pos;
		//al ser prueba se informa del movimiento
		//System.out.println("Ralph se movio a ["+posicion.getX()+" , "+posicion.getY()+"]");
	}

//	public void setImagen(Sprite img){
//		imagen= img;
//	}

	public void setCantLadrillos(int lad){
		cant_ladrillos= lad;
	}

	public void setTimeLadrillo(int tlad){
		time_ladrillo= tlad;
	}

	public void setVelocidad(int vel){
		velocidad= vel;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	public int getIntervalo_lad() {
		return intervalo_lad;
	}

	public void setIntervalo_lad(int intervalo_lad) {
		this.intervalo_lad = intervalo_lad;
	}
	
	/*
	 * Con el metodo crearLadrillos inicializamos el arreglo de
	 * ladrillos que posee Ralph. Este contiene todos los ladrillos
	 * que dispone por nivel para lanzar, y cada uno con sus atributos
	 * y estados particulares. Para el caso del ejemplo son todos
	 * iguales en cuanto a sus caracteristicas.
	 */

	private void crearLadrillos(int cant, int vel, Posicion pos){
		Ladrillo [] tmp= new Ladrillo[cant];
		for(int i= 0; i<cant; i++){
			tmp[i]= new Ladrillo(pos, vel);
		}
		ladrillos= tmp;
		System.out.println("");
		System.out.println("Se crearon "+cant+" ladrillos de posicion ["+pos.getX()+" , "+pos.getY()+"] con velocidad de caida "+vel);
	}

	public Ladrillo getLadrillo(int i){
		return ladrillos[i];
	}
	
	/*
	 * Este metodo se utilizara para romper ventanas con Ralph. En el test
	 * no es utilizado ya que las ventanas y sus estados se inicializan
	 * de manera aleatoria.
	 */
	public void romper(/*Sprite img*/){
		seccion.getVentana(posicion).setRota(true);
		//al ser prueba no se modifica imagen
		//seccion.getVentana(posicion).setImagen(img);
		System.out.println("Ralph rompio la Ventana ["+posicion.getX()+" , "+posicion.getY()+"]");
	}
	
	public void setLadrillo_act(int act){
		ladrillo_act= act;
	}

	public int getLadrillo_act(){
		return ladrillo_act;
	}
	
	/*
	 * Al igual que felix, este metodo permite el movimiento de Ralph.
	 * Nuevamente sus condicionales son especificos para el diseño de la
	 * seccion y pueden mutar en la version completa del juego.
	 */
	public void move(Direccion d){
	Posicion tmp= posicion;
	switch (d.getValue()) {
		case 1:
			tmp.setY(tmp.getY()+1);
			if (tmp.getY() < 4){
				setPosicion(tmp);
				System.out.println("Ralph se movio arriba");
			}else
				System.out.println("Ralph no puede acceder a esa posicion");
			break;
		
		case 2:
			tmp.setY(tmp.getY()-1);
			if (tmp.getY() > 1){
				setPosicion(tmp);
				System.out.println("Ralph se movio abajo");
			}else
				System.out.println("Ralph no puede acceder a esa posicion");
			break;
	
		case 3:
			tmp.setX(tmp.getX()-1);
			if (tmp.getX() >= 0){
				setPosicion(tmp);
				System.out.println("Ralph se movio a la izquierda.");
			}else
				System.out.println("Ralph no puede acceder a esa posicion");
			break;
		
		case 4:
			tmp.setX(tmp.getX()+1);
			if (tmp.getX() < 5){
				setPosicion(tmp);
				System.out.println("Ralph se movio a la derecha.");
			}else
				System.out.println("Ralph no puede acceder a esa posicion");
			break;
		
		default:
			System.out.println("Direction Error.");
			break;
	}
}
}