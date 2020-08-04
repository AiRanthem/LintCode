package src.search_for_a_range_61;

public class Solution {
    /**
     * AB两数求均值，希望floor则(A+B)/2，希望ceil则(A+B+1)/2
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        int[] ans = {-1, -1};
        int l = 0, r = A.length-1;
        // find start
        while (l<=r){
            int mid = (l+r)/2;
            if(A[mid] == target){
                if(l == r) {
                    ans[0] = r;
                    break;
                }
                r = mid;
            } else if (A[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        // find end
        l = 0; r = A.length-1;
        while (l<=r){
            int mid = (l+r+1)/2;
            if(A[mid] == target){
                if(l == r) {
                    ans[1] = l;
                    break;
                }
                l = mid;
            } else if (A[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return ans;
    }
}
