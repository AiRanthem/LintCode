from common import *

class Solution:
    min_depth = 0
    def minDepth(self, root: TreeNode):
        """
        @param root: The root of binary tree
        @return: An integer
        """
        if not root:
            return 0
        self.min_depth = 10000000
        self.dfs(root, 1)
        return self.min_depth

    def dfs(self, node: TreeNode, cur_depth: int):
        if cur_depth == self.min_depth:
            return
        if not node.left and not node.right:
            self.min_depth = cur_depth
        if node.left:
            self.dfs(node.left, cur_depth+1)
        if node.right:
            self.dfs(node.right, cur_depth+1)
