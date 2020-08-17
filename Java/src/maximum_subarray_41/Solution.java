package src.maximum_subarray_41;

public class Solution {
    /**
     * dp[i] = 以i结束的最大子数组和
     * dp[i] = max{dp[i-1] + nums[i], nums[i]}
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
        }
        int max = dp[0];
        for (int i : dp) {
            if (max < i){
                max = i;
            }
        }
        return max;
    }
}
