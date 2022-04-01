import java.util.*;


public class WordDictionaryTester {
    
    public static void main(String args[]) {
      
        Set<String> hashSet = new HashSet<>();
        WordDictionary Hash = new WordDictionary(hashSet);
        Hash.AddWord("word1");
        Hash.AddWord("word2");
        Hash.AddWord("word3");
        Hash.AddWord("word4");
        long t1 = System.currentTimeMillis();
        Hash.Write("C:/Users/hamin/Desktop/dictionary1.txt");
        Hash.Read("C:/Users/hamin/Desktop/dictionary1.txt");
      
        System.out.println("Hash: " + (System.currentTimeMillis() - t1) + "ms");

        Set<String> treeSet = new TreeSet<>();
        WordDictionary Tree = new WordDictionary(treeSet);
        Tree.AddWord("word1");
        Tree.AddWord("word2");
        Tree.AddWord("word3");
        Tree.AddWord("word4");
        long t2 = System.currentTimeMillis();
        Tree.Write("C:/Users/hamin/Desktop/dictionary2.txt");
        Tree.Read("C:/Users/hamin/Desktop/dictionary2.txt");
        System.out.println("Tree: " + (System.currentTimeMillis() - t2) + "ms");

    }
}