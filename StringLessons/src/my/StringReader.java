package my;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StringReader {

	private static boolean isAlpha(char token) {
			int asciiValue = (int) token; // get asciiValue
			if(asciiValue < 65 && asciiValue > 90 && asciiValue < 97 && asciiValue > 122) { // check if not valid
				return false;
			}
		return true; // it will be valid
	}
	
	private static boolean isDigit(char token) {
			int asciiValue = (int) token;
			if(asciiValue < 48 && asciiValue > 57) {
				return false;
			}
		return true;
	}
	
	private static boolean isAlphaNumeric(char token) {
		if(isAlpha(token) == true || isDigit(token) == true) {
			return true;
		} else {
			return false;
		}
	}
	
	private static int numberOfWords(String inpStr, int len) {
		// convert string to char[]
		char[] inpCa = inpStr.toCharArray();
		// use a flag (boolean) to track whether to count or not
		boolean flagCountNow = true; // initialize to true because the first letter could be the beginning of the word
		int numCount = 0; // keeps track of number of words
		for(int pos = 0; pos < len; ++pos) { // iterate through each position len times
			// check if pos is in white space
			int asciiValue = (int)inpCa[pos];
			// check if ascii value is white space
			if(asciiValue <= 32) {
				flagCountNow = true; // means that current position is a word boundary
			} else { // current letter is a letter
				if(flagCountNow == true) { // means current current letter is past a boundary
					++numCount; // increment counter
					flagCountNow = false; // reset flag because inside a word
				}
			}
		} // end for
		// return the counter
		return numCount;
	}
	
	private static String[] getWords(String inpStr) {
		// convert inpStr to a char[]
		char[] inpCa = inpStr.toCharArray();
		// find number of words
		int numWords = numberOfWords(inpStr, inpCa.length);
		//initialize variables
		int foundWords = 0;
		int firstPosOfWord = -1;
		int lastPosOfWord = -1;
		boolean inWordBoundary = false;
		String[] retWords = new String[numWords];
		for(int curPos = 0; curPos < inpCa.length; ++curPos) { // visit each element in the array inpCa
			if(isAlphaNumeric(inpCa[curPos]) == true) {
				if(inWordBoundary == false) {
					firstPosOfWord = curPos;
					lastPosOfWord = curPos;
				}
				lastPosOfWord++;
				inWordBoundary = true;
			} else {
				if(inWordBoundary == true) {
					retWords[foundWords] = new String(inpCa, firstPosOfWord, lastPosOfWord);
					++foundWords;
				}
				inWordBoundary = false;
				firstPosOfWord = -1;
				lastPosOfWord = -1;
			}
		}
		if(inWordBoundary == true) {
			retWords[foundWords] = new String(inpCa, firstPosOfWord, lastPosOfWord);
		}
		return retWords;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path stringInputPath = Paths.get("/Users/Siddharth/line.txt");
		
		try {
			BufferedReader reader = Files.newBufferedReader(stringInputPath);
			// read string from file
			String inputString = reader.readLine();
			while(inputString != null) { // do until inputString is null
				String[] words = getWords(inputString);
				for(String s : words) {
					System.out.println(s);
				}
				inputString = reader.readLine(); // read next line
			} // end loop
		} catch (IOException e) {
			System.out.printf("Debugg: %s %n", e.toString());
		}

	}

}
