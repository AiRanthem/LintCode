package src.first_position_of_target_14;

public class Solution {
    /**
     * @param nums:   The integer array.
     * @param target: Target to find.
     * @return The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                if(l == r) return l;
                r = mid;
            }
            else if (nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }
}
