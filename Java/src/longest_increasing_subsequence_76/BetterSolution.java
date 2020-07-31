package src.longest_increasing_subsequence_76;

import java.util.TreeSet;

public class BetterSolution {
    /**
     * Treeset.ceiling(x) 取出大于等于X的最小元素，不存在则返回null
     * Treeset是一个排序的集合
     *
     * 对于nums中的每个数字，set中取seiling
     * 1. 如果这个数字不存在，说明x大于set中任何数字，直接把x插入set中。 最后返回set的大小即可。
     * 2. 如果这个数字存在，则删除这个数字，然后把x插入set中，相当于代替该数字
     *
     * 这种解法等价于最优的DP思想：
     * DP的思想：dp[i] = nums[:i] 的最大子序列长度，max_elem[i]记录最大元素
     * 对于当前数字，
     * 1. 如果它比当前候选序列所有元素大，则放到最后
     * 2. 否则，如果它比某一个最大值要小，则更新对应的max_elem值
     * 也就是说，如果之前存在一个递增子序列，结尾数值比nums[i]大，则用nums[i]替换掉这个结尾
     * 由于max_elem一定是严格递增的，所以可以通过折半查找来找到满足条件的值。
     * 迭代复杂度O(n) 查找复杂度O(logn) 总复杂度 O(nlogn)
     *
     * 使用Treeset的分析：两者的情况1情况2是等价的。
     * Treeset中存放的其实是相当于max_elem。
     * set[i]是长度为 i+1 的子序列对应的max的值。
     * 迭代复杂度O(n) ceiling复杂度O(logn) 总复杂度O(nlogn)
     * 不过情况1使用Treeset也需要进行一次ceiling，而传统DP直接赋值，所以平均复杂度要高于DP。
     * 但是代码少啊，真香。
     *
     * 进一步优化：借助Treeset方法的思想，比较最高位，不满足放置条件再使用ceiling。
     * 但是last方法貌似也要O(logn)，并不是O(1)
     *
     * 为了省事我就没有做优化了。要优化应该要自己弄数据结构
     *
     * @param nums: An integer array
     * @return The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            Integer ceiling = set.ceiling(num);
            if (ceiling != null) {
                set.remove(ceiling);
            }
            set.add(num);
        }
        return set.size();
    }
}
