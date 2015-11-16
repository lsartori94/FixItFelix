package misc;

/*
 * Este enumerativo representa las modificaciones de hoja posibles.
 * 
 * @author Agustín Liébana lsartori
 */
public enum Hoja{
		NO(0),
		ABIERTA(1),
		CERRADA(2);
		
		private int value;
		
		public int getValue(){
			return value;
		}
		
		private Hoja(int v){
			this.value = v;
		}
}

