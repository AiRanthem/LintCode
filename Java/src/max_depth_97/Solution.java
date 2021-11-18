package src.max_depth_97;

import utils.TreeNode;

public class Solution {

    private int maxDepthValue = 0;

    /**
     * 给定一个二叉树，找出其最大深度。最终答案不会超过5000。
     * 最大深度是从根节点到叶节点的最长路径的节点数。
     *
     * @param root: The root of binary tree.
     * @return An integer
     */
    public int maxDepth(TreeNode root) {
        if (root != null) {
            dfs(root, 0);
        }
        return maxDepthValue;
    }

    public void dfs(TreeNode node, int depth) {
        depth++;
        if (node.left == null && node.right == null) {
            if (maxDepthValue < depth) {
                maxDepthValue = depth;
            }
            return;
        }
        if (node.left != null) {
            dfs(node.left, depth);
        }
        if (node.right != null) {
            dfs(node.right, depth);
        }
    }
}
