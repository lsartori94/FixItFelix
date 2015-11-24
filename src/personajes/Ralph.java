package personajes;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import entorno.Ladrillo;
import entorno.Seccion;
import misc.Direccion;
import misc.Posicion;

public class Ralph {
	
	private static final int ladrilloInicial= 0;
	private int cantLadrillos;
	//espera entre cambio de posicion
	private double velocidad;
	private Ladrillo [] ladrillos;
	private int ladrilloAct;
	//tiempo de espera entre ladrillos
	private Seccion seccion;
	//boleano de control de sentido de movimiento
	private boolean derecha;
	private Posicion posicion;
	private Map <String, BufferedImage> imagenes;

	//metodo para iniciar a Ralph por nivel. no se asume Sprite por ser prueba
	/*
	 * En el constructor de Ralph, inicializamos su posicion inicial, ademas
	 * seteamos los atributos relativos a los ladrillos que Ralph lanzará, como
	 * su cantidad y velocidad y el intervalo de lanzamiento de cada uno.
	 * 
	 * @author Agustín Liébana lsartori
	 */
	public Ralph(){
		setCantLadrillos(50);
		crearLadrillos(getCantLadrillos(), getPosicion());
		setLadrillo_act(ladrilloInicial);
		cargarImagenes();
		//por ser prueba se informa lo realizado
<<<<<<< HEAD
=======
		System.out.println(" ");
		System.out.println("Ralph se inicio en la Seccion " +seccion.getId()+ " en la posicion "+getPosicion().getX()+ ", "+getPosicion().getY());
		System.out.println("Ralph tiene "+getCantLadrillos()+ " ladrillos, con un espacio de lanzamiento de segundos");
		//System.out.println("Ralph se mueve de lugar cada "+getVelocidad()+" segundos");
>>>>>>> fdc6db05542000f91fa6e4310196e2248b9d01ce
	}

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
<<<<<<< HEAD
		System.out.println("Se crearon "+cant+" ladrillos de posicion ["+pos.getX()+" , "+pos.getY()+"] con velocidad de caida "+getVelocidad());
=======
		System.out.println("Se crearon "+cant+" ladrillos de posicion ["+pos.getX()+" , "+pos.getY()+"] con velocidad de caida ");
>>>>>>> fdc6db05542000f91fa6e4310196e2248b9d01ce
	}

	public Ladrillo getLadrillo(int i){
		return ladrillos[i];
	}
	
	/*
	 * Este metodo se utilizara para romper ventanas con Ralph. En el test
	 * no es utilizado ya que las ventanas y sus estados se inicializan
	 * de manera aleatoria.
	 */
	public void romper(){
		seccion.getVentana(posicion).romper();
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
				refreshImagenPosicion(d);
				System.out.println("Ralph se movio arriba");
			}else
				System.out.println("Ralph no puede acceder a esa posicion");
			break;
		
		case 2:
			tmp.setY(tmp.getY()-1);
			if (tmp.getY() > 1){
				setPosicion(tmp);
				refreshImagenPosicion(d);
				System.out.println("Ralph se movio abajo");
			}else
				System.out.println("Ralph no puede acceder a esa posicion");
			break;
	
		case 3:
			tmp.setX(tmp.getX()-1);
			if (tmp.getX() >= 0){
				setPosicion(tmp);
				setDerecha(false);
				refreshImagenPosicion(d);
				System.out.println("Ralph se movio a la izquierda.");
			}else
				System.out.println("Ralph no puede acceder a esa posicion");
			break;
		
		case 4:
			tmp.setX(tmp.getX()+1);
			if (tmp.getX() < 5){
				setPosicion(tmp);
				setDerecha(true);
				refreshImagenPosicion(d);
				System.out.println("Ralph se movio a la derecha.");
			}else
				System.out.println("Ralph no puede acceder a esa posicion");
			break;
		
		default:
			System.out.println("Direction Error.");
			break;
		}
	}

	private void cargarImagenes(){
		try{
			if(imagenes.isEmpty()){
				imagenes.put("parado", ImageIO.read(new File("ralph_parado.png")));
				imagenes.put("moverDerecha1", ImageIO.read(new File("ralph_mover_derecha_1.png")));
				imagenes.put("moverDerecha2", ImageIO.read(new File("ralph_mover_derecha_2.png")));
				imagenes.put("moverIzquierda1", ImageIO.read(new File("ralph_mover_izquierda_1.png")));
				imagenes.put("moverIzquierda2", ImageIO.read(new File("ralph_mover_izquierda_2.png")));
				imagenes.put("tirar1", ImageIO.read(new File("ralph_tirar_1.png")));
				imagenes.put("tirar2", ImageIO.read(new File("ralph_tirar_2.png")));
				imagenes.put("tirar3", ImageIO.read(new File("ralph_tirar_3.png")));
				imagenes.put("tirar4", ImageIO.read(new File("ralph_tirar_4.png")));
				imagenes.put("tirar5", ImageIO.read(new File("ralph_tirar_5.png")));
				imagenes.put("tirar6", ImageIO.read(new File("ralph_tirar_6.png")));
				imagenes.put("subir1", ImageIO.read(new File("ralph_subir_1.png")));
				imagenes.put("subir2", ImageIO.read(new File("ralph_subir_2.png")));
			}
			
		} catch(IOException e){
			System.out.println("Error interno en Ralph" + e.getMessage());
		}
	}

	private void refreshImagenPosicion(Direccion d){
		if(derecha){
			switch(d.getValue()){
			case 1:
				pintar(imagenes.get("subir1"));
				//WAIT
				pintar(imagenes.get("subir2"));
				//WAIT
				pintar(imagenes.get("parado"));
				break;
			case 2:
				pintar(imagenes.get("subir1"));
				//WAIT
				pintar(imagenes.get("subir2"));
				//WAIT
				pintar(imagenes.get("parado"));
				break;
			case 3:
				pintar(imagenes.get("moverIzquierda1"));
				//WAIT
				pintar(imagenes.get("moverIzquierda2"));
				//WAIT
				pintar(imagenes.get("parado"));
				break;
			case 4:
				pintar(imagenes.get("moverDerecha1"));
				//WAIT
				pintar(imagenes.get("moverDerecha2"));
				//WAIT
				pintar(imagenes.get("parado"));
				break;
			}
		} else{
			switch(d.getValue()){
			case 1:
				pintar(imagenes.get("subir1"));
				//WAIT
				pintar(imagenes.get("subir2"));
				//WAIT
				pintar(imagenes.get("parado"));
				break;
			case 2:
				pintar(imagenes.get("subir1"));
				//WAIT
				pintar(imagenes.get("subir2"));
				//WAIT
				pintar(imagenes.get("parado"));
				break;
			case 3:
				pintar(imagenes.get("moverDerecha1"));
				//WAIT
				pintar(imagenes.get("moverDerecha2"));
				//WAIT
				pintar(imagenes.get("parado"));
				break;
			case 4:
				pintar(imagenes.get("moverIzquierda1"));
				//WAIT
				pintar(imagenes.get("moverIzquierda2"));
				//WAIT
				pintar(imagenes.get("parado"));
				break;
			}
		}
	}
	
	private void pintar(BufferedImage imagen){
	}

}