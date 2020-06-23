package src.twitch_words_1401;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    /**
     * @param str: the origin string
     * @return the start and end of every twitch words
     */
    public int[][] twitchWords(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char cur = str.charAt(0);
        int start = 0, end = 0;
        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) != cur) {
                cur = str.charAt(i);
                if (end - start >= 2) {
                    res.add(new int[]{start, end});
                }
                start = i;
            } else {
                end = i;
            }
        }

        if (end - start >= 2) {
            res.add(new int[]{start, end});
        }

        int[][] ret = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ret = solution.twitchWords("");
        System.out.println("ret = " + Arrays.deepToString(ret));
    }
}
