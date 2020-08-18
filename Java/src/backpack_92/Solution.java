package src.backpack_92;

public class Solution {
    /**
     * dp[i][j] = 要拿第i件物品，还有j个空间最多装多少个
     * dp[i][j] = max{
     *     dp[i-1][j-A[i-1]]+A[i-1], // 拿
     *     dp[i-1][j] // 不拿
     * }
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        int[][] dp = new int[A.length + 1][m + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= m; j++) {
                if (j < A[i-1]) dp[i][j] = dp[i-1][j];
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-A[i-1]]+A[i-1]);
                }
            }
        }
        return dp[A.length][m];
    }
}
