from common import *


class Solution:
    n_cols, n_rows = 0, 0
    parent = []
    islands = 0
    pos = -1

    def numIslands2(self, n, m, operators: list):
        """
        @param n: n_rows
        @param m: n_cols
        @param operators: an array of point
        @return: an integer array
        """
        # write your code here
        self.parent = [-1 for _ in range(m * n)]
        self.islands = 0
        self.n_cols, self.n_rows = m, n

        results = []

        operator: Point
        for operator in operators:
            x, y = operator.x, operator.y
            self.pos = self.serialize(x, y)
            if self.parent[self.pos] == -1:
                self.islands += 1
                self.parent[self.pos] = self.pos
                if x > 0:
                    self.merge_with_neighbour(x - 1, y)
                if y > 0:
                    self.merge_with_neighbour(x, y - 1)
                if x < self.n_rows - 1:
                    self.merge_with_neighbour(x + 1, y)
                if y < self.n_cols - 1:
                    self.merge_with_neighbour(x, y + 1)
            results.append(self.islands)

        return results

    def serialize(self, x, y):
        return x * self.n_cols + y

    def merge(self, par_a, par_b):
        for i, pos in enumerate(self.parent):
            if pos == par_b:
                self.parent[i] = par_a
        self.islands -= 1

    def merge_with_neighbour(self, x, y):
        n_pos = self.serialize(x, y)
        if self.parent[n_pos] != -1 and self.parent[n_pos] != self.parent[self.pos]:
            self.merge(self.parent[n_pos], self.parent[self.pos])


from TestUtil import Test

if __name__ == '__main__':
    test = Test(Solution())

    cases = [(3, 3, lists2Points([[0, 0], [0, 1], [2, 2], [2, 2]]))]
    test.run(cases, 'numIslands2')
