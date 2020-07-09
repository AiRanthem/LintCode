from common import *


class Solution:

    def serialize(self, root: TreeNode):
        """
        @param root: An object of TreeNode, denote the root of the binary tree.
        This method will be invoked first, you should design your own algorithm
        to serialize a binary tree which denote by a root node to a string which
        can be easily deserialized by your own "deserialize" method later.
        """
        if not root:
            return "{}"
        values = [str(root.val)]
        nodes = [root]
        while nodes:
            node = nodes.pop(0)
            if node.left:
                values.append(str(node.left.val))
                nodes.append(node.left)
            else:
                values.append("#")
            if node.right:
                values.append(str(node.right.val))
                nodes.append(node.right)
            else:
                values.append("#")
        while values[-1] == "#":
            values.pop()
        return '{' + ','.join(values) + '}'

    def deserialize(self, data: str):
        """
        @param data: A string serialized by your serialize method.
        This method will be invoked second, the argument data is what exactly
        you serialized at method "serialize", that means the data is not given by
        system, it's given by your own serialize method. So the format of data is
        designed by yourself, and deserialize it here as you serialize it in
        "serialize" method.
        """
        values = data[1:-1].split(',')
        if not values:
            return None

        root = TreeNode(values[0])
        cur = root
        values = values[1:]
        nodes = []

        left = True
        while values:
            val = values.pop(0)
            if val != "#":
                node = TreeNode(int(val))
                nodes.append(node)
                if left:
                    cur.left = node
                else:
                    cur.right = node
            if not left:
                cur = nodes.pop(0)
            left = not left
        return root


if __name__ == '__main__':
    solution = Solution()
    deserialize = solution.deserialize('{3,9,20,#,#,15,7}')
    serialize = solution.serialize(deserialize)
    pass
