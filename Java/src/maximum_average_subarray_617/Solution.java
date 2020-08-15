package src.maximum_average_subarray_617;

public class Solution {
    /**
     * @param nums: an array with positive and negative numbers
     * @param k:    an integer
     * @return: the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        double l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > r) r = num;
            if (num < l) l = num;
        }

        while (r - l >= 1e-5) {
            double mid = (l + r) / 2;
            if (tooSmall(mid, nums, k)){
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public boolean tooSmall(double avg, int[] nums, int k){
        double rsum = 0, lsum = 0, lmin = 0;
        for (int i = 0; i < k; i++) {
            rsum += nums[i] - avg;
        }
        for (int i = k; i < nums.length; i++) {
            if (rsum - lmin >= 0){
                return true;
            }
            rsum += nums[i] - avg;
            lsum += nums[i-k] - avg;
            lmin = Double.min(lmin, lsum);
        }
        return rsum >= lmin;
    }

}
