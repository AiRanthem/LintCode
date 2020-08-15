package src.longest_consecutive_sequence_124;

import java.util.HashSet;

public class Solution {
    /**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : num) {
            set.add(i);
        }
        int longest = 0;
        for (int i : num) {
            if (set.contains(i)) {
                set.remove(i);
                int up = i + 1, down = i - 1;
                while (set.contains(up)) {
                    set.remove(up);
                    up++;
                }
                while (set.contains(down)) {
                    set.remove(down);
                    down--;
                }
                int length = up - down - 1;
                if (length > longest) longest = length;
            }
        }
        return longest;
    }
}