package entorno;

public class Ventana {
		private boolean moldura;
		private boolean macetero;
		private boolean rota;
		//golpes para arreglar
		private int golpes_fix;
		//golpes acumulados
		private int golpes_act;
		//al ser prueba se comenta Sprite
		//private Sprite imagen;
		
		//metodo de creacion de ventana
		public Ventana(boolean mold, boolean mace, boolean rota, int fix/*, Sprite img*/){
			setMoldura(mold);
			setMacetero(mace);
			setGolpes_fix(fix);
			setGolpes_act(0);
			//setImagen(img);
			setRota(rota);
		}

		public boolean moldura() {
			return moldura;
		}

		public void setMoldura(boolean moldura) {
			this.moldura = moldura;
		}

		public boolean macetero() {
			return macetero;
		}

		public void setMacetero(boolean macetero) {
			this.macetero = macetero;
		}

		public boolean rota() {
			return rota;
		}

		public void setRota(boolean rota) {
			this.rota = rota;
		}

		public int getGolpes_fix() {
			return golpes_fix;
		}

		public void setGolpes_fix(int golpes_fix) {
			this.golpes_fix = golpes_fix;
		}

//		public Sprite getImagen() {
//			return imagen;
//		}

//		public void setImagen(Sprite imagen) {
//			this.imagen = imagen;
//		}

		public int getGolpes_act() {
			return golpes_act;
		}

		public void setGolpes_act(int golpes_act) {
			this.golpes_act = golpes_act;
		}

		public void romper(/*Sprite img*/){
			setRota(true);
			//por ser prueba no se cambia Sprite
			//setImagen(img);
		}

		public void arreglar(/*Sprite img*/){
			setGolpes_act(getGolpes_act()+1);
		//	System.out.println("GOLPES ACUUTAL "+getGolpes_act());
			if(getGolpes_act() == getGolpes_fix()){
				//setImagen(img);
				//al ser pruba se informa
				setRota(false);
				System.out.println("Ventana Arreglada");
			}
		}
}
