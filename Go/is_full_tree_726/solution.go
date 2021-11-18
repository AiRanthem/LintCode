package is_full_tree_726

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/**
 * @param root: the given tree
 * @return: Whether it is a full tree
 */
func isFullTree(root *TreeNode) bool {
	if (root.Left == nil && root.Right != nil) || (root.Left != nil && root.Right == nil) {
		return false
	}
	if root.Left == nil {
		return true
	}
	return isFullTree(root.Left) && isFullTree(root.Right)
}
