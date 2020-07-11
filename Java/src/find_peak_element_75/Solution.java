package src.find_peak_element_75;

public class Solution {
    private int[] A;
    /**
     * @param A: An integers array.
     * @return return any of peek positions.
     */
    public int findPeak(int[] A) {
        this.A = A;
        return helper(0, A.length - 1);
    }

    private int helper(int left, int right){
        int mid = (left + right) / 2;
        if(A[mid] > A[mid-1] && A[mid] > A[mid+1]) return mid;
        if(A[mid] < A[mid-1]) return helper(left, mid);
        else return helper(mid, right);
    }
}
