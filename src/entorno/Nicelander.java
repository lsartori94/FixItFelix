package entorno;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

public class Nicelander {
	private Map<String, BufferedImage> imagenes;
	
	public Nicelander(){
		cargarImagenes();
	}

	private void cargarImagenes(){
		try{
			if(imagenes.isEmpty()){
				imagenes.put("CAMBIAR ESTO PORQUE NO SE ME OCURRE", ImageIO.read(new File("RUTA.png")));
				imagenes.put("CAMBIAR ESTO PORQUE NO SE ME OCURRE", ImageIO.read(new File("RUTA.png")));
			}
			
		} catch(IOException e){
			System.out.println("Error interno en Nicelander" + e.getMessage());
		}
	}
}
