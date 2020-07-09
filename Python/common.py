class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None

    def __repr__(self) -> str:
        return "val = {}, left = {}, right = {}".format(self.val, self.left.val if self.left else None,
                                                        self.right.val if self.right else None)


class TreeFactory:
    def __init__(self, values: str):
        values = values[1:-1].split(',')
        self.values = values[1:]
        self.root = TreeNode(int(values[0]))

    def bfsBuild(self):
        cur = self.root
        left = True
        nodes = []
        while self.values:
            val = self.values.pop(0)
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
        return self.root


class Point:
    def __init__(self, a=0, b=0):
        self.x = a
        self.y = b

    def __repr__(self):
        return "x = {}, y = {}".format(self.x, self.y)


def lists2Points(lists: list):
    result = []
    for ls in lists:
        result.append(Point(ls[0], ls[1]))
    return result
