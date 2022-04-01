// This file should contain the HiddenWord class, with constructor, instance variable(s) and getHint method
public class HiddenWord {
	  private String word;

	  public HiddenWord(String input)
	  {
	    word = input;
	  }
	  
	  public String getHint(String guess)
	  {
	    String hint = "";

	    for(int i = 0; i < word.length(); i++)
	    {
	      String guessLetter = guess.substring(i, i + 1);
	      if(word.substring(i, i + 1).equals(guessLetter))
	        hint += guessLetter;
	      else if(word.indexOf(guessLetter) != -1)
	        hint += "+";
	      else
	        hint += "*";
	    }
	    
	    return hint;
	  }
	// DO NOT DELETE THIS METHOD. Run it only when you think your Hidden Word Method is correct.
     public static void runHiddenWordAcceptanceTest(){
		(new HiddenWordTester()).generateCasesAndRun();
	}
	public static void main(String[] args) {
		runHiddenWordAcceptanceTest();

	}

}

