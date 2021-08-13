package src.weight_capacity_1915;

public class Solution {
    /**
     * 问题见SolutionClassic.java
     *
     * 改进的DP方法：使用数组 bool dp[j] = 是否有使最终重量等于j的方案
     * 初始dp[0] = true 表示存在重量等于0的方案（即什么都不取）
     * 当考虑前i个物品时，如果取第i个物品，那么dp[j] = dp[j-w[i]]；如果不取那么dp[j] = dp[j]，即保持不变
     * i从1到n都对数组dp迭代n次，即可得到最终答案。
     * 编码优化：当w[i] >= j时，一定不能取物品i，所以dp[j]一定保持不变，所以迭代时j从maxCapacity开始向下迭代即可。
     *
     * @param weights:     An array of n integers, where the value of each element weights[i] is the weight of each plate i
     * @param maxCapacity: An integer, the capacity of the barbell
     * @return an integer denoting the maximum capacity of items that she can lift.
     */
    public int weightCapacity(int[] weights, int maxCapacity) {
        boolean[] dp = new boolean[maxCapacity + 1];
        dp[0] = true;

        for (int weight : weights) {
            for (int j = maxCapacity; j >= weight; j--) {
                dp[j] = dp[j] || dp[j - weight];
            }
        }
        for (int i = maxCapacity; i >= 0; i--) {
            if (dp[i]) {
                return i;
            }
        }
        return 0;
    }
}
