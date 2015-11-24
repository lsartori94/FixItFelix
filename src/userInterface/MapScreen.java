package userInterface;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import misc.Posicion;

public class MapScreen extends Frame {

		private static final int anchoPanel= 800;
		private static final int altoPanel= 600;
		private static final int posHorizontalMapa= 250;
		private static final int posVerticalMapa= 120;
		private static final int offsetHorizontalVentana= 280;
		private static final int offsetVerticalVentana= 140;
		private static final int anchoVentana= 38;
		private static final int altoVentana= 60;
		private static final int espacioDeZonaDeRalph= 10;
		private static final int espacioHorizontalEntreVentanas= 16;
		private static final int espacioVerticalEntreVentanas= 20;
		private BufferedImage seccion;
		private BufferedImage ventana;
		private BufferedImage puerta;
		private BufferedImage balcon;
		private BufferedImage ralphie;
		private Posicion pos= new Posicion(1,0);
	
	public MapScreen(){
		try{
			seccion= ImageIO.read(new File("src/imagenes/edificio_seccion1.png"));
			ventana= ImageIO.read(new File("src/imagenes/ventana_doble_sana.png"));
			puerta= ImageIO.read(new File("src/imagenes/puerta_sana.png"));
			balcon= ImageIO.read(new File("src/imagenes/balcon_sano.png"));
			ralphie= ImageIO.read(new File("src/imagenes/ralph_parado.png"));
		} 
		catch(IOException e){
			System.out.println("Error de carga de imagen"+e.getMessage());
		}
		setTitle("FixIt Felix Jr.");
		setSize(anchoPanel, altoPanel);
		setVisible(true);
		dibujar();
	}
	
	/**
	 * Metodo que dibuja la seccion entera
	 */
	public void dibujar(){
		// Pinta seccion
		this.getGraphics().drawImage(seccion, posHorizontalMapa, posVerticalMapa, null);
		int auxAncho;
		int auxAlto;
		for(int x=0; x<5; x++){
			for(int y=0; y<4; y++){
				switch(y){
					case 1:
						auxAncho= offsetHorizontalVentana+(anchoVentana+espacioHorizontalEntreVentanas)*x;
						auxAlto= offsetVerticalVentana+(altoVentana+espacioDeZonaDeRalph+espacioVerticalEntreVentanas)*y;
						this.getGraphics().drawImage(ventana, auxAncho, auxAlto, null);
						break;
					default:
						auxAncho= offsetHorizontalVentana+(anchoVentana+espacioHorizontalEntreVentanas)*x;
						auxAlto= offsetVerticalVentana+(altoVentana+espacioVerticalEntreVentanas)*y;
						if(x == 2){
							if(y == 3){
								// Pinta puerta
								auxAncho= auxAncho-10;
								auxAlto= auxAlto-20;
								this.getGraphics().drawImage(puerta, auxAncho, auxAlto, null);
							}else if(y == 2){
								// Pinta balcon
								auxAncho= auxAncho-10;
								auxAlto= auxAlto-3;
								this.getGraphics().drawImage(balcon, auxAncho, auxAlto, null);
							}else
								this.getGraphics().drawImage(ventana, auxAncho, auxAlto, null);
								
						}else{
							this.getGraphics().drawImage(ventana, auxAncho, auxAlto, null);
							// Pinta Ralph si coincide con su posicion
							if((pos.getY() == y)&(pos.getX() == x)){
								this.getGraphics().drawImage(ralphie, auxAncho-15, auxAlto-20, null);
							}
						}
						break;
				}
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {
			super.paintComponents(g);
			dibujar();
	}
}
