package entorno;

/**
 * Clase que representa el mapa del juego.
 * Posee un array de seccciones del nivel y un cuantificador.
 * 
 * @author lsartori Agustín Liébana
 */
public class Mapa {
	private int cant_secciones;
	private Seccion [] secciones;

	/**
	 * Metodo para iniciar el mapa en un nivel.
	 * A futuro modificar para aceptar distintos niveles.
	 * @param secc = array de secciones.
	 * @param tamanio = cantidad de secciones.
	 */
	public Mapa(Seccion [] secc, int tamanio){
		setCant_secciones(tamanio);
		setSecciones(secc);
		//por ser prueba se informa creacion
		System.out.println("Se creo mapa con "+getCant_secciones()+" secciones");
	}

	public int getCant_secciones() {
		return cant_secciones;
	}

	public void setCant_secciones(int cant_secciones) {
		this.cant_secciones = cant_secciones;
	}

	public Seccion getSeccion(int i) {
		return secciones[i];
	}

	public void setSecciones(Seccion[] secciones) {
		this.secciones = secciones;
	}

}
