package src.binary_tree_paths_480;

import src.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> strings;
    /**
     * @param root: the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        strings = new ArrayList<>();
        if(root == null) return strings;
        String root_val = String.valueOf(root.val);
        if(root.left == null && root.right == null) {
            strings.add(root_val);
            return strings;
        }
        if(root.left != null)
            helper(root.left, root_val);
        if(root.right != null)
            helper(root.right, root_val);
        return strings;
    }

    private void helper(TreeNode node, String string){
        String new_string = string + "->" + node.val;
        if(node.left == null && node.right == null){
            strings.add(new_string);
            return;
        }
        if(node.left != null){
            helper(node.left, new_string);
        }
        if(node.right != null){
            helper(node.right, new_string);
        }
    }
}
