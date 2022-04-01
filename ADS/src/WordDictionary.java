import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class WordDictionary {

	private Set<String> dictionary;
	Iterator<String> iterator;
	
	WordDictionary(Set storage){
		storage.clear();
		dictionary = storage;
        ResetList();

	}
	
	public void AddWord(String word) {
		if(!dictionary.contains(word.toUpperCase()))
			dictionary.add(word.toUpperCase());
	}
	

	public boolean IsInDictionary(String word) {
	     ResetList();
	     while (iterator.hasNext()) {
	    	 if (word.equalsIgnoreCase((String) iterator.next())) {
	    		 ResetList();
	             return true;
	         }
	     }
	     ResetList();
	     return false;
	}

	public void ResetList() {
		iterator = dictionary.iterator();
	}

	public String NextWord() {
		if (iterator.hasNext()) {
            return iterator.next();
        } else {
            ResetList();
            return iterator.next();
        }
	}
	
	public int Size() {
		return dictionary.size();
	}
	
	public void Write(String filename) {
        try {
            FileWriter file = new FileWriter(filename.toUpperCase());
            ResetList();
            while (iterator.hasNext()) {
                file.write(iterator.next());
                file.write(System.getProperty("line.separator"));
            }
            file.close();
        } catch (IOException e) {
            //System.out.println("Error");
        }
    }

    // This function reads a dictionary from a file, presumably one created by
    // write.
    public void Read(String filename) {
        dictionary.clear();
        ResetList();
        try {
            File file = new File(filename.toUpperCase());
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                AddWord(scan.nextLine());
            }
            
            scan.close();
        } catch (FileNotFoundException e) {
            //System.out.println("Error");
        }

    }
}
