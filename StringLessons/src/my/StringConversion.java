package my;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StringConversion {

	private static int length(String inpStr) {
		// convert string to char[]
		char[] inpCa = inpStr.toCharArray();
		
		// iterate through the char[] till the ArrayIndexOutOfBounds exception is thrown
		int index = 0; // starting index
		for(;;) { // loop until a break
			try { // try to see if error occurs
				char c = inpCa[index]; // access char at index
				// increment index to try and access next element in array
				++index;
			} catch (ArrayIndexOutOfBoundsException e) { // caught error
				System.out.printf("Out Of Bounds %s: %n", e.toString());
				break; // break out loop because error is caught
			}
		} // end of for
		// went past the end of the array
		// index is one past the end of the array
		// therefore index is the length of the array because we counted starting from 0 not 1
		return index;
	}
	/**
	 * 
	 * @param inpStr specifies the input string to convert to int
	 * @return the integer value of the string, or 0 if invalid string
	 * 
	 */
	private static int stringToInt(String inpStr, int startPos) {
		// convert string to char[]
		char[] inpCa = inpStr.toCharArray();
		// find length of inpStr 
		int len = length(inpStr);
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
	/**
	 * 
	 * @param inpStr specifies the input string to convert to int
	 * @return the signed integer value of of the string, or 0 if invalid string
	 */
	private static int stringToIntSigned(String inpStr) {
		//convert inpStr to char[]
		char[] inpCa = inpStr.toCharArray();
		// find length of inpStr
		int len = length(inpStr);
		// initialize sum to 0
		int sum = 0;
		/*
		 * sign indicates what sign the number has
		 * true = negative number
		 * false = positive number
		 */
		boolean sign = false; // default is positive if there is no sign
		for(int i = 0; i < len; ++i) { //increment through each position len times
			int asciiValue = (int) inpCa[i]; //get ascii value
			// first look for the sign
			if(asciiValue == 43 || asciiValue == 45) { // check if asciivalue is a + or - sign
				if (asciiValue == 43) { // check if + sign
					sign = false; // set sign to false
					sum = stringToInt(inpStr, i++); // find the number with starting position as next position
					break; // exit loop to return value
				} else if (asciiValue == 45) { // check if - sign
					sign = true; // set sign to true indicating negative number
					sum = stringToInt(inpStr, i++); // find the number with starting position as next position
					break; // exit loop to return value
				}
			} else if (asciiValue >= 48 && asciiValue <= 57) { // check if asciivalue is a digit
				// means no sign so let sign be default value
				sum = stringToInt(inpStr, i); // find sum with current position
				break; // exit loop
			} else { // no sign or digit
				continue; // iterate through loop until sign or number is found
			}
		} // end for loop
		if(sign == true) { // if negative number
			return sum * -1; // return number as a negative number
		} else { // positive number
			return sum; // return number as a positive number
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// open file from home directory
		Path stringInputPath = Paths.get("/Users/Siddharth/integer.txt");

		// create a new buffered reader using path to read inputstring
		try {
			BufferedReader reader = Files.newBufferedReader(stringInputPath);
			// read string from file
			String inputString = reader.readLine();
			while(inputString != null) { // do until inputString is null
				int strLength = length(inputString);
				System.out.printf("length of %s is %d %n", inputString, strLength);
				int intFromString = stringToInt(inputString, 0);
				System.out.printf("%s converted to an integer is %d %n", inputString, intFromString);
				int intFromStringSigned = stringToIntSigned(inputString);
				System.out.printf("%s converted to a signed integer is: %d %n", inputString, intFromStringSigned);
				inputString = reader.readLine(); // read next line
			} // end loop
		} catch (IOException e) {
			System.out.printf("Debugg: %s %n", e.toString());
		}
	}

}
