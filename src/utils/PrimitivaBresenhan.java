package utils;

import java.awt.Graphics;
import java.util.ArrayList;

public class PrimitivaBresenhan {

	public static void drawLineBresenhan(Graphics g, int x1, int y1, int x2, int y2, int xCentro, int yCentro) {

		int octante = Utils.getOctanteDaReta(x1, y1, x2, y2);
		
		ArrayList<Integer[]> conjPontosDaRetaRebatida = getConjuntoDePontosDoBresenhan(x1, y1, x2, y2, octante); 
		
		ArrayList<Integer[]> conjPontosDaReta = getConjuntoDePontos(x1, octante, conjPontosDaRetaRebatida);
		
		//drawPoints(g, xCentro, yCentro, conjPontosDaRetaRebatida);
		drawPoints(g, xCentro, yCentro, conjPontosDaReta);
	}
	
	private static void drawPoints(Graphics g, int xCentro, int yCentro, ArrayList<Integer[]> conjPontosDaReta) {
		
		int x, y, xNovo, yNovo;
		
		for (int i = 0; i < conjPontosDaReta.size(); i++) {
			
			x = conjPontosDaReta.get(i)[0];
			y = conjPontosDaReta.get(i)[1];
			
			xNovo = Utils.converteCoordenadaX(x, xCentro);
			yNovo = Utils.converteCoordenadaY(y, yCentro);
			
			//System.out.println("x = " + xNovo);
			//System.out.println("y = " + yNovo);
			
			Primitiva.drawPixel(g, xNovo, yNovo);
		}
		
	}
	
	public static ArrayList<Integer[]> getConjuntoDePontosDoBresenhan(int x1, int y1, int x2, int y2, int octante) {

		ArrayList<Integer[]> conjPontosDaReta = new ArrayList<Integer[]>(0); 
		
		int[] novosPontos = {x1, y1, x2, y2};
		
		if (octante != 1) {
			novosPontos = Utils.executaRebatimentoParaPrimeiroOctante(x1, y1, x2, y2, octante);
		}
		
		int novoPontoX1 = novosPontos[0];
		int novoPontoY1 = novosPontos[1];
		int novoPontoX2 = novosPontos[2];
		int novoPontoY2 = novosPontos[3];
		
		Integer[] ponto = null;
		
		int dx = novoPontoX2 - novoPontoX1;
		int dy = novoPontoY2 - novoPontoY1;
		int d = 2 * dy - dx; /* Valor inicial de d */
		
		int incE = 2 * dy; /* Incremento de E */
		int incNE = 2 * (dy - dx); /* Incremento de NE */
		int x = novoPontoX1;
		int y = novoPontoY1;
		
//		System.out.println("dx = " + dx);
//		System.out.println("dy = " + dy);
//		System.out.println("d = " + d);
//		System.out.println("incE = " + incE);
//		System.out.println("incNE = " + incNE);
		//System.out.println("x = " + x);
		//System.out.println("y = " + y);
		
		//Primitiva.drawPixel(g, x, y);
		
		ponto = new Integer[2];
		ponto[0] = x;
		ponto[1] = y;
		
		conjPontosDaReta.add( ponto );
		
		while ( x < novoPontoX2 ){
			
			if (d <= 0){
				// Escolhe E
				d = d + incE;
				x++;
			} else {
				// Escolhe NE
				d = d + incNE;
				x++;
				y++;
			}
			
//			System.out.println("x = " + x);
//			System.out.println("y = " + y);
			
			//Primitiva.drawPixel(g, x, y);
			
			ponto = new Integer[2];
			ponto[0] = x;
			ponto[1] = y;
			
			conjPontosDaReta.add( ponto );
		} 
		
		return conjPontosDaReta;
	}
	
	private static ArrayList<Integer[]> getConjuntoDePontos(int x1, int octante, ArrayList<Integer[]> conjPontosDaRetaRebatida) {
		
		ArrayList<Integer[]> conjPontosDaReta = Utils.desfazRebatimentoParaPrimeiroOctante(octante, conjPontosDaRetaRebatida);
		
		return conjPontosDaReta;
	}
	
}