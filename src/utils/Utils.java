package utils;

import java.util.ArrayList;

import javax.swing.JPanel;

public class Utils {

	public static int[] deslocaEixoDasCoordenadasDeAcordoComPontoCentral(int x1, int y1, int x2, int y2, int[] pontoCentral) {
		
		int x1Novo = x1;
		int x2Novo = x2;
		int y1Novo = y1;
		int y2Novo = y2;
		
		int xCentro = pontoCentral[0];
		int yCentro = pontoCentral[1];
		
		x1Novo += xCentro; 
		x2Novo += xCentro;
		
		y1Novo += yCentro;
		y2Novo += yCentro;
		
		int[] novaCoordenadas = {x1Novo, y1Novo, x2Novo, y2Novo};
		
		return novaCoordenadas;
	}
	
	public static int inverteCoordenadaY(int coord, int yCentro, JPanel painel) {

		int difParaCentro = Math.abs(coord - yCentro);
		
		if (coord == yCentro) {
			return coord;
		}
		
		int coordNovo = painel.getHeight() - coord;
		
		int difParaCentroNovo = Math.abs(coordNovo - yCentro);
		
		if (difParaCentroNovo == difParaCentro) {
			return coordNovo;
		}
		
		if (difParaCentroNovo > difParaCentro) {
			coordNovo += Math.abs(difParaCentro - difParaCentroNovo);
		} else {
			coordNovo -= Math.abs(difParaCentro - difParaCentroNovo);
		}
		
		return coordNovo;
	}
	
	public static int[] ordenaCoordenadas(int coord1, int coord2, boolean inverso) {
		
		int aux;
		
		if ( coord1 > coord2 ) {
			
			aux = coord1;
			coord1 = coord2;
			coord2 = aux;
		}
		
		int[] novoX = {coord1, coord2}; 
		
		return novoX;
	}
	
	public static int getOctanteDaReta(int x1, int y1, int x2, int y2) {
		
		int octante = 1;

		int dx = Math.abs(x2 - x1);
		int dy = Math.abs(y2 - y1);
		
		/*
		 * Q1: x1 < x2 && y1 < y2
		 * Q2: x1 > x2 && y1 < y2
		 * Q3: x1 > x2 && y1 > y2
		 * Q4: x1 < x2 && y1 > y2
		 * */
		
		if (x1 < x2 && y1 < y2) {
			
			if (dx > dy) {
				octante = 1;
			} else {
				octante = 2;
			}
			
		} else if ( x1 > x2 && y1 <= y2 ) {
			
			if (dx < dy) {
				octante = 3;
			} else {
				octante = 4;
			}
			
		} else if ( x1 > x2 && y1 > y2 ) {
			
			if (dx > dy) {
				octante = 5;
			} else {
				octante = 6;
			}
		
		} else if ( x1 < x2 && y1 > y2) {
			
			if (dx < dy) {
				octante = 7;
			} else {
				octante = 8;
			}
		}
		
		return octante;
	}
	
	public static int[] executaRebatimentoParaPrimeiroOctante(int x1, int y1, int x2, int y2, int octante) {
		
		int[] novosPontos = { x1, y1, x2, y2 };
		
		if (octante == 1) {
			
			return novosPontos;
			
		} else if (octante == 2){
			
			novosPontos = executaRebatimentoDo2Para1(x1, y1, x2, y2);
			
		} else if (octante == 3){
			
			novosPontos = executaRebatimentoDo3Para1(x1, y1, x2, y2);
		
		} else if (octante == 4){
			
			novosPontos = executaRebatimentoDo4Para1(x1, y1, x2, y2);
			
		} else if (octante == 5){
			
			novosPontos = executaRebatimentoDo5Para1(x1, y1, x2, y2);
		
		} else if (octante == 6){
			
			novosPontos = executaRebatimentoDo6Para1(x1, y1, x2, y2);
		
		} else if (octante == 7){
			
			novosPontos = executaRebatimentoDo7Para1(x1, y1, x2, y2);
		
		} else if (octante == 8){
			
			novosPontos = executaRebatimentoDo8Para1(x1, y1, x2, y2);
		}
		
		return novosPontos;
	}
	
	public static ArrayList<Integer[]> desfazRebatimentoParaPrimeiroOctante(int octante, ArrayList<Integer[]> conjPontosDaRetaRebatida) {
		
		ArrayList<Integer[]> conjPontosDaReta = new ArrayList<Integer[]>(0);
		
		if (octante == 1) {
		
			return conjPontosDaRetaRebatida;
		
		} else if (octante == 2){
			
			conjPontosDaReta = desfazRebatimentoDo1Para2(conjPontosDaRetaRebatida);
			
		} else if (octante == 3){
			
			conjPontosDaReta = desfazRebatimentoDo1Para3(conjPontosDaRetaRebatida);
			
		} else if (octante == 4){
			
			conjPontosDaReta = desfazRebatimentoDo1Para4(conjPontosDaRetaRebatida);
			
		} else if (octante == 5){
			
			conjPontosDaReta = desfazRebatimentoDo1Para5(conjPontosDaRetaRebatida);
			
		} else if (octante == 6){
			
			conjPontosDaReta = desfazRebatimentoDo1Para6(conjPontosDaRetaRebatida);
			
		} else if (octante == 7){
			
			conjPontosDaReta = desfazRebatimentoDo1Para7(conjPontosDaRetaRebatida);
			
		} else if (octante == 8){
			
			conjPontosDaReta = desfazRebatimentoDo1Para8(conjPontosDaRetaRebatida);
			
		}
		
		return conjPontosDaReta;
	}
	
	private static Integer[] inverteXY(int x, int y) {
		
		Integer[] novosPontos = new Integer[2];
		
		novosPontos[0] = y;
		novosPontos[1] = x;
		
		return novosPontos;
	}
	
	private static int[] inverteXY(int x1, int y1, int x2, int y2) {
		
		int[] novosPontos = new int[4];
		
		novosPontos[0] = y1;
		novosPontos[1] = x1;
		novosPontos[2] = y2;
		novosPontos[3] = x2;
		
		return novosPontos;
	}
	
	private static int[] executaRebatimentoDo2Para1(int x1, int y1, int x2, int y2) {
		
		return inverteXY(x1, y1, x2, y2);
	}
	
	private static ArrayList<Integer[]> desfazRebatimentoDo1Para2(ArrayList<Integer[]> conjPontosDaRetaRebatida) {
		
		ArrayList<Integer[]> conjPontosDaReta = new ArrayList<Integer[]>(0);
		
		Integer[] ponto = new Integer[2];
		
		int x, y;
		
		for (int i = 0; i < conjPontosDaRetaRebatida.size(); i++) {
			
			x = conjPontosDaRetaRebatida.get(i)[0];
			y = conjPontosDaRetaRebatida.get(i)[1];
			
			ponto = inverteXY(x, y);
			
			conjPontosDaReta.add(ponto);
		}
		
		return conjPontosDaReta;
	}
	
	private static int[] inverteSinalDeX2(int x1, int y1, int x2, int y2) {
		
		int[] novosPontos = new int[4];
		
		novosPontos[0] = x1;
		novosPontos[1] = y1;
		novosPontos[2] = (x2 * -1);
		novosPontos[3] = y2;
		
		return novosPontos;
	}
	
	private static Integer[] inverteSinalDeX(int x, int y) {
		
		Integer[] novosPontos = new Integer[2];
		
		novosPontos[0] = (x * -1);
		novosPontos[1] = y;
		
		return novosPontos;
	}
	
	private static int[] inverteSinalDeY2(int x1, int y1, int x2, int y2) {
		
		int[] novosPontos = new int[4];
		
		novosPontos[0] = x1;
		novosPontos[1] = y1;
		novosPontos[2] = x2;
		novosPontos[3] = (y2 * -1);
		
		return novosPontos;
	}
	
	private static Integer[] inverteSinalDeY(int x, int y) {
		
		Integer[] novosPontos = new Integer[2];
		
		novosPontos[0] = x;
		novosPontos[1] = (y * -1);
		
		return novosPontos;
	}
	
	private static int[] executaRebatimentoDo3Para1(int x1, int y1, int x2, int y2) {
		
		int[] novosPontos = inverteSinalDeX2(x1, y1, x2, y2);
		
		novosPontos = inverteXY(novosPontos[0], novosPontos[1], novosPontos[2], novosPontos[3]);
		
		return novosPontos;
	}
	
	private static ArrayList<Integer[]> desfazRebatimentoDo1Para3(ArrayList<Integer[]> conjPontosDaRetaRebatida) {
	
		ArrayList<Integer[]> conjPontosDaReta = new ArrayList<Integer[]>(0);
		
		Integer[] ponto = new Integer[2];
		
		int x, y;
		
		for (int i = 0; i < conjPontosDaRetaRebatida.size(); i++) {
			
			x = conjPontosDaRetaRebatida.get(i)[0];
			y = conjPontosDaRetaRebatida.get(i)[1];
			
			ponto = inverteXY(x, y);
			
			ponto = inverteSinalDeX(ponto[0], ponto[1]);
			
			conjPontosDaReta.add(ponto);
		}
		
		return conjPontosDaReta;
	}
	
	private static int[] executaRebatimentoDo4Para1(int x1, int y1, int x2, int y2) {
		
		int[] novosPontos = inverteSinalDeX2(x1, y1, x2, y2);
		
		return novosPontos;
	}
	
	private static ArrayList<Integer[]> desfazRebatimentoDo1Para4(ArrayList<Integer[]> conjPontosDaRetaRebatida) {
		
		ArrayList<Integer[]> conjPontosDaReta = new ArrayList<Integer[]>(0);
		
		Integer[] ponto = new Integer[2];
		
		int x, y;
		
		for (int i = 0; i < conjPontosDaRetaRebatida.size(); i++) {
			
			x = conjPontosDaRetaRebatida.get(i)[0];
			y = conjPontosDaRetaRebatida.get(i)[1];
			
			ponto = inverteSinalDeX(x, y);
			
			conjPontosDaReta.add(ponto);
		}
		
		return conjPontosDaReta;
	}
	
	private static int[] executaRebatimentoDo5Para1(int x1, int y1, int x2, int y2) {
		
		int[] novosPontos = inverteSinalDeY2(x1, y1, x2, y2);
		
		novosPontos = inverteSinalDeX2(novosPontos[0], novosPontos[1], novosPontos[2], novosPontos[3]);
		
		return novosPontos;
	}
	
	private static ArrayList<Integer[]> desfazRebatimentoDo1Para5(ArrayList<Integer[]> conjPontosDaRetaRebatida) {
		
		ArrayList<Integer[]> conjPontosDaReta = new ArrayList<Integer[]>(0);
		
		Integer[] ponto = new Integer[2];
		
		int x, y;
		
		for (int i = 0; i < conjPontosDaRetaRebatida.size(); i++) {
			
			x = conjPontosDaRetaRebatida.get(i)[0];
			y = conjPontosDaRetaRebatida.get(i)[1];
			
			ponto = inverteSinalDeX(x, y);
			
			ponto = inverteSinalDeY(ponto[0], ponto[1]);
			
			conjPontosDaReta.add(ponto);
		}
		
		return conjPontosDaReta;
	}
	
	private static int[] executaRebatimentoDo6Para1(int x1, int y1, int x2, int y2) {
		
		int[] novosPontos = inverteSinalDeX2(x1, y1, x2, y2);
		
		novosPontos = inverteSinalDeY2(novosPontos[0], novosPontos[1], novosPontos[2], novosPontos[3]);
		
		novosPontos = inverteXY(novosPontos[0], novosPontos[1], novosPontos[2], novosPontos[3]);
		
		return novosPontos;
	}
	
	private static ArrayList<Integer[]> desfazRebatimentoDo1Para6(ArrayList<Integer[]> conjPontosDaRetaRebatida) {
		
		ArrayList<Integer[]> conjPontosDaReta = new ArrayList<Integer[]>(0);
		
		Integer[] ponto = new Integer[2];
		
		int x, y;
		
		for (int i = 0; i < conjPontosDaRetaRebatida.size(); i++) {
			
			x = conjPontosDaRetaRebatida.get(i)[0];
			y = conjPontosDaRetaRebatida.get(i)[1];
			
			ponto = inverteXY(x, y);
			
			ponto = inverteSinalDeY(ponto[0], ponto[1]);
			
			ponto = inverteSinalDeX(ponto[0], ponto[1]);
			
			conjPontosDaReta.add(ponto);
		}
		
		return conjPontosDaReta;
	}
	
	private static int[] executaRebatimentoDo7Para1(int x1, int y1, int x2, int y2) {
		
		int[] novosPontos = inverteSinalDeY2(x1, y1, x2, y2);
		
		novosPontos = inverteXY(novosPontos[0], novosPontos[1], novosPontos[2], novosPontos[3]);
		
		return novosPontos;
	}
	
	private static ArrayList<Integer[]> desfazRebatimentoDo1Para7(ArrayList<Integer[]> conjPontosDaRetaRebatida) {
		
		ArrayList<Integer[]> conjPontosDaReta = new ArrayList<Integer[]>(0);
		
		Integer[] ponto = new Integer[2];
		
		int x, y;
		
		for (int i = 0; i < conjPontosDaRetaRebatida.size(); i++) {
			
			x = conjPontosDaRetaRebatida.get(i)[0];
			y = conjPontosDaRetaRebatida.get(i)[1];
			
			ponto = inverteXY(x, y);
			
			ponto = inverteSinalDeY(ponto[0], ponto[1]);
			
			conjPontosDaReta.add(ponto);
		}
		
		return conjPontosDaReta;
	}
	
	private static int[] executaRebatimentoDo8Para1(int x1, int y1, int x2, int y2) {
		
		int[] novosPontos = inverteSinalDeY2(x1, y1, x2, y2);
		
		return novosPontos;
	}
	
	private static ArrayList<Integer[]> desfazRebatimentoDo1Para8(ArrayList<Integer[]> conjPontosDaRetaRebatida) {
		
		ArrayList<Integer[]> conjPontosDaReta = new ArrayList<Integer[]>(0);
		
		Integer[] ponto = new Integer[2];
		
		int x, y;
		
		for (int i = 0; i < conjPontosDaRetaRebatida.size(); i++) {
			
			x = conjPontosDaRetaRebatida.get(i)[0];
			y = conjPontosDaRetaRebatida.get(i)[1];
			
			ponto = inverteSinalDeY(x, y);
			
			conjPontosDaReta.add(ponto);
		}
		
		return conjPontosDaReta;
	}
	
	public static int converteCoordenadaX(int x, int xCentro) {
		
		int novoX = x + xCentro;
		
		return novoX;
	}
	
	public static int converteCoordenadaY(int y, int yCentro) {
		
		int novoY = y * -1; 
		
		novoY = novoY + yCentro;
		
		return novoY;
	}
}