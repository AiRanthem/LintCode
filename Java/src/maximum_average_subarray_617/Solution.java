package src.maximum_average_subarray_617;

public class Solution {
    private int[] nums;
    private int k;

    /**
     * 二分查找：不一定有序的才能二分，不一定要二分序列。解空间也可以进行二分
     * left 初始为数组最小值，right 初始为数组最大值
     * 如果平均值 mid 比解大，则 right = mid
     * 否则 left = mid
     * 这样 left 和 right 不停逼近最终的解
     * 由于这种逼近是近似逼近，所以需要设定精度条件：left + 1e-5 < right
     * <p>
     * 如何判断 mid 和解的大小关系？
     * 尝试让 nums 每个元素减去 mid，如果存在一个区间上的和大于0，则证明这个区间均值大于 mid
     * 也就是说解一定比 mid 大
     * <p>
     * 如何确定这个区间呢？穷举需要
     * 假设这个区间在序列 nums 中的结构是这样的：
     * lll|xxxxxxxxxxx|rrrrrrrr
     * 左面有一个前缀序列l，右面有一个后缀序列r。
     * 从左往右开始扫描，只要发现有一个 sum(nums[:x]) - sum(nums[:l]) > mid 就算找到了
     * 这个偏序性，只要保存 min(sum(nums[:l])) 逐步扫描 sum(nums[:x])即可。
     * 换句话说，最开始 xxxxx|rrrrrrrr，x长度为k
     * x还是从最左开始向右增长，l从长度1开始向右增长，x是包含l的
     * 当x的和减去某一个l的和大于0，则确认ans > mid
     *
     * @param nums: an array with positive and negative numbers
     * @param k:    an integer
     * @return the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        this.nums = nums;
        this.k = k;

        // 构造最初的 left & right
        double left = nums[0], right = nums[0], mid = 0;
        for (int num : nums) {
            if (num < left) left = num;
            if (num > right) right = num;
        }

        // 解空间二分查找
        while (left + 1e-5 < right){
            mid = (left + right) / 2;
            if(ansGreaterThan(mid)){
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 判断当前选定的均值和答案的关系
     *
     * @param avg mid
     * @return ans > mid
     */
    public boolean ansGreaterThan(double avg) {
        double sumX = 0, sumL = 0, minL = 0; // 三个数值参看上面的解释
        // xxxxxx|rrrrrrrrrrr 最初的情况，只要
        for (int i = 0; i < k; i++) {
            sumX += nums[i] - avg;
        }

        // x 和 l 开始同步增长
        for (int i = k; i <= nums.length; i++) {
            if (sumX - minL >= 0) return true;
            if(i < nums.length){
                sumL += nums[i - k] - avg;
                sumX += nums[i] - avg;
                if (sumL < minL) minL = sumL;
            }
        }

        // 增长完后没有发现大于的，则小于
        return false;
    }
}
