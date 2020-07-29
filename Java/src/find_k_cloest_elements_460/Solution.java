package src.find_k_cloest_elements_460;

public class Solution {
    /**
     * @param A:      an integer array
     * @param target: An integer
     * @param k:      An integer
     * @return an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // preprocess
        for (int i = 0; i < A.length; i++) {
            A[i] -= target;
        }

        int[] ans = new int[k];
        int l = 0, r = 0;
        // find the cloest
        int min = 10000;
        int abs = 0;
        for (int i = 0; i < A.length; i++) {
            abs = Math.abs(A[i]);
            if (abs < min) {
                min = abs;
                l = i;
                r = i + 1;
            }
        }
        // fill the answer
        boolean left, right;
        for (int i = 0; i < k; i++) {
            if (r == A.length || l != -1 && Math.abs(A[l]) <= Math.abs(A[r]) ) {
                ans[i] = A[l--] + target;
            } else {
                ans[i] = A[r++] + target;
            }
        }
        return ans;
    }
}
