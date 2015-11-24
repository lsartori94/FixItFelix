package personajes;
import entorno.Seccion;
import misc.Direccion;
import misc.Posicion;

public class Felix {
	private Posicion posicion;
	private Seccion sec;
	private static final Posicion posInicial= new Posicion(2, 1);
	private int vidas;
	private boolean poder;
	private int limiteSup = 4;
	private int limiteInf = 0;
	private boolean derecha;

	//inicia Default Felix
	/*
	 * Inicializamos a felix en la posicion 2, 1 que se coorresponde con la posicion
	 * de la puerta del edificio. Ademas seteamos la cantidad de vidas y el estado
	 * del poder del mismo, en este caso falso.
	 * 
	 * @author Agustín Liébana lsartori
	 * 
	 */
	public void iniciar(Seccion sec){
		//se asume como posicion inicial el piso 0 a la mitad del mapa (fila 3 de 5)
		Posicion tmpPos = posInicial;
		setPosicion(tmpPos);
		setSec(sec);
		setPoder(false);
		//por ser prueba se informa creacion
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

	public void setVidas(int life) {
		vidas = life;
	}

	public boolean Poder() {
		return poder;
	}

	public void setPoder(boolean poder) {
		this.poder = poder;
	}

	//metodo a ejecutar cuando se tenga que arreglar algo
	public int martillar(){
		getSec().getVentana(getPosicion()).arreglar();
		getSec().setCantRotas(getSec().getCantRotas()-1);
		//se informa por ser prueba
		System.out.println("Felix martilla ventana");
		// devuelve el puntaje de martillar un panel
		return sec.getVentana(posicion).getPuntaje();
	}

	//metodo a ejecutar cuando se reciba un golpe
	public boolean golpe(){
		int vTemp= getVidas();
		setVidas((vTemp -1));
		boolean muerto= (getVidas() == 0)? true : false;
		//por ser prueba se informa
		System.out.println("Felix perdio una vida. Vidas restantes= "+getVidas());
		return muerto;
	}

	// metodo a ejecutar cuando se gane el nivel
	public void victoria(){

	}
	
	public int getLimiteSup() {
		return limiteSup;
	}

	public void setLimiteSup(int limiteSup) {
		this.limiteSup = limiteSup;
	}

	public int getLimteInf() {
		return limiteInf;
	}

	public void setLimteInf(int limteInf) {
		this.limiteInf = limteInf;
	}

	public Seccion getSec() {
		return sec;
	}

	public boolean derecha() {
		return derecha;
	}

	public void setDerecha(boolean derecha) {
		this.derecha = derecha;
	}

	public void setSec(Seccion sec) {
		this.sec = sec;
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
	 * A su vez controla que se pueda mover a esa ventana (que no tenga modificadores)
	 */
	public void move(Direccion d){
		Posicion tmp= posicion;
	
		switch (d.getValue()) {
			case 1:
				tmp.setY(tmp.getY()+1);
				if (tmp.getY() < limiteSup){
					if(!getSec().getVentana(tmp).macetero()){
						if(!getSec().getVentana(posicion).moldura()){
							setPosicion(tmp);
							System.out.println("Felix se movio arriba");
						} else{
							System.out.println("Hay moldura, no puede subir");
						}
					}else{
						System.out.println("Hay macetero arriba, no puede subir");
					}
				}else
					System.out.println("Felix no puede acceder a esa posicion, fuera de mapa");
				break;
		
			case 2:
				tmp.setY(tmp.getY()-1);
				if (tmp.getY() > limiteInf){
					if(!getSec().getVentana(tmp).moldura()){
						if(!getSec().getVentana(posicion).macetero()){
							setPosicion(tmp);
							System.out.println("Felix se movio abajo");
						} else{
							System.out.println("Hay macetero, no puede Bajar");
						}
					}else{
						System.out.println("Hay Moldura abajo, no puede bajar");
					}
				}else
					System.out.println("Felix no puede acceder a esa posicion, fuera de mapa");
				break;
	
			case 3:
				tmp.setX(tmp.getX()-1);
				if (tmp.getX() >= 0){
					if(getSec().getVentana(tmp).getHoja().getValue() == 1){
							System.out.println("Hay ventana con hojas abiertas en destino, no puede moverse en esa direccion");
					}else{
						switch (getSec().getVentana(posicion).getHoja().getValue()){
							case 1:
								System.out.println("Esta en una Ventana con hojas, no puede avanzar");
								break;
						
							default:
								setPosicion(tmp);
								setDerecha(false);
								System.out.println("Felix se movio a la izquierda.");
								break;
						}
					}
				}else
					System.out.println("Felix no puede acceder a esa posicion, fuera de mapa");
				break;
		
			case 4:
				tmp.setX(tmp.getX()+1);
				if (tmp.getX() < 5){
					if(getSec().getVentana(tmp).getHoja().getValue() == 1){
						System.out.println("Hay ventana con hojas abiertas en destino, no puede moverse en esa direccion");
					}else{
						switch (getSec().getVentana(posicion).getHoja().getValue()){
							case 1:
								System.out.println("Esta en una Ventana con hojas, no puede avanzar");
								break;
					
							default:
								setPosicion(tmp);
								setDerecha(true);
								System.out.println("Felix se movio a la derecha.");
								break;
						}
					}
			}else
				System.out.println("Felix no puede acceder a esa posicion, fuera de mapa");
			break;
		
			default:
				System.out.println("Direction Error.");
				break;
		}
		System.out.println("Posicion de Felix "+getPosicion().getX()+" * "+getPosicion().getY());
	}
}