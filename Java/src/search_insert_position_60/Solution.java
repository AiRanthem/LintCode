package src.search_insert_position_60;

public class Solution {
    /**
     * @param A:      an integer sorted array
     * @param target: an integer to be inserted
     * @return: An integer
     */
    public int searchInsert(int[] A, int target) {
        int l = 0, r = A.length - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (A[mid] == target) return mid;
            if (mid == l){ // size = 2
                if (A[l] > target) return l;
                if (A[r] < target) return r+1;
                return r;
            }
            if (A[mid] < target) l = mid;
            else r = mid;
        }
        return 0;
    }
}
