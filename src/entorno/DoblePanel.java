package entorno;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import misc.Hoja;

/**
 * Clase que representa una ventana de doble panel.
 * Acepta todos los modificadores, excepto hoja.
 * Puede tener un pie que da poder.
 * Requiere 4 golpes para arreglarse.
 * Posee una imagen.
 * Tiene un contador de golpes de martillo acumulados.
 * @author lsartori Agustín Liébana
 */
public class DoblePanel extends Ventana{
	private static final int golpesFix= 4;
	private static final int golpesACero= 0;
	private boolean pie;
	private Panel panelInferior;
	private Panel panelSuperior;
	private Map <String, BufferedImage> imagenes;

	/**
	 * Constructor de Doble_panel.
	 * Setea automaticamente en 4 los golpes requeridos para el arreglo.
	 * Crea los paneles superior e inferior.
	 * 
	 * @param mold = indica si tiene moldura.
	 * @param mace = indica si tiene maceta.
	 * @param rota = indica si esta rota.
	 */
	public DoblePanel(boolean mold, boolean mace, boolean rota) {
		super(mold, mace, rota, Hoja.NO, golpesFix);
		cargarImagenes();
		super.setImagenes(imagenes);
		Panel pR= new Panel(rota, rota);
		Panel pS= new Panel(rota, rota);
		setPanelInferior(pR);
		setPanelSuperior(pS);
	}

	public boolean Pie() {
		return pie;
	}

	public void setPie(boolean pie) {
		this.pie = pie;
	}


	public Panel getPanelInferior() {
		return panelInferior;
	}


	public void setPanelInferior(Panel panelInferior) {
		this.panelInferior = panelInferior;
	}


	public Panel getPanelSuperior() {
		return panelSuperior;
	}


	public void setPanelSuperior(Panel panelSuperrior) {
		this.panelSuperior = panelSuperrior;
	}

	/**
	 * Metodo que rompe la ventana.
	 * Setea en rotos ambos paneles.
	 * Setea en 0 los golpes acumulados.
	 */
	public void romper(){
		panelInferior.romper();
		panelSuperior.romper();
		super.setGolpesAct(golpesACero);
	}

	/**
	 * Sobreescribe arreglar de Ventana.
	 * Setea la imagen de la ventana.
	 * Si los golpes acumulados <=2 arregla panel inferior.
	 * Si los golpes acumulados >2 arregla panel superior.
	 */
	@Override
	public void arreglar(){
		super.arreglar();
		if(super.getGolpesAct() <= 2){
			panelInferior.arreglar();
		}else if(super.getGolpesAct() > 2){
			panelSuperior.arreglar();
		}
		
	}

	private void cargarImagenes(){
		try{
			if(imagenes.isEmpty()){
				imagenes.put("rota1", ImageIO.read(new File("ventana_doble_rota_1.png")));
				imagenes.put("rota2", ImageIO.read(new File("ventana_doble_rota_2.png")));
				imagenes.put("rota3", ImageIO.read(new File("ventana_doble_rota_3.png")));
				imagenes.put("sana", ImageIO.read(new File("ventana_doble_sana.png")));
			}
			
		} catch(IOException e){
			System.out.println("Error interno en Ventana de Doble Panel" + e.getMessage());
		}
	}
}
