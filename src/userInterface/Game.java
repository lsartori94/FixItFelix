package userInterface;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import misc.EstadosJuego;
import misc.HighScores;
import misc.Persona;
import misc.Posicion;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.JTextPane;
import java.awt.CardLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;

public class Game extends JFrame {

	private JLayeredPane contentPane;
	private int numSeccion;
	private EstadosJuego estado;
	private BufferedImage [][] imagenesVentanas= new BufferedImage [5][5];
	private Map <String, BufferedImage> imagenes= new TreeMap<String, BufferedImage>();
	private HighScores hgs;
	private static Persona auxper= new Persona("FORRO", 25548787);
	private static Persona[] per= new Persona[5];
	private Posicion posRalph;
	private Posicion posFelix;
	private Posicion posLadrillo;
	private Posicion posNicelander;
	private Posicion posPato;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for(int i=0; i<5; i++)
						per[i]= auxper;
					HighScores hig= new HighScores(per);

					Game frame = new Game(hig);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Game(HighScores hig) {
		hgs= hig;
		setBackground(Color.BLACK);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Game.class.getResource("/imagenes/felix_martillo_derecha_1.png")));
		setTitle("FixIt Felix Jr.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 431);
		contentPane = new JLayeredPane();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel Menu = new JPanel();
		Menu.setBackground(Color.BLACK);
		contentPane.add(Menu, "Menu");
		
		JButton btnPuntajesAltos = new JButton("Puntajes Altos");
		btnPuntajesAltos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)contentPane.getLayout();
			    card.show(contentPane, "PuntajesAltos");
			    estado= EstadosJuego.HIGHSCORE;
			}
		});
		
		JButton btnComenzar = new JButton("Comenzar");
		btnComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)contentPane.getLayout();
			    card.show(contentPane, "Mapa");
			    estado= EstadosJuego.ONGAME;
			}
		});
		
		JButton btnInstrucciones = new JButton("Instrucciones");
		btnInstrucciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)contentPane.getLayout();
			    card.show(contentPane, "Instrucciones");
			    estado= EstadosJuego.INSTRUCCIONES;
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Game.class.getResource("/imagenes/titulo.png")));
		
		JTextPane txtpnByLucaY = new JTextPane();
		txtpnByLucaY.setForeground(Color.RED);
		txtpnByLucaY.setBackground(Color.BLACK);
		txtpnByLucaY.setEditable(false);
		txtpnByLucaY.setText("By Luca y Agus");
		GroupLayout gl_Menu = new GroupLayout(Menu);
		gl_Menu.setHorizontalGroup(
			gl_Menu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Menu.createSequentialGroup()
					.addGroup(gl_Menu.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Menu.createSequentialGroup()
							.addGap(239)
							.addGroup(gl_Menu.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnPuntajesAltos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnInstrucciones, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnComenzar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_Menu.createSequentialGroup()
							.addGap(35)
							.addComponent(lblNewLabel))
						.addGroup(gl_Menu.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtpnByLucaY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		gl_Menu.setVerticalGroup(
			gl_Menu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Menu.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel)
					.addGap(27)
					.addComponent(btnComenzar)
					.addGap(18)
					.addComponent(btnInstrucciones)
					.addGap(18)
					.addComponent(btnPuntajesAltos)
					.addGap(21)
					.addComponent(txtpnByLucaY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		Menu.setLayout(gl_Menu);
		
		JPanel Instrucciones = new JPanel();
		Instrucciones.setBackground(Color.BLACK);
		contentPane.add(Instrucciones, "Instrucciones");
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Game.class.getResource("/imagenes/instrucciones.png")));
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)contentPane.getLayout();
			    card.show(contentPane, "Menu");
			    estado= EstadosJuego.ONMENU;
			}
		});
		btnMenu.setIcon(new ImageIcon(Game.class.getResource("/imagenes/nicelander_conPie.png")));
		GroupLayout gl_Instrucciones = new GroupLayout(Instrucciones);
		gl_Instrucciones.setHorizontalGroup(
			gl_Instrucciones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Instrucciones.createSequentialGroup()
					.addGroup(gl_Instrucciones.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 576, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Instrucciones.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnMenu)))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		gl_Instrucciones.setVerticalGroup(
			gl_Instrucciones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Instrucciones.createSequentialGroup()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnMenu)
					.addContainerGap())
		);
		Instrucciones.setLayout(gl_Instrucciones);
		
		JPanel PuntajesAltos = new JPanel();
		PuntajesAltos.setBackground(Color.BLACK);
		contentPane.add(PuntajesAltos, "PuntajesAltos");
		
		JButton btnNewButton = new JButton("Menu");
		btnNewButton.setIcon(new ImageIcon(Game.class.getResource("/imagenes/nicelander_conPie.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)contentPane.getLayout();
			    card.show(contentPane, "Menu");
			    estado= EstadosJuego.ONMENU;
			}
		});
		
		JLabel lblPuntajesAltos = new JLabel("Puntajes Altos");
		lblPuntajesAltos.setForeground(Color.RED);
		lblPuntajesAltos.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setForeground(Color.RED);
		list.setBackground(Color.BLACK);
		HighScores hgs= hig;
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"1.  "+hgs.getStringIn(0), "", "", "2.  "+hgs.getStringIn(1), "", "", "3.  "+hgs.getStringIn(2), "", "", "4.  "+hgs.getStringIn(3), "", "", "5.  "+hgs.getStringIn(4)};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setVisibleRowCount(5);
		GroupLayout gl_PuntajesAltos = new GroupLayout(PuntajesAltos);
		gl_PuntajesAltos.setHorizontalGroup(
			gl_PuntajesAltos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PuntajesAltos.createSequentialGroup()
					.addGroup(gl_PuntajesAltos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_PuntajesAltos.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton))
						.addGroup(gl_PuntajesAltos.createSequentialGroup()
							.addGap(199)
							.addGroup(gl_PuntajesAltos.createParallelGroup(Alignment.TRAILING)
								.addComponent(list, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPuntajesAltos))))
					.addContainerGap(167, Short.MAX_VALUE))
		);
		gl_PuntajesAltos.setVerticalGroup(
			gl_PuntajesAltos.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_PuntajesAltos.createSequentialGroup()
					.addGap(29)
					.addComponent(lblPuntajesAltos)
					.addGap(84)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		PuntajesAltos.setLayout(gl_PuntajesAltos);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{Menu, txtpnByLucaY, btnPuntajesAltos, btnComenzar, btnInstrucciones, lblNewLabel, Instrucciones, label, btnMenu}));

	}
}
