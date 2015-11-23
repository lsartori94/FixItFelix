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
	private static final int golpesFix= 8;

	/**
	 * Constructor de Puerta
	 * 
	 * @param rota = indica si esta rota
	 * @param paneles = vector de paneles de la puerta
	 * @param img = imagen de la ventana
	 */
	public Puerta(boolean rota) {
		super(rota, golpesFix);
	}
}
