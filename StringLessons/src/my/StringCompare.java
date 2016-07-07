package my;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StringCompare {

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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//open string1.txt file
		Path fileString1 = Paths.get("/Users/Siddharth/string1.txt");
		Path fileString2 = Paths.get("/Users/Siddharth/string2.txt");
		
		try {
			BufferedReader reader = Files.newBufferedReader(fileString1);
			BufferedReader reader2 = Files.newBufferedReader(fileString2);
			// readline from string1.txt
			String string1 = reader.readLine();
			// readline from string2.txt
			String string2 = reader2.readLine();
			boolean stringCompare = compareStrings(string1, string2);
			if(stringCompare) {
				System.out.printf("The Strings %s and %s are the same", string1, string2);
			} else {
				System.out.printf("The Strings %s and %s are not the same", string1, string2);
			}
		} catch (IOException e) {
			System.out.printf("Debugg: %s %n:", e.toString());
			return;
		}
		return;
	}

}
