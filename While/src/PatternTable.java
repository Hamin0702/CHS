import java.util.ArrayList;

public class PatternTable {
	private TreeNode tree;
	public void AddWord(String word) {
		String pat = PatternMaker.makePattern(word);
		tree = addWordToTree(word, pat, tree);
	}
	public ArrayList WordsWithSamePatternAs(String word) {
		String pat = PatternMaker.makePattern(word);
		return findPatternInTree(pat, tree);
	}

	private ArrayList findPatternInTree(String pat, TreeNode tree) {
		if(tree == null) {
			return new ArrayList<>();
		}else if(tree.getPattern().compareTo(pat) ==0) {
			return  tree.getList();
		} else if(tree.getPattern().compareTo(pat)< 0) {
			return findPatternInTree(pat, tree.getRight());
		}else {
			return findPatternInTree(pat, tree.getLeft());
		}
	}
	private TreeNode addWordToTree(String word, String pat, TreeNode tree) {
		if(tree == null) {
			return new TreeNode(word, pat);
		}
		else {
			if(tree.getPattern().compareTo(pat)  == 0) {
				tree.getList().add(word);
			}
			else if(tree.getPattern().compareTo(pat)< 0) {
				tree.setRight(addWordToTree(word, pat, tree.getRight()));
			}else {
				tree.setLeft(addWordToTree(word, pat, tree.getLeft()));
			}

		}
		return tree;
	}
}
