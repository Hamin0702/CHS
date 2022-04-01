
public class WordGetter{

	public void GetWords(WordDictionary dict, String filename) {
		WordMaker maker = new WordMaker();
		for(int i=0; i<filename.length(); i++){
			maker.addChar(filename.charAt(i));
		}
		
		dict.AddWord(maker.getWord());
	}
}
