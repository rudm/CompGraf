package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import utils.Primitiva;

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
		
		Primitiva.drawLine(g, 10, 10, 30, 30, xCentro, yCentro);
		Primitiva.drawLine(g, 30, 30, 70, 30, xCentro, yCentro);
		Primitiva.drawLine(g, 70, 30, 90, 10, xCentro, yCentro);
		Primitiva.drawLine(g, 90, 10, 90, -20, xCentro, yCentro);
		Primitiva.drawLine(g, 90, -20, 65, -70, xCentro, yCentro);
		Primitiva.drawLine(g, 65, -70, 35, -70, xCentro, yCentro);
		Primitiva.drawLine(g, 35, -70, 10, -20, xCentro, yCentro);
		Primitiva.drawLine(g, 10, -20, 10, 10, xCentro, yCentro);
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