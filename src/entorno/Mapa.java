package entorno;

/**
 * Clase que representa el mapa del juego.
 * Posee un array de seccciones del nivel y un cuantificador.
 * 
 * @author lsartori Agustín Liébana
 */
public class Mapa {
	private int cantSecciones;
	private Seccion [] secciones;

	/**
	 * Metodo para iniciar el mapa en un nivel.
	 * A futuro modificar para aceptar distintos niveles.
	 * @param secc = array de secciones.
	 * @param tamanio = cantidad de secciones.
	 */
	public Mapa(Seccion [] secc, int tamanio){
		setCantSecciones(tamanio);
		setSecciones(secc);
		//por ser prueba se informa creacion
		System.out.println("Se creo mapa con "+getCantSecciones()+" secciones");
	}

	public int getCantSecciones() {
		return cantSecciones;
	}

	public void setCantSecciones(int cantSecciones) {
		this.cantSecciones = cantSecciones;
	}

	public Seccion getSeccion(int i) {
		return secciones[i];
	}

	public void setSecciones(Seccion[] secciones) {
		this.secciones = secciones;
	}

}
