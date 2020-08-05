package src.find_minimun_in_rotated_sorted_array_159;

public class Solution {
    /**
     * 画出曲线，找最低点，轻松理解思路
     *
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (r - l <= 1) return Math.min(nums[l], nums[r]);
            int mid = (l + r) / 2;
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] >= nums[r]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
