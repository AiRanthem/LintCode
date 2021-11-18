package src.smallest_divisor_1816;

import java.util.Arrays;

public class Solution {
    /**
     * 给你一个整数数组 nums 和一个正整数 threshold  ，你需要选择一个正整数作为除数，然后将数组里每个数都除以它，并对除法结果求和。
     * 请你找出能够使上述结果小于等于阈值 threshold 的除数中 最小 的那个。
     * 每个数除以除数后都向上取整，比方说 7/3 = 3 ， 10/2 = 5 。
     * 题目保证一定有解。
     * <p>
     * 1 <= nums.length <= 5 * 10^4
     * 1 <= nums[i] <= 10^6
     * nums.length <= threshold <= 10^6
     * <p>
     * 解法：显然，除法结果求和一定随着除数增加递减。二分查找即可。
     *
     * @param nums:      an array of integers
     * @param threshold: an integer
     * @return the smallest divisor
     */
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        int l = 1, r = max, mid;

        while (l < r) {
            mid = (l + r) / 2;
            int sum = getDividedSum(nums, mid);
            if (sum > threshold) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    public int getDividedSum(int[] nums, float divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += (int) Math.ceil(num / divisor);
        }
        return sum;
    }
}