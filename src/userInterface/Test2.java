package userInterface;

import misc.Posicion;
import entorno.*;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ventana [][]vent= new Ventana[5][5];
		int secId= 0;
		for(int i=0; i<5; i++){
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
		Seccion sec= new Seccion(5, 3, 0, 0, vent, secId);
		Renderizable ren= new Renderizable(sec);
		ren.setPosFelix(new Posicion(2,1));
		ren.setPosRalph(new Posicion(3,4));
		ren.setPosLadrillo(new Posicion(1,1));
		ren.setPosNicelander(new Posicion(1,3));
		ren.setPosPato(new Posicion(1,2));
		
		ren.run();
		ren.getScreen().render();
	}

}
