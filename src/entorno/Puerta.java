package entorno;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

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
	private Map <String, BufferedImage> imagenes;

	/**
	 * Constructor de Puerta
	 * 
	 * @param rota = indica si esta rota
	 * @param paneles = vector de paneles de la puerta
	 * @param img = imagen de la ventana
	 */
	public Puerta(boolean rota) {
		super(rota, golpesFix);
		cargarImagenes();
		super.setImagenes(imagenes);
	}
	
	private void cargarImagenes(){
		try{
			if(imagenes.isEmpty()){
				imagenes.put("rota", ImageIO.read(new File("puerta_rota.png")));
				imagenes.put("sana", ImageIO.read(new File("puerta_sana.png")));
			}
			
		} catch(IOException e){
			System.out.println("Error interno en Puerta" + e.getMessage());
		}
	}
}
