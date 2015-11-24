package entorno;
import misc.Hoja;

/**
 *Clase abstracta que representa a 
 *las ventanas semicirculares
 *
 *Este tipo de ventanas no posee modificadores
 * 
 * @param mold = si tiene moldura
 * @param macae = si posee maceta
 * @param rota = si esta rota
 * @param goplesFix = golpes necesarios para arreglarla
 * @param imgamenes = imagenes de la ventana
 *
 * @author Agustín Liébana lsartori
 */
public abstract class Semicirculo extends Ventana{
	

	public Semicirculo(boolean rota, int golpesFix) {
		/**
		 * Llamado al constructor de la clase padre (ventana)
		 */
		super(false, false, rota, Hoja.NO, golpesFix);
	}
}
