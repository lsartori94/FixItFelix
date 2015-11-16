package misc;
/**
 * Clase que representa a una persona con su nombre y su highscore
 * @author lsartori
 *
 */
public class Persona{
	private String name;
	private int score;

	public Persona(String nam, int sc){
		this.name= nam;
		this.score= sc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
