import java.util.Scanner;

public class Madlib {
	
	public static String substitudeWord (String storyLine, String word) {
		String firstPart = storyLine.substring(0, storyLine.indexOf("<"));
		String lastPart = storyLine.substring(storyLine.indexOf(">") + 1);
		String newString = firstPart + word + lastPart;
		return newString;
	} 
	
	public static String wordInsideBrackets (String storyLine) {
		String newString="";
		if (storyLine.indexOf("<")!=-1) {
			newString=storyLine.substring(storyLine.indexOf("<")+1,storyLine.indexOf(">"));
		}
		return newString;
	}
	
	public static String queryReplace (String storyLine) {
		while (storyLine.indexOf("<")!=-1) {
			String firstLetter=wordInsideBrackets(storyLine).substring(0,1);
			if (firstLetter.equalsIgnoreCase("a") || firstLetter.equalsIgnoreCase("e") || firstLetter.equalsIgnoreCase("i") || firstLetter.equalsIgnoreCase("o") || firstLetter.equalsIgnoreCase("u")) {
				System.out.println("Enter an " + wordInsideBrackets (storyLine) +": ");
			} else {
				System.out.println("Enter a " + wordInsideBrackets (storyLine) +": ");
				}
			Scanner input = new Scanner (System.in);
			String word = input.nextLine();
			storyLine=substitudeWord (storyLine, word);
		}
		return storyLine;
	}
	
	public static void playMadlibs (String[] story) {
		System.out.println("Welcome to Madlibs. Game created by Hamin");
		int lines=story.length;
		for (int x=0;x<story.length;x++) {
			story[x]=queryReplace(story[x]);
		}
		for (int x=0;x<story.length;x++) {
			System.out.println(story[x]);
		}
	}

	public static void main (String args[])	{
		//playMadlibs driver
		
		String[] story = new String[] {"<name>, who is very <adjective>, loves to play <sport> with a <noun>", "while <name>, who is suprisingly <adjetive>, loves to <verb> instead.", "But both of them enjoy eating <plural noun> for dessert,", "and they make sure they have time to <verb> with each other sine they ae best friends."};
		playMadlibs(story);
	}
}

	

