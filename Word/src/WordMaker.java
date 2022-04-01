
public class WordMaker {

	private String theWord = "";
	private boolean ready = false;
	private boolean making = false;
	
	public void reset() {
		theWord = "";
		ready = false;
		making = false;
	}
	
	public void addChar(char newChar) {
		if(Character.isLetter(newChar) && !making) {
			reset();
			theWord += newChar;
			making = !making;
		}else if(Character.isLetter(newChar) && making) {
			theWord += newChar;
		}else if(newChar!= '\'') {
			making = true;
		}else if(!Character.isLetter(newChar) && making) {
			making = !making;
			ready = true;
		}
		
	}
	
	public boolean wordReady() {
		return ready;
	}
	
	public String getWord() {
		String word = "";
		if(wordReady()) {
			word = theWord;
		}
		return word;
		
	}
}
