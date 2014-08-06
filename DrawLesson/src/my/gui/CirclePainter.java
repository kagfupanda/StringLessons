package my.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class CirclePainter extends JPanel implements Runnable {
	private double upperLeftX;
	private double upperLeftY;
	private int circleHeight;
	private int circleWidth;
	private Color circleColor; 
	private int sleepTime;
	private int adjustXY;

	public CirclePainter() {
		// TODO Auto-generated constructor stub
		System.out.println("ctor");
		upperLeftX = 0.0; //assuming start from largest
		upperLeftY = 0.0; //assuming start from largest
		circleHeight = getHeight();
		circleWidth = getWidth();
		circleColor = Color.GREEN;
		sleepTime = 2000; 
		adjustXY = 10;
		//setOpaque(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		System.out.println("Paint compent got called");
		System.out.println("circleWidth" + circleWidth);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setPaint(circleColor);
		g2d.draw(new Ellipse2D.Double(upperLeftX, upperLeftY, circleWidth, circleHeight));	
	}

	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		System.out.println("prefsize");
		return new Dimension(500,500);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
		Thread.sleep(2000);
		} catch (Exception e) {
			//No-Op
		}
		System.out.println("run");
		circleHeight = getHeight();
		circleWidth = getWidth();
		for(int i = 0; i < (adjustXY * 2); i++) {
			//repaint();
			repaint((int)upperLeftX, (int)upperLeftY, circleHeight, circleWidth); // repaint only this rectangle area
			circleHeight = circleHeight - (2*adjustXY);
			circleWidth = circleWidth - (2*adjustXY);
			upperLeftX = upperLeftX + adjustXY;
			upperLeftY = upperLeftY + adjustXY;
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				//No-Op
			}
		}
		
	}
	

}
