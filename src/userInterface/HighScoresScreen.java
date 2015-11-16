package userInterface;
import javax.swing.DefaultListModel;
import javax.swing.JList;

import misc.HighScores;

/**
 * pantalla de highscores
 * @author lsartori
 *
 */
public class HighScoresScreen {
	private JList<String> lista= new JList<String>();
	private DefaultListModel<String> namelist;
	
	public HighScoresScreen(HighScores hgs){
		for(int i=0; i<hgs.size(); i++){
			namelist.addElement((i+1)+ ".     " + hgs.getStringIn(i));
		}
		lista.setVisibleRowCount(hgs.size());
		lista.setModel(namelist);
	}

	public void dibujar(){
		
	}
}
