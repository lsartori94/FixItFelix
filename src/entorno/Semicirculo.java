package entorno;

/**
 *Clase abstracta que representa a 
 *las ventanas semicirculares
 *
 *Este tipo de ventanas no posee modificadores
 * 
 * @param mold = si tiene moldura
 * @param macae = si posee maceta
 * @param rota = si esta rota
 * @param goples_fix = golpes necesarios para arreglarla
 * 
 */
public abstract class Semicirculo extends Ventana{

	public Semicirculo(boolean rota, int golpes_fix) {
		/**
		 * Llamado al constructor de la clase padre (ventana)
		 */
		super(false, false, rota, golpes_fix);
	}

}
