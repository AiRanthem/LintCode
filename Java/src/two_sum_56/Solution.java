package src.two_sum_56;

import java.util.HashMap;

public class Solution {
    /**
     * O(n) space
     * O(n) time
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // maps a number to its index
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int except = target - numbers[i];
            if (map.containsKey(except)) {
                int[] ans = new int[2];
                ans[0] = map.get(except);
                ans[1] = i;
                return ans;
            } else {
                map.put(numbers[i],i);
            }
        }
        return null;
    }
}