package src.word_break_107;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    private Set<String> wordSet;
    private Map<Integer, Set<String>> map;
    int max_len = 0, min_len = Integer.MAX_VALUE;

    /**
     * @param s:       A string
     * @param wordSet: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> wordSet) {
        map = new HashMap<>();
        this.wordSet = wordSet;
        for (String s1 : wordSet) {
            int length = s1.length();
            if (length > max_len) max_len = length;
            if (length < min_len) min_len = length;
            if (!map.containsKey(length)){
                HashSet<String> set = new HashSet<>();
                map.put(length, set);
            }
            map.get(length).add(s1);
        }
        return helper(s);
    }

    public boolean helper(String s) {
        int length = s.length();
        if (length == 0) return true;
        if (length < min_len) return false;
        for (int i = min_len; i <= Math.min(max_len, length); i++) {
            if (map.containsKey(i)) {
                String substring = s.substring(0, i);
                Set<String> set = map.get(i);
                if (set.contains(substring) &&
                        helper(s.substring(i, length)))
                    return true;
            }
        }
        return false;
    }
}
