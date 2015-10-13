package misc;


public enum Direccion {
		UP(1),
		DOWN(2),
		LEFT(3),
		RIGHT(4);
		
		private int value;
		
		public int getValue(){
			return value;
		}
		
		private Direccion(int v){
			this.value = v;
		}
}

