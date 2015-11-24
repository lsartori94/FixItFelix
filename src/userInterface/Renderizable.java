package userInterface;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import misc.Direccion;

public class Renderizable extends TimerTask {

	private Timer timer;
	private static final long periodoTimer= 100;
	private Map <String, BufferedImage> balcon;
	private boolean romperBalcon= false;
	private Map <String, BufferedImage> conHoja;
	private Map <String, BufferedImage> doblePanel;
	private boolean romperDoblePanel= false;
	private String panelDobleRender;
	private Map <String, BufferedImage> ladrillo;
	private boolean destruirLadrillo= false;
	private Map <String, BufferedImage> nicelander;
	private boolean hayNicelander= false;
	private Map <String, BufferedImage> pato;
	private boolean destruirPato= false;
	private Map <String, BufferedImage> puerta;
	private boolean romperPuerta= false;
	private Map <String, BufferedImage> felix;
	private boolean felixDerecha= false;
	private Map <String, BufferedImage> ralph;
	private boolean ralphDerecha= false;
	private Map <String, BufferedImage> misc;
	private Map <String, BufferedImage> edificio;	
	private Map <String, Map<String, BufferedImage>> imagenes;

	public Renderizable(Timer tim){
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
		
		timer= tim;
	}
	
	@Override
	public void run(){
		
	}
	
	public void finRender() {
		timer.cancel();
	}
	
	public boolean isRomperBalcon() {
		return romperBalcon;
	}

	public void setRomperBalcon(boolean romperBalcon) {
		this.romperBalcon = romperBalcon;
	}

	public boolean isRomperDoblePanel() {
		return romperDoblePanel;
	}

	public void setRomperDoblePanel(boolean romperDoblePanel) {
		this.romperDoblePanel = romperDoblePanel;
	}

	public boolean isDestruirLadrillo() {
		return destruirLadrillo;
	}

	public void setDestruirLadrillo(boolean destruirLadrillo) {
		this.destruirLadrillo = destruirLadrillo;
	}

	public boolean isHayNicelander() {
		return hayNicelander;
	}

	public void setHayNicelander(boolean hayNicelander) {
		this.hayNicelander = hayNicelander;
	}

	public boolean isDestruirPato() {
		return destruirPato;
	}

	public void setDestruirPato(boolean destruirPato) {
		this.destruirPato = destruirPato;
	}

	public boolean isRomperPuerta() {
		return romperPuerta;
	}

	public void setRomperPuerta(boolean romperPuerta) {
		this.romperPuerta = romperPuerta;
	}

	public boolean isFelixDerecha() {
		return felixDerecha;
	}

	public void setFelixDerecha(boolean felixDerecha) {
		this.felixDerecha = felixDerecha;
	}

	public boolean isRalphDerecha() {
		return ralphDerecha;
	}

	public void setRalphDerecha(boolean ralphDerecha) {
		this.ralphDerecha = ralphDerecha;
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
			}
		} catch(IOException e){
			System.out.println("Error interno en Misc" + e.getMessage());
		}
	}
	
	private void cargarImagenesBalcon(){
		try{
			if(balcon.isEmpty()){
				balcon.put("rota", ImageIO.read(new File("src/imagenes/balcon_roto.png")));
				balcon.put("sana", ImageIO.read(new File("src/imagenes/balcon_sano.png")));
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
				doblePanel.put("conMaceta", ImageIO.read(new File("src/imagenes/ventana_doble_macetero")));
				doblePanel.put("conMoldura", ImageIO.read(new File("src/imagenes/ventana_doble_moldura")));
			}
			
		} catch(IOException e){
			System.out.println("Error interno en Ventana de Doble Panel" + e.getMessage());
		}
	}
	
	private void randomDoblePanel(){
		if(romperDoblePanel){
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
		}else{
			panelDobleRender= "sana";
		}
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
				nicelander.put("sinPie", ImageIO.read(new File("src/imagenes/nicelander_conPie.png")));
				nicelander.put("conPie", ImageIO.read(new File("src/imagenes/nicelander_sinPie.png")));
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
				felix.put("saltarDerecha", ImageIO.read(new File("src/imagenes/felix_saltar_derecha.png")));
				felix.put("saltarIzquierda", ImageIO.read(new File("src/imagenes/felix_saltar_izquierda.png")));
				felix.put("golpe", ImageIO.read(new File("src/imagenes/felix_golpe.png")));
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
	
	private void cargarTodo(){
		imagenes.put("edificio", edificio);
		imagenes.put("misc", misc);
		imagenes.put("balcon", balcon);
		imagenes.put("conHoja", conHoja);
		imagenes.put("doblePanel", doblePanel);
		imagenes.put("ladrillo", ladrillo);
		imagenes.put("nicelander", nicelander);
		imagenes.put("pato", pato);
		imagenes.put("puerta", puerta);
		imagenes.put("felix", felix);
		imagenes.put("ralph", ralph);
	}
	
	/**
	 * Refresca las imagenes de movimiento de felix
	 * @param d = direccion de movimiento
	 */
	private void refreshImagenPosicionFelix(Direccion d){
		if(felixDerecha){
			switch(d.getValue()){
			case 1:
				pintar(felix.get("saltarDerecha"));
				Thread.sleep(500);
				pintar(felix.get("paradoDerecha"));
				break;
			case 2:
				pintar(felix.get("saltarDerecha"));
				Thread.sleep(500);
				pintar(felix.get("paradoDerecha"));
				break;
			case 3:
				pintar(felix.get("moverIzquierda"));
				Thread.sleep(500);
				pintar(felix.get("paradoIzquierda"));
				break;
			case 4:
				pintar(felix.get("moverDerecha"));
				Thread.sleep(500);
				pintar(felix.get("paradoDerecha"));
				break;
			}
		} else{
			switch(d.getValue()){
			case 1:
				pintar(felix.get("saltarIzquierda"));
				Thread.sleep(500);
				pintar(felix.get("paradoIzquierda"));
				break;
			case 2:
				pintar(felix.get("saltarIzquierda"));
				Thread.sleep(500);
				pintar(felix.get("paradoIzquierda"));
				break;
			case 3:
				pintar(felix.get("moverIzquierda"));
				Thread.sleep(500);
				pintar(felix.get("paradoIzquierda"));
				break;
			case 4:
				pintar(felix.get("moverDerecha"));
				Thread.sleep(500);
				pintar(felix.get("paradoDerecha"));
				break;
			}
		}	
	
	/**
	 * Refresca las imagenes de movimiento de Ralph
	 * @param d direccion del movimiento
	 */
	private void refreshImagenPosicionRalph(Direccion d){
		if(ralphDerecha){
			switch(d.getValue()){
			case 1:
				pintar(ralph.get("subir1"));
				//WAIT
				pintar(ralph.get("subir2"));
				//WAIT
				pintar(ralph.get("parado"));
				break;
			case 2:
				pintar(ralph.get("subir1"));
				//WAIT
				pintar(ralph.get("subir2"));
				//WAIT
				pintar(ralph.get("parado"));
				break;
			case 3:
				pintar(ralph.get("moverIzquierda1"));
				//WAIT
				pintar(ralph.get("moverIzquierda2"));
				//WAIT
				pintar(ralph.get("parado"));
				break;
			case 4:
				pintar(ralph.get("moverDerecha1"));
				//WAIT
				pintar(ralph.get("moverDerecha2"));
				//WAIT
				pintar(ralph.get("parado"));
				break;
			}
		} else{
			switch(d.getValue()){
			case 1:
				pintar(ralph.get("subir1"));
				//WAIT
				pintar(ralph.get("subir2"));
				//WAIT
				pintar(ralph.get("parado"));
				break;
			case 2:
				pintar(ralph.get("subir1"));
				//WAIT
				pintar(ralph.get("subir2"));
				//WAIT
				pintar(ralph.get("parado"));
				break;
			case 3:
				pintar(ralph.get("moverDerecha1"));
				//WAIT
				pintar(ralph.get("moverDerecha2"));
				//WAIT
				pintar(ralph.get("parado"));
				break;
			case 4:
				pintar(ralph.get("moverIzquierda1"));
				//WAIT
				pintar(ralph.get("moverIzquierda2"));
				//WAIT
				pintar(ralph.get("parado"));
				break;
			}
		}
	}	
	
	/**
	 * Refresca las imagenes de movimiento del pato
	 * @param d direccion del movimiento
	 */
	private void refreshImagenPosicionPato(Direccion d){
		switch(d.getValue()){
		case 3:
			pintar(pato.get("aleteoIzquierda1"));
			//WAIT
			pintar(pato.get("aleteoizquierda2"));
			break;
		case 4:
			pintar(pato.get("aleteoDerecha1"));
			//WAIT
			pintar(pato.get("aleteoDerecha2"));
			break;
		}
	}	
}
