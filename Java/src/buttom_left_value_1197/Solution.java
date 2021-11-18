package src.buttom_left_value_1197;

import utils.TreeNode;

public class Solution {
    int maxDepth;
    TreeNode buttomLeft;

    /**
     * 给定一棵二叉树，找到这棵树最后一行中最左边的值
     * <p>
     * 思路：左序dfs，当第一次发现节点的深度大于记录值时，将buttomLeft指向它。
     *
     * @param root: a root of tree
     * @return return a integer
     */
    public int findBottomLeftValue(TreeNode root) {
        maxDepth = -1;
        dfs(root, 0);
        return buttomLeft.val;
    }

    public void dfs(TreeNode node, int depth) {
        if (depth > maxDepth) {
            maxDepth = depth;
            buttomLeft = node;
        }
        if (node.left != null) {
            dfs(node.left, depth + 1);
        }
        if (node.right != null) {
            dfs(node.right, depth + 1);
        }
    }
}
