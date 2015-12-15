package userInterface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import misc.EstadosJuego;
import misc.HighScore;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import juego.Juego;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que gestiona la intefaz gráfica e inicia el juego
 * La clase fue generada por una herramienta de graficación, por lo tanto no se comentan los métodos
 * @author Luca Sartori, Agustín Liébana
 *
 */
@SuppressWarnings("serial")
public class Game extends JFrame {

	private JLayeredPane contentPane;
	@SuppressWarnings("unused")
	private EstadosJuego estado;
	private HighScore [] hgs= {new HighScore("Agus", 2546463), new HighScore("Luca", 254646), new HighScore("Agus", 25464), new HighScore("Luca", 2546), new HighScore("Agus", 254)};
	private JTable table;
	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Game () {
		setBackground(Color.BLACK);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Game.class.getResource("/imagenes/felix_martillo_derecha_1.png")));
		setTitle("FixIt Felix Jr.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
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
			public void actionPerformed(ActionEvent e)  {
			    estado= EstadosJuego.INGAME;
			   
			    setVisible(false);
			    Juego j= new Juego();
			    Thread game= new Thread(j);
			    game.start();
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
					.addContainerGap()
					.addComponent(txtpnByLucaY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(235, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_Menu.createSequentialGroup()
					.addContainerGap(144, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(126))
				.addGroup(Alignment.TRAILING, gl_Menu.createSequentialGroup()
					.addContainerGap(225, Short.MAX_VALUE)
					.addGroup(gl_Menu.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnInstrucciones, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnPuntajesAltos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnComenzar, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE))
					.addGap(221))
		);
		gl_Menu.setVerticalGroup(
			gl_Menu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Menu.createSequentialGroup()
					.addGap(31)
					.addComponent(lblNewLabel)
					.addGap(105)
					.addComponent(btnComenzar)
					.addGap(50)
					.addComponent(btnInstrucciones)
					.addGap(47)
					.addComponent(btnPuntajesAltos)
					.addGap(40)
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
					.addContainerGap()
					.addComponent(btnMenu)
					.addContainerGap(675, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_Instrucciones.createSequentialGroup()
					.addContainerGap(100, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 649, GroupLayout.PREFERRED_SIZE)
					.addGap(35))
		);
		gl_Instrucciones.setVerticalGroup(
			gl_Instrucciones.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_Instrucciones.createSequentialGroup()
					.addContainerGap(12, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
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
		lblPuntajesAltos.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		table = new JTable();
		table.setBackground(Color.BLACK);
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		table.setFont(new Font("Tahoma", Font.BOLD, 23));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{hgs[0].getName(), new Integer(hgs[0].getScore())},
				{"", null},
				{"", null},
				{hgs[1].getName(), new Integer(hgs[1].getScore())},
				{"", null},
				{"", null},
				{hgs[2].getName(), new Integer(hgs[2].getScore())},
				{"", null},
				{"", null},
				{hgs[3].getName(), new Integer(hgs[3].getScore())},
				{"", null},
				{null, null},
				{hgs[4].getName(), new Integer(hgs[4].getScore())},
			},
			new String[] {
				"Jugador", "Puntaje"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.setForeground(Color.RED);
		
		JLabel lblJugador = new JLabel("JUGADOR");
		lblJugador.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblJugador.setForeground(Color.RED);
		
		JLabel lblPuntaje = new JLabel("PUNTAJE");
		lblPuntaje.setForeground(Color.RED);
		lblPuntaje.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout gl_PuntajesAltos = new GroupLayout(PuntajesAltos);
		gl_PuntajesAltos.setHorizontalGroup(
			gl_PuntajesAltos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PuntajesAltos.createSequentialGroup()
					.addGroup(gl_PuntajesAltos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_PuntajesAltos.createSequentialGroup()
							.addGap(10)
							.addComponent(btnNewButton))
						.addGroup(gl_PuntajesAltos.createSequentialGroup()
							.addGap(279)
							.addComponent(lblPuntajesAltos, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_PuntajesAltos.createSequentialGroup()
							.addGap(216)
							.addGroup(gl_PuntajesAltos.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_PuntajesAltos.createSequentialGroup()
									.addComponent(lblJugador, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
									.addGap(143)
									.addComponent(lblPuntaje, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
								.addComponent(table, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(205, Short.MAX_VALUE))
		);
		gl_PuntajesAltos.setVerticalGroup(
			gl_PuntajesAltos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PuntajesAltos.createSequentialGroup()
					.addGap(40)
					.addComponent(lblPuntajesAltos, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addGroup(gl_PuntajesAltos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblJugador, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPuntaje, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(btnNewButton))
		);
		PuntajesAltos.setLayout(gl_PuntajesAltos);
		
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{Menu, txtpnByLucaY, btnPuntajesAltos, btnComenzar, btnInstrucciones, lblNewLabel, Instrucciones, label, btnMenu}));

	}
}
