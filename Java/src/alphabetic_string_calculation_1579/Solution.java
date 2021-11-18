package src.alphabetic_string_calculation_1579;

import java.util.HashMap;

public class Solution {
    /**
     * 有一串英文字母，每次可以删掉一个英文字母
     * 求最少删多少次可以让每个字母出现的次数不同
     *
     * 解法：
     * 1. 统计每个字母出现的个数
     * 2. 用一个数组来统计每个次数的字母数量（比如3次有2个字母，就是a[3]=2）
     * 3. 如果出现了x次（x>1）的字母大于1（e.g. a[x] = 2），那么一定需要减x-1次（e.g. a[x], a[x-1] = 1， a[x-1] + a[x]-1）
     *
     * @param aString: letter string
     * @return the Minimum times
     */
    public int Kstart(String aString) {
        HashMap<Character, Integer> alphabeta2times = new HashMap<>(aString.length());
        for (char c : aString.toCharArray()) {
            alphabeta2times.put(c, alphabeta2times.getOrDefault(c, 0) + 1);
        }

        int[] occurances = new int[aString.length() + 1];
        for (Integer time : alphabeta2times.values()) {
            occurances[time]++;
        }

        int res = 0;
        for (int i = aString.length(); i > 0 ; i--) {
            if (occurances[i] > 1) {
                res += occurances[i] - 1;
                occurances[i-1] += occurances[i] - 1;
            }
        }
        return res;
    }
}
