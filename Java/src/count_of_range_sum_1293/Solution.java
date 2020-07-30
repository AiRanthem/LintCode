package src.count_of_range_sum_1293;

public class Solution {
    private int lower, upper;
    private int[] prefixSum, temp;

    /**
     * 这个问题要求每个区间的和，在原数组上势必要保证顺序不变。
     * 但是问题只需要求出区间和的个数，不要求给出具体是哪个区间。
     * <p>
     * 如果转化为前缀和数组：prefix[i] = nums前i个元素的和，prefix[0] = 0)
     * 则区间和S(i,j) = prefix[j] - prefix[i] (i <= j)
     * 也就是说，从原来严格的必须全排列变成了只要保证 i < j，就能得出一个区间和
     * <p>
     * 我们把prefix分成两部分，i,k,j，不难发现，分割点k确定的情况下，i在前半部分的位置随意变化，
     * j在后半部分的位置随意变化
     * <p>
     * prefix[:k]和prefix[k+1:]按照值升序排列，可以保证后半段的下标一定比前半段大，也就是说后半段
     * 任意取一个前缀和减去前半段的一个前缀和都一定是一个区间和。后半段一定在前半段之后，但是同一个段内
     * 无法保证具有先后顺序
     * <p>
     * 再看题目要求的是区间和的条件是在 lower 和 upper 之间，那自然想到给prefix数组排序：
     * 因为段内顺序现在是允许改变的，那就可以给段内排序。如果前后半段有序，则对于后半段的每个元素O，
     * 前半段的下标越小，则形成的区间和越大，反之亦然。只要在前半段遍历找到两个符合要求的下标O(n),相减
     * 就是当前后半段元素在这种划分下的count总数。
     * 由此可以找到以每个元素为结尾的符合要求的区间和count总数O(n)
     * <p>
     * 一组划分结束后，将规模扩大，两组归并排序，之后共同最为后组（或前组）参与接下来的计算O(logn)
     * 总复杂度O(n^2logn)
     * <p>
     * 对比暴力解法，对于每一个结尾元素O(n)，遍历每一个前序元素O(n)，求区间和O(n)，复杂度O(n^3)
     * <p>
     *
     * @param nums:  a list of integers
     * @param lower: a integer
     * @param upper: a integer
     * @return return a integer
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) {
            if (nums[0] <= upper && nums[0] >= lower) return 1;
            else return 0;
        }
        prefixSum = new int[nums.length + 1];
        temp = new int[nums.length + 1];
        this.lower = lower;
        this.upper = upper;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i + 1] = sum;
        }
        return mergeSort(0, nums.length);
    }

    public int mergeSort(int start, int end) {
        if (start >= end) return 0;
        int mid = (start + end) / 2;
        int count = mergeSort(start, mid) + mergeSort(mid + 1, end);

        int left = start, right;
        // 遍历每一个后半段元素。
        // 让left和right从start开始递增至mid，
        for (int i = mid + 1; i <= end; i++) {
            // 找到最大区间和
            while (left <= mid && prefixSum[i] - prefixSum[left] > upper)
                left++;
            // 找到最小区间和
            right = left;
            while (right <= mid && prefixSum[i] - prefixSum[right] >= lower)
                right++;
            count += right-left;
        }
        // 归并，继续
        merge(start, mid, end);
        return count;
    }

    public void merge(int start, int mid, int end){
        int left = start, right = mid + 1, idx = start;
        while (left <= mid && right <= end){
            if(prefixSum[left] <= prefixSum[right]){
                temp[idx++] = prefixSum[left++];
            } else {
                temp[idx++] = prefixSum[right++];
            }
        }
        while (left <= mid) temp[idx++] = prefixSum[left++];
        while (right <= end) temp[idx++] = prefixSum[right++];

        if (end + 1 - start >= 0) System.arraycopy(temp, start, prefixSum, start, end + 1 - start);
    }
}