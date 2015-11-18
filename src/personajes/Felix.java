package personajes;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Map;
import javax.imageio.ImageIO;
import entorno.Seccion;
import misc.Direccion;
import misc.Posicion;

public class Felix {
	private Posicion posicion;
	private Seccion sec;
	private static final Posicion posInicial= new Posicion(2, 1);
	private int vidas;
	private boolean poder;
	public final int vidasInicio= 3;
	private int limiteSup;
	private int limiteInf;
	private boolean derecha;
	private Map<String, BufferedImage> imagenes;

	//inicia Default Felix
	/*
	 * Inicializamos a felix en la posicion 2, 1 que se coorresponde con la posicion
	 * de la puerta del edificio. Ademas seteamos la cantidad de vidas y el estado
	 * del poder del mismo, en este caso falso.
	 * 
	 * @author Agustín Liébana lsartori
	 * 
	 */
	public void iniciar(Seccion sec){
		//se asume como posicion inicial el piso 0 a la mitad del mapa (fila 3 de 5)
		Posicion tmpPos= posInicial;
		setPosicion(tmpPos);
		setVidas(vidasInicio);
		setSec(sec);
		setPoder(false);
		//aca se define la imagen con setImagen
		//por ser prueba se informa creacion
		System.out.println(" ");
		System.out.println("Felix se creo en la posicion "+getPosicion().getX()+", "+getPosicion().getY()+" con "+getVidas()+" vidas");
		System.out.println("Poder de Felix= "+Poder());
		//carga de todas las imagenes de Felix
		cargarImagenes();
	}

	/*
	 * Estos metodos proporcionan la informacion pertinente del personaje
	 * como la posicion y las vidas del mismo.
	 */
	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
		//al ser prueba se informa del movimiento
		//System.out.println("Felix se movio a ["+posicion.getX()+" , "+posicion.getY()+"]");

	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public boolean Poder() {
		return poder;
	}

	public void setPoder(boolean poder) {
		this.poder = poder;
	}

	//metodo a ejecutar cuando se tenga que arreglar algo
	public int martillar(){
		sec.getVentana(posicion).arreglar();
		sec.setCantRotas(sec.getCantRotas()-1);
		//se informa por ser prueba
		System.out.println("Felix martilla ventana");
		// devuelve el puntaje de martillar un panel
		return sec.getVentana(posicion).getPuntaje();
	}


	//metodo a ejecutar cuando se reciba un golpe
	public void golpe(){
		int vTemp= getVidas();
		setVidas((vTemp -1));
		//por ser prueba se informa
		System.out.println("Felix perdio una vida. Vidas restantes= "+getVidas());
	}

	// metodo a ejecutar cuando se gane el nivel
	public void victoria(){

	}
	
	public int getLimiteSup() {
		return limiteSup;
	}

	public void setLimiteSup(int limiteSup) {
		this.limiteSup = limiteSup;
	}

	public int getLimteInf() {
		return limiteInf;
	}

	public void setLimteInf(int limteInf) {
		this.limiteInf = limteInf;
	}

	public Seccion getSec() {
		return sec;
	}

	public boolean derecha() {
		return derecha;
	}

	public void setDerecha(boolean derecha) {
		this.derecha = derecha;
	}

	public void setSec(Seccion sec) {
		this.sec = sec;
	}

	// suma una vida al total
	public void sumarVida(){
		int vTemp= getVidas();
		setVidas(vTemp ++);
	}

	/*
	 * Este metodo se encarga de mover a felix a lo largo de la matriz
	 * que compone la seccion de ventanas. Los diferente case se corresponden
	 * con los valores del enumerativo Direccion. Los condicionales de cada
	 * movimiento estan ajustados al diseño actual de la seccion.
	 * A su vez controla que se pueda mover a esa ventana (que no tenga modificadores)
	 */
	public void move(Direccion d){
		Posicion tmp= posicion;
	
		switch (d.getValue()) {
			case 1:
				tmp.setY(tmp.getY()+1);
				if (tmp.getY() < limiteSup){
					if(!sec.getVentana(tmp).macetero()){
						if(!sec.getVentana(posicion).moldura()){
							setPosicion(tmp);
							refreshImagenPosicion(d);
							System.out.println("Felix se movio arriba");
						} else{
							System.out.println("Hay moldura, no puede subir");
						}
					}else{
						System.out.println("Hay macetero arriba, no puede subir");
					}
				}else
					System.out.println("Felix no puede acceder a esa posicion, fuera de mapa");
				break;
		
			case 2:
				tmp.setY(tmp.getY()-1);
				if (tmp.getY() > limiteInf){
					if(!sec.getVentana(tmp).moldura()){
						if(!sec.getVentana(posicion).macetero()){
							setPosicion(tmp);
							refreshImagenPosicion(d);
							System.out.println("Felix se movio abajo");
						} else{
							System.out.println("Hay macetero, no puede Bajar");
						}
					}else{
						System.out.println("Hay Moldura abajo, no puede bajar");
					}
				}else
					System.out.println("Felix no puede acceder a esa posicion, fuera de mapa");
				break;
	
			case 3:
				tmp.setX(tmp.getX()-1);
				if (tmp.getX() >= 0){
					switch (sec.getVentana(tmp).getHoja().getValue()){
						case 1:
							System.out.println("Hay ventana con hojas abiertas, no puede moverse");
							break;
						
						default:
							setPosicion(tmp);
							setDerecha(false);
							refreshImagenPosicion(d);
							System.out.println("Felix se movio a la izquierda.");
							break;
						}
					switch (sec.getVentana(posicion).getHoja().getValue()){
						case 1:
							System.out.println("Esta en una Ventana con hojas, no puede avanzar");
							break;
						
						default:
							setPosicion(tmp);
							setDerecha(false);
							refreshImagenPosicion(d);
							System.out.println("Felix se movio a la izquierda.");
							break;
					}
				}else
					System.out.println("Felix no puede acceder a esa posicion, fuera de mapa");
				break;
		
			case 4:
				tmp.setX(tmp.getX()+1);
				if (tmp.getX() < 5){
					switch (sec.getVentana(tmp).getHoja().getValue()){
					case 1:
						System.out.println("Hay ventana con hojas abiertas, no puede moverse");
						break;
					
					default:
						setPosicion(tmp);
						setDerecha(true);
						refreshImagenPosicion(d);
						System.out.println("Felix se movio a la derecha.");
						break;
					}
				switch (sec.getVentana(posicion).getHoja().getValue()){
					case 1:
						System.out.println("Esta en una Ventana con hojas, no puede avanzar");
						break;
					
					default:
						setPosicion(tmp);
						setDerecha(true);
						refreshImagenPosicion(d);
						System.out.println("Felix se movio a la derecha.");
						break;
				}
			}else
				System.out.println("Felix no puede acceder a esa posicion, fuera de mapa");
			break;
		
			default:
				System.out.println("Direction Error.");
				break;
		}
	}

	/**
	 * Carga todas las imagenes que puede usar Felix
	 */
	private void cargarImagenes(){
		try{
			if(imagenes.isEmpty()){
				imagenes.put("paradoDerecha", ImageIO.read(new File("felix_parado_derecha.png")));
				imagenes.put("paradoIzquierda", ImageIO.read(new File("felix_parado_izquierda.png")));
				imagenes.put("moverDerecha", ImageIO.read(new File("felix_mover_derecha.png")));
				imagenes.put("moverIzquierda", ImageIO.read(new File("felix_mover_izquierda.png")));
				imagenes.put("saltarDerecha", ImageIO.read(new File("felix_saltar_derecha.png")));
				imagenes.put("saltarIzquierda", ImageIO.read(new File("felix_saltar_izquierda.png")));
				imagenes.put("golpe", ImageIO.read(new File("felix_golpe.png")));
				imagenes.put("martilloDerecha1", ImageIO.read(new File("felix_martillo_derecha_1.png")));
				imagenes.put("martilloDerecha2", ImageIO.read(new File("felix_martillo_derecha_2.png")));
				imagenes.put("martilloIzquierda1", ImageIO.read(new File("felix_martillo_izquierda_1.png")));
				imagenes.put("martilloIzquierda2", ImageIO.read(new File("felix_martillo_izquierda_2.png")));
				imagenes.put("pieDerecha1", ImageIO.read(new File("felix_pie_derecha_1.png")));
				imagenes.put("pieDerecha2", ImageIO.read(new File("felix_pie_derecha_2.png")));
				imagenes.put("pieIzquierda1", ImageIO.read(new File("felix_pie_izquierda_1.png")));
				imagenes.put("pieIzquierda2", ImageIO.read(new File("felix_pie_izquierda_2.png")));
				imagenes.put("victoria1", ImageIO.read(new File("felix_victoria_1.png")));
				imagenes.put("victoria2", ImageIO.read(new File("felix_victoria_2.png")));
				imagenes.put("victoria3", ImageIO.read(new File("felix_victoria_3.png")));
				imagenes.put("muerte1", ImageIO.read(new File("felix_muerte_1.png")));
				imagenes.put("muerte2", ImageIO.read(new File("felix_muerte_2.png")));
				imagenes.put("muerte3", ImageIO.read(new File("felix_muerte_3.png")));
				imagenes.put("muerte4", ImageIO.read(new File("felix_muerte_4.png")));
				imagenes.put("muerte5", ImageIO.read(new File("felix_muerte_5.png")));
				imagenes.put("muerte6", ImageIO.read(new File("felix_muerte_6.png")));
			}
			
		} catch(IOException e){
			System.out.println("Error interno en Felix" + e.getMessage());
		}
	}

	/**
	 * FALTA HACER LAS ESPERAS DE LOS REFRESCOS
	 * Refresca las imagenes de movimiento de felix
	 * @param d = direccion de movimiento
	 */
	private void refreshImagenPosicion(Direccion d){
		if(derecha){
			switch(d.getValue()){
			case 1:
				pintar(imagenes.get("saltarDerecha"));
				//WAIT
				pintar(imagenes.get("paradoDerecha"));
				break;
			case 2:
				pintar(imagenes.get("saltarDerecha"));
				//WAIT
				pintar(imagenes.get("paradoDerecha"));
				break;
			case 3:
				pintar(imagenes.get("moverIzquierda"));
				//WAIT
				pintar(imagenes.get("paradoIzquierda"));
				break;
			case 4:
				pintar(imagenes.get("moverDerecha"));
				//WAIT
				pintar(imagenes.get("paradoDerecha"));
				break;
			}
		} else{
			switch(d.getValue()){
			case 1:
				pintar(imagenes.get("saltarIzquierda"));
				//WAIT
				pintar(imagenes.get("paradoIzquierda"));
				break;
			case 2:
				pintar(imagenes.get("saltarIzquierda"));
				//WAIT
				pintar(imagenes.get("paradoIzquierda"));
				break;
			case 3:
				pintar(imagenes.get("moverIzquierda"));
				//WAIT
				pintar(imagenes.get("paradoIzquierda"));
				break;
			case 4:
				pintar(imagenes.get("moverDerecha"));
				//WAIT
				pintar(imagenes.get("paradoDerecha"));
				break;
			}
		}
	}

	/**
	 * Borra la imagen anterior y pinta la nueva
	 * @param img = imagen a pintar
	 */
	private void pintar(BufferedImage img){
		
	}
}