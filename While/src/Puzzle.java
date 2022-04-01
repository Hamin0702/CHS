import java.util.ArrayList;

public class Puzzle {

	String[] puzzling;
	Translation translation = new Translation();	
	int[] status = new int[puzzling.length];
	
	//The word has not yet been translated:
	public static final UNTRANSLATED=0;
	//The word has been completely translated (all its letters have
	//translations and it matches a known word:
	public static final TRANSLATED=1;
	//The word, as already translated does not match any known word;
	public static final UNTRANSLATABLE=2;

	int[] track = new int[3];
	ArrayList[] list = new ArrayList[puzzling.length];
	
	Puzzle(String[] message, PatternTable table) {

//	This constructor stores message as the coded message 
//	to be solved. It sets its translation to be a new 
//	translation and creates a status array of the same length 
//	as message with all elements set to UNTRANSLATED. 
//	For each word in the puzzle, it uses the table to determine 
//	the words with the same pattern.
	}
	
	Puzzle(Puzzle P){

//	This constructor creates a new puzzle identical to P. 
//	It creates a new array for each of the arrays stored as 
//	instance variables p to be the appropriate size, and 
//	then sets the elements of each to equal to the corresponding 
//	element of P. It then creates a new translation identical 
//	to the one stored in P and stores it in the puzzle being 
//	constructed.

	}
	
	public int messageSize() {

//	Returns the number of words in the message.
	}
	
	public String nthWord(int N) {

//	Returns the Nth word in the message.
	}
	
	public int statusOfWord(int N) {

//	Returns the status of the Nth word in the message.
	}
	
	public void setStatus(int N, int status) {

//	This sets the status of the Nth word in the message 
//	to status. E.g. setStatus(3,Puzzle.TRANSLATED); would 
//	set the status of the third word to be TRANSLATED. 
//	This method will set the status array and update the 
//	array which keeps track of the number of words with each 
//	status by decreasing the one corresponding to the old 
//	status and increasing the one corresponding to the new status.

	}
	
	public int numberOfWordsWithStatus(int status) {

//	This returns the number of words with the given status. 
//	I.e. numberOfWordsWithStatus(puzzle.UNTRANSLATABLE) would 
//	return the number of words in the puzzle whose status is 
//	UNTRANSLATABLE.

	}
	
	public ArrayList wordsWithSamePatternAs(int n) {

//	This returns an ArrayList containing the words with the 
//	same pattern as the nth word in the puzzle.

	}
	
	public Translation getTranslation() {

//	This returns the translation associated with the puzzle.

	}
	
	public void TranslateNthWordTo(int N, String word) {

//	This method indicates that the Nth word in the puzzle should 
//	be translated to the word passed in. This presupposes the 
//	following:

//	•	Word is the same length as the nth word in the puzzle.
//	•	Word has the “pattern” as the Nth word in the puzzle
//	•	The Nth word in the puzzle could be translated into word based on the letters already translated.

//	This method will update the translation so that all letters 
//	in the Nth word of the puzzle translate to the corresponding 
//	letter in word. It will then set the status of the Nth word 
//	to be TRANSLATED. For example if word is ABC and the Nth 
//	word in the puzzle is DEF, it would update the Translation 
//	so that D translates to A, E translates to B and C translates 
//	to F.

	}
	
	public int easiestToTranslate() {

//	This looks up every UNTRANSLATED word in the puzzle using 
//	the table given. It returns the number of the word with the 
//	fewest words in table that have the same pattern as it does.

//	When you are finished with the Puzzle class, turn it in and 
//	begin implementing the decoding algorithm.

	}
	
}
