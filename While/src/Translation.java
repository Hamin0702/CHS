
public class Translation {

	Translation(){
//		This constructor initializes a new translation indicating that no letters have been translated.
	}
	
	Translation(Translation t){
//		This constructor initializes a new translation to be an exact copy of t, an existing translation. 
//		I.e. all letters already translated in t are also translated in the translation being constructed 
//		to the same decoded letter and all letters not yet translated in t are not yet translated in the translation being constructed.
	}
	
	public void translateLetterTo(String encoded, String decoded) {
//		Records the fact that the letter stored in encoded (a one character string) 
//		has been found to translate to the letter stored in decoded (also a one character string.)
//		I.e. translateLetterTo(“N”,”L”) would indicate that whenever the letter N occurs in the 
//		encoded message it will translate into L in the decoded message.
	}
	
	public boolean isTranslated(String letter) {
//		Return true if the string stored in the (one-letter) string letter has yet had a 
//		translation stored via a call to the translateLetterTo method.
	}
	
	public String translation(String encoded){
//		Returns the translation of the String encoded. If encoded contains letters whose 
//		translations have not been recorded via a call to translateLetterTo, their 
//		translation should be an asterisk.
	}
	
	public boolean canBeTranslated(String encoded) {
//		Returns true if a call to translation on encoded has no asterisks.
	}
	
	public boolean couldTranslateTo(String encoded, String word){
//		Returns true if the word contained in encoded could possibly translate to the word 
//		contained in word. This means that each letter in encoded is either already known to 
//		translate to the corresponding letter in word, or has not been given a translation 
//		(isTranslated returns false). It also means that no letter in word has a letter that 
//		translates to it that is not the corresponding letter in encoded.
	}
	
}
