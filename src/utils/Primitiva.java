package utils;

import java.awt.Graphics;
import java.util.ArrayList;

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
	}
	
	public static void drawPolygon(Graphics g, ArrayList<Integer> pontos, int xCentro, int yCentro) {
		
		if (pontos.size() % 2 != 0 || pontos.size() <= 2) {
			System.out.println("conjunto de pontos inválidos");
			return;
		}
		
		pontos.add(new Integer(pontos.get(0)));
		pontos.add(new Integer(pontos.get(1)));
		
		for (int i = 0 ; i < pontos.size() - 2 ; i += 2) {
			drawLine(g, pontos.get(i), pontos.get(i + 1), pontos.get(i + 2), pontos.get(i + 3), xCentro, yCentro);
		}
	}
}