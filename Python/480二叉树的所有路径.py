from common import *


class Solution:
    path = []
    all_path = []

    def binaryTreePaths(self, root: TreeNode):
        """
        @param root: the root of the binary tree
        @return: all root-to-leaf paths
        """
        self.path.clear()
        self.all_path.clear()
        if root:
            self.helper(root)
        return self.all_path

    def helper(self, root: TreeNode):
        self.path.append(str(root.val))
        if (not root.left) and (not root.right):
            # leaf
            self.all_path.append("->".join(self.path))
        if root.left:
            self.helper(root.left)
        if root.right:
            self.helper(root.right)
        self.path.pop()


from TestUtil import Test

if __name__ == '__main__':
    test = Test(Solution())
    root = TreeFactory("{1,2,3,#,5}").bfsBuild()
    cases = [root]
    test.run(cases, 'binaryTreePaths')
