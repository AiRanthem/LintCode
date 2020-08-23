package src.serialize_binary_tree_7;

import utils.TreeNode;

import java.util.*;

public class Solution {

    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root.left);
        queue.add(root.right);
        for (int i = 0; i < queue.size(); i++) {
            TreeNode nd = queue.get(i);
            if (nd == null) {
                sb.append(",#");
            } else {
                sb.append(',');
                sb.append(nd.val);
                queue.add(nd.left);
                queue.add(nd.right);
            }
        }
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        TreeNode cur = root;
        LinkedList<TreeNode> queue = new LinkedList<>();

        boolean go_left = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode tmp = new TreeNode(Integer.parseInt(vals[i]));
                if (go_left) {
                    cur.left = tmp;
                } else {
                    cur.right = tmp;
                }
                queue.offer(tmp);
            }
            if (!go_left) {
                cur = queue.poll();
            }

            go_left = !go_left;
        }

        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String ser = "3,9,20,#,#,15,7";
        TreeNode root = solution.deserialize(ser);
        String ser1 = solution.serialize(root);
        System.out.println(ser1);
    }
}
