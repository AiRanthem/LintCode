package src.longest_substring_without_repeating_characters_384;

import java.util.HashMap;

public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // maps a char in cur substr to its prev char
        HashMap<Character, Character> beforeMap = new HashMap<>();
        // maps a char to its index
        HashMap<Character, Integer> idxMap = new HashMap<>();
        int longest = 0;
        char before = 1;
        int idx = 0;
        int firstIdx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (beforeMap.containsKey(c)){
                if (beforeMap.size() > longest) longest = beforeMap.size();
                char cursor = c;
                char next;
                int nextIdx, curIdx;
                while (beforeMap.containsKey(cursor)){
                    // get data
                    next = beforeMap.get(cursor);
                    Integer integer = idxMap.get(next);
                    nextIdx = integer == null?Integer.MAX_VALUE:integer;
                    curIdx = idxMap.get(cursor);
                    // remove cur
                    beforeMap.remove(cursor);
                    idxMap.remove(cursor);
                    // whether next should be removed
                    if (nextIdx >= curIdx) {
                        break;
                    }
                    cursor = next;
                }
            }
            beforeMap.put(c, before);
            idxMap.put(c, idx++);
            before = c;
        }
        return Math.max(longest, beforeMap.size());
    }
}