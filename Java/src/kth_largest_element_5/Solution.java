package src.kth_largest_element_5;

public class Solution {
    int[] nums;

    /**
     * @param n:    An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        this.nums = nums;
        return quickSelect(0, nums.length-1, n);
    }

    public int quickSelect(int start, int end, int n) {
        int pivot = nums[start];
        int i = start, j = start, temp;
        temp = nums[end];
        nums[end] = nums[start];
        nums[start] = temp;

        while (j < nums.length){
            if (nums[j] < pivot){
                j++;
            } else {
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j++;
            }
        }
        int k = i - start;
        i--;
        if (k > n) return quickSelect(start, i - 1, n);
        if (k < n) return quickSelect(i + 1, end, n - k);
        return pivot;
    }
}