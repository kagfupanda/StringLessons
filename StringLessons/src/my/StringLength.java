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
				//System.out.printf("%c %n", c);
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

	private static String reverseString(String inpString, int len) {
		// create a result character array of length len
		char[] reverseCa = new char[len];

		// create char array of inpString
		char[] inpCa = inpString.toCharArray();

		// initialze 2 index to iterate through the array
		// index going backwards from last to 0
		int inpIndex = len - 1; // set this to the last valid index
		//System.out.printf("inpIndex = %d %n", inpIndex);
		int revIndex = 0; //set postion to 0
		// decrement inp index by 1 to go backwards, incriment rev index by 1
		for(; inpIndex >= 0; inpIndex--, revIndex++) {
			reverseCa[revIndex] = inpCa[inpIndex]; // copy character from inp array to reverseChar array
			//System.out.printf("DEBUGG: %c %n", reverseCa[revIndex]);
		}
		// create a string from the reverseca and char array and return it
		return new String(reverseCa);
	}

	private static boolean isPalindrome(String inpString, String revString, int len) {
		// compare inpString and revString 1 character at a time 
		char[] inpCa = inpString.toCharArray();
		char[] revCa = revString.toCharArray();

		// start from 0 position to len, compare inpCa with revCa
		for (int index = 0; index < len; index++) { // iterate until len - 1
			if(inpCa[index] == revCa[index]) {
				continue;
			} else {
				return false;
			}
		}
		return true; // all positions matched
	}

	private static String changeLowerToUpper(String inpString, int len) {
		// convert string to char[]
		char[] inpCa = inpString.toCharArray(); // modified in place

		// visit each element in the inpCa, check lower case then convert to upper
		for(int i = 0; i < len; i++) { // visit until len - 1
			// check if element is lowercase
			/* 
			 * lower case ascii values are from 97-122
			 */
			int asciiValue = (int)inpCa[i]; //cast char to int to get ascii value
			if(asciiValue >= 97 && asciiValue <= 122) { // it is lower case
				// substract 32 to convert to uppercase ascii value
				asciiValue = asciiValue - 32;
				// store in inpCa array
				inpCa[i] = (char)asciiValue; // cast it to char before storing in char array
			}
		} // end for
		// create a new string from inpCa char array and return
		return new String(inpCa); // create a string from char[]
	}

	private static String removeWhiteSpace(String inpString, int len) {
		// convert to char[]
		char[] inpCa = inpString.toCharArray();

		/*
		 * keep track of last non white space position; lastNonWsPos
		 * keep track of current position; curPos
		 * if curPos is whitespace: 
		 *     continue to next position
		 * if curPos is not a whitespace:
		 *     advance non whitespacePos by one // note: increment then copy. Hint for init value
		 *     copy curPos to last nonWhiteSPos
		 *     continue
		 */
		// initialize the position pointers
		int curPos = 0; // start from zero position
		int lastNonWsPos = -1; // no non whitespace found yet
		for(; curPos < len; curPos++) { // visit all elements in the array
			// check if character in curPos is non white space
			/*
			 * non white space char is ascii code: greater than 32
			 */
			int asciiValue = (int)inpCa[curPos]; // get ascii code
			if(asciiValue > 32) { // found non whiteSpace
				// increment last nowhitspacepso
				++lastNonWsPos;
				// then copy curPos to last ws pos
				inpCa[lastNonWsPos] = inpCa[curPos]; 
			} 
			// do nothing if white space, just go to next
		} // end for
		// check for empty result string: if last nonWsPos is -1
		if(lastNonWsPos == -1) {
			return null;
		}
		// create a string with sub array zero to lastNonWsPos and return
		return new String(inpCa, 0 /* offset */, lastNonWsPos /* count */);

	}

	private static String capitalizeFirstLet(String inpString, int len) {
		// convert inpString to an char[]
		char[] inpCa = inpString.toCharArray();

		/*
		 * use a flag (boolean) to track whether to capitalize or not
		 */
		boolean flagCapNow = true; // capitalize the first non white space

		for (int curPos = 0; curPos < len; curPos++) {
			// check if curPos is white space
			int asciiValue = (int) inpCa[curPos]; // get acsii value
			if(asciiValue <= 32) {
				flagCapNow = true; // capitlize the next non white space
			} else { // non white space
				if (flagCapNow == true) {
					// is char a lowercase
					if(asciiValue >= 97 && asciiValue <= 122) { // lowercase
						//change to upercase
						asciiValue = asciiValue - 32;
						// modify the char[]
						inpCa[curPos] = (char) asciiValue;
					}
					//reset flag to not capitlize anymore for this word
					flagCapNow = false;
				}
			}
		} // end for
		// return a new string with the new char[]
		return new String(inpCa);
	}

	private static int getIndexOf(String inpString, int len, char findC) {
		// convert inpString to char[]
		char[] inpCa = inpString.toCharArray();

		// iterate through the array
		int retPos = -1; // default/assume find c not found
		for(int curPos = 0; curPos < len; curPos++) {
			// check for character
			if(inpCa[curPos] == findC) {
				retPos = curPos;
				break;
			}
		} // end for
		return retPos;
	}

	private static int countOccurrences(String inpString, int len, char c) {
		// convert String to char[]
		char[] inpCa = inpString.toCharArray();

		//iterate through the inpCa
		int retCount = 0; //default/assume 0 occurrences
		for(int curPos = 0; curPos < len; curPos++) {
			// check for char c
			if(inpCa[curPos] == c) {
				retCount++;
			}
		} // end for
		return retCount;
	}

	/**
	 * @param String inpStr
	 * @param int len 
	 * @return number of words in string
	 */
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//open string.txt file from home directory
		Path stringInputPath = Paths.get("/Users/Siddharth/string.txt");

		// create a new bufferedReader using path to read the inputstring
		try {
			BufferedReader reader = Files.newBufferedReader(stringInputPath);
			// read the string from the file - bufferedreader file
			String inputTestString = reader.readLine();
			while (inputTestString != null) {
				int len = computeStringLength(inputTestString);
				System.out.printf("Length of %s is: %d %n", inputTestString, len);
				//String reversedValue = reverseString(inputTestString, len);
				//System.out.printf("Reversed value of %s is: %s %n", inputTestString, reversedValue);
				//System.out.printf("Length of Reversed Value: %d %n", computeStringLength(reversedValue));
				//boolean flag = isPalindrome(inputTestString, reversedValue, len);
				//System.out.printf("String %s is %s palindrome %n", inputTestString, flag ? "a" : "not a");
				//String upperResult = changeLowerToUpper(inputTestString, len);
				//System.out.printf("Input %s in uppercase is: %s %n", inputTestString, upperResult);
				//String noWhiteSpaceString = removeWhiteSpace(inputTestString, len);
				//System.out.printf("Input %s without whitespace is: %s %n", inputTestString, noWhiteSpaceString);
				String capFirstLet = capitalizeFirstLet(inputTestString, len);
				System.out.printf("Input %s capitalized first letter is: %s %n", inputTestString, capFirstLet);
				int numWords = numberOfWords(inputTestString, len);
				System.out.printf("Number of words in %s is: %d %n", inputTestString, numWords);
				//char c = 'a';
				//int charIndex = getIndexOf(inputTestString, len, c);
				//System.out.printf("Input %s index of %c is: %d %n", inputTestString, c, charIndex);
				/**
				for(int letValue = (int)'a'; letValue <= (int)'z'; ++letValue) {
					int charCount = countOccurrences(inputTestString, len, (char) letValue);
					System.out.printf("%c\t%d%n", (char)letValue, charCount);
				}
				*/
				/**
				for(int letValue = (int)'A'; letValue <= (int)'Z'; ++letValue) {
					int charCount = countOccurrences(upperResult, len, (char) letValue);
					System.out.printf("%c\t%d%n", (char)letValue, charCount);
				}
				*/
				//System.out.println("============================");
				// find most often occurring character
				// define variables to store the answer
				/**
				int answerCount = 0;
				char answerChar = 'a'; // don't know
				for(int letValue = (int)'a'; letValue <= (int)'z'; ++letValue) {
					int charCount = countOccurrences(inputTestString, len, (char) letValue);
					if (charCount > answerCount) {
						answerCount = charCount;
						answerChar = (char) letValue;
					}
					System.out.printf("%c\t%d%n", (char)letValue, charCount);
				}
				*/
				/**
				for(int letValue = (int)'A'; letValue <= (int)'Z'; ++letValue) {
					int charCount = countOccurrences(inputTestString, len, (char) letValue);
					if(charCount > answerCount) {
						answerCount = charCount;
						answerChar = (char) letValue;
					}
					System.out.printf("%c\t%d%n", (char)letValue, charCount);
				}
				*/
				//print result
				//System.out.printf("Input %s most ofter char is: %c %d times %n", inputTestString, answerCount == 0 ? null : answerChar, answerCount);
				// read the next line
				inputTestString = reader.readLine();
			}
		} catch (IOException e) {
			System.out.printf("DEBUGG: %s %n", e.toString());
			return;
		}
		return;
	}

}
