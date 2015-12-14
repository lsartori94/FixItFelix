package entorno;

/**
 * Clase que representa el mapa del juego.
 * Posee un array de seccciones del nivel y un cuantificador.
 * 
 * @author lsartori Agustín Liébana
 */
public class Mapa {
	private int level;
	private Seccion [] secciones;
	private int rotas;

	/**
	 * Metodo para iniciar el mapa en un nivel.
	 * @param secc = array de secciones.
	 * @param tamanio = cantidad de secciones.
	 */
	public Mapa(Seccion [] secc, int lvl){
		setLevel(lvl);
		setSecciones(secc);
		setRotas(secciones[0].getCantRotas()+secciones[1].getCantRotas()+secciones[2].getCantRotas());
		//por ser prueba se informa creacion
		System.out.println("Se creo mapa del level "+getLevel());
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int lvl) {
		this.level = lvl;
	}

	public Seccion getSeccion(int i) {
		return secciones[i];
	}

	public void setSecciones(Seccion[] secciones) {
		this.secciones = secciones;
	}

	public int getRotas(){
		return rotas;
	}
	
	public void setRotas(int rot){
		rotas= rot;
	}
}
