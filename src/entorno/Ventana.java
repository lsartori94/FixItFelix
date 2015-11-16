package entorno;

import misc.Hoja;

/**
 * Clase que representa a una ventana.
 * Puede tener todos los tipos de modificadores (Moldura, maceta, nicelander).
 *
 * @author lsartori Agustín Liébana
 *
 */
public class Ventana {
		private static final int golpesIniciar= 0;
		private boolean moldura;
		private boolean macetero;
		private boolean rota;
		private Hoja hoja;
		private int golpesFix;
		private int golpesAct;
		
		/**
		 * Metodo de creacion de ventana.
		 * 
		 * @param mold = indica si tiene moldura.
		 * @param mace = indica si tiene maceta.
		 * @param rota = indica si esta rota.
		 * @param fix = golpes necesarios para arreglarse.
		 * @param hoja = indica si no tiene hojas (0), si esta cerrada(1) o si esta abierta(2).
		 */
		public Ventana(boolean mold, boolean mace, boolean rota, Hoja hoja, int fix){
			setMoldura(mold);
			setMacetero(mace);
			setGolpesFix(fix);
			setHoja(hoja);
			setGolpesAct(golpesIniciar);
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

		public int getGolpesAct() {
			return golpesAct;
		}

		public void setGolpesAct(int golpesAct) {
			this.golpesAct = golpesAct;
		}

		
		public Hoja getHoja() {
			return hoja;
		}

		public void setHoja(Hoja hoja) {
			this.hoja = hoja;
		}

		/**
		 * Metodo de rotura de ventana.
		 * Setea en true el atributo de rota.
		 * Setea imagen de ventana rota.
		 */
		public void romper(){
			setRota(true);
		}

		/**
		 * Resta en 1 los golpes restantes para arreglarse.
		 * Si se arregla cambia de imagen y lo refleja en el atributo "rota"
		 * 
		 * @param img = imagen de ventana sana
		 */
		public void arreglar(){
			setGolpesAct(getGolpesAct()+1);
		//	System.out.println("GOLPES ACUUTAL "+getGolpes_act());
			if(getGolpesAct() == getGolpesFix()){
			//	al ser pruba se informa
				setRota(false);
				System.out.println("Ventana Arreglada");
			}
		}
}
