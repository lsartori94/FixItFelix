package userInterface;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

import javax.imageio.ImageIO;

import entorno.Seccion;
import entorno.Ventana;
import misc.Direccion;
import misc.EstadosJuego;
import misc.Hoja;
import misc.Posicion;

/**
 * Metodo que se encarga de la carga de imágenes y del llamado al dibujado de las mismas
 * @author lsartori
 *
 */
public class Renderizable extends TimerTask {

	private Timer timer;
	private Map <String, BufferedImage> balcon= new TreeMap<String, BufferedImage>();
	private Map <String, BufferedImage> conHoja= new TreeMap<String, BufferedImage>();
	private Map <String, BufferedImage> doblePanel= new TreeMap<String, BufferedImage>();
	private Map <String, BufferedImage> ladrillo= new TreeMap<String, BufferedImage>();
	private Map <String, BufferedImage> nicelander= new TreeMap<String, BufferedImage>();
	private Map <String, BufferedImage> pato= new TreeMap<String, BufferedImage>();
	private Map <String, BufferedImage> puerta= new TreeMap<String, BufferedImage>();
	private Map <String, BufferedImage> felix= new TreeMap<String, BufferedImage>();
	private Map <String, BufferedImage> ralph= new TreeMap<String, BufferedImage>();
	private Map <String, BufferedImage> misc= new TreeMap<String, BufferedImage>();
	private Map <String, BufferedImage> edificio= new TreeMap<String, BufferedImage>();	
	private Map <String, BufferedImage> imagenes= new TreeMap<String, BufferedImage>();
	private BufferedImage[][] imagenesVentanas= new BufferedImage[5][5];
	private Seccion seccion;
	private Ventana[][] ventanas= new Ventana[5][5];
	private MapScreen screen= new MapScreen();
	private Posicion posRalph;
	private Posicion posFelix;
	private Posicion posLadrillo;
	private Posicion posNicelander;
	private Posicion posPato;
	private EstadosJuego estado;
	private long sleepR;
	private long sleepP;
	private long sleepF;
	private long sleepFelixMart;

	/**
	 * Carga todas las imagenes de memoria y setea los relojes de refrescado
	 * @param sec seccion actual a dibujar
	 * @param tim instancia de timer para el automatizado
	 * @param slp velocidad del timer
	 */
	public Renderizable(Seccion sec, Timer tim, long slp){
		setSeccion(sec);
		cargarImagenesEdificio();
		cargarImagenesMisc();
		cargarImagenesBalcon();
		cargarImagenesConHoja();
		cargarImagenesDoblePanel();
		cargarImagenLadrillo();
		cargarImagenNicelander();
		cargarImagenesPato();
		cargarImagenesPuerta();
		cargarImagenesFelix();
		cargarImagenesRalph();
		cargarTodo();
		screen.setNumSeccion(sec.getId());
		screen.setEstado(estado);
		screen.setImagenes(imagenes);
		sleepR= 60;
		sleepP= 110;
		sleepF= 110;
		sleepFelixMart= sleepF+250;

		this.timer= tim;
	}
	
	/*
	 * metodo que realiza el llamado al dibujado
	 * (non-Javadoc)
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run(){
		screen.setImagenesVentanas(imagenesVentanas);
		screen.setPosFelix(posFelix);
		screen.setPosLadrillo(posLadrillo);
		screen.setPosNicelander(posNicelander);
		screen.setPosPato(posPato);
		screen.setPosRalph(posRalph);
		screen.setEstado(getEstado());
		screen.repaint();
		screen.render();
	}

	public void finRender() {
		timer.cancel();
	}
	
	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
		screen.setNumSeccion(seccion.getId());
		cargarSeccion();
		setVentanas(seccion.getVentanas());
	}

	public Ventana[][] getVentanas() {
		return ventanas;
	}

	public void setVentanas(Ventana[][] ventanas) {
		Ventana [][] vent= ventanas;
		this.ventanas = vent;
	}

	public Posicion getPosRalph() {
		return posRalph;
	}

	public void setPosRalph(Posicion posRalph) {
		this.posRalph = posRalph;
	}

	public Posicion getPosFelix() {
		return posFelix;
	}

	public void setPosFelix(Posicion posFelix) {
		this.posFelix = posFelix;
	}

	public Posicion getPosLadrillo() {
		return posLadrillo;
	}

	public void setPosLadrillo(Posicion posLadrillo) {
		this.posLadrillo = posLadrillo;
	}

	public Posicion getPosNicelander() {
		return posNicelander;
	}

	public void setPosNicelander(Posicion posNicelander) {
		this.posNicelander = posNicelander;
	}

	public Posicion getPosPato() {
		return posPato;
	}

	public void setPosPato(Posicion posPato) {
		this.posPato = posPato;
	}

	private void cargarImagenesEdificio(){
		try{
			if(edificio.isEmpty()){
				edificio.put("seccion1", ImageIO.read(new File("src/imagenes/edificio_seccion1.png")));
				edificio.put("seccion2", ImageIO.read(new File("src/imagenes/edificio_seccion2.png")));
				edificio.put("seccion3", ImageIO.read(new File("src/imagenes/edificio_seccion3.png")));
				edificio.put("edificio", ImageIO.read(new File("src/imagenes/edificio.png")));
			}
		} catch(IOException e){
			System.out.println("Error interno en Misc" + e.getMessage());
		}
	}
	
	private void cargarImagenesMisc(){
		try{
			if(misc.isEmpty()){
				misc.put("titulo", ImageIO.read(new File("src/imagenes/titulo.png")));
				misc.put("gameOver", ImageIO.read(new File("src/imagenes/gameover.png")));
				misc.put("levelWin", ImageIO.read(new File("src/imagenes/win.png")));
				misc.put("fondo", ImageIO.read(new File("src/imagenes/fondo.png")));
				misc.put("instrucciones", ImageIO.read(new File("src/imagenes/instrucciones.png")));
			}
		} catch(IOException e){
			System.out.println("Error interno en Misc" + e.getMessage());
		}
	}
	
	private void cargarImagenesBalcon(){
		try{
			if(balcon.isEmpty()){
				balcon.put("roto", ImageIO.read(new File("src/imagenes/balcon_roto.png")));
				balcon.put("sano", ImageIO.read(new File("src/imagenes/balcon_sano.png")));
			}
			
		} catch(IOException e){
			System.out.println("Error interno en Balcon" + e.getMessage());
		}
	}
	
	private void cargarImagenesConHoja(){
		try{
			if(conHoja.isEmpty()){
				conHoja.put("abierta", ImageIO.read(new File("src/imagenes/ventana_hoja_abierta.png")));
				conHoja.put("cerrada", ImageIO.read(new File("src/imagenes/ventana_hoja_cerrada.png")));
			}
			
		} catch(IOException e){
			System.out.println("Error interno en Ventana con Hoja" + e.getMessage());
		}
	}

	private void cargarImagenesDoblePanel(){
		try{
			if(doblePanel.isEmpty()){
				doblePanel.put("rota1", ImageIO.read(new File("src/imagenes/ventana_doble_rota_1.png")));
				doblePanel.put("rota2", ImageIO.read(new File("src/imagenes/ventana_doble_rota_2.png")));
				doblePanel.put("rota3", ImageIO.read(new File("src/imagenes/ventana_doble_rota_3.png")));
				doblePanel.put("sana", ImageIO.read(new File("src/imagenes/ventana_doble_sana.png")));
				doblePanel.put("conMaceta", ImageIO.read(new File("src/imagenes/ventana_doble_macetero.png")));
				doblePanel.put("conMoldura", ImageIO.read(new File("src/imagenes/ventana_doble_moldura.png")));
			}
			
		} catch(IOException e){
			System.out.println("Error interno en Ventana de Doble Panel" + e.getMessage());
		}
	}
	
	/**
	 * Si la ventana esta rota hace un random para seleccionar la imagen, sino devuele que esta sana
	 * @param vent ventana a analizar
	 * @return devuelve el hash que representa la imagen del estado de la ventana
	 */
	private String randomDoblePanel(Ventana vent){
		String panelDobleRender= "sana";
		if(vent.rota()){
			double ran= Math.random();
			if(ran < 0.33){
				panelDobleRender= "rota1";
			}else if(ran > 0.33){
				if(ran < 0.66){
					panelDobleRender= "rota2";
				}else{
					panelDobleRender= "rota3";
				}
			}
		}
		if(vent.macetero())
			panelDobleRender= "conMaceta";
		if(vent.moldura())
			panelDobleRender="conMoldura";
			
		return panelDobleRender;
	}	

	private void cargarImagenLadrillo(){
		try{
			if(ladrillo.isEmpty()){
				ladrillo.put("ladrillo", ImageIO.read(new File("src/imagenes/ladrillo.png")));
			}
			
		} catch(IOException e){
			System.out.println("Error interno en Ladrillo" + e.getMessage());
		}
	}	
	
	private void cargarImagenNicelander(){
		try{
			if(nicelander.isEmpty()){
				nicelander.put("sinPie", ImageIO.read(new File("src/imagenes/nicelander_sinPie.png")));
				nicelander.put("conPie", ImageIO.read(new File("src/imagenes/nicelander_conPie.png")));
			}
			
		} catch(IOException e){
			System.out.println("Error interno en Nicelander" + e.getMessage());
		}
	}	
	
	private void cargarImagenesPato(){
		try{
			if(pato.isEmpty()){
				pato.put("aleteoDerecha1", ImageIO.read(new File("src/imagenes/pato_derecha_1.png")));
				pato.put("aleteoDerecha2", ImageIO.read(new File("src/imagenes/pato_derecha_2.png")));
				pato.put("aleteoIzquierda1", ImageIO.read(new File("src/imagenes/pato_izquierda_1.png")));
				pato.put("aleteoIzquierda2", ImageIO.read(new File("src/imagenes/pato_izquierda_2.png")));
			}
			
		} catch(IOException e){
			System.out.println("Error interno en Pato" + e.getMessage());
		}
	}	
	
	private void cargarImagenesPuerta(){
		try{
			if(puerta.isEmpty()){
				puerta.put("rota", ImageIO.read(new File("src/imagenes/puerta_rota.png")));
				puerta.put("sana", ImageIO.read(new File("src/imagenes/puerta_sana.png")));
			}
			
		} catch(IOException e){
			System.out.println("Error interno en Puerta" + e.getMessage());
		}
	}	
	
	private void cargarImagenesFelix(){
		try{
			if(felix.isEmpty()){
				felix.put("paradoDerecha", ImageIO.read(new File("src/imagenes/felix_parado_derecha.png")));
				felix.put("paradoIzquierda", ImageIO.read(new File("src/imagenes/felix_parado_izquierda.png")));
				felix.put("moverDerecha", ImageIO.read(new File("src/imagenes/felix_mover_derecha.png")));
				felix.put("moverIzquierda", ImageIO.read(new File("src/imagenes/felix_mover_izquierda.png")));
				felix.put("golpe", ImageIO.read(new File("src/imagenes/felix_saltar_derecha.png")));
				felix.put("martilloDerecha1", ImageIO.read(new File("src/imagenes/felix_martillo_derecha_1.png")));
				felix.put("martilloDerecha2", ImageIO.read(new File("src/imagenes/felix_martillo_derecha_2.png")));
				felix.put("martilloIzquierda1", ImageIO.read(new File("src/imagenes/felix_martillo_izquierda_1.png")));
				felix.put("martilloIzquierda2", ImageIO.read(new File("src/imagenes/felix_martillo_izquierda_2.png")));
				felix.put("pieDerecha1", ImageIO.read(new File("src/imagenes/felix_pie_derecha_1.png")));
				felix.put("pieDerecha2", ImageIO.read(new File("src/imagenes/felix_pie_derecha_2.png")));
				felix.put("pieIzquierda1", ImageIO.read(new File("src/imagenes/felix_pie_izquierda_1.png")));
				felix.put("pieIzquierda2", ImageIO.read(new File("src/imagenes/felix_pie_izquierda_2.png")));
				felix.put("victoria1", ImageIO.read(new File("src/imagenes/felix_victoria_1.png")));
				felix.put("victoria2", ImageIO.read(new File("src/imagenes/felix_victoria_2.png")));
				felix.put("victoria3", ImageIO.read(new File("src/imagenes/felix_victoria_3.png")));
				felix.put("muerte1", ImageIO.read(new File("src/imagenes/felix_muerte_1.png")));
				felix.put("muerte2", ImageIO.read(new File("src/imagenes/felix_muerte_2.png")));
				felix.put("muerte3", ImageIO.read(new File("src/imagenes/felix_muerte_3.png")));
				felix.put("muerte4", ImageIO.read(new File("src/imagenes/felix_muerte_4.png")));
				felix.put("muerte5", ImageIO.read(new File("src/imagenes/felix_muerte_5.png")));
				felix.put("muerte6", ImageIO.read(new File("src/imagenes/felix_muerte_6.png")));
				felix.put("muerte7", ImageIO.read(new File("src/imagenes/felix_muerte_7.png")));
			}
			
		} catch(IOException e){
			System.out.println("Error interno en Felix" + e.getMessage());
		}
	}	
	
	private void cargarImagenesRalph(){
		try{
			if(ralph.isEmpty()){
				ralph.put("parado", ImageIO.read(new File("src/imagenes/ralph_parado.png")));
				ralph.put("moverDerecha1", ImageIO.read(new File("src/imagenes/ralph_mover_derecha_1.png")));
				ralph.put("moverDerecha2", ImageIO.read(new File("src/imagenes/ralph_mover_derecha_2.png")));
				ralph.put("moverIzquierda1", ImageIO.read(new File("src/imagenes/ralph_mover_izquierda_1.png")));
				ralph.put("moverIzquierda2", ImageIO.read(new File("src/imagenes/ralph_mover_izquierda_2.png")));
				ralph.put("tirar1", ImageIO.read(new File("src/imagenes/ralph_tirar_1.png")));
				ralph.put("tirar2", ImageIO.read(new File("src/imagenes/ralph_tirar_2.png")));
				ralph.put("tirar3", ImageIO.read(new File("src/imagenes/ralph_tirar_3.png")));
				ralph.put("tirar4", ImageIO.read(new File("src/imagenes/ralph_tirar_4.png")));
				ralph.put("tirar5", ImageIO.read(new File("src/imagenes/ralph_tirar_5.png")));
				ralph.put("tirar6", ImageIO.read(new File("src/imagenes/ralph_tirar_6.png")));
				ralph.put("subir1", ImageIO.read(new File("src/imagenes/ralph_subir_1.png")));
				ralph.put("subir2", ImageIO.read(new File("src/imagenes/ralph_subir_2.png")));
			}
				
		} catch(IOException e){
			System.out.println("Error interno en Ralph" + e.getMessage());
			}
	}	
	
	private void cargarVentanas(){
		for(int x=0; x<5; x++){
			for(int y=1; y<4; y++){
				Ventana auxV= ventanas[x][y];
				switch(auxV.getClass().getSimpleName()){
				case "DoblePanel":
						imagenesVentanas[x][y]= doblePanel.get(randomDoblePanel(auxV));
					break;
					
				case "ConHoja":
					if(auxV.getHoja().equals(Hoja.ABIERTA)){
						imagenesVentanas[x][y]= conHoja.get("abierta");
					}else{
						imagenesVentanas[x][y]= conHoja.get("cerrada");
					}
					break;
					
				case "Puerta":
					if(auxV.rota()){
						imagenesVentanas[x][y]= puerta.get("rota");
					}else{
						imagenesVentanas[x][y]= puerta.get("sana");
					}
					break;
				
				case "Balcon":
					if(auxV.rota()){
						imagenesVentanas[x][y]= balcon.get("roto");
					}else{
						imagenesVentanas[x][y]= balcon.get("sano");
					}
					break;
				}
			}
		}
	}

	private void cargarSeccion(){
		switch(getSeccion().getId()){
		case 0:
			imagenes.put("seccion", edificio.get("seccion1"));
			break;
		
		case 1:
			imagenes.put("seccion", edificio.get("seccion2"));
			break;
			
		case 2:
			imagenes.put("seccion", edificio.get("seccion3"));
			break;
		}
	}

	public void cargarTodo(){
		cargarVentanas();
		cargarSeccion();
		imagenes.put("instrucciones", misc.get("instrucciones"));
		imagenes.put("fondo", misc.get("fondo"));
		imagenes.put("titulo", misc.get("titulo"));
		imagenes.put("win", misc.get("levelWin"));
		imagenes.put("gameOver", misc.get("gameOver"));
		imagenes.put("ladrillo", ladrillo.get("ladrillo"));
		imagenes.put("nicelander", nicelander.get("sinPie"));
		imagenes.put("pato", pato.get("aleteoDerecha1"));
		imagenes.put("felix", felix.get("paradoDerecha"));
		imagenes.put("ralph", ralph.get("parado"));
	}

	/**
	 * Refresca las imagenes de movimiento de felix. Deja una espera de 500ms entre cada cambio de imagen
	 * @param d = direccion de movimiento
	 * @param felixDerecha = si felix mira a derecha o no
	 */
	public void refreshImagenPosicionFelix(Direccion d, Boolean felixDerecha){
		if(felixDerecha){
			switch(d.getValue()){
			case 1:
				imagenes.put("felix", felix.get("paradoDerecha"));
				try {
					Thread.sleep(sleepF);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imagenes.put("felix", felix.get("paradoDerecha"));
				break;
			case 2:
				imagenes.put("felix", felix.get("saltarDerecha"));
				try {
					Thread.sleep(sleepF);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imagenes.put("felix", felix.get("paradoDerecha"));
				break;
			case 3:
				imagenes.put("felix", felix.get("moverIzquierda"));
				try {
					Thread.sleep(sleepF);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imagenes.put("felix", felix.get("paradoIzquierda"));
				break;
			case 4:
				imagenes.put("felix", felix.get("moverDerecha"));
				try {
					Thread.sleep(sleepF);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imagenes.put("felix", felix.get("paradoDerecha"));
				break;
			}
		} else{
			switch(d.getValue()){
			case 1:
				imagenes.put("felix", felix.get("paradoIzquierda"));
				try {
					Thread.sleep(sleepF);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imagenes.put("felix", felix.get("paradoIzquierda"));
				break;
			case 2:
				imagenes.put("felix", felix.get("saltarIzquierda"));
				try {
					Thread.sleep(sleepF);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imagenes.put("felix", felix.get("paradoIzquierda"));
				break;
			case 3:
				imagenes.put("felix", felix.get("moverIzquierda"));
				try {
					Thread.sleep(sleepF);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imagenes.put("felix", felix.get("paradoIzquierda"));
				break;
			case 4:
				imagenes.put("felix", felix.get("moverDerecha"));
				try {
					Thread.sleep(sleepF);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imagenes.put("felix", felix.get("paradoDerecha"));
				break;
			}
		}
	}
	
	/**
	 * Refresca las imagenes de movimiento del pato. Deja una espera de 500ms entre cada cambio de imagen
	 * @param d direccion del movimiento
	 */
	public void refreshImagenPosicionPato(Direccion d){
		switch(d.getValue()){
		case 3:
			imagenes.put("pato", pato.get("aleteoIzquierda1"));
			try {
				Thread.sleep(sleepP);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			imagenes.put("pato",pato.get("aleteoizquierda2"));
			break;
		case 4:
			imagenes.put("pato",pato.get("aleteoDerecha1"));
			try {
				Thread.sleep(sleepP);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			imagenes.put("pato",pato.get("aleteoDerecha2"));
			break;
		}
	}

	/**
	 * Refresca las imagenes de movimiento de Ralph. Deja una espera de 500ms entre cada cambio de imagen
	 * @param d = direccion del movimiento
	 * @param ralphDerecha = si ralph mira a derecha
	 */
	public void refreshImagenPosicionRalph(Direccion d, boolean ralphDerecha){
			switch(d.getValue()){
			case 1:
				imagenes.put("ralph", ralph.get("subir1"));
				try {
					Thread.sleep(sleepR);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imagenes.put("ralph", ralph.get("subir2"));
				try {
					Thread.sleep(sleepR);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imagenes.put("ralph", ralph.get("parado"));
				break;
			case 2:
				imagenes.put("ralph", ralph.get("subir1"));
				try {
					Thread.sleep(sleepR);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imagenes.put("ralph", ralph.get("subir2"));
				try {
					Thread.sleep(sleepR);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imagenes.put("ralph", ralph.get("parado"));
				break;
			case 3:
				imagenes.put("ralph", ralph.get("moverIzquierda1"));
				try {
					Thread.sleep(sleepR);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imagenes.put("ralph", ralph.get("moverIzquierda2"));
				try {
					Thread.sleep(sleepR);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imagenes.put("ralph", ralph.get("parado"));
				break;
			case 4:
				imagenes.put("ralph", ralph.get("moverDerecha1"));
				try {
					Thread.sleep(sleepR);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imagenes.put("ralph", ralph.get("moverDerecha2"));
				try {
					Thread.sleep(sleepR);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imagenes.put("ralph", ralph.get("parado"));
				break;
			}
	}

	/**
	 * Refresca las imagenes de tiro de Ralph. Deja una espera de 500ms entre cada cambio de imagen
	 */
	public void refreshTiroRalph(){
		imagenes.put("ralph", ralph.get("tirar1"));
		try {
			Thread.sleep(sleepR);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imagenes.put("ralph", ralph.get("tirar2"));
		try {
			Thread.sleep(sleepR);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imagenes.put("ralph", ralph.get("tirar3"));
		try {
			Thread.sleep(sleepR);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imagenes.put("ralph", ralph.get("tirar4"));
		try {
			Thread.sleep(sleepR);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imagenes.put("ralph", ralph.get("tirar5"));
		try {
			Thread.sleep(sleepR);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imagenes.put("ralph", ralph.get("tirar6"));
		try {
			Thread.sleep(sleepR);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imagenes.put("ralph", ralph.get("parado"));
	}

	public EstadosJuego getEstado() {
		return estado;
	}

	public void setEstado(EstadosJuego estado) {
		this.estado = estado;
		screen.setEstado(estado);
	}

	public MapScreen getScreen() {
		return screen;
	}
	
	public void setScreen(MapScreen screen) {
		this.screen = screen;
	}
	
	/*
	 * refresca la imagen de felix cuando lo golpea un ladrillo
	 */
	public void refreshImagenGolpeFelix(){
		imagenes.put("felix", felix.get("golpe"));
		try {
			Thread.sleep(sleepFelixMart);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imagenes.put("felix", felix.get("paradoDerecha"));
	}
	
	/*
	 * refresca la imagen de felix cuando muere
	 */
	public void refreshImagenMuerteFelix(){
		imagenes.put("felix", felix.get("muerte1"));
		try {
			Thread.sleep(sleepF);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imagenes.put("felix", felix.get("muerte2"));
		try {
			Thread.sleep(sleepF);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imagenes.put("felix", felix.get("muerte3"));
		try {
			Thread.sleep(sleepF);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imagenes.put("felix", felix.get("muerte4"));
		try {
			Thread.sleep(sleepF);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imagenes.put("felix", felix.get("muerte5"));
		try {
			Thread.sleep(sleepF);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imagenes.put("felix", felix.get("muerte6"));
		try {
			Thread.sleep(sleepF);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imagenes.put("felix", felix.get("muerte7"));
		try {
			Thread.sleep(sleepF);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imagenes.put("felix", felix.get("paradoDerecha"));
	}
	
	/*
	 * referesca la imagen de felix cuando martilla
	 */
	public void refreshImagenMartilleoFelix(Boolean felixDerecha){
		if(felixDerecha){
			imagenes.put("felix", felix.get("martilloDerecha1"));
			try {
				Thread.sleep(sleepF);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			imagenes.put("felix", felix.get("martilloDerecha2"));
			try {
				Thread.sleep(sleepF);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			imagenes.put("felix", felix.get("paradoDerecha"));
		}else {
			imagenes.put("felix", felix.get("martilloIzquierda1"));
			try {
				Thread.sleep(sleepF);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			imagenes.put("felix", felix.get("martilloIzquierda2"));
			try {
				Thread.sleep(sleepF);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			imagenes.put("felix", felix.get("paradoIzquierda"));
			}
	}
	
	/*
	 * refresca la imagen de una ventana cuando se arregla
	 */
	public void setAreglarImagenVentana(Posicion pos){
		Ventana auxV= ventanas[pos.getX()][pos.getY()];
		if(!auxV.rota()){
			int x= pos.getX();
			int y= pos.getY();
			switch(auxV.getClass().getSimpleName()){
				case "DoblePanel":
					imagenesVentanas[x][y]= doblePanel.get("sana");
					break;
			
				case "Puerta":
					imagenesVentanas[x][y]= puerta.get("sana");
					break;
		
				case "Balcon":
					imagenesVentanas[x][y]= balcon.get("sano");
					break;
			}
		}
	}
	
}