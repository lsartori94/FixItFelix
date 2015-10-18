package entorno;
/**
 * Clase que simula el Panel de una Ventana.
 * Puede estar parcial o completamente roto.
 * @author lsartori Agustín Liébana
 */
public class Panel {
	private boolean parcial;
	private boolean completa;
	
	/**
	 * Constructor del Panel
	 * Si ambos parametros estan en false, el panel esta sano.
	 * 
	 * @param parcial = indica si el panel esta parcialmente roto.
	 * @param completa = indica si el panel esta completamente roto.
	 */
	public Panel(boolean parcial, boolean completa){
		setParcial(parcial);
		setCompleta(completa);
	}
	
	public boolean parcial() {
		return parcial;
	}
	
	public void setParcial(boolean parcial) {
		this.parcial = parcial;
	}
	
	public boolean completa() {
		return completa;
	}
	
	public void setCompleta(boolean completa) {
		this.completa = completa;
	}

	/**
	 * Arregla el panel.
	 * Si el panel esta completamente roto lo pone en parcial.
	 * Si el panel esta parcialmeente roto lo arregla.
	 */
	public void arreglar(){
		if(parcial())
			setCompleta(true);
		setParcial(true);
	}

	/**
	 * Rompe el panel.
	 * Pone el panel completamente roto.
	 */
	public void romper(){
		setParcial(false);
		setCompleta(false);
	}
}
