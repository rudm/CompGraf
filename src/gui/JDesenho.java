package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import utils.OperacaoMatriz;
import utils.Primitiva;
import utils.Utils;

public class JDesenho extends JPanel {

	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		
		int [] pontoCentral = this.retornaPontoCentralDoPainel();
		
		int xCentro = pontoCentral[0];
		int yCentro = pontoCentral[1];
		
		Primitiva.drawHLine(g, 0, this.getWidth(), yCentro, JDesenho.this);
		//Primitiva.drawVLine(g, xCentro, 0, this.getHeight(), JDesenho.this);
		Primitiva.drawVLine(g, 0, (-1)*(this.getHeight()/2), this.getHeight(), xCentro, yCentro);
		
		g.setColor(Color.RED);
		
		/**
		 * ########## TESTES PARA 2o OCTANTE ##########
		 * **/
		/*Primitiva.drawLine(g, 10, 10, 40, 100, xCentro, yCentro);
		Primitiva.drawLine(g, -10, 10, 20, 100, xCentro, yCentro);
		Primitiva.drawLine(g, -30, 10, 0, 100, xCentro, yCentro);
		Primitiva.drawLine(g, -30, -10, 0, 80, xCentro, yCentro);
		Primitiva.drawLine(g, -30, -100, 0, -10, xCentro, yCentro);
		Primitiva.drawLine(g, -10, -100, 20, -10, xCentro, yCentro);
		Primitiva.drawLine(g, 10, -100, 40, -10, xCentro, yCentro);
		Primitiva.drawLine(g, -10, -80, 20, 10, xCentro, yCentro);*/
		
		/**
		 * ########## TESTES PARA 3o OCTANTE ##########
		 * **/
		/*Primitiva.drawLine(g, 40, 10, 10, 80, xCentro, yCentro);
		Primitiva.drawLine(g, 10, 10, -20, 80, xCentro, yCentro);
		Primitiva.drawLine(g, -20, 10, -50, 80, xCentro, yCentro);
		Primitiva.drawLine(g, -30, -10, -60, 60, xCentro, yCentro);
		Primitiva.drawLine(g, -30, -80, -60, -10, xCentro, yCentro);
		Primitiva.drawLine(g, 10, -80, -20, -10, xCentro, yCentro);
		Primitiva.drawLine(g, 40, -80, 10, -10, xCentro, yCentro);
		Primitiva.drawLine(g, 40, -30, 10, 40, xCentro, yCentro);*/
		
		/**
		 * ########## TESTES PARA 4o OCTANTE ##########
		 * **/
		/*Primitiva.drawLine(g, 80, 10, 10, 40, xCentro, yCentro);
		Primitiva.drawLine(g, 50, 10, -20, 40, xCentro, yCentro);
		Primitiva.drawLine(g, -10, 10, -80, 40, xCentro, yCentro);
		Primitiva.drawLine(g, -10, -10, -80, 20, xCentro, yCentro);
		Primitiva.drawLine(g, -10, -40, -80, -10, xCentro, yCentro);
		Primitiva.drawLine(g, 10, -40, -60, -10, xCentro, yCentro);
		Primitiva.drawLine(g, 80, -40, 10, -10, xCentro, yCentro);
		Primitiva.drawLine(g, 80, -10, 10, 20, xCentro, yCentro);*/
		
		/**
		 * ########## TESTES PARA 5o OCTANTE ##########
		 * **/
		/*Primitiva.drawLine(g, 80, 40, 10, 10, xCentro, yCentro);
		Primitiva.drawLine(g, 10, 50, -60, 20, xCentro, yCentro);
		Primitiva.drawLine(g, -60, 40, -130, 10, xCentro, yCentro);
		Primitiva.drawLine(g, -60, 10, -130, -20, xCentro, yCentro);
		Primitiva.drawLine(g, -60, -10, -130, -40, xCentro, yCentro);
		Primitiva.drawLine(g, 20, -10, -50, -40, xCentro, yCentro);
		Primitiva.drawLine(g, 80, -10, 10, -40, xCentro, yCentro);
		Primitiva.drawLine(g, 180, 10, 110, -20, xCentro, yCentro);*/
		
		/**
		 * ########## TESTES PARA 6o OCTANTE ##########
		 * **/
		/*Primitiva.drawLine(g, -10, -10, -30, -90, xCentro, yCentro);
		Primitiva.drawLine(g, 10, -10, -10, -90, xCentro, yCentro);
		Primitiva.drawLine(g, 30, -10, 10, -90, xCentro, yCentro);
		Primitiva.drawLine(g, -10, -40, 10, 40, xCentro, yCentro);
		Primitiva.drawLine(g, -30, 10, -10, 90, xCentro, yCentro);
		Primitiva.drawLine(g, -10, 10, 10, 90, xCentro, yCentro);
		Primitiva.drawLine(g, 10, 10, 30, 90, xCentro, yCentro);*/
		
		/**
		 * ########## TESTES PARA 7o OCTANTE ##########
		 * **/
		/*Primitiva.drawLine(g, 10, -10, 30, -90, xCentro, yCentro);
		Primitiva.drawLine(g, -10, -10, 10, -90, xCentro, yCentro);
		Primitiva.drawLine(g, -30, -10, -10, -90, xCentro, yCentro);
		Primitiva.drawLine(g, -10, 40, 10, -40, xCentro, yCentro);
		Primitiva.drawLine(g, 10, 90, 30, 10, xCentro, yCentro);
		Primitiva.drawLine(g, -10, 90, 10, 10, xCentro, yCentro);
		Primitiva.drawLine(g, -30, 90, -10, 10, xCentro, yCentro);*/
		
		/**
		 * ########## TESTES PARA 8o OCTANTE ##########
		 * **/
		/*Primitiva.drawLine(g, 20, 40, 90, 10, xCentro, yCentro);
		Primitiva.drawLine(g, -20, 40, 70, 10, xCentro, yCentro);
		Primitiva.drawLine(g, -90, 40, -20, 10, xCentro, yCentro);
		Primitiva.drawLine(g, -90, 20, -20, -10, xCentro, yCentro);
		Primitiva.drawLine(g, -90, -20, -20, -40, xCentro, yCentro);
		Primitiva.drawLine(g, -70, -20, 20, -40, xCentro, yCentro);
		Primitiva.drawLine(g, 20, -20, 90, -40, xCentro, yCentro);
		Primitiva.drawLine(g, 20, 20, 90, -10, xCentro, yCentro);*/
		
		//Primitiva.drawLine(g, 10, 10, 10, 80, xCentro, yCentro);
		//Primitiva.drawLine(g, 10, 80, 80, 80, xCentro, yCentro);
		//Primitiva.drawLine(g, 80, 80, 80, 10, xCentro, yCentro);
		//Primitiva.drawLine(g, 80, 10, 10, 10, xCentro, yCentro);
		
		//Primitiva.drawLine(g, -80, 10, -10, 80, xCentro, yCentro);
		//Primitiva.drawLine(g, -10, 80, 20, 10, xCentro, yCentro);
		//Primitiva.drawLine(g, 20, 10, -80, 10, xCentro, yCentro);
		
		/**
		 * ########## CAIXAOZINHO ##########
		 * **/
//		Primitiva.drawLine(g, 10, 10, 30, 30, xCentro, yCentro);
//		Primitiva.drawLine(g, 30, 30, 70, 30, xCentro, yCentro);
//		Primitiva.drawLine(g, 70, 30, 90, 10, xCentro, yCentro);
//		Primitiva.drawLine(g, 90, 10, 90, -20, xCentro, yCentro);
//		Primitiva.drawLine(g, 90, -20, 65, -70, xCentro, yCentro);
//		Primitiva.drawLine(g, 65, -70, 35, -70, xCentro, yCentro);
//		Primitiva.drawLine(g, 35, -70, 10, -20, xCentro, yCentro);
//		Primitiva.drawLine(g, 10, -20, 10, 10, xCentro, yCentro);
		
		/**
		 * ########## TRIANGULO ##########
		 * **/
		ArrayList<Integer> p1 = new ArrayList<Integer>();
		p1.add(new Integer(30));
		p1.add(new Integer(30));
		p1.add(new Integer(60));
		p1.add(new Integer(90));
		p1.add(new Integer(90));
		p1.add(new Integer(30));
		
		Primitiva.drawPolygon(g, p1, xCentro, yCentro);
		
		int dX, dY, xPivot, yPivot, angulo;
		double fatorX, fatorY;
		
		/*int dX = -30;
		int dY = -30;
		
		g.setColor(Color.BLUE);
		
		ArrayList<Integer> novoP1 = transaladaPoligono(p1, dX, dY); 
		
		Primitiva.drawPolygon(g, novoP1, xCentro, yCentro);
		
		int xPivot = 0;
		int yPivot = 0;
		int angulo = 45;
		
		g.setColor(Color.GREEN);
		
		ArrayList<Integer> novoP1_2 = rotacionaPoligono(novoP1, xPivot, yPivot, angulo); 
		
		Primitiva.drawPolygon(g, novoP1_2, xCentro, yCentro);
		
		
		g.setColor(Color.MAGENTA);
		
		ArrayList<Integer> novoP1_3 = transaladaPoligono(novoP1_2, -dX, -dY); 
		
		Primitiva.drawPolygon(g, novoP1_3, xCentro, yCentro);*/
		
		
		/*xPivot = 30;
		yPivot = 30;
		angulo = 45;
		
		g.setColor(Color.PINK);
		
		ArrayList<Integer> novoP1_4 = rotacionaPoligonoCompleto(p1, xPivot, yPivot, angulo); 
		
		Primitiva.drawPolygon(g, novoP1_4, xCentro, yCentro);*/
		
		xPivot = 30;
		yPivot = 30;
		fatorX = 0.5;
		fatorY = 0.5;
		
		g.setColor(Color.BLUE);
		
		ArrayList<Integer> novoP1_5 = escalaPoligonoCompleto(p1, xPivot, yPivot, fatorX, fatorY); 
		
		Primitiva.drawPolygon(g, novoP1_5, xCentro, yCentro);
		
		
		//g.setColor(Color.BLACK);
		
		//Primitiva.drawVLine(g, -10, -30, 30, xCentro, yCentro);
		//Primitiva.drawVLine(g, 30, 30, 90, xCentro, yCentro);
		
		/**
		 * ########## QUADRADO ##########
		 * **/
		/*ArrayList<Integer> p2 = new ArrayList<Integer>();
		p2.add(new Integer(-30));
		p2.add(new Integer(30));
		p2.add(new Integer(-30));
		p2.add(new Integer(90));
		p2.add(new Integer(-90));
		p2.add(new Integer(90));
		p2.add(new Integer(-90));
		p2.add(new Integer(30));
		Primitiva.drawPolygon(g, p2, xCentro, yCentro);*/
		
		/**
		 * ########## PENTAGONO ##########
		 * **/
		/*ArrayList<Integer> p3 = new ArrayList<Integer>();
		p3.add(new Integer(-50));
		p3.add(new Integer(-10));
		p3.add(new Integer(-10));
		p3.add(new Integer(-50));
		p3.add(new Integer(-25));
		p3.add(new Integer(-90));
		p3.add(new Integer(-70));
		p3.add(new Integer(-90));
		p3.add(new Integer(-90));
		p3.add(new Integer(-50));
		Primitiva.drawPolygon(g, p3, xCentro, yCentro);
		
		int dX = 60;
		int dY = 60;
		
		g.setColor(Color.BLUE);
		
		ArrayList<Integer> novoP1 = transaladaPoligono(p3, dX, dY); 
		
		Primitiva.drawPolygon(g, novoP1, xCentro, yCentro);*/
	}
	
	private ArrayList<Integer> transaladaPoligono(ArrayList<Integer> poligono, int dX, int dY) {
		
		int x1, y1;
		int[] novoPonto;
		ArrayList<Integer> novoPoligono = new ArrayList<Integer>(0);
		
		OperacaoMatriz.escreveMatrizNoConsole(Utils.getMatrizTemplateTransalacao(dX, dY), "Translação");
		
		for (int i = 0; i < poligono.size(); i+=2) {
			x1 = poligono.get(i);
			y1 = poligono.get(i+1);
			
			novoPonto = Utils.transladaPonto(x1, y1, (dX + x1), (dY + y1));
			
			novoPoligono.add(novoPonto[0]);
			novoPoligono.add(novoPonto[1]);
		}
		
		return novoPoligono;
	}
	
	private ArrayList<Integer> rotacionaPoligonoCompleto(ArrayList<Integer> poligono, int xPivot, int yPivot, double angulo) {
		
		int x1, y1;
		int[] novoPonto;
		ArrayList<Integer> novoPoligono = new ArrayList<Integer>(0);
		
		OperacaoMatriz.escreveMatrizNoConsole(Utils.getMatrizTemplateRotacaoCompleta(xPivot, yPivot, angulo), "Rotação Completa");
		
		for (int i = 0; i < poligono.size(); i+=2) {
			x1 = poligono.get(i);
			y1 = poligono.get(i+1);
			
			novoPonto = Utils.rotacionaPontoCompleto(x1, y1, xPivot, yPivot, angulo);
			
			novoPoligono.add(novoPonto[0]);
			novoPoligono.add(novoPonto[1]);
		}
		
		return novoPoligono;
	}
	
	
	private ArrayList<Integer> rotacionaPoligonoCompleto(ArrayList<Integer> poligono, double angulo) {
		
		int[] pontoPivot = Utils.calculaPivot(poligono);
		
		ArrayList<Integer> novoPoligono = rotacionaPoligonoCompleto(poligono, pontoPivot[0], pontoPivot[1], angulo);
		
		return novoPoligono;
	}
	
	private ArrayList<Integer> rotacionaPoligono(ArrayList<Integer> poligono, int xPivot, int yPivot, double angulo) {
		
		int x1, y1;
		int[] novoPonto;
		ArrayList<Integer> novoPoligono = new ArrayList<Integer>(0);
		
		OperacaoMatriz.escreveMatrizNoConsole(Utils.getMatrizTemplateRotacao(xPivot, yPivot, angulo), "Rotação Simples");
		
		for (int i = 0; i < poligono.size(); i+=2) {
			x1 = poligono.get(i);
			y1 = poligono.get(i+1);
			
			novoPonto = Utils.rotacionaPonto(x1, y1, xPivot, yPivot, angulo);
			
			novoPoligono.add(novoPonto[0]);
			novoPoligono.add(novoPonto[1]);
		}
		
		return novoPoligono;
	}
	
	private ArrayList<Integer> escalaPoligonoCompleto(ArrayList<Integer> poligono, int xPivot, int yPivot, double fatorX, double fatorY) {
		
		int x1, y1;
		int[] novoPonto;
		ArrayList<Integer> novoPoligono = new ArrayList<Integer>(0);
		
		OperacaoMatriz.escreveMatrizNoConsole(Utils.getMatrizTemplateEscalaCompleta(xPivot, yPivot, fatorX, fatorY), "Escala Simples");
		
		for (int i = 0; i < poligono.size(); i+=2) {
			x1 = poligono.get(i);
			y1 = poligono.get(i+1);
			
			novoPonto = Utils.escalaPontoCompleto(x1, y1, xPivot, yPivot, fatorX, fatorY);
			
			novoPoligono.add(novoPonto[0]);
			novoPoligono.add(novoPonto[1]);
		}
		
		return novoPoligono;
	}
	
	private int[] retornaPontoCentralDoPainel() {
		
		int x = this.getWidth();

		if (x % 2 != 0) {
			x += 1;
		}
				
		x = x / 2;
		
		int y = this.getHeight();
		
		if (y % 2 != 0) {
			y += 1;
		}
		
		y = y / 2;
		
		int [] ponto = { x, y };
		
		return ponto;
	}
	
}