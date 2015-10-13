package entorno;

public class Mapa {
	private int cant_secciones;
	private Seccion [] secciones;

	//metodo para iniciar mapa por nivel
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

	public Seccion [] getSecciones() {
		Seccion [] tmp_secc= secciones.clone();
		return tmp_secc;
	}

	public void setSecciones(Seccion[] secciones) {
		this.secciones = secciones;
	}

}
