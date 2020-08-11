package src.split_array_largest_sum_1251;

public class Solution {
    /**
     * 解空间二分
     * 初始 l = max(nums); r = sum(nums)
     * <p>
     * 检查mid是不是解的方法：
     * 找和小于等于mid的区间数。
     * nums从左往右求和，如果出现和大于mid，reset，然后区间计数+1
     * 如果计数
     * 1. 大于m，段多了，说明 mid < target
     * 2. 等于m，段正好，说明 target <= mid < nums.ceiling(target)
     * 3. 小于m，段少了，说明 target < mid
     * 只有状态1可以判定。不过也够用了
     * <p>
     * 还有，这个题目nums会很大，所以l和r要用long
     *
     * @param nums: a list of integers
     * @param m:    an integer
     * @return: return a integer
     */
    public int splitArray(int[] nums, int m) {
        long l = 0, r = 0;
        for (int num : nums) {
            l = Math.max(num, l);
            r += num;
        }
        while (l <= r) {
            long mid = (l + r) / 2;
            if (tooSmall(mid, nums, m)) l = mid + 1;
                // 防止mid直接命中target和mid==right导致的死循环
            else r = mid == r ? mid - 1 : mid;
        }
        return (int) l;
    }

    public boolean tooSmall(long mid, int[] nums, int m) {
        long total = 0;
        int count = 1;
        for (int num : nums) {
            total += num;
            if (total > mid) {
                total = num; // reset的小技巧
                count++;
                if (count > m) return true;
            }
        }
        return false;
    }
}

