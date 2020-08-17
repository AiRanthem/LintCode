package src.merge_sorted_array_64;

public class Solution {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int[] temp = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (A[i] < B[j]) temp[k++] = A[i++];
            else temp[k++] = B[j++];
        }
        while (i<m) temp[k++] = A[i++];
        while (j<n) temp[k++] = B[j++];
        System.arraycopy(temp, 0, A, 0, m+n);
    }
}