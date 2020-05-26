from TestUtil import Test


class MyTreeNode:
    def __init__(self, s: str, level: int):
        self.level = level
        self.val = len(s)
        self.children = []
        self.is_file = '.' in s


class Solution:

    def lengthLongestPath(self, inputstr: str):
        """
        :param inputstr: an abstract file system
        :return: return the length of the longest absolute path to file
        """
        if not inputstr:
            return 0
        files = inputstr.split('\n')
        nodes = []
        for file in files:
            level = file.count('\t')
            if file:
                nodes.append((file[level:].strip(), level))
        root = self.buildTree(nodes)
        return max([self.cacu_len(d) if not d.is_file else d.val+1 for d in root.children ])

    def cacu_len(self, root: MyTreeNode) -> int:
        # return
        if not root.children:
            return root.val if root.is_file else 0
        # recur
        children_max = max([self.cacu_len(node) for node in root.children])
        return children_max + root.val + 1 if children_max else 0

    def buildTree(self, nodes: list) -> MyTreeNode:
        root = MyTreeNode('', -1)
        nodes_iter = iter(nodes)
        cur_node = root
        stack = []
        node_tuple = next(nodes_iter)
        while True:
            try:
                s, level = node_tuple
                # 同级目录、高级目录
                if level <= cur_node.level:
                    cur_node = stack.pop()
                    continue
                # 子目录
                new_node = MyTreeNode(*node_tuple)
                cur_node.children.append(new_node)
                stack.append(cur_node)
                cur_node = new_node
                node_tuple = next(nodes_iter)
            except StopIteration:
                break
        return root


if __name__ == '__main__':
    test = Test(Solution())
    cases = ["dir\n file.txt"]
    test.run(cases, 'lengthLongestPath')
