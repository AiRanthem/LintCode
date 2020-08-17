package src.majority_element_46;

import java.util.List;

public class Solution {
    /*
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(List<Integer> nums) {
        int cur_majority = nums.get(0)+1;
        int count = 0;
        for (Integer num : nums) {
            if (count == 0){
                cur_majority = num;
            }
            if (num == cur_majority){
                count++;
            } else {
                count--;
            }
        }
        return cur_majority;
    }
}
