package entorno;

public class Balcon extends Semicirculo{
	private Panel [] paneles;

	public Balcon(boolean mold, boolean mace, boolean rota, Panel [] paneles) {
		super(mold, mace, rota);
		// TODO Auto-generated constructor stub
		setPaneles(paneles);
	}

	public Panel[] getPaneles() {
		return paneles;
	}

	public void setPaneles(Panel[] paneles) {
		this.paneles = paneles;
	}

}
