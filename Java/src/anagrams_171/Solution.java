package src.anagrams_171;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] key = new int[26];
            for (int i = 0; i < str.length(); i++) {
                key[str.charAt(i)-'a']++;
            }
            int hash = Arrays.hashCode(key);
            if (!map.containsKey(hash)){
                map.put(hash, new ArrayList<>());
            }
            map.get(hash).add(str);
        }
        ArrayList<String> res = new ArrayList<>();
        for (List<String> value : map.values()) {
            if (value.size() > 1) res.addAll(value);
        }
        return res;
    }
}
