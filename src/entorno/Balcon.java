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
	private static final int golpesFix= 16;

	/**
	 * Constructor de Balcon.
	 * @param rota = indica si esta roto
	 */
	public Balcon(boolean rota) {
		super(rota, golpesFix);
	}


}
