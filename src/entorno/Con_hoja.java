package entorno;

public class Con_hoja extends Ventana{
	private boolean abierta;
	
	public Con_hoja(boolean moldura ,boolean macetero, boolean abierta){
		super(moldura, macetero, false, 0);
		setAbierta(abierta);
	}

	public void setAbierta(boolean bol){
		abierta= bol;
	}

	public boolean getAbierta(){
		return abierta;
	}
}
