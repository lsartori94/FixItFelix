package userInterface;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.*;

import misc.EstadosJuego;
import misc.Posicion;

@SuppressWarnings("serial")
public class MapScreen extends JFrame {

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
		private static final int offsetHorizontalPuertaBalcon= 11;
		private static final int offsetVerticalPuerta= 14;
		private static final int pisoPuerta= 1;
		private static final int pisoBalcon= 2;
		private static final int columnaPuertaBalcon= 2;
		private static final int espacioDeZonaDeRalph= 10;
		private static final int espacioHorizontalEntreVentanas= 16;
		private static final int espacioVerticalEntreVentanas= 20;
		private static final int anchoWin= 250;
		private static final int altoWin= 200;
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
		setAlwaysOnTop(true);
		setAutoRequestFocus(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Game.class.getResource("/imagenes/felix_martillo_derecha_1.png")));
		setSize(anchoPanel, altoPanel);
		setResizable(false);
		setVisible(true);
		setFocusable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dibujarMapa();
	}
	
	@Override
	public void paint(Graphics g){
		super.paintComponents(g);
		dibujarMapa();
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
		if(estado == EstadosJuego.INGAME){
			// Se agrega de abajo para arriba por la implementacion de la matriz de ventanas
			for(int x=minDimX; x<maxDimX; x++){
				for(int y=maxDimY; y>minDimY; y--){
					switch(y){
						case maxDimY-1:
							// Deja un espacio distinto al ser el piso de ralph
							auxAncho= offsetHorizontalVentana+(anchoVentana+espacioHorizontalEntreVentanas)*x;
							auxAlto= offsetVerticalVentana+(altoVentana+espacioDeZonaDeRalph+espacioVerticalEntreVentanas)*(maxDimY-y);
							this.getGraphics().drawImage(imagenesVentanas[x][y], auxAncho, auxAlto, null);
							if(posLadrillo != null){
								if((posLadrillo.getX() == x)&&(posLadrillo.getY() == y))
									// Pinta ladrillo
									this.getGraphics().drawImage(imagenes.get("ladrillo"), auxAncho+offsetLadrillo, auxAlto+offsetLadrillo, null);
							}
							if(posNicelander != null){
								if((posNicelander.getX() == x)&&(posNicelander.getY() == y))
									// Pinta nicelander
									this.getGraphics().drawImage(imagenes.get("nicelander"), auxAncho+offsetHorizontalNicelander, auxAlto+offsetVerticalNicelander, null);
							}
							if(posRalph != null){
								if((posRalph.getY() == y)&&(posRalph.getX() == x))
									// Pinta Ralph
									this.getGraphics().drawImage(imagenes.get("ralph"), auxAncho-offsetHorizontalRalph, auxAlto-offsetVerticalRalph, null);
							}
							if(posFelix != null){
								if((posFelix.getY() == y)&&(posFelix.getX() == x))
									// Pinta Felix
									this.getGraphics().drawImage(imagenes.get("felix"), auxAncho+offsetFelix, auxAlto+offsetFelix, null);
							}
							if(posPato != null){
								if((posPato.getY() == y)&&(posPato.getX() == x))
									// Pinta Pato
									this.getGraphics().drawImage(imagenes.get("pato"), auxAncho, auxAlto, null);
							}

							break;
						default:
							if(numSeccion == 0){
								if( x == columnaPuertaBalcon){
									if(y == pisoPuerta){
										//desvia la puerta para que calze bien
										auxAncho= offsetHorizontalVentana+(anchoVentana+offsetHorizontalPuertaBalcon)*x;
										auxAlto= offsetVerticalVentana+(altoVentana+offsetVerticalPuerta)*(maxDimY-y);
									}else if(y == pisoBalcon){
										//desvia el balcon para que calze bien
										auxAncho= offsetHorizontalVentana+(anchoVentana+offsetHorizontalPuertaBalcon)*x;
										auxAlto= offsetVerticalVentana+(altoVentana+espacioVerticalEntreVentanas)*(maxDimY-y);
									}else{
										//usa la desviacion estandar
										auxAncho= offsetHorizontalVentana+(anchoVentana+espacioHorizontalEntreVentanas)*x;
										auxAlto= offsetVerticalVentana+(altoVentana+espacioVerticalEntreVentanas)*(maxDimY-y);	
									}
								} else{
									auxAncho= offsetHorizontalVentana+(anchoVentana+espacioHorizontalEntreVentanas)*x;
									auxAlto= offsetVerticalVentana+(altoVentana+espacioVerticalEntreVentanas)*(maxDimY-y);
								}
							}else{
								auxAncho= offsetHorizontalVentana+(anchoVentana+espacioHorizontalEntreVentanas)*x;
								auxAlto= offsetVerticalVentana+(altoVentana+espacioVerticalEntreVentanas)*(maxDimY-y);
							}
							if(numSeccion == 2){
								if(y != maxDimY){
									// Si no es la ultima seccion y es la fila 4 dibuja ventanas
									this.getGraphics().drawImage(imagenesVentanas[x][y], auxAncho, auxAlto, null);
								}
							}else{
								this.getGraphics().drawImage(imagenesVentanas[x][y], auxAncho, auxAlto, null);
							}
							if(posLadrillo != null){
								if((posLadrillo.getX() == x)&&(posLadrillo.getY() == y))
									// Pinta ladrillo
									this.getGraphics().drawImage(imagenes.get("ladrillo"), auxAncho+offsetLadrillo, auxAlto+offsetLadrillo, null);
							}
							if(posNicelander != null){
								if((posNicelander.getX() == x)&&(posNicelander.getY() == y))
									// Pinta nicelander
									this.getGraphics().drawImage(imagenes.get("nicelander"), auxAncho+offsetHorizontalNicelander, auxAlto+offsetVerticalNicelander, null);
							}
							if(posRalph != null){
								if((posRalph.getY() == y)&&(posRalph.getX() == x))
									// Pinta Ralph
									this.getGraphics().drawImage(imagenes.get("ralph"), auxAncho-offsetHorizontalRalph, auxAlto-offsetVerticalRalph, null);
							}
							if(posFelix != null){
								if((posFelix.getY() == y)&&(posFelix.getX() == x))
									// Pinta Felix
									this.getGraphics().drawImage(imagenes.get("felix"), auxAncho+offsetFelix, auxAlto+offsetFelix, null);
							}
							if(posPato != null){
								if((posPato.getY() == y)&&(posPato.getX() == x))
									// Pinta Pato
									this.getGraphics().drawImage(imagenes.get("pato"), auxAncho, auxAlto, null);
							}
							break;
					}
					
				}
			}
		}else if (estado == EstadosJuego.WIN){
			dibujarWin();
		}
		else if (estado == EstadosJuego.GAMEOVER)
			dibujarLose();
	}
	
	public void dibujarWin(){
		this.getGraphics().drawImage(imagenes.get("win"), anchoWin, altoWin, null);
		setEstado(EstadosJuego.INGAME);
	}
	
	public void dibujarLose(){
		this.getGraphics().drawImage(imagenes.get("win"), anchoLose, altoLose, null);
		setEstado(EstadosJuego.ONMENU);
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

	
}
