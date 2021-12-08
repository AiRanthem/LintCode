package src.add_b_label_1127;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    /**
     * @param s: a string
     * @param dict: a list of strings
     * @return: return a string
     */
    public String addBoldTag(String s, String[] dict) {
        // write your code here
    }

    public static class Trie {
        Character value;
        Map<Character, Trie> children;

        public boolean isLeaf() {
            return children == null;
        }

        public void addString(char[] chars) {
            if (children == null) {
                children = new HashMap<>();
            }
            // todo
        }
    }
}
