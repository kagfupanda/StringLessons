package my.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class ConcentricCirclesForLoop extends JPanel{
	private boolean drawCircle;

	public ConcentricCirclesForLoop() {
		// TODO Auto-generated constructor stub
		drawCircle = true;
		
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		int width = getWidth();
		int height = getHeight();
		int centerx = width/2;
		int centery = height/2;
		
		Graphics2D g2d = (Graphics2D) g;
		int circleWidth = width;
		int circleHeight = height;
		double upperX = centerx - circleWidth/2;
		double upperY = centery - circleHeight/2;
		//g2d.draw(new Ellipse2D.Double(upperX, upperY, circleWidth, circleHeight));
		
		g2d.setPaint(Color.RED);
		 
		for(int i = 0; i < width/20; i++) {
			if (drawCircle == true) {
				g2d.draw(new Ellipse2D.Double(upperX, upperY, circleWidth, circleHeight));
				upperX = upperX + 10;
				upperY = upperY + 10;
				circleWidth = circleWidth - 20;
				circleHeight = circleHeight - 20;
			} else {
				System.out.println("drawCircle is not true");
			}
		}	
	}
	public void circleDraw() {
		drawCircle = true;
		repaint();
	}
	
	
	
	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(300,300);
	}

	
	

}
