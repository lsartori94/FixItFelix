package personajes;

public class Felix {
	private Posicion posicion;
	private Sprite imagen;
	private int vidas;
	private boolean poder;

	public Sprite getImagen() {
		return imagen;
	}

	public void setImagen(Sprite imagen) {
		this.imagen = imagen;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public boolean Poder() {
		return poder;
	}

	public void setPoder(boolean poder) {
		this.poder = poder;
	}

	public void martillar(){
		//metodo a ejecutar cuando se tenga que arreglar algo
	}

	public void golpe(){
		//metodo a ejecutar cuando se reciba un golpe
	}

	public void victoria(){
		// metodo a ejecutar cuando se gane el nivel
	}

	public void getVida(){
		// suma una vida al total
	}

}