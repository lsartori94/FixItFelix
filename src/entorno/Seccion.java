package entorno;
import misc.Posicion;

/**
 * Clase qye representa una seccion de ventanas.
 * Tiene una cantidad de filas, columnas, ventanas rotas y ventanas modificadas.
 * Posee una imagen.
 * Posee una matriz de ventanas.
 * @author lsartori Agustín Liébana
 */
public class Seccion {
	private int cantFilas;
	private int cantColumnas;
	private int cantRotas;
	private int cantModificador;
	private int id;
	private boolean hayPato;
	private Posicion posPato;
	private Ventana [][] ventanas;

	/**
	 * Constructor de la seccion.
	 * 
	 * @param cF = cantidad de filas.
	 * @param cC = cantidad de columnas.
	 * @param cRot = cantidad de ventanas rotas.
	 * @param cmod = cantidad de ventanas modificadas.
	 * @param ventanas = matriz de ventanas.
	 */
	public Seccion(int cF, int cC, int cRot, int cMod, Ventana[][] ventanas, int iD, boolean pato){
		setCantFilas(cF);
		setCantColumnas(cC);
		setCantRotas(cRot);
		setCantModificador(cMod);
		setVentanas(ventanas);
		setId(iD);
		hayPato= pato;
		if(hayPato)
			posPato= new Posicion(0,(Math.random() < 0.5)?2:3);
		//por ser prueba se informa creacion
		System.out.println(" ");
		System.out.println("Se creo seccion con "+getCantFilas()+" filas, "+getCantColumnas()+" columnas, con ID "+getId());
		System.out.println("La seccion posee "+ getCantRotas()+" ventanas rotas y "+getCantModificador()+" ventanas modificadas");
	}

	public int getCantFilas() {
		return cantFilas;
	}

	public void setCantFilas(int cantFilas) {
		this.cantFilas = cantFilas;
	}

	public int getCantColumnas() {
		return cantColumnas;
	}

	public void setCantColumnas(int cantColumnas) {
		this.cantColumnas = cantColumnas;
	}

	public int getCantRotas() {
		return cantRotas;
	}

	public void setCantRotas(int cantRotas) {
		this.cantRotas = cantRotas;
	}

	public int getCantModificador() {
		return cantModificador;
	}

	public void setCantModificador(int cantModificador) {
		this.cantModificador = cantModificador;
	}

	public Ventana [][] getVentanas() {
		Ventana [][] tmpV= ventanas.clone();
		return tmpV;
	}

	public void setVentanas(Ventana[][] ventanas) {
		this.ventanas = ventanas;
	}
	
	public int getId(){
		return id;
	}

	public void setId(int ident){
		id= ident;
	}

	public Ventana getVentana(Posicion pos){
		return ventanas[pos.getX()][pos.getY()];
	}

	public boolean isHayPato() {
		return hayPato;
	}

	public void setHayPato(boolean hayPato) {
		this.hayPato = hayPato;
	}

	public Posicion getPosPato() {
		return posPato;
	}

	public void setPosPato(Posicion posPato) {
		this.posPato = posPato;
	}
	
}
