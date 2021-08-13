package src.weight_capacity_1915;


public class SolutionClassic {
    /**
     * 奥利第一次来到健身房，她正在计算她能举起的最大重量。杠铃所能承受的最大重量为maxCapacity，健身房里有n个杠铃片，第 i 个杠铃片的重量为 weights[i]。
     * 奥利现在需要选一些杠铃片加到杠铃上，使得杠铃的重量最大，但是所选的杠铃片重量总和又不能超过 maxCapacity ，请计算杠铃的最大重量是多少。
     * <p>
     * 比如，给定杠铃片的重量为 weights = [1, 3, 5]， 而杠铃的最大承重为 maxCapacity = 7，那么应该选择重量为 1 和 5 的杠铃片，(1 + 5 = 6)，所以最终的答案是 6。
     * <p>
     * 思路：典型的背包问题。定义数组 dp[i][j] = 可选择前i个物品，最大负重为j的情况下可拿取的最大重量。
     * 计算dp[i][j]时，如果选择拿取第i个物品，那么此时背包的余量必定至少有j - weight[i]，而该余量下必定取最大重量，相当于 dp[i][j] = dp[i-1][j - w[i]] + w[i]
     * 如果不拿取第i个物品，显然dp[i][j] = dp[i-1][j]
     * 最终的结果取大值即可。即：dp[i][j] = MAX{ dp[i-1][maxC - w[i]] + w[i], dp[i-1][j] }
     * 根据状态转移方程，dp数组按行遍历即可。遍历时，注意考虑第i个物品是否真的能装得下。
     *
     * @param weights:     An array of n integers, where the value of each element weights[i] is the weight of each plate i
     * @param maxCapacity: An integer, the capacity of the barbell
     * @return an integer denoting the maximum capacity of items that she can lift.
     */
    public int weightCapacity(int[] weights, int maxCapacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][maxCapacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxCapacity; j++) {
                if (weights[i - 1] > j) { // 一定装不下
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j - weights[i - 1]] + weights[i - 1],
                            dp[i - 1][j]);
                }
            }
        }
        return dp[n][maxCapacity];
    }
}