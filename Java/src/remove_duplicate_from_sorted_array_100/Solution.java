package src.remove_duplicate_from_sorted_array_100;

public class Solution {
    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int cnt = 1;
        for(int i = 1; i< nums.length;i++){
            if (nums[i] != nums[i-1]) nums[cnt++]=nums[i];
        }
        return cnt;
    }
}
