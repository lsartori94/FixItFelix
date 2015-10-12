package personajes;
import entorno.Ladrillo;
import misc.Posicion;

public class Ralph {

	private int cant_ladrillos;
	private int time_ladrillo;
	//espera entre cambio de posicion
	private int velocidad;
	private Ladrillo ladrillo;
	//tiempo de espera entre ladrillos
	private int intervalo_lad;
	//Sprite se comenta por ser prueba
	//private Sprite imagen;
	private Seccion seccion;
	private Posicion posicion;

	//metodo para iniciar a Ralph por nivel. no se asume Sprite por ser prueba
	public void Ralph(int cant_lad, int tiempo_lad, int vel_ralph, Posicion pos, Seccion sec/*, Sprite img*/){
		setPosicion(pos);
		setCantLadrillos(cant_lad);
		setTimeLadrillo(tiempo_lad);
		setVelocidad(vel_ralph);
		setSeccion(sec);
		//por ser prueba se informa lo realizado
		System.out.println(" ");
		System.out.println("Ralph se inicio en la Seccion " +Seccion.id()+ " en la posicion "+getPosicion().getX()+ ", "+getPosicion().getY());
		System.out.println("Ralph tiene "+getCantLadrillos()+ " ladrillos, con un espacio de lanzamiento de "+getTimeLadrillo()+" segundos");
		System.out.println("Ralph se mueve de lugar cada "+getVelocidad()+" segundos");
	}
	
	//metodo a ejecutar para mover a Ralph en una direccion
	//direccion no se utiliza por ser prueba
//	public void mover(Direccion dir){
//		
//	}

	//metodo a ejecutar para que Ralph tire un ladrillo
	public void shoot(){
		
	}

	public Posicion getPosicion(){
		return posicion;
	}

//	public Sprite getImagen(){
//		return imagen;
//	}

	public int getCantLadrillos(){
		return cant_ladrillos;
	}

	public int getTimeLadrillo(){
		return time_ladrillos;
	}

	public int getVelocidad(){
		return velocidad;
	}

	public void setPosicion(Posicion pos){
		posicion= pos;
	}

//	public void setImagen(Sprite img){
//		imagen= img;
//	}

	public void setCantLadrillos(int lad){
		cant_ladrillos= lad;
	}

	public void setTimeLadrillo(int tlad){
		time_ladrillo= tlad;
	}

	public void setVelocidad(int vel){
		velocidad= vel;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}


	public int getIntervalo_lad() {
		return intervalo_lad;
	}


	public void setIntervalo_lad(int intervalo_lad) {
		this.intervalo_lad = intervalo_lad;
	}
	
}