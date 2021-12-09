package src.add_b_label_1127;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void getTrieTree() {
        SolutionTrie solution = new SolutionTrie();
        SolutionTrie.Trie root = solution.getTrieTree(new String[]{"aaa", "aab", "bc", "aa"});
        System.out.println();
    }

    @Test
    public void addBoldTag() {
        SolutionTrie solution = new SolutionTrie();
        assertEquals("<b>abc</b>xyz<b>123</b>", solution.addBoldTag("abcxyz123", new String[]{"abc", "123"}));
        assertEquals("<b>aaabbc</b>c", solution.addBoldTag("aaabbcc", new String[]{"aaa", "aab", "bc"}));
    }
}