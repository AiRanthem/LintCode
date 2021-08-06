package src.recover_rotated_sorted_array_39;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 给定一个旋转排序数组，在原地恢复其排序。（升序）
     * 比如，原始数组为[1,2,3,4], 则其旋转数组可以是[1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
     * 又比如：输入：数组 = [4,5,1,2,3]，输出：[1,2,3,4,5]
     * <p>
     * 解法：二分找最小。
     * 如果一个区间第一项比最后一项大，那么这个区间发生了折断，最小值一定在这个区间中。
     * 如果一个区间第一项比最后一项小，那么：
     * 1、如果另一个区间发生折断，那么最小值在另一个区间中
     * 2、如果另一个区间未发生折断，那么可能出现类似 [1, 1, -1, 1] [1, 1, 1, 1] 这样的极端情况，无法判断，需要对两个区间分别找最小值并取小。
     *
     * @param nums: An integer array
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        int idx = idxMin(nums, 0, nums.size() - 1);
        if (idx == 0) {
            return;
        }
        List<Integer> res = new ArrayList<>(nums.subList(idx, nums.size()));
        res.addAll(nums.subList(0, idx));
        nums.clear();
        nums.addAll(res);
    }

    public int idxMin(List<Integer> nums, int start, int end) {
        if (start == end) {
            return start;
        }
        int mid = (start + end) / 2;
        if (nums.get(start) > nums.get(mid)) {
            return idxMin(nums, start, mid);
        } else if (nums.get(mid + 1) > nums.get(end)) {
            return idxMin(nums, mid + 1, end);
        } else {
            int left = idxMin(nums, start, mid);
            int right = idxMin(nums, mid + 1, end);
            return nums.get(left) < nums.get(right) ? left : right;
        }
    }
}
