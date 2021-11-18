package src.trangle_minimum_total_109;

public class Solution {
    /**
     * 给定一个数字三角形，找到从顶部到底部的最小路径和。每一步可以移动到下面一行的相邻数字上。
     * <p>
     * 思路：因为数字能正能负，自上而下进行搜索对于一个节点，永远无法知道接下来可能和是多少，因此无法剪枝
     * （就算到某个节点的和巨大无比，也不知道接下来会有多少更大的负数把他压下去）
     * 但是如果自下而上，就确定的多了：从最后一层开始，记录以该节点为根的最小和。显然最后一层最小和就是其值。
     * 所求节点的坐标为(depth, position)，使用记忆化搜索（DP+剪枝）来进行解题。
     * memo[depth, pos] = trangle[depth, pos] + min{ memo[depth+1, pos], memo[depth+1, pos] }
     * 发现memo数组的每一行，更新pos后下一行的pos就无用了，且不影响pos之后的部分，所以可以使用滚动数组来进行空间优化。具体见实现。
     *
     * @param triangle: a list of lists of integers
     * @return An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        int size = triangle.length; // trangle[last].length == trangle.length. there're "size" lines total.
        int[] memo = new int[size];
        System.arraycopy(triangle[size - 1], 0, memo, 0, size);
        for (int i = size - 2; i >= 0; i--) {
            // iter from the last 2th line. trangle[i].length == i
            // var i means both the line number index and the length of the line - 1.
            for (int j = 0; j <= i; j++) {
                // right memo means last line and left memo, current line.
                memo[j] = triangle[i][j] + Math.min(memo[j], memo[j + 1]);
            }
        }
        return memo[0];
    }
}