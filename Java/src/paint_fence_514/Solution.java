package src.paint_fence_514;

public class Solution {
    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        if (n == 1) return k;
        int[] dp = new int[n];
        dp[0] = k;
        dp[1] = k * k;
        for (int i = 2; i < n; i++) {
            // 不同 dp[i-1] * (k-1)
            // 相同 dp[i-2] * (k-1)
            dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]);
        }
        return dp[n - 1];
    }
}