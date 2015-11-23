package entorno;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

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
	private Map <String, BufferedImage> imagenes;

	/**
	 * Constructor de Balcon.
	 * @param rota = indica si esta roto
	 */
	public Balcon(boolean rota) {
		super(rota, golpesFix);
		cargarImagenes();
		super.setImagenes(imagenes);
	}

	private void cargarImagenes(){
		try{
			if(imagenes.isEmpty()){
				imagenes.put("rota", ImageIO.read(new File("balcon_roto.png")));
				imagenes.put("sana", ImageIO.read(new File("balcon_sano.png")));
			}
			
		} catch(IOException e){
			System.out.println("Error interno en Balcon" + e.getMessage());
		}
	}
}
