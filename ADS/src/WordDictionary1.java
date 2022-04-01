
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class WordDictionary1 {
    private Set<String> broadSet;
    Iterator<String> iterator;

    // This constructor takes as a parameter an instance of a class that implements
    // the set interface.
    // It clears the set passed in and then uses it to store the words in the
    // dictionary.
    WordDictionary1(Set storage) {
        storage.clear();
        broadSet = storage;
        ResetList();

    }

    // This function adds a word to your dictionary.
    // If the word is already in the dictionary, it should do nothing.
    public void AddWord(String word) {
        if (!IsInDictionary(word)) {
            broadSet.add(word);
        }
    }

    // This function returns true if the word is in the dictionary, false otherwise.
    public boolean IsInDictionary(String word) {
        Iterator<String> localIterator = broadSet.iterator();
        while (localIterator.hasNext()) {
            if (word.equalsIgnoreCase((String) localIterator.next())) {
                ResetList();
                return true;
            }
        }
        return false;

    }

    // This function initializes the current position for an iteration through the
    // dictionary.
    public void ResetList() {
        iterator = broadSet.iterator();
    }

    // This function returns the next word in the dictionary
    public String NextWord() {
        if (iterator.hasNext()) {
            return broadSet.iterator().next();
        } else {
            ResetList();
            return broadSet.iterator().next();
        }

    }

    // This function returns the number of unique words in the dictionary
    public int Size() {
        return broadSet.size();
    }

    // This function writes your dictionary to a file.
    public void Write(String filename) {
        try {
            FileWriter myWriter = new FileWriter(filename);
            Iterator<String> localIterator = broadSet.iterator();
            while (localIterator.hasNext()) {
                myWriter.write(localIterator.next());
                myWriter.write(System.getProperty("line.separator"));
            }
            myWriter.close();
            // System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            // System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // This function reads a dictionary from a file, presumably one created by
    // write.
    public void Read(String filename) {
        broadSet.clear();
        ResetList();
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                AddWord(myReader.nextLine());
            }
            
            myReader.close();
        } catch (FileNotFoundException e) {
            // System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}
