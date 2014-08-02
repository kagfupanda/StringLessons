package my.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class ConcentricCircles extends JPanel {

	public ConcentricCircles() {
		this.setSize(100,100);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		int width = getWidth();
		int height = getHeight();
		System.out.println("The height is " + height + " and the width is " + width);
		int centerx = width/2;
		int centery = height/2;
		
		Graphics2D g2d = (Graphics2D)g;
		int circleWidth = width;
		int circleHeight = height;
		double upperX = centerx - circleWidth/2;
		double upperY = centery - circleHeight/2;
		g2d.draw(new Ellipse2D.Double(upperX, upperY, circleWidth, circleHeight));
		
		//draw the second circle
		//adjust the circle identifiers for the second circle
		upperX = upperX + 10;
		upperY = upperY + 10;
		circleWidth = circleWidth - 20;
		circleHeight = circleHeight - 20;
		g2d.draw(new Ellipse2D.Double(upperX, upperY, circleWidth, circleHeight));
		
		//draw the third circle
		//adjust the circle identifiers for the third circle
		upperX = upperX + 10;
		upperY = upperY + 10;
		circleWidth = circleWidth - 20;
		circleHeight = circleHeight - 20;
		g2d.draw(new Ellipse2D.Double(upperX, upperY, circleWidth, circleHeight));
		
		//draw the fourth circle
		//adjust the circle identifiers for the fourth circle
		upperX = upperX + 10;
		upperY = upperY + 10;
		circleWidth = circleWidth - 20;
		circleHeight = circleHeight - 20;
		g2d.draw(new Ellipse2D.Double(upperX, upperY, circleWidth, circleHeight));
		
		//draw the fifth circle
		//adjust the circle identifiers for the fifth circle
		upperX = upperX + 10;
		upperY = upperY + 10;
		circleWidth = circleWidth - 20;
		circleHeight = circleHeight - 20;
		g2d.draw(new Ellipse2D.Double(upperX, upperY, circleWidth, circleHeight));
		
		//draw the sixth circle
		//adjust the circle identifiers for the sixth circle
		upperX = upperX + 10;
		upperY = upperY + 10;
		circleWidth = circleWidth - 20;
		circleHeight = circleHeight - 20;
		g2d.draw(new Ellipse2D.Double(upperX, upperY, circleWidth, circleHeight));
		
		System.out.println("upper left corner is " + upperX + " upper left corner is " + upperY + " the circle width is " + circleWidth + " the circle hight is " + circleHeight);
	}
	
	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(200,200);
	}

}
