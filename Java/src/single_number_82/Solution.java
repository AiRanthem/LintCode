package src.single_number_82;

public class Solution {
    /**
     * O(n) time O(1) space
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {
        int x = A[0];
        for(int i = 1; i< A.length; i++){
            x ^= A[i];
        }
        return x;
    }
}