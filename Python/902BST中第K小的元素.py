from Python.TestUtil import Test

"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""


class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None


class Solution:
    """
    @param root: the given BST
    @param k: the given k
    @return: the kth smallest element in BST
    """

    def kthSmallest(self, root: TreeNode, k: int):
        res = self.helper(root, k)
        return sorted(res)[-1]

    def helper(self, root:TreeNode, k:int):
        # return
        if root is None:
            return []

        # recur
        res = self.helper(root.left, k) + self.helper(root.right, k) + [root.val]
        if len(res) <= k:
            return res
        else:
            return sorted(res)[:k]

if __name__ == '__main__':
    test = Test(Solution())
    cases = []
    test.run(cases, 'kthSmallest')
