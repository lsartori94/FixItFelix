package entorno;

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
	private boolean abierta;
	
	public ConHoja(boolean abierta){
		super(false, false, false, 0);
		setAbierta(abierta);
	}

	public void setAbierta(boolean bol){
		abierta= bol;
	}

	public boolean getAbierta(){
		return abierta;
	}
}
