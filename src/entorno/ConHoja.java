package entorno;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import misc.Hoja;

/**
 * Clase que representa ventana con hoja.
 * Impide el paso de Felix a traves de la hoja abierta.
 * No posee otros modificadores.
 * No puede estar rota.
 * No da puntos
 * 
 * Revisar para posterior agregado se sentido de apertura
 * 
 * @author lsartori Agustín Liébana
 *
 */
public class ConHoja extends Ventana{
	private Hoja hoja;
	private static final int puntaje= 0;
	private Map<String, BufferedImage> imagenes;
	
	
	public ConHoja(Hoja hoja){
		super(false, false, false, hoja, 0);
		super.setPuntaje(puntaje);
		cargarImagenes();
		super.setImagenes(imagenes);
	}

	public void setAbierta(Hoja h){
		hoja= h;
	}

	public Hoja getAbierta(){
		return hoja;
	}

	private void cargarImagenes(){
		try{
			if(imagenes.isEmpty()){
				imagenes.put("abierta", ImageIO.read(new File("ventana_hoja_abierta.png")));
				imagenes.put("cerrada", ImageIO.read(new File("ventana_hoja_cerrada.png")));
			}
			
		} catch(IOException e){
			System.out.println("Error interno en Ventana con Hoja" + e.getMessage());
		}
	}
}
