package entorno;

public class Panel {
	private boolean parcial;
	private boolean completa;
	
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

	public void arreglar(){
		if(parcial())
			setCompleta(true);
		setParcial(true);
	}

	public void romper(){
		setParcial(false);
		setCompleta(false);
	}
}
