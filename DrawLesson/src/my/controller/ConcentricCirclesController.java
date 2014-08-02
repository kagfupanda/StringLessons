package my.controller;
import my.gui.ConcentricCirclesForLoop;

public class ConcentricCirclesController extends Thread {
	private ConcentricCirclesForLoop cc;
	private int sleepInterval;

	public ConcentricCirclesController(ConcentricCirclesForLoop concenCircles, int sleepTime) {
		// TODO Auto-generated constructor stub
		cc = concenCircles;
		sleepInterval = sleepTime;
		
	}
	
	public void delay(int sleepInterval) {
		try {
			Thread.sleep(sleepInterval);
		} catch (Exception e) {
			System.out.println("sleep got interrupted");
		}
	}
	@Override
	public void run() {
		while(true) {
			cc.circleDraw();
			delay(sleepInterval);
		}
	}
	

}
