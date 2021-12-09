package src.add_b_label_1127;

import java.util.HashMap;
import java.util.Map;

public class SolutionTrie {
    /**
     * @param s:    a string
     * @param dict: a list of strings
     * @return: return a string
     */
    public String addBoldTag(String s, String[] dict) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        Trie root = getTrieTree(dict);
        Trie cursor;
        char[] chars = s.toCharArray();
        boolean[] bold = new boolean[chars.length];
        int start;
        for (int cur = 0; cur < chars.length; cur++) {
            cursor = root;
            start = cur;
            for (int i = cur; i < chars.length; i++) {
                char c = chars[i];
                if (cursor.children.containsKey(c)) {
                    cursor = cursor.children.get(c);
                    if (cursor.isWord) {
                        for (int j = start; j <= i; j++) {
                            bold[j] = true;
                        }
                        start = i + 1;
                    }
                } else {
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean outTag = true;
        for (int i = 0; i < bold.length; i++) {
            if (outTag && bold[i]) {
                sb.append("<b>");
                outTag = false;
            }
            sb.append(chars[i]);
            if (!outTag && (i == bold.length - 1 || !bold[i + 1])) {
                sb.append("</b>");
                outTag = true;
            }

        }
        return sb.toString();
    }

    public static class Trie {
        char value;
        Map<Character, Trie> children;
        boolean isWord;

        public Trie(char value) {
            this.value = value;
            this.children = new HashMap<>();
        }

        public void addString(char[] s, int pos) {
            Trie child = children.computeIfAbsent(s[pos], Trie::new);
            child.isWord = (s.length - 1 == pos);
            if (!child.isWord) {
                child.addString(s, pos + 1);
            }
        }
    }

    public Trie getTrieTree(String[] dict) {
        Trie root = new Trie('\0');
        for (String s : dict) {
            root.addString(s.toCharArray(), 0);
        }
        return root;
    }
}
