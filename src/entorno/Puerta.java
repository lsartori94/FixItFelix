package entorno;
/**
 * Clase que simula la puerta del edificio.
 * No posee modificadores.
 * Requiere 8 golpes para arreglarse.
 * 
 * @author lsartori Agustín Liébana
 *
 *Los paneles se ecnuentran comentados por no ser necesarios para la prueba.
 */

public class Puerta extends Semicirculo {
	//private Panel[] paneles;

	/**
	 * Constructor de Puerta
	 * 
	 * @param rota = indica si esta rota
	 * @param paneles = vector de paneles de la puerta
	 */
	public Puerta(boolean rota/*, Panel [] paneles*/) {
		super(rota, 8);
	//	setPaneles(paneles);
	}

//	public Panel[] getPaneles() {
//		return paneles;
//	}

//	public void setPaneles(Panel[] paneles) {
//		this.paneles = paneles;
//	}

	
}
