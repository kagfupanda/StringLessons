/**
 * 
 */
package my;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MaxInteger {

	private static int stringToInt(String inpStr, int startPos) {
		// convert string to char[]
		char[] inpCa = inpStr.toCharArray();
		// find length of inpStr 
		int len = inpStr.length();
		// use flag to see if number has been found
		boolean foundNum = false; // flag to see if in the number
		int sum = 0; // initialize sum to 0 
		for(int i = startPos; i < len; i++) { // increment through each position len times
			int asciiValue = (int) inpCa[i]; // get ascii value 
			if(asciiValue >= 48 && asciiValue <= 57) { // check to see if asciivalue is a digit literal
				int decimalValue = asciiValue - 48; // convert to decimal value
				sum = sum * 10 + decimalValue; // update sum
				foundNum = true; // found a number so set flag to true
			} else { // outside number
				if(foundNum == true) { // if found number already
					break; // exit loop to return sum
				}
				continue; // iterate through loop until number is found
			}
		} // end loop
		return sum; // return the final sum
	}
	
	private static int maxInt(int[] inpInt) {
		// initialize max variable
		int max = inpInt[0];
		for(int i = 0; i < inpInt.length; ++i) { // iterate through loop the length of inpInt times
			if(inpInt[i] > max) { // check if element is greater than max
				max = inpInt[i]; // replace value with new max
			}
		} // end loop
		return max; // return the final max value
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Path stringInputPath = Paths.get("/Users/Siddharth/max.txt");

		// create a new buffered reader using path to read inputstring
		int[] maxInt = new int[20];
		try {
			BufferedReader reader = Files.newBufferedReader(stringInputPath);
			// read string from file
			String inputString = reader.readLine();
			int i = 0;
			while(inputString != null) { // do until inputString is null
				int inputInt = stringToInt(inputString, 0);
				maxInt[i] = inputInt;
				++i;
				inputString = reader.readLine(); // read next line
			} // end loop
		} catch (IOException e) {
			System.out.printf("Debugg: %s %n", e.toString());
		}
		System.out.printf("Max number is %d % n", maxInt(maxInt));
	}

}
