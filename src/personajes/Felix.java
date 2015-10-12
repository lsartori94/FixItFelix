package personajes;
import misc.Posicion;

public class Felix {
	private Posicion posicion;
	//se comenta Sprite por ser prueba
//	private Sprite imagen;
	private int vidas;
	private boolean poder;

	//inicia Default Felix
	public void iniciar(){
		//se asume como posicion inicial el piso 0 a la mitad del mapa (fila 3 de 5)
		Posicion tmp_pos= new Posicion(3, 0);
		setPosicion(tmp_pos);
		setVidas(3);
		setPoder(false);
		//aca se define la imagen con setImagen
		//por ser prueba se informa creacion
		System.out.println(" ");
		System.out.println("Felix se creo en la posicion "+getPosicion().getX()+", "+getPosicion().getY()+" con "+getVidas()+" vidas");
		System.out.println("Poder de Felix= "+Poder());
	}

/*	public Sprite getImagen() {
		return imagen;
	}

	public void setImagen(Sprite imagen) {
		this.imagen = imagen;
	}
*/
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

	//metodo a ejecutar para mover a Felix en una direccion
	//direccion no se utiliza por ser prueba
//	public void mover(Direccion dir){
//		
//	}

	//metodo a ejecutar cuando se tenga que arreglar algo
	public void martillar(/*Sprite img*/){
		//setImagen(img);
		//se informa por ser prueba
		System.out.println("Felix martilla ventana");
	}

	//metodo a ejecutar cuando se reciba un golpe
	public void golpe(){
		int v_temp= getVidas();
		setVidas(v_temp --);
		//luego se debe implementar el Sprite correspondiente
		//por ser prueba se informa
		System.out.println("Felix perdio una vida. Vidas restantes= "+getVidas());
	}

	// metodo a ejecutar cuando se gane el nivel
	public void victoria(){

	}

	// suma una vida al total
	public void sumarVida(){
		int v_temp= getVidas();
		setVidas(v_temp ++);
	}

	public void mover(Direccion dir){
		
	}
}