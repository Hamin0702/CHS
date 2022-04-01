
import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class PatternTable {
    private TreeNode root;

    public void addWord(String word) {
        PatternMaker patternMaker = new PatternMaker();
        String str = patternMaker.makePattern(word);
        addWordToTree(word, str, root);
    }

    ArrayList wordsWithSamePatternAs(String word) {
        PatternMaker patternMaker = new PatternMaker();
        String str = patternMaker.makePattern(word);
        return treePatern(str, root);
    }

    private ArrayList treePattern(String pat, TreeNode tree) {

        if (tree.getLeft() == null && tree.getRight() == null) {
            return new ArrayList<>();
        } else if (pat.equals(tree.getPattern())) {
            return tree.getList();
        } else if (tree.getPattern().compareTo(pat) < 0) {
            return findPatternInTree(pat, tree.getLeft());
        } else {
            return findPatternInTree(pat, tree.getRight());
        }
    }

    private TreeNode addWordToTree(String word, String pat, TreeNode tree) {
        if (tree.getLeft() == null && tree.getRight() == null) {
            TreeNode n = new TreeNode(word, pat);
        } else {
            if (tree.getPattern().equals(pat)) {
                tree.getList().add(word);
            } else if (tree.getPattern().compareTo(pat) < 0) {
                TreeNode x = tree.getRight();
                x = addWordToTree(word, pat, tree.getRight());
            } else {
                TreeNode x = tree.getLeft();
                x = addWordToTree(word, pat, tree.getLeft());
            }
        }

    }

}
