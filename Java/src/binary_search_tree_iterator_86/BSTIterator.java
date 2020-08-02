package src.binary_search_tree_iterator_86;

import src.utils.TreeNode;

/**
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * }
 */


public class BSTIterator {
    TreeNode current, cursor;
    /**
     * 真正保存的是current，是现在遍历的进度
     * @param root: The root of binary tree.
     */
    public BSTIterator(TreeNode root) {
        this.current = root;
    }

    /**
     * @return True if there has next node, or false
     */
    public boolean hasNext() {
        return current != null;
    }

    /**
     * 思路：current一路向左
     * 1. current不是左叶子，则把它左叶子的最右的right指针连到cur上面
     *      (cur->left->right->right->...->right=cur)
     *    这样，每次遍历到叶子节点时，只需要cur = cur.right就可以回到上一层，很巧妙的方法。
     * 2. current是左叶子，那么返回之，然后 cur = cur.right
     *
     * 每次next，current节点有三种状态：
     * 1. left != null
     *      1.1 left的最右没有连接current，证明这个左路没有遍历过，则连接之，然后current = left
     *      2.2 left的最右连接了current，证明这个左路走过了，那么 return current 然后 current = right
     * 2. left == null
     *      最小，return current 然后go right
     * @return return next node
     */
    public TreeNode next() {
        TreeNode res = null;
        while (current != null){
            // scene 2
            if(current.left == null){
                res = current;
                current = current.right;
                break;
            }
            // scene 1
            cursor = current.left;
            while (cursor.right != null && cursor.right != current){
                cursor = cursor.right;
            }
            // scene 1.1
            if(cursor.right == null){
                cursor.right = current;
                current = current.left;
            } else {
                res = current;
                current = current.right;
                break;
            }
        }

        return res;
    }
}
