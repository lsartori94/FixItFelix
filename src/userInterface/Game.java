package userInterface;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import misc.EstadosJuego;
import misc.HighScores;
import misc.Persona;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
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
import juego.Juego;

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
	@SuppressWarnings("unused")
	private HighScores hgs;
	private static Persona auxper= new Persona("ASDF", 25548787);
	private static Persona[] per= new Persona[5];
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Game(HighScores hig) {
		hgs= hig;
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
			    
			    //ACA VA LA INTANCIA DE JUEGO PARA USAR PAPAAAAAAAAAA
			    Juego juego= new Juego();
			    juego.go();
			    /**
				Ventana [][]vent= new Ventana[5][5];
				int secId= 0;
				boolean hayPato= true;
				for(int i= 0; i<5; i++){
					for(int i2=0; i2<5; i2++){
						if(i == 2){
							if(secId == 0){
								if(i2 == 1){
									vent[i][i2]= new Puerta(false);
								}else if(i2 == 2){
									vent[i][i2]= new Balcon(false);
								}else
									vent[i][i2]= new DoblePanel(false, false, false);
							} else{
								vent[i][i2]= new DoblePanel(false, false, false);
							}
						} else{
							vent[i][i2]= new DoblePanel(false, false, false);
						}
					}
				}
				Seccion sec= new Seccion(5, 3, 0, 0, vent, secId, hayPato);
				
				Timer timer= new Timer();
				long sleep= 200;
				
				Renderizable ren= new Renderizable(sec, timer, sleep);
				timer.schedule(ren, 0, sleep);
				
				while(1<2){
					for(int a= 5; a>0; a--){
						ren.setPosRalph(new Posicion(a-1, 4));
						//ren.setPosPato(new Posicion(a-1, 2));
						ren.refreshImagenPosicionRalph(Direccion.LEFT, false);
						ren.refreshTiroRalph();
						//ren.refreshImagenPosicionPato(Direccion.LEFT);
						ren.setPosFelix(new Posicion(a-1, 1));
						try {
							Thread.sleep(sleep);
						} catch (InterruptedException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						ren.setPosLadrillo(new Posicion(1, a-1));
					}
					for(int a2=1; a2<5; a2++){
						ren.refreshImagenPosicionRalph(Direccion.RIGHT, true);
						ren.setPosRalph(new Posicion(a2, 4));
						ren.setPosPato(new Posicion(a2-1, 2));
						ren.refreshImagenPosicionPato(Direccion.RIGHT);
						ren.setPosFelix(new Posicion(a2, 1));
						try {
							Thread.sleep(sleep);
						} catch (InterruptedException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						ren.setPosLadrillo(new Posicion(1, 4-a2));
					}
				}

				
				//ACA TERMINA EL BLOQUE PARA EL GAME **/
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
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
			gl_PuntajesAltos.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_PuntajesAltos.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addContainerGap(675, Short.MAX_VALUE))
				.addGroup(gl_PuntajesAltos.createSequentialGroup()
					.addGap(279)
					.addComponent(lblPuntajesAltos, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
					.addGap(245))
				.addGroup(gl_PuntajesAltos.createSequentialGroup()
					.addContainerGap(294, Short.MAX_VALUE)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
					.addGap(192))
		);
		gl_PuntajesAltos.setVerticalGroup(
			gl_PuntajesAltos.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_PuntajesAltos.createSequentialGroup()
					.addGap(40)
					.addComponent(lblPuntajesAltos, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(106)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		PuntajesAltos.setLayout(gl_PuntajesAltos);

		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{Menu, txtpnByLucaY, btnPuntajesAltos, btnComenzar, btnInstrucciones, lblNewLabel, Instrucciones, label, btnMenu}));

	}
}
