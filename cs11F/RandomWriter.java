package cs11F;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Hashtable;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Dictionary;

public class RandomWriter {

	
	public static String getText(String source) throws FileNotFoundException { //get source text into one String
		File input = new File(source);
		Scanner sc = new Scanner(input);
		String text = "";
		while (sc.hasNextLine()) {
			text = text + sc.nextLine() + "\n";
		}
		sc.close();
		return text;
	}
	
	public static void write(String source, int seedLength, int length) throws FileNotFoundException {
		//int length = Integer.parseInt(args[1]);
		//String result = args[3];
		
		String text = getText(source);

		CharGenerator generator = new CharGenerator(text, seedLength);
		ArrayList<Character> nextsArray = generator.getProbableNexts();
		System.out.println("my seed: " + generator.charSeed);
		System.out.println("my string: ");
		for(int i = 0; i < length; i++) {
			char nextChar = generator.getNextChar(nextsArray);
			System.out.print(nextChar);
			generator.charSeed.add(nextChar);
			generator.charSeed.remove(0);
			//System.out.println(generator.charSeed);
			nextsArray = generator.getProbableNexts();
		}
	}
	
	
	
}