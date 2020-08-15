package src.count_of_range_sum_1293;

public class Solution {
    private int[] prefix, temp;
    private int lower, upper;

    /**
     * @param nums:  a list of integers
     * @param lower: a integer
     * @param upper: a integer
     * @return: return a integer
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        prefix = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i+1] = prefix[i]+nums[i];
        }
        temp = new int[prefix.length];
        this.upper = upper;
        this.lower = lower;
        return mergeSort(0, prefix.length-1);
    }

    public int mergeSort(int start, int end) {
        if (start >= end) return 0;
        int mid = (start + end) / 2;
        int count = mergeSort(start, mid) + mergeSort(mid+1, end);
        for (int i = mid + 1; i <= end; i++) {
            int left = start;
            while (left <= mid && prefix[i] - prefix[left] > upper) left++;
            int right = left;
            while (right <= mid && prefix[i] - prefix[right] >= lower) right++;
            count += right - left;
        }
        int i = start;
        int j = mid + 1;
        int idx = start;
        while (i <= mid && j <= end){
            if (prefix[i] <= prefix[j]){
                temp[idx++] = prefix[i++];
            } else {
                temp[idx++] = prefix[j++];
            }
        }
        while (i <= mid) temp[idx++] = prefix[i++];
        while (j <= end) temp[idx++] = prefix[j++];

        if (end + 1 - start >= 0) System.arraycopy(temp, start, prefix, start, end + 1 - start);
        return count;
    }
}