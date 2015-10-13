package entorno;

public class Doble_panel extends Ventana{
	private boolean pie;
	private Panel panel_inferior;
	private Panel panel_superior;

	public Doble_panel(boolean mold, boolean mace, boolean rota/*, Sprite img*/) {
		super(mold, mace, rota, 4/*, Sprite img*/);
		// TODO Auto-generated constructor stub
		Panel p_i= new Panel(true, true);
		Panel p_s= new Panel(true, true);
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

	public void romper(/*Sprite img*/){
		panel_inferior.romper();
		panel_superior.romper();
		super.setGolpes_act(0);
	}

	@Override
	public void arreglar(/*Sprite img*/){
		super.arreglar(/*img*/);
		if(super.getGolpes_act() <= 2){
			panel_inferior.arreglar();
		}else if(super.getGolpes_act() > 2){
			panel_superior.arreglar();
		}
		
	}
}
