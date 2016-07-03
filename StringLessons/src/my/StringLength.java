package my;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StringLength {

	private static int computeStringLength(String inpString) {
		//convert inpString to char[]
		char[] ca = inpString.toCharArray();

		// iterate through the string - starting at index 0 
		// until ArrayIndexOutOfBoundsException is thrown

		int index = 0; //starting index
		for (;;) { // loop until a break
			try {
				// try to access the array at index until exeception
				char c = ca[index]; // access char at index
				// increment index to try accessing the next element in the array
				System.out.printf("%c %n", c);
				++index;
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.printf("Out of Bounds %s %n", e.toString());
				// break out of the loop
				break;
			}
		}
		// we gone past the end array 
		//index is one past the end of the array
		//therefore index is the length of the array because we counted starting from 0 not 1
		return index;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//open string.txt file from home directory
		Path stringInputPath = Paths.get("/Users/Siddharth/string.txt");

		// create a new bufferedReader using path to read the inputstring
		try {
			BufferedReader reader = Files.newBufferedReader(stringInputPath);
			// read the string from the file - bufferedreader file
			String stringToFindLength = reader.readLine();
			int len = computeStringLength(stringToFindLength);
			System.out.printf("Length of %s is %d %n", stringToFindLength, len);
		} catch (IOException e) {
			System.out.printf("DEBUGG: %s %n", e.toString());
			return;
		}
		return;
	}

}
