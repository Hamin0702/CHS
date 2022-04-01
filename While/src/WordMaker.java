
public class WordMaker {

	private String theWord = "";
	private boolean ready = false;
	private boolean progress = false;
	
	public void reset() {
		theWord = "";
		ready = false; progress = false;
	}
	
	public void addChar(char newChar) {
		if(Character.isLetter(newChar) && !progress) {
			reset();
			theWord += newChar;
			progress = !progress;
		}else if(Character.isLetter(newChar) && progress) {
			theWord += newChar;
		}else if(newChar == '\'') {
			progress = true;
		}else if(!Character.isLetter(newChar) && progress) {
			progress = !progress;
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


