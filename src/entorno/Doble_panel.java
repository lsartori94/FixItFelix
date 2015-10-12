package entorno;

public class Doble_panel extends Ventana{
	private boolean pie;
	private Panel panel_inferior;
	private Panel panel_superior;

	public Doble_panel(boolean mold, boolean mace, boolean rota, boolean pie, Panel p_i, Panel p_s) {
		super(mold, mace, rota, 4);
		// TODO Auto-generated constructor stub
		setPie(pie);
		setPanel_inferior(p_i);
		setPanel_superior(p_s);
	}

	public boolean Pie() {
		return pie;
	}

	public void setPie(boolean pie) {
		this.pie = pie;
	}


	public Panel getPanel_inferior() {
		return panel_inferior;
	}


	public void setPanel_inferior(Panel panel_inferior) {
		this.panel_inferior = panel_inferior;
	}


	public Panel getPanel_superior() {
		return panel_superior;
	}


	public void setPanel_superior(Panel panel_superrior) {
		this.panel_superior = panel_superrior;
	}

}
