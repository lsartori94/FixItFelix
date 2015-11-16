package personajes;
import entorno.Ladrillo;
import entorno.Seccion;
import misc.Direccion;
import misc.Posicion;

public class Ralph {
	
	private static final int ladrilloInicial= 0;
	private int cantLadrillos;
	private int timeLadrillo;
	//espera entre cambio de posicion
	private int velocidad;
	private Ladrillo [] ladrillos;
	private int ladrilloAct;
	//tiempo de espera entre ladrillos
	private int intervaloLad;
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
	public Ralph(int cantLad, int tiempoLad, int velLad, int velRalph, Posicion pos, Seccion sec){
		setPosicion(pos);
		setCantLadrillos(cantLad);
		crearLadrillos(cantLad, velLad, getPosicion());
		setTimeLadrillo(tiempoLad);
		setLadrillo_act(ladrilloInicial);
		setVelocidad(velRalph);
		setSeccion(sec);
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

	public int getTimeLadrillo(){
		return timeLadrillo;
	}

	public int getVelocidad(){
		return velocidad;
	}

	public void setPosicion(Posicion pos){
		posicion= pos;
	}

	public void setCantLadrillos(int lad){
		cantLadrillos= lad;
	}

	public void setTimeLadrillo(int tlad){
		timeLadrillo= tlad;
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

	public int getIntervaloLad() {
		return intervaloLad;
	}

	public void setIntervaloLad(int intervaloLad) {
		this.intervaloLad = intervaloLad;
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
		ladrilloAct= act;
	}

	public int getLadrilloAct(){
		return ladrilloAct;
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