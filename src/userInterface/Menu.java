package userInterface;
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import juego.Juego;
import listeners.*;

/**
 * pantalla principal del juego
 * @author lsartori
 *
 */
public class Menu extends JFrame {
	private JPanel total= new JPanel();
	private JTextArea titulo = new JTextArea("Fix It Felix Jr.");
	private JPanel superior = new JPanel();
	private JPanel inferior = new JPanel();
	private GridLayout botonesGrid = new GridLayout(3, 3);
	private JPanel botones = new JPanel(botonesGrid);
	private JButton start = new JButton("Comenzar");
	private JButton howTo = new JButton("Como Jugar?");
	private JButton highS = new JButton("Puntajes Altos");

	public Menu(){
		// Setea el titulo
		total.setLayout(new BorderLayout());
		titulo.setEditable(false);
		superior.setLayout(new BorderLayout());
		superior.add(titulo, BorderLayout.CENTER);
		inferior.setLayout(new BorderLayout());
		total.add(superior, BorderLayout.NORTH);

		// Agrego botones
		start.addMouseListener(new MouseOnClickListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		howTo.addMouseListener(new MouseOnClickListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		highS.addMouseListener(new MouseOnClickListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		botones.add(start);
		botones.add(howTo);
		botones.add(highS);
		botones.setSize(100, 100);
		
		// Agrego Layout de Botones
		inferior.add(botones, BorderLayout.CENTER);
		total.add(inferior, BorderLayout.CENTER);

		add(total);
		this.setSize(400, 400);
	}

	public void dibujar(){
		setVisible(true);
	}
}
