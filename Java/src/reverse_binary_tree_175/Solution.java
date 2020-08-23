package src.reverse_binary_tree_175;

import utils.TreeNode;

import java.util.Stack;

public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            TreeNode temp = pop.left;
            pop.left = pop.right;
            pop.right = temp;
            if (pop.right != null) stack.push(pop.right);
            if (pop.left != null) stack.push(pop.left);
        }
    }
}