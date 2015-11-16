package userInterface;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InstruccionesScreen {
	private static final String ins= "asdffsafljdslkjsdlkghdslfjdslkjdgkljdslkjsdl"
			+ "skasjkasjdkasjkjfkdjsdfjsdlkfjfjdsldsjsdjflsdkjfds"
			+ "jelrjsdlkfjdfjdsf"
			+ "dfjdsgjkdfgjh"
			+ "dfklerjglefjg"
			+ "fjlfjfosejfo;ekfjesknmxfnklngirjgiprjgrogjrklgn";
	private JPanel panel= new JPanel();
	private JButton volver= new JButton();
	private JTextArea titulo= new JTextArea(ins);
	private JTextArea txt= new JTextArea();

	public InstruccionesScreen(){
		titulo.setEditable(false);
	}
}
