package entorno;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

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
	private boolean derecha;
	private Map <String, BufferedImage> imagenes;

	public Pato(Posicion pos, int vel){
		cargarImagenes();
		posicion = pos;
		velocidad = vel;
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
	
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	/**
	 * Mueve al pato por la fila.
	 * 
	 * @param dir = direccion a la cual se movera el pato.
	 */
	public void mover(Direccion dir){
		Posicion tmp= posicion;
		switch(dir.getValue()){
		case 3:
			tmp.setX(tmp.getX()-1);
			if (tmp.getX() >= 0){
				setPosicion(tmp);
				setDerecha(false);
				refreshImagenPosicion(dir);
				System.out.println("Pato se movio a la izquierda.");
			}else
				System.out.println("Pato no puede acceder a esa posicion");
			break;
		
		case 4:
			tmp.setX(tmp.getX()+1);
			if (tmp.getX() < 5){
				setPosicion(tmp);
				setDerecha(true);
				refreshImagenPosicion(dir);
				System.out.println("Pato se movio a la derecha.");
			}else
				System.out.println("Pato no puede acceder a esa posicion");
			break;
		
		default:
			System.out.println("Direction Error PATO.");
			break;
		}
	}
	
	private void refreshImagenPosicion(Direccion d){
		if(derecha){
			switch(d.getValue()){
			case 3:
				pintar(imagenes.get("aleteoIzquierda1"));
				//WAIT
				pintar(imagenes.get("aleteoizquierda2"));
				break;
			case 4:
				pintar(imagenes.get("aleteoDerecha1"));
				//WAIT
				pintar(imagenes.get("aleteoDerecha2"));
				break;
			}
		} else{
			switch(d.getValue()){
			case 3:
				pintar(imagenes.get("aleteoIzquierda1"));
				//WAIT
				pintar(imagenes.get("aleteoIzquierda2"));
				break;
			case 4:
				pintar(imagenes.get("aleteoDerecha1"));
				//WAIT
				pintar(imagenes.get("aleteoDerecha2"));
				break;
			}
		}
	}
	
	private void cargarImagenes(){
		try{
			if(imagenes.isEmpty()){
				imagenes.put("aleteoDerecha1", ImageIO.read(new File("pato_derecha_1.png")));
				imagenes.put("aleteoDerecha2", ImageIO.read(new File("pato_derecha_2.png")));
				imagenes.put("aleteoIzquierda1", ImageIO.read(new File("pato_izquierda_1.png")));
				imagenes.put("aleteoIzquierda2", ImageIO.read(new File("pato_izquierda_2.png")));
			}
			
		} catch(IOException e){
			System.out.println("Error interno en Pato" + e.getMessage());
		}
	}

	private void pintar(BufferedImage imagen){
		
	}

}
