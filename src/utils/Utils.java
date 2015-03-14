package utils;

import java.util.ArrayList;

public class Utils {

	public static int[][] getMatrizTemplateTransalacao(int x1, int y1, int x2, int y2) {
		
		int[][] matrizTemplateTranslacao = { {1, 0, (x2 - x1)}, {0, 1, (y2 - y1)}, {0, 0, 1} };
		
		return matrizTemplateTranslacao;
	}
	
	public static int[][] getMatrizTemplateRotacaoCompleta(int x1, int y1, int x2, int y2, double angulo) {
		
		int[][] matrizTemplateRotacaoCompleta = new int [3][3];
		
		matrizTemplateRotacaoCompleta[0][0] = Math.round((float)Math.cos(angulo));
		matrizTemplateRotacaoCompleta[0][1] = Math.round((float)Math.sin(angulo)*-1); 
		matrizTemplateRotacaoCompleta[0][2] = (x2 - x1)*(1 - Math.round((float)Math.cos(angulo))) + (y2 - y1)*Math.round((float)Math.sin(angulo));
		matrizTemplateRotacaoCompleta[1][0] = Math.round((float)Math.sin(angulo));
		matrizTemplateRotacaoCompleta[1][1] = Math.round((float)Math.cos(angulo)*-1);
		matrizTemplateRotacaoCompleta[1][2] = (y2 - y1)*(1 - Math.round((float)Math.cos(angulo))) + (x2 - x1)*Math.round((float)Math.sin(angulo));
		matrizTemplateRotacaoCompleta[2][0] = 0;
		matrizTemplateRotacaoCompleta[2][1] = 0;
		matrizTemplateRotacaoCompleta[2][2] = 1;
		
		return matrizTemplateRotacaoCompleta;
	}
	
	public static int[][] getMatrizTemplateEscalaCompleta(int x1, int y1, int x2, int y2, double fatorX, double fatorY) {
		
		int[][] matrizTemplateRotacaoCompleta = new int [3][3];
		
		matrizTemplateRotacaoCompleta[0][0] = Math.round((float)fatorX);
		matrizTemplateRotacaoCompleta[0][1] = 0;
		matrizTemplateRotacaoCompleta[0][2] = (x2 - x1)*(1 - Math.round((float)fatorX));
		matrizTemplateRotacaoCompleta[1][0] = 0;
		matrizTemplateRotacaoCompleta[1][1] = Math.round((float)fatorY);
		matrizTemplateRotacaoCompleta[1][2] = (y2 - y1)*(1 - Math.round((float)fatorY));
		matrizTemplateRotacaoCompleta[2][0] = 0;
		matrizTemplateRotacaoCompleta[2][1] = 0;
		matrizTemplateRotacaoCompleta[2][2] = 1;
		
		return matrizTemplateRotacaoCompleta;
	}
	
	public static int[] transladaPonto(int x1, int y1, int x2, int y2) {

		int[][] matrizTranslacao = getMatrizTemplateTransalacao(x1, y1, x2, y2);
		
		int[][] matrizNovoPonto = new int [1][3];
		
		int[][] matrizResultado = OperacaoMatriz.multiplicaMatrizes(matrizTranslacao, matrizNovoPonto);
		
		int[] novoPonto = {matrizResultado[0][0], matrizResultado[0][1]};
		
		return novoPonto;
	}
	
	public static int getOctanteDaReta(int x1, int y1, int x2, int y2) {
		
		int octante = 1;

		int dx = Math.abs(x2 - x1);
		int dy = Math.abs(y2 - y1);
		
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
	
	private static int[] invertePontos(int x1, int y1, int x2, int y2) {
		
		int[] novosPontos = new int[4];
		
		novosPontos[0] = x2;
		novosPontos[1] = y2;
		novosPontos[2] = x1;
		novosPontos[3] = y1;
		
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
	
	private static int[] executaRebatimentoDo3Para1(int x1, int y1, int x2, int y2) {
		
		int[] novosPontos = {x1, y1, x2, y2}; 
		
		novosPontos[0] = x2;
		novosPontos[1] = y1;
		novosPontos[2] = x1;
		novosPontos[3] = y2;

		novosPontos = executaRebatimentoDo2Para1(novosPontos[0], novosPontos[1], novosPontos[2], novosPontos[3]); //inverteXY(novosPontos[0], novosPontos[1], novosPontos[2], novosPontos[3]);
		
		return novosPontos;
	}
	
	private static ArrayList<Integer[]> desfazRebatimentoDo1Para3(ArrayList<Integer[]> conjPontosDaRetaRebatida) {
	
		ArrayList<Integer[]> conjPontosDaReta = desfazRebatimentoDo1Para2(conjPontosDaRetaRebatida);
		
		Integer[] ponto = new Integer[2];
		
		int sizeArrayList = conjPontosDaReta.size();
		
		Integer[] arX = new Integer[sizeArrayList];
		
		for (int i = 0; i < sizeArrayList; i++) {

			arX[i] = conjPontosDaReta.get(i)[0];
		}
		
		for (int i = 0; i < sizeArrayList; i++) {

			ponto = new Integer[2];
			
			ponto[0] = arX[arX.length - 1 - i];
			ponto[1] = conjPontosDaReta.get(i)[1];

			conjPontosDaReta.set(i, ponto);
		}
		
		return conjPontosDaReta;
	}
	
	private static int[] executaRebatimentoDo4Para1(int x1, int y1, int x2, int y2) {
		
		int[] novosPontos = {x1, y1, x2, y2}; //inverteSinalDeX2(x1, y1, x2, y2);
		
		novosPontos[0] = x2;
		novosPontos[1] = y1;
		novosPontos[2] = x1;
		novosPontos[3] = y2;
		
		return novosPontos;
	}
	
	private static ArrayList<Integer[]> desfazRebatimentoDo1Para4(ArrayList<Integer[]> conjPontosDaRetaRebatida) {
		
		ArrayList<Integer[]> conjPontosDaReta = new ArrayList<Integer[]>(0);
		
		Integer[] ponto = new Integer[2];
		
		int sizeArrayList = conjPontosDaRetaRebatida.size();
		
		Integer[] arX = new Integer[sizeArrayList];
		
		for (int i = 0; i < sizeArrayList; i++) {

			arX[i] = conjPontosDaRetaRebatida.get(i)[0];
		}
		
		for (int i = 0; i < sizeArrayList; i++) {

			ponto = new Integer[2];
			
			ponto[0] = arX[arX.length - 1 - i];
			ponto[1] = conjPontosDaRetaRebatida.get(i)[1];

			conjPontosDaReta.add(ponto);
		}
		
		return conjPontosDaReta;
	}
	
	private static int[] executaRebatimentoDo5Para1(int x1, int y1, int x2, int y2) {
		
		int[] novosPontos = {x1, y1, x2, y2}; //inverteSinalDeX2(x1, y1, x2, y2);
		
		novosPontos[0] = x2;
		novosPontos[1] = y2;
		novosPontos[2] = x1;
		novosPontos[3] = y1;
		
		return novosPontos;
	}
	
	private static ArrayList<Integer[]> desfazRebatimentoDo1Para5(ArrayList<Integer[]> conjPontosDaRetaRebatida) {
		
		ArrayList<Integer[]> conjPontosDaReta = conjPontosDaRetaRebatida;
		
		return conjPontosDaReta;
	}
	
	private static int[] executaRebatimentoDo6Para1(int x1, int y1, int x2, int y2) {
		
		int[] novosPontos = invertePontos(x1, y1, x2, y2);
		
		novosPontos = executaRebatimentoDo2Para1(novosPontos[0], novosPontos[1], novosPontos[2], novosPontos[3]);
		
		return novosPontos;
	}
	
	private static ArrayList<Integer[]> desfazRebatimentoDo1Para6(ArrayList<Integer[]> conjPontosDaRetaRebatida) {
		
		conjPontosDaRetaRebatida = desfazRebatimentoDo1Para2(conjPontosDaRetaRebatida);
		
		return conjPontosDaRetaRebatida;
	}
	
	private static int[] executaRebatimentoDo7Para1(int x1, int y1, int x2, int y2) {
		
		int[] novosPontos = {x1, y1, x2, y2};
		
		novosPontos = invertePontos(novosPontos[0], novosPontos[1], novosPontos[2], novosPontos[3]);
		
		novosPontos = executaRebatimentoDo3Para1(novosPontos[0], novosPontos[1], novosPontos[2], novosPontos[3]);
		
		return novosPontos;
	}
	
	private static ArrayList<Integer[]> desfazRebatimentoDo1Para7(ArrayList<Integer[]> conjPontosDaRetaRebatida) {
		
		ArrayList<Integer[]> conjPontosDaReta = desfazRebatimentoDo1Para3(conjPontosDaRetaRebatida);
		
		return conjPontosDaReta;
	}
	
	private static int[] executaRebatimentoDo8Para1(int x1, int y1, int x2, int y2) {
		
		int[] novosPontos = {x1, y1, x2, y2}; // inverteSinalDeY2(x1, y1, x2, y2);
		
		novosPontos[0] = x1;
		novosPontos[1] = y2;
		novosPontos[2] = x2;
		novosPontos[3] = y1;
		
		return novosPontos;
	}
	
	private static ArrayList<Integer[]> desfazRebatimentoDo1Para8(ArrayList<Integer[]> conjPontosDaRetaRebatida) {
		
		ArrayList<Integer[]> conjPontosDaReta = new ArrayList<Integer[]>(0);
		
		Integer[] ponto = new Integer[2];
		
		int sizeArrayList = conjPontosDaRetaRebatida.size();
		
		Integer[] arY = new Integer[sizeArrayList];
		
		for (int i = 0; i < sizeArrayList; i++) {

			arY[i] = conjPontosDaRetaRebatida.get(i)[1];
		}
		
		for (int i = 0; i < sizeArrayList; i++) {

			ponto = new Integer[2];
			
			ponto[0] = conjPontosDaRetaRebatida.get(i)[0];
			ponto[1] = arY[arY.length - 1 - i];

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