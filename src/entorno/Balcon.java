package entorno;

/**
 * Clase que representa el balcon.
 * No posee modificadores.
 * Requiere 16 golpes para arrelarse.
 * 
 * @author lsartori Agustín Liébana
 *
 *Paneles se encuentran comentados por ser prueba.
 */

public class Balcon extends Semicirculo{
//	private Panel [] paneles;
	private static final int golpesFix= 16;

	/**
	 * Constructor de Balcon.
	 * 
	 * @param rota = indica si esta roto
	 * @param paneles = array de paneles
	 * 
	 */
	public Balcon(boolean rota/*, Panel [] paneles*/) {
		super(rota, golpesFix);
//		setPaneles(paneles);
	}

//	public Panel[] getPaneles() {
//		return paneles;
//	}

//	public void setPaneles(Panel[] paneles) {
//		this.paneles = paneles;
//	}

}
