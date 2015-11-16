package entorno;
/**
 * Clase que representa a una ventana.
 * Puede tener todos los tipos de modificadores (Moldura, maceta, nicelander).
 *
 * @author lsartori Agustín Liébana
 *
 */
public class Ventana {
		private boolean moldura;
		private boolean macetero;
		private boolean rota;
		private int golpesFix;
		private int golpesAct;
		//private Sprite imagen;
		
		/**
		 * Metodo de creacion de ventana.
		 * 
		 * @param mold = indica si tiene moldura.
		 * @param mace = indica si tiene maceta.
		 * @param rota = indica si esta rota.
		 * @param fix = golpes necesarios para arreglarse.
		 * @param img = imagen de la ventana.
		 */
		public Ventana(boolean mold, boolean mace, boolean rota, int fix/*, Sprite img*/){
			setMoldura(mold);
			setMacetero(mace);
			setGolpesFix(fix);
			setGolpesAct(0);
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

		public int getGolpesFix() {
			return golpesFix;
		}

		public void setGolpesFix(int golpesFix) {
			this.golpesFix = golpesFix;
		}

//		public Sprite getImagen() {
//			return imagen;
//		}

//		public void setImagen(Sprite imagen) {
//			this.imagen = imagen;
//		}

		public int getGolpesAct() {
			return golpesAct;
		}

		public void setGolpesAct(int golpesAct) {
			this.golpesAct = golpesAct;
		}

		/**
		 * Metodo de rotura de ventana.
		 * Setea en true el atributo de rota.
		 * Setea imagen de ventana rota.
		 * 
		 * @param img = imagen de ventana rota.
		 */
		public void romper(/*Sprite img*/){
			setRota(true);
			//por ser prueba no se cambia Sprite
			//setImagen(img);
		}

		/**
		 * Resta en 1 los golpes restantes para arreglarse.
		 * Si se arregla cambia de imagen y lo refleja en el atributo "rota"
		 * 
		 * @param img = imagen de ventana sana
		 */
		public void arreglar(/*Sprite img*/){
			setGolpesAct(getGolpesAct()+1);
		//	System.out.println("GOLPES ACUUTAL "+getGolpes_act());
			if(getGolpesAct() == getGolpesFix()){
				//setImagen(img);
				//al ser pruba se informa
				setRota(false);
				System.out.println("Ventana Arreglada");
			}
		}
}
