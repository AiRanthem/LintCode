package src.search_in_rotated_sorted_array_62;

public class Solution {
    /**
     * target在区间上有四种可能性（只有三种可能发生）
     * 1. 右递增段
     * 2. 右跳跃段
     * 3. 左递增段
     * 4. 左跳跃段
     * 区间有三种可能性：
     * a. 严格递增，target可能发生1,2
     * b. mid在正上升段，target可能发生1,2,3
     * c. mid在负上升段，target可能发生1,3,4
     *
     * @param A:      an integer rotated sorted array
     * @param target: an integer to be searched
     * @return an integer
     */
    public int search(int[] A, int target) {
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] == target) return mid;
            // 状态 a 递增
            if (A[l] < A[r]) {
                if (A[mid] < target) l = mid + 1;
                else r = mid - 1;
            }
            // 状态 b 正上升
            else if (A[mid] > A[r]) {
                if (target > A[mid] || target < A[l]) l = mid + 1;
                else r = mid - 1;
            }
            // 状态 c 负上升
            else {
                if (target < A[mid] || target > A[r]) r = mid - 1;
                else l = mid + 1;
            }
        }
        return -1;
    }
}
