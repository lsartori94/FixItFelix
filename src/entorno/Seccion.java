package entorno;

import misc.Posicion;

public class Seccion {
	private int cant_filas;
	private int cant_columnas;
	private int cant_rotas;
	private int cant_modificador;
	private int id;
	//se comenta Sprite por ser prueba
//	private Sprite imagen;
	private Ventana [][] ventanas;

	//metodo de inicio de Seccion
	public Seccion(int c_f, int c_c, int c_rot, int c_mod, Ventana[][] ventanas/*,Sprite img*/){
		setCant_filas(c_f);
		setCant_columnas(c_c);
		setCant_rotas(c_rot);
		setCant_modificador(c_mod);
		setVentanas(ventanas);
		//setImagen(img);
		//por ser prueba se informa creacion
		System.out.println(" ");
		System.out.println("Se creo seccion con "+getCant_filas()+" filas, "+getCant_columnas()+" columnas, con ID "+getId());
		System.out.println("La seccion posee "+ getCant_rotas()+" ventanas rotas y "+getCant_modificador()+" ventanas modificadas");
	}

	public int getCant_filas() {
		return cant_filas;
	}

	public void setCant_filas(int cant_filas) {
		this.cant_filas = cant_filas;
	}

	public int getCant_columnas() {
		return cant_columnas;
	}

	public void setCant_columnas(int cant_columnas) {
		this.cant_columnas = cant_columnas;
	}

	public int getCant_rotas() {
		return cant_rotas;
	}

	public void setCant_rotas(int cant_rotas) {
		this.cant_rotas = cant_rotas;
	}

	public int getCant_modificador() {
		return cant_modificador;
	}

	public void setCant_modificador(int cant_modificador) {
		this.cant_modificador = cant_modificador;
	}

//	public Sprite getImagen() {
//		return imagen;
//	}

//	public void setImagen(Sprite imagen) {
//		this.imagen = imagen;
//	}

	public Ventana [][] getVentanas() {
		Ventana [][] tmp_v= ventanas.clone();
		return tmp_v;
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
}
