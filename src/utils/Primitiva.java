package utils;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Primitiva {

	public static void drawPixel(Graphics g, int x, int y) {
		g.drawLine(x, y, x, y);
	}

	public static void drawHLine(Graphics g, int x1, int x2, int y, JPanel painel) {

		y = painel.getHeight() - y;
		
		for (int i = x1; i <= x2; i++) {
			Primitiva.drawPixel(g, i, y);
		}
	}
	
	public static void drawVLine(Graphics g, int x, int y1, int y2, int xCentro, int yCentro) {

		int xNovo, y1Novo, y2Novo, y;
		
		y1Novo = y1;
		y2Novo = y2;
		
		if (y1 > y2) {
			y1Novo = y2;
			y2Novo = y1;
		}
		
		for (int i = y1Novo; i <= y2Novo; i++) {
			
			xNovo = Utils.converteCoordenadaX(x, xCentro);
			y = Utils.converteCoordenadaY(i, yCentro);
			
			Primitiva.drawPixel(g, xNovo, y);
		}
	}
	
	public static void drawLine(Graphics g, int x1, int y1, int x2, int y2, int xCentro, int yCentro) {

		if (x1 == x2) {
			drawVLine(g, x1, y1, y2, xCentro, yCentro);
		} else {
			
			int x1Novo = x1;
			int x2Novo = x2;
			int y1Novo = y1;
			int y2Novo = y2;
			
			if (y1 == y2 && x1 > x2){
				
				x1Novo = x2;
				x2Novo = x1;
			}
			
			PrimitivaBresenhan.drawLineBresenhan(g, x1Novo, y1Novo, x2Novo, y2Novo, xCentro, yCentro);
		}
		
		/*double m = (double)( y2 - y1 ) / (double)( x2 - x1 );
		
		double b = y1 - (double)( m * x1 );
		
		for (int i = x1; i <= x2; i++) {
			Primitiva.drawPixel(g, i, (int)(m * i + b));
		}*/
	}
}