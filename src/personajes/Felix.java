package personajes;
import misc.Direccion;
import misc.Posicion;

public class Felix {
	private Posicion posicion;
	private static final Posicion posInicial= new Posicion(2, 1);
	private int vidas;
	private boolean poder;
	public final int vidasInicio= 3;

	//inicia Default Felix
	/*
	 * Inicializamos a felix en la posicion 2, 1 que se coorresponde con la posicion
	 * de la puerta del edificio. Ademas seteamos la cantidad de vidas y el estado
	 * del poder del mismo, en este caso falso.
	 * 
	 * @author Agustín Liébana lsartori
	 * 
	 */
	public void iniciar(){
		//se asume como posicion inicial el piso 0 a la mitad del mapa (fila 3 de 5)
		Posicion tmpPos= posInicial;
		setPosicion(tmpPos);
		setVidas(vidasInicio);
		setPoder(false);
		//aca se define la imagen con setImagen
		//por ser prueba se informa creacion
		System.out.println(" ");
		System.out.println("Felix se creo en la posicion "+getPosicion().getX()+", "+getPosicion().getY()+" con "+getVidas()+" vidas");
		System.out.println("Poder de Felix= "+Poder());
	}

	/*
	 * Estos metodos proporcionan la informacion pertinente del personaje
	 * como la posicion y las vidas del mismo.
	 */
	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
		//al ser prueba se informa del movimiento
		//System.out.println("Felix se movio a ["+posicion.getX()+" , "+posicion.getY()+"]");

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
		int vTemp= getVidas();
		setVidas((vTemp -1));
		//luego se debe implementar el Sprite correspondiente
		//por ser prueba se informa
		System.out.println("Felix perdio una vida. Vidas restantes= "+getVidas());
	}

	// metodo a ejecutar cuando se gane el nivel
	public void victoria(){

	}

	// suma una vida al total
	public void sumarVida(){
		int vTemp= getVidas();
		setVidas(vTemp ++);
	}

	/*
	 * Este metodo se encarga de mover a felix a lo largo de la matriz
	 * que compone la seccion de ventanas. Los diferente case se corresponden
	 * con los valores del enumerativo Direccion. Los condicionales de cada
	 * movimiento estan ajustados al diseño actual de la seccion.
	 */
	public void move(Direccion d){
	Posicion tmp= posicion;
	
	switch (d.getValue()) {
		case 1:
			tmp.setY(tmp.getY()+1);
			if (tmp.getY() < 4){
				setPosicion(tmp);
				System.out.println("Felix se movio arriba");
			}else
				System.out.println("Felix no puede acceder a esa posicion");
			break;
		
		case 2:
			tmp.setY(tmp.getY()-1);
			if (tmp.getY() > 1){
				setPosicion(tmp);
				System.out.println("Felix se movio abajo");
			}else
				System.out.println("Felix no puede acceder a esa posicion");
			break;
	
		case 3:
			tmp.setX(tmp.getX()-1);
			if (tmp.getX() >= 0){
				setPosicion(tmp);
				System.out.println("Felix se movio a la izquierda.");
			}else
				System.out.println("Felix no puede acceder a esa posicion");
			break;
		
		case 4:
			tmp.setX(tmp.getX()+1);
			if (tmp.getX() < 5){
				setPosicion(tmp);
				System.out.println("Felix se movio a la derecha.");
			}else
				System.out.println("Felix no puede acceder a esa posicion");
			break;
		
		default:
			System.out.println("Direction Error.");
			break;
	}

}

}