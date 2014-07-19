package my.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class ColorRectanglePanel extends JPanel{

	private Color fillColor; 
	
	public ColorRectanglePanel(Color c) {
		
		fillColor = c; 
		//this.setSize(200,200);
	}

	@Override
	public void paint(Graphics g) {
		System.out.println("[3]paint method in ColorrectanglePanel");
		super.paint(g);
		
		int width = getWidth();
		int height = getHeight(); 
		int centerx = width/2;
		int centery = height/2; 
		int rectangleWidth = 50; 
		int rectangleHeight = 90; 
		
		Graphics2D g2d = (Graphics2D)g;
		double upperLeftX = centerx - rectangleWidth/2;
		double upperLeftY = centery - rectangleHeight/2;
		
		g2d.setPaint(fillColor);
		System.out.println("Values are: " + upperLeftX + " " + upperLeftY);
		System.out.println("rectangle values: " + rectangleWidth + " " + rectangleHeight);
		
		g2d.fill(new Rectangle2D.Double(upperLeftX, upperLeftY, rectangleWidth, rectangleHeight));
	}

	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(200,200);
	}

}