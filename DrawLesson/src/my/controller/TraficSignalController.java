package my.controller;

import my.gui.TrafficSignal;

public class TraficSignalController extends Thread {

	// internal data model
	private TrafficSignal theSignal; //this is the signal to control
	private int sleepInterval; //sleep interval in milliseconds
	
	// The ctor needs to be told the TrafficSignal to control
	public TraficSignalController(TrafficSignal trSignal) {
		// initialize internal data variables
		System.out.println("ctor 1 called");
		theSignal = trSignal; //store the parameter value in theSignal
		sleepInterval = 2000; //sleep interval defauslt to 2000 miliseconds
	}
	
	//second ctor that takes a TrafficSignal and the sleep time in milliseconds
	public TraficSignalController(TrafficSignal triSignal, int sleepTime) {
		//initialize internal data variables
		System.out.println("ctor 2 called");
		theSignal = triSignal; //store the input parameter in theSignal var
		sleepInterval = sleepTime; // store the input param sleepTime in instance data
	}

	@Override
	public void run() {
		// implement the logic to operate the signal
		
		//logic description:
		//Turn red,yellow, and green lights on  one after another
		//after sleeping for 2 seconds in between
		//Step 1: turn red light on
		//Step 2: sleep for 2 seconds
		//Step 3: turn green light on
		//Step 4: sleep for 2 seconds
		//Step 5: turn yellow light on
		//Step 6: sleep for 2 seconds
		//Step 7: loop back to step 1
		//the above is an infinite loop because it does not exit, break,  or terminate
		
		while(true) {
			//turn the signal red light on
			theSignal.setRedOn();
			//sleep for 2 seconds = 2000 miliseconds
			try{
				Thread.sleep(sleepInterval);
			} catch (Exception e) {
				System.out.println("sleep got interrupted");
			}
			
			
			// turn the signal's green light on
			theSignal.setGreenOn();
			//try to sleep for 2 seconds = 2000 mili seconds
			try {
				Thread.sleep(sleepInterval);
			} catch (Exception e) {
				System.out.println("sleep got interrupted again.");
			}
			
			//Turn the signals yellow light on
			theSignal.setYellowOn();
			//try to sleep for 2 seconds = 2000 mili seconds
			try {
				Thread.sleep(sleepInterval);
			} catch (Exception e) {
				System.out.println("Sleep got interrupted again and again");
			}
		} // end of while loop
	}
}
