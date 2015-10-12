package entorno;

public class Ventana {
		private boolean moldura;
		private boolean macetero;
		private boolean rota;
		//golpes para arreglar
		private int golpes_fix;
		//al ser prueba se comenta Sprite
		//private Sprite imagen;
		
		//metodo de creacion de ventana
		public Ventana(boolean mold, boolean mace, boolean rota, int fix/*, Sprite img*/){
			setMoldura(mold);
			setMacetero(mace);
			setGolpes_fix(fix);
			//setImagen(img);
			setRota(rota);
			//por ser prueba se informa cracion
			System.out.println(" ");
			System.out.println("Se creo ventana con moldura= "+moldura()+", macetero= "+macetero()+", rota= "+rota()+" y "+getGolpes_fix()+" golpes para arreglarse");
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

		public void romper(/*Sprite img*/){
			setRota(true);
			//por ser prueba no se cambia Sprite
			//setImagen(img);
		}

		public void arreglar(/*Sprite img*/){
			setGolpes_fix(getGolpes_fix()-1);
			if(getGolpes_fix() == 0)
				//setImagen(img);
				//al ser pruba se informa
				System.out.println("Ventana Arreglada");
		}
}
