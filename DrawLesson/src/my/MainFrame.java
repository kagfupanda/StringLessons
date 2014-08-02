package my;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import my.controller.ConcentricCirclesController;
import my.controller.TraficSignalController;
import my.gui.ColorCirclePanel;
import my.gui.ColorRectanglePanel;
import my.gui.ConcentricCircles;
import my.gui.ConcentricCirclesForLoop;
import my.gui.TrafficSignal;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

	public MainFrame() {
		//set JFrame properties
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Main Frame");
		this.getContentPane().setLayout(new GridLayout(0,1)); // rows = 0 columns = 2
		
		//create and add ColorCirclePanel to content pane
		//this.getContentPane().add(new ColorCirclePanel(Color.GREEN));
		//this.getContentPane().add(new ColorCirclePanel(Color.RED));
		//this.getContentPane().add(new ColorRectanglePanel(Color.CYAN)); 
		//TrafficSignal tSignal1 = new TrafficSignal();
		//this.getContentPane().add(new ConcentricCircles());
		//this.getContentPane().add(new ConcentricCirclesForLoop());
		ConcentricCirclesForLoop cc = new ConcentricCirclesForLoop();
		this.getContentPane().add(cc);
		ConcentricCirclesController cccon = new ConcentricCirclesController(cc, 2000);
		cccon.start();
		//this.getContentPane().add(tSignal1);
		//tSignal1.setGreenOn();//turn green light on
		//create a TrafficSignalController to control tSignla1 TrafficSignal instance
		//TraficSignalController tsc = new TraficSignalController(tSignal1);
		//Start the controller thread
		//tsc.start();
		
		//TrafficSignal tSignal2 = new TrafficSignal();
		//this.getContentPane().add(tSignal2);
		//create a second controller for tSignal2
		//TraficSignalController tsc2 = new TraficSignalController(tSignal2, 3000);
		//start the thread
		//tsc2.start();
		
		//pack the frame and show
		this.pack();
		//this.setSize(300, 300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// create a GUI/Swing thread to create MainFrame
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new MainFrame(); //create the MainFrame object
			}
			
		});
		
	}

}
