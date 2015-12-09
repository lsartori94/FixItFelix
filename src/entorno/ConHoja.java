package entorno;
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
	
	
	public ConHoja(Hoja hoja){
		super(false, false, false, hoja, 0);
		super.setPuntaje(puntaje);
	}

	public void setAbierta(Hoja h){
		hoja= h;
	}

	public boolean getAbierta(){
		return (hoja.getValue() == 1)?true:false;
	}
}
