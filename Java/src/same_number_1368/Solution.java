package src.same_number_1368;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    /**
     * @param nums: the arrays
     * @param k: the distance of the same number
     * @return the ans of this question
     */
    public String sameNumber(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer pre = map.get(nums[i]);
            if(pre != null){
                if(i - pre < k){
                    return "YES";
                }
            }
            map.put(nums[i], i);
        }
        return "NO";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.sameNumber(new int[]{1,2,3,5,7,1,5,1,3}, 4);
        System.out.println(s);
    }
}
