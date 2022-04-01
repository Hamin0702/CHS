
public class PatternMaker {
	
	public static String MakePattern(String input) {
		String pattern = "";
		String word = input.toLowerCase();
		char[] ch = word.toCharArray();
		String[] st = new String[word.length()];
		int A = 64;
		boolean[] check = new boolean[word.length()];
		
		for(int i = 0; i<check.length; i++) {
			check[i] = false;
		}
		
		for(int i =0; i<ch.length; i++) {
			if(!check[i]) {
				A++;
				st[i] = "" + (char)(A);
			}
			for(int j =i+1; j<ch.length; j++) {
				if(ch[i]==ch[j] && !check[j]) {
					st[j] = "" + (char)(A);
					check[j] = true;
				}
			}

		}
		
		for(int i = 0; i<st.length; i++) {
			pattern = pattern + st[i];
		}
		
		return pattern;
	}
}
