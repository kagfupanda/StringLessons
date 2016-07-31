package my;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.SynchronousQueue;

public class StringCompare {

	private static boolean isStringInString(String inpString, String subString) {
		// convert strings to char[]
		char[] inpCa = inpString.toCharArray();
		char[] subCa = subString.toCharArray();
		// initialize the counter for the smaller string
		int counter = 0;
		for(int i = 0; i < inpCa.length; i++) {
			if(inpCa[i] == subCa[counter]) {
				++counter; // incriment counter if match
				if(counter == subCa.length) { 
					return true;
				}
			} else {
				counter = 0;  // reset counter to zero if not match
			}
		}
		return false;
	}
	private static boolean compareStrings(String inpStr1, String inpStr2) {
		// convert strings to char[]
		char[] inpCa1 = inpStr1.toCharArray();
		char[] inpCa2 = inpStr2.toCharArray();
		// check if char arrays are the same length
		if(inpCa1.length != inpCa2.length) {
			return false;
		}
		// iterate through loop and check if they are the same
		for(int i = 0; i < inpCa1.length; i++) {
			if(inpCa1[i] != inpCa2[i]) {
				return false;
			}
		}
		return true;
	}
	public static String stringEncoder(String inpStr) {
		// convert String to char[]
		char[] inpCa = inpStr.toCharArray();
		// visit each element and change the char value
		for(int i = 0; i < inpCa.length; i++) {
			int asciiValue = (int) inpCa[i];
			if(asciiValue >= 97 && asciiValue <= 122) {
				asciiValue = asciiValue - 97;
				asciiValue = asciiValue + 13;
				asciiValue = asciiValue % 26;
				asciiValue = asciiValue + 97;
				inpCa[i] = (char) asciiValue;
			} else if(asciiValue >= 65 && asciiValue <= 90) {
				asciiValue = asciiValue - 65;
				asciiValue = asciiValue + 13;
				asciiValue = asciiValue % 26;
				asciiValue = asciiValue + 65;
				inpCa[i] = (char) asciiValue;
			}
		} // end for
		return new String(inpCa);
	}
	
	public static String stringDecoder(String inpStr) {
		// convert String to char[]
		char[] inpCa = inpStr.toCharArray();
		// visit each element and change back the char value
		for (int i = 0; i < inpCa.length; ++i) {
			int asciiValue = (int) inpCa[i];
			if(asciiValue >= 97 && asciiValue <= 122) {
				asciiValue = asciiValue - 97;
				asciiValue = asciiValue + 13;
				asciiValue = asciiValue % 26;
				asciiValue = asciiValue + 97;
				inpCa[i] = (char) asciiValue;
			} else if(asciiValue >= 65 && asciiValue <= 90) {
				asciiValue = asciiValue - 65;
				asciiValue = asciiValue + 13;
				asciiValue = asciiValue % 26;
				asciiValue = asciiValue + 65;
				inpCa[i] = (char) asciiValue;
			}
		} // end loop
		return new String(inpCa);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//open string1.txt file
		Path fileString1 = Paths.get("/Users/Siddharth/string1.txt");
		Path fileString2 = Paths.get("/Users/Siddharth/string2.txt");
		Path fileString3 = Paths.get("/Users/Siddharth/decoded.txt");

		try {
			BufferedReader reader = Files.newBufferedReader(fileString1);
			BufferedReader reader2 = Files.newBufferedReader(fileString2);
			BufferedReader reader3 = Files.newBufferedReader(fileString3);
			// readline from string1.txt
			String string1 = reader.readLine();
			// readline from string2.txt
			String string2 = reader2.readLine();
			// readline from decoded.txt
			String string3 = reader3.readLine();
			boolean stringCompare = false;
			boolean stringInString = false;
			String encodedString = "";
			String decodedString = "";
			while(string1 != null || string2 != null) {
				if(string1 != null && string2 != null) {
					 stringCompare = compareStrings(string1, string2);
					 stringInString = isStringInString(string1, string2);
					 encodedString = stringEncoder(string1);
					 decodedString = stringDecoder(string3);
				} else {
					stringCompare = false;
				}
				//System.out.printf("The Strings %s and %s %s the same %n", string1, string2, stringCompare ? "are" : "are not");
				System.out.printf("%s %s %s %n", stringCompare ? " ": ">", string1, string2);
				System.out.printf("%s is %s %s %n", string2, stringInString ? "in": "not in", string1);
				System.out.printf("%s encoded is %s %n", string1, encodedString);
				System.out.printf("%s decoded is %s %n", string3, decodedString);
				string1 = reader.readLine();
				string2 = reader2.readLine();
				string3 = reader3.readLine();
			}
		} catch (IOException e) {
			System.out.printf("Debugg: %s %n:", e.toString());
			return;
		}
		return;
	}

}
