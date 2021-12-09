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
        return null;
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

    public int[] cacuKmpNext(String p) {
        int[] next = new int[p.length()];
        next[0] = 0;
        int x = 1, y = 0; // x is fast, y is slow
        while (x < next.length) {
            if (p.charAt(x) == p.charAt(y)) {
                y++; // 根据所谓的“下一个匹配点”属性和最大长度定义，都需要先+1
                next[x] = y;
                x++;
            } else if (y != 0) { // 可以回溯进行匹配
                y = next[y - 1];
            } else { // y = 0 表示 p[0] != p[x] 且经过几次迭代没有任何前后缀满足条件，保留0.
                x++;
            }
        }
        return next;
    }
}
