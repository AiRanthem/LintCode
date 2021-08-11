package src.put_balls_1904;

import java.util.Collections;
import java.util.List;

public class Solution {
    /**
     * 在n个桶里放着一些小球，在一开始，第i个桶中的小球有A[i]个。
     * 你还将得到每个桶的容纳上限W，也就是说，第i个桶中存放的小球不能超过W[i]个。
     *
     * 你每次可以从任意一个桶中拿走一个球，或者在任意一个桶中放置一个球。
     * 你最多执行k次操作，在小于等于k次操作后，你将进行如下计算：
     * 求出每一对相邻的桶（第0个桶和第1个桶，第1个桶和第2个桶，...，第n-2个桶和第n-1个桶）的绝对差值。
     *
     * 你的任务是最小化这些绝对差值中最大值的平方，并将最后的答案返回。
     * 1 <= k <= 100
     * 1 <= n <= 100
     * 0 <= A[i] <= W[i] <= 100
     *
     * 解法：
     * 0）定义名词
     *      绝对差值：任意两个相邻的桶的差值的绝对值都是一个绝对差值
     *      最大绝对差值：所有绝对差值中的最大值
     *      目标最大绝对差值：给定的最大绝对差值的目标值。是调整的目标。
     *      如果在条件给定调整次数内，能够使得最大绝对差值小于等于目标最大绝对差值，那么称为存在该目标最大绝对差值的调整方案
     *      解：题目所要求的答案，即经过k次调整后，所有可能最大绝对差值的最小值
     *      A[x:y]：序列A从 A[x] 到 A[y] 的子序列，包含b。
     *
     * 1）二分搜索解空间
     *      显然，最小绝对差值一定是在区间[0, max(A) - min(A)]中。在这个区间上进行二分搜索。
     *      对于每一次搜索，mid = (l + r) / 2，这个mid就是该次搜索的目标最大绝对差值。
     *      如果mid存在一个调整方案，那么解一定小于等于mid；否则，解一定大于mid。
     *
     * 2）通过类背包动态规划求判断是否存在该目标最大绝对差值的调整方案
     *      类背包动态规划是我总结的一系列动态规划问题。这些问题思考过程类似，实现方法也相似。这类问题的代表就是背包问题。
     *      类背包动态规划问题的一般包含四个元素，即 序列A，约束条件b，约束函数f，目标函数g。
     *          对于序列A，存在一个约束条件b，在满足约束函数 f(A) @ j （其中 @ 为任何可比较符号，包括但不限于 > < == 等）的情况下，
     *          需要求得目标函数 g(A) 的最优值。
     *      具体到背包问题，A就是物品列表，b就是背包容量；约束函数f为“物品列表中选取的物品总重量小于背包容量b”，目标函数为“选中物品总价值最大”。
     *      构成类背包问题的最重要的一个问题性质在于元组(f, b)可以向前递推。在背包问题的例子中，如果选中物品i，那么可以理解为将 f(A) 递推到：
     *          f1(A[0:i-1]) = 总重量小于b-物品i的重量；b1 = b - 物品i的重量
     *      有了这么一个递推，那么不难想到通过记录所有可能的b的取值即可通过动态规划轻易求出结果。
     *
     *      解决类背包问题最重要的是在思考问题时，通常A与g是问题明确给出的。我们需要先进行假设二元组 (f, b)，然后找出 (f, b) 的向前递推逻辑。
     *      如果无法找到，那么证明假设错误，需要寻找替代的方案；找到递推逻辑后，首先建立动态规划数组dp。
     *          在寻找过程中，b的选择是至关重要的——选择了b自然可以得到f。b的特性有：
     *              b的最大值已知且对于0到最大值的所有值，对于这个问题都有意义
     *              b这个参数能同时约束 A[i] 和 A[i-1]
     *          dp的size是(A.length + 1, ...)，具体维度由需要记录的约束条件b而定，需要包含b的所有取值。
     *          dp的值 dp[i,j] 是 A[0:i] 在 b == j 的条件下，g(A[0:i]) 的最优值。
     *          在经典背包问题中，b是一个标量值，因此dp为(A.length + 1, max(b))。
     *      建立好dp数组后，根据前面找到的 (f, b) 递推逻辑推演出 dp[i:] 与 dp[i-1:] 的状态转移方程，初始化dp数组后即可迭代进行DP。
     *
     *      现在通过上面的思考方式来解决现在的问题：判断是否存在给定目标最大绝对差值的调整方案
     *      从定义得出，目标值可调整则意味着调整最大绝对差值到满足目标需要的最小次数小于等于给定的K。那么进行问题分析：
     *      A：题干给出的球桶列表
     *      b：桶i的球数
     *      f：桶i的球个数等于 b 且 A[0:i] 最大绝对差值小于等于目标差值
     *      g：将桶i中的球个数调整到b个所需要的最少调整次数
     *
     *      怎么样才能想到这种脑洞清奇的四元组呢？
     *      题目中有两个可以备选为b的：
     *      1. A[i]（注意：因为需要推算，因此我们能使用的只有A[i]这个最后一项。所有序列可变的类背包问题中A[i]似乎都能作为一个b的备选）
     *      2. 目标最大绝对差值target
     *      如果选择2，无法建立 (f, b) 的递推关系，因此选择1。事实上只有1能够作为b。
     *      我们得出的递推关系是 f(A[:i])：A[i]的值是b => A[i-1]的值是b1且 |b1 - b| <= target
     *      所以定义dp[i][j] = A[0:i] 中，当A[i] == j时且最大绝对差值 <= target时，需要的最小调整次数
     *          如果 j > W[i] 显然 A[i] 永远调整不到，值记为infinity
     *          A[i] 调整到 j 一定需要 |A[i] - j| 次
     *          如果A[i] == j，那么A[i-1] 一定在区间 [j-target, j+target] 上，否则不满足条件；反推之能得到转移方程
     *              dp[i][j] = min{ dp[i-1][k] + |A[i] - j| } 这个min需要第三层搜索来得到。
     *              （传统背包问题中，得到的A[i-1]的约束条件是一个定值而不是一个区间，所以不需要第三次搜索）
     *      最终，dp最后一行的最小值就是我们要求的调整最大绝对差值到满足目标需要的最小次数。将其与给定K值作比较即可。
     *
     * @param n: the number of buckets
     * @param k: the maximum times of operations
     * @param A: the number of balls in each bucket
     * @param W: the maximum capacity of each bucket
     * @return return the minimum square value of the maximum difference
     */
    public int getAns(int n, int k, List<Integer> A, List<Integer> W) {
        int r = Collections.max(A) - Collections.min(A);
        int l = 0, mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (minOperations(A, W, mid) <= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l * l;
    }

    public int minOperations(List<Integer> A, List<Integer> W, int target) {
        int wMax = Collections.max(W);
        int aSize = A.size();
        int[][] dp = new int[aSize + 1][wMax + 1];
        for (int j = 0; j <= wMax; j++) {
            dp[1][j] = Math.abs(A.get(0) - j);
        }
        for (int i = 2; i <= aSize; i++) {
            for (int j = 0; j <= wMax; j++) {
                dp[i][j] = Integer.MAX_VALUE; // init here 'cause it's not used before.
                if (W.get(i - 1) < j) {
                    // the ith bucket will never be adjusted to >=j 'cause it's capacity is too small.
                    break;
                }
                for (int k = Math.max(0, j - target); k <= Math.min(W.get(i - 2), j + target); k++) {
                    // here, A[i] is set to j and A[i-1] is set to k
                    // so the value of k means the difference between A[i] and A[i-1] is smaller than target.
                    // of course k should have additional limits: >= 0 and <= W[i-1]
                    if (dp[i-1][k] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + Math.abs(A.get(i - 1) - j));
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i : dp[aSize]) {
            if (ans > i) {
                ans = i;
            }
        }
        return ans;
    }
}