package userInterface;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import listeners.MouseOnClickListener;
import misc.EstadosJuego;
import misc.Posicion;

@SuppressWarnings("serial")
public class MapScreen extends Frame {

		private static final int maxDimX= 5;
		private static final int minDimX= 0;
		private static final int maxDimY= 4;
		private static final int minDimY= 0;
		private static final int anchoPanel= 800;
		private static final int altoPanel= 600;
		private static final int posHorizontalMapa= 250;
		private static final int posVerticalMapa= 120;
		private static final int offsetHorizontalVentana= 280;
		private static final int offsetVerticalVentana= 140;
		private static final int offsetLadrillo= 12;
		private static final int offsetHorizontalNicelander= 7;
		private static final int offsetVerticalNicelander= 30;
		private static final int offsetFelix= 3;
		private static final int offsetVerticalRalph= 20;
		private static final int offsetHorizontalRalph= 15;
		private static final int anchoVentana= 38;
		private static final int altoVentana= 60;
		private static final int espacioDeZonaDeRalph= 10;
		private static final int espacioHorizontalEntreVentanas= 16;
		private static final int espacioVerticalEntreVentanas= 20;
		private static final int anchoWin= 200;
		private static final int altoWin= 150;
		private static final int anchoLose= 200;
		private static final int altoLose= 200;
		private int numSeccion;
		private EstadosJuego estado;
		private BufferedImage [][] imagenesVentanas= new BufferedImage [5][5];
		private Map <String, BufferedImage> imagenes= new TreeMap<String, BufferedImage>();
		private Posicion posRalph;
		private Posicion posFelix;
		private Posicion posLadrillo;
		private Posicion posNicelander;
		private Posicion posPato;
	

	public MapScreen(){
		
	}

	/**
	 * Inicia el refresco de imagen
	 */
	public void render(){
		setTitle("FixIt Felix Jr.");
		setSize(anchoPanel, altoPanel);
		setVisible(true);
		switch(estado.getValue()){
		case 0:
			dibujarMenu();
			break;
		case 1:
			dibujarInstrucciones();
			break;
		case 2:
			dibujarHighscore();
			break;
		case 3:
			dibujarMapa();
			break;
		case 4:
			dibujarWin();
			break;
		case 5:
			dibujarLose();
			break;
		}
	}
	
	@Override
	public void paint(Graphics g){
		super.paintComponents(g);
	}

	/**
	 * Metodo que dibuja la seccion entera con sus personajes
	 */
	public void dibujarMapa(){
		// Pinta seccion
		this.getGraphics().drawImage(imagenes.get("fondo"), 0, 0, null);
		this.getGraphics().drawImage(imagenes.get("seccion"), posHorizontalMapa, posVerticalMapa, null);
		int auxAncho;
		int auxAlto;
		// Se agrega de abajo para arriba por la implementacion de la matriz de ventanas
		for(int x=minDimX; x<maxDimX; x++){
			for(int y=maxDimY; y>minDimY; y--){
				switch(y){
					case maxDimY-1:
						// Deja un espacio distinto al ser el piso de ralph
						auxAncho= offsetHorizontalVentana+(anchoVentana+espacioHorizontalEntreVentanas)*x;
						auxAlto= offsetVerticalVentana+(altoVentana+espacioDeZonaDeRalph+espacioVerticalEntreVentanas)*(maxDimY-y);
						this.getGraphics().drawImage(imagenesVentanas[x][y], auxAncho, auxAlto, null);
						if((posLadrillo.getX() == x)&&(posLadrillo.getY() == y))
							// Pinta ladrillo
							this.getGraphics().drawImage(imagenes.get("ladrillo"), auxAncho+offsetLadrillo, auxAlto+offsetLadrillo, null);
						if((posNicelander.getX() == x)&&(posNicelander.getY() == y))
							// Pinta nicelander
							this.getGraphics().drawImage(imagenes.get("nicelander"), auxAncho+offsetHorizontalNicelander, auxAlto+offsetVerticalNicelander, null);
						if((posRalph.getY() == y)&&(posRalph.getX() == x))
							// Pinta Ralph
							this.getGraphics().drawImage(imagenes.get("ralph"), auxAncho-offsetHorizontalRalph, auxAlto-offsetVerticalRalph, null);
						if((posFelix.getY() == y)&&(posFelix.getX() == x))
							// Pinta Felix
							this.getGraphics().drawImage(imagenes.get("felix"), auxAncho+offsetFelix, auxAlto+offsetFelix, null);
						if((posPato.getY() == y)&&(posPato.getX() == x))
							// Pinta Pato
							this.getGraphics().drawImage(imagenes.get("pato"), auxAncho, auxAlto, null);

						break;
					default:
						auxAncho= offsetHorizontalVentana+(anchoVentana+espacioHorizontalEntreVentanas)*x;
						auxAlto= offsetVerticalVentana+(altoVentana+espacioVerticalEntreVentanas)*(maxDimY-y);
						if(numSeccion == 2){
							if(y != maxDimY){
								// Si no es la ultima seccion y es la fila 4 dibuja ventanas
								this.getGraphics().drawImage(imagenesVentanas[x][y], auxAncho, auxAlto, null);
							}
						}else{
							this.getGraphics().drawImage(imagenesVentanas[x][y], auxAncho, auxAlto, null);
						}
						if((posLadrillo.getX() == x)&&(posLadrillo.getY() == y))
							// Pinta ladrillo
							this.getGraphics().drawImage(imagenes.get("ladrillo"), auxAncho+offsetLadrillo, auxAlto+offsetLadrillo, null);
						if((posNicelander.getX() == x)&&(posNicelander.getY() == y))
							// Pinta Nicelander
							this.getGraphics().drawImage(imagenes.get("nicelander"), auxAncho+offsetHorizontalNicelander, auxAlto+offsetVerticalNicelander, null);
						if((posRalph.getY() == y)&&(posRalph.getX() == x))
							// Pinta Ralph
							this.getGraphics().drawImage(imagenes.get("ralph"), auxAncho-15, auxAlto-20, null);
						if((posFelix.getY() == y)&&(posFelix.getX() == x))
							// Pinta Felix
							this.getGraphics().drawImage(imagenes.get("felix"), auxAncho+offsetFelix, auxAlto+offsetFelix, null);
						if((posPato.getY() == y)&&(posPato.getX() == x))
							// Pinta Pato
							this.getGraphics().drawImage(imagenes.get("pato"), auxAncho, auxAlto, null);

						break;
				}
			}
		}
	}
	
	public void dibujarWin(){
		dibujarMapa();
		this.getGraphics().drawImage(imagenes.get("win"), anchoWin, altoWin, null);
	}
	
	public void dibujarLose(){
		dibujarMapa();
		this.getGraphics().drawImage(imagenes.get("win"), anchoLose, altoLose, null);
	}
	
	public BufferedImage[][] getImagenesVentanas() {
		return imagenesVentanas;
	}

	public void setImagenesVentanas(BufferedImage[][] imagenesVentanas) {
		this.imagenesVentanas = imagenesVentanas;
	}

	public Map<String, BufferedImage> getImagenes() {
		return imagenes;
	}

	public void setImagenes(Map<String, BufferedImage> imagenes) {
		this.imagenes = imagenes;
	}

	public Posicion getPosRalph() {
		return posRalph;
	}

	public void setPosRalph(Posicion posRalph) {
		this.posRalph = posRalph;
	}

	public Posicion getPosFelix() {
		return posFelix;
	}

	public void setPosFelix(Posicion posFelix) {
		this.posFelix = posFelix;
	}

	public int getNumSeccion() {
		return numSeccion;
	}

	public void setNumSeccion(int numSeccion) {
		this.numSeccion = numSeccion;
	}

	public Posicion getPosLadrillo() {
		return posLadrillo;
	}

	public void setPosLadrillo(Posicion posLadrillo) {
		this.posLadrillo = posLadrillo;
	}

	public Posicion getPosNicelander() {
		return posNicelander;
	}

	public void setPosNicelander(Posicion posNicelander) {
		this.posNicelander = posNicelander;
	}

	public Posicion getPosPato() {
		return posPato;
	}

	public void setPosPato(Posicion posPato) {
		this.posPato = posPato;
	}

	
	public EstadosJuego getEstado() {
		return estado;
	}
	

	public void setEstado(EstadosJuego estado) {
		this.estado = estado;
	}

	
	private void dibujarMenu(){
		int anchoVentana= 512;
		int altoVentana= 400;
		String title= "FixIt Felix Jr.";
		JPanel total= new JPanel();
		JLabel titulo = new JLabel();
		JPanel superior = new JPanel();
		JPanel inferior = new JPanel();
		GridLayout botonesGrid = new GridLayout(3, 3);
		JPanel botones = new JPanel(botonesGrid);
		JButton start = new JButton("Comenzar");
		JButton howTo = new JButton("Como Jugar?");
		JButton highS = new JButton("Puntajes Altos");
		ImageIcon image = new ImageIcon("src/imagenes/titulo.png");
		// Setea el titulo
		total.setLayout(new BorderLayout());
		titulo.setIcon(image);
		superior.setLayout(new BorderLayout());
		superior.add(titulo, BorderLayout.CENTER);
		inferior.setLayout(new BorderLayout());
		total.add(superior, BorderLayout.NORTH);

		// Agrego botones
		start.addMouseListener(new MouseOnClickListener(){
			public void actionPerformed(ActionEvent e){
				estado= EstadosJuego.ONGAME;
				setVisible(false);
			}
		});
		howTo.addMouseListener(new MouseOnClickListener(){
			public void actionPerformed(ActionEvent e){
				estado= EstadosJuego.INSTRUCCIONES;
				setVisible(false);
			}
			
		});
		highS.addMouseListener(new MouseOnClickListener(){
			public void actionPerformed(ActionEvent e){
				estado= EstadosJuego.HIGHSCORE;
				setVisible(false);
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
		this.setTitle(title);
		this.setSize(anchoVentana, altoVentana);
		
		setVisible(true);
	}

	private void dibujarInstrucciones(){
		
	}
	
	private void dibujarHighscore(){
		
	}
}
