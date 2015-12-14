package misc;
/**
 * Clase que representa a una persona con su nombre y su highscore
 * @author lsartori Agustin Liebana
 *
 */
public class HighScore{
	private String name;
	private int score;

	public HighScore(String nam, int sc){
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
