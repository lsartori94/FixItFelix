package misc;

public enum Coin {
	HOJA(0),
	MACETA(1),
	MOLDURA(2);
	
	private int value;
	
	public int getValue(){
		return value;
	}
	
	public static Coin getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

	private Coin(int v){
		this.value = v;
	}
}
