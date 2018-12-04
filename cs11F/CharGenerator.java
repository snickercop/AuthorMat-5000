package cs11F;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class CharGenerator {
	String text;
	int k;
	int myRandomSeed;
	Random r;
	ArrayList<Character> charSeed = new ArrayList<Character>();
	ArrayList<Character> chars = new ArrayList<Character>();
	
	public CharGenerator(String text, int k){
		this(text, k, -1);
	}
	public CharGenerator(String text, int k, int myRandomSeed){
		this.text = text;
		this.k = k;
		this.myRandomSeed = myRandomSeed;
		if(myRandomSeed!=-1) {
			this.r = new Random(myRandomSeed);
		}
		else {
			this.r = new Random();
		}
		buildChars();
		buildSeed();
	}
	
	public char getNextChar(ArrayList<Character> nextsArray){
		
		//TreeSet<Character> nextsSet = new TreeSet<Character>(nextsArray);
		int selector = r.nextInt(nextsArray.size());
		return nextsArray.get(selector);
	}
	
	
	public ArrayList<Character> getProbableNexts(){
		String charString = arrayListToString(charSeed);
		int matchIndex = text.indexOf(charString);
		int firstMatchIndex = matchIndex;
		ArrayList<Character> returnArray = new ArrayList<Character>();
		do{ //look for next match
			returnArray.add(chars.get(matchIndex+k));
			//System.out.println(chars.get(matchIndex+k));
			//System.out.println("getnextsloop");
			matchIndex = text.indexOf(arrayListToString(charSeed), matchIndex+1);
		}while(matchIndex != firstMatchIndex); //leave the loop when the first match is reached again
		returnArray.remove(returnArray.size()-1);//'1' kept showing up as the last item in the array--why?
		return returnArray;
	}
	
	public static Hashtable getFreqs(TreeSet<Character> defs, ArrayList<Character> data) {
		Iterator iterator = defs.iterator();
		Hashtable<Character, Float> frequencies = new Hashtable<Character, Float>();
		while(iterator.hasNext()) {
			char currentDef = (char) iterator.next();
			float currentDefCount = 0;
			for(int i = 0; i < data.size(); i++) {
				if(data.get(i)==currentDef) {
					currentDefCount++;
				}
			}
			frequencies.put(currentDef, currentDefCount/data.size());
		}
		return frequencies;
	}

	// constructor methods
	public void buildSeed(){
		int seedStart = getSeedStart();
		for(int i = seedStart; i < k+seedStart; i++){ //build seed
			charSeed.add(chars.get(i));
		}
	}
	public void buildChars(){
		for(char c : text.toCharArray()){
			chars.add(c);
		}
	}
	public int getSeedStart(){
		Random r = new Random();
		if(myRandomSeed!=-1){
			r = new Random(myRandomSeed);
		}
		return r.nextInt(chars.size());
	}
	public String arrayListToString(ArrayList<Character> chars){
		String output = "";
		for(int i = 0; i < chars.size(); i++){
			output = output + chars.get(i);
		}
		return output;
	}
	
}