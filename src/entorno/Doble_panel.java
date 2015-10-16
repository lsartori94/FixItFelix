package entorno;

/**
 * Clase que representa una ventana de doble panel.
 * Acepta todos los modificadores, excepto hoja.
 * Puede tener un pie que da poder.
 * Requiere 4 golpes para arreglarse.
 * Posee una imagen.
 * Tiene un contador de golpes de martillo acumulados.
 * @author lsartori
 */
public class Doble_panel extends Ventana{
	private boolean pie;
	private Panel panel_inferior;
	private Panel panel_superior;

	/**
	 * Constructor de Doble_panel.
	 * Setea automaticamente en 4 los golpes requeridos para el arreglo.
	 * Crea los paneles superior e inferior.
	 * 
	 * @param mold = indica si tiene moldura.
	 * @param mace = indica si tiene maceta.
	 * @param rota = indica si esta rota.
	 * @param img = imagen de la ventana.
	 */
	public Doble_panel(boolean mold, boolean mace, boolean rota/*, Sprite img*/) {
		super(mold, mace, rota, 4/*, Sprite img*/);
		// TODO Auto-generated constructor stub
		Panel p_i= new Panel(rota, rota);
		Panel p_s= new Panel(rota, rota);
		setPanel_inferior(p_i);
		setPanel_superior(p_s);
	}

	public boolean Pie() {
		return pie;
	}

	public void setPie(boolean pie) {
		this.pie = pie;
	}


	public Panel getPanel_inferior() {
		return panel_inferior;
	}


	public void setPanel_inferior(Panel panel_inferior) {
		this.panel_inferior = panel_inferior;
	}


	public Panel getPanel_superior() {
		return panel_superior;
	}


	public void setPanel_superior(Panel panel_superrior) {
		this.panel_superior = panel_superrior;
	}

	/**
	 * Metodo que rompe la ventana.
	 * Setea en rotos ambos paneles.
	 * Setea en 0 los golpes acumulados.
	 */
	public void romper(/*Sprite img*/){
		panel_inferior.romper();
		panel_superior.romper();
		super.setGolpes_act(0);
	}

	/**
	 * Sobreescribe arreglar de Ventana.
	 * Setea la imagen de la ventana.
	 * Si los golpes acumulados <=2 arregla panel inferior.
	 * Si los golpes acumulados >2 arregla panel superior.
	 */
	@Override
	public void arreglar(/*Sprite img*/){
		super.arreglar(/*img*/);
		if(super.getGolpes_act() <= 2){
			panel_inferior.arreglar();
		}else if(super.getGolpes_act() > 2){
			panel_superior.arreglar();
		}
		
	}
}
