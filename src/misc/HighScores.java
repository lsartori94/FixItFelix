package misc;
/**
 * Clase que representa la lista de highscores
 * @author lsartori
 *
 */
public class HighScores{
	private Persona [] listaScores;
	private static final int largo= 5;

	/**
	 * constructor
	 * @param people = array de personas
	 */
	public HighScores(Persona[] people){
		listaScores= people;
	}
	
	public int getHighScoreIn(int i){
		return listaScores[i].getScore();
	}

	/**
	 * retorna el string que describe a la persona en la posicion i con su highscore
	 * @param i = posicion de la persona
	 * @return = persona+highscore
	 */
	public String getStringIn(int i){
		return listaScores[i].getName()+listaScores[i].getScore();
	}

	public Persona [] getLista(){
		return listaScores;
	}

	public int size(){
		return listaScores.length;
	}

	/**
	 * agrega la persona p en el array, manteniendo el orden
	 * @param p
	 */
	public void add(Persona p){
		for(int i=0; i<largo; i++){
			if(this.getHighScoreIn(i) < p.getScore()){
				this.addHere(i, p, largo);
			}
		}
	}

	private void addHere(int i, Persona p, int largo){
		for(int i2= i+1; i2<=largo; i2++){
			listaScores[i2]= listaScores[i2+1];
		}
		listaScores[i]= p;
	}
}
