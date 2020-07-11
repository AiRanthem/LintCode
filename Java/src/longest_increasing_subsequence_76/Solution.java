package src.longest_increasing_subsequence_76;

import java.util.*;

public class Solution {
    /**
     * @param nums: An integer array
     * @return The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // pack
        Integer[] integers = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            integers[i] = nums[i];
        }
        // drop duplicate
        LinkedHashSet<Integer> set = new LinkedHashSet<>(integers.length);
        set.addAll(Arrays.asList(integers));
        Object[] droped = set.toArray();
        // unpack
        int[] sorted = new int[droped.length];
        for (int i = 0; i < droped.length; i++) {
            sorted[i] = (int) droped[i];
        }
        // sort
        Arrays.sort(sorted);
        // dp
        return longestSameSubsequence(sorted, nums);
    }

    private int longestSameSubsequence(int[] a, int[] b) {
        int[][] dp = new int[a.length + 1][b.length + 1];
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1]) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[a.length][b.length];
    }
}
