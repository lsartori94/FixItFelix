package entorno;

import misc.Hoja;

/**
 * Clase que representa ventana con hoja.
 * Impide el paso de Felix a traves de la hoja abierta.
 * No posee otros modificadores.
 * No puede estar rota.
 * 
 * 
 * Revisar para posterior agregado se sentido de apertura
 * 
 * @author lsartori Agustín Liébana
 *
 */
public class ConHoja extends Ventana{
	private Hoja hoja;
	
	public ConHoja(Hoja hoja){
		super(false, false, false, hoja, 0);
	}

	public void setAbierta(Hoja h){
		hoja= h;
	}

	public Hoja getAbierta(){
		return hoja;
	}
}
