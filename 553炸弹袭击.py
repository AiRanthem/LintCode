from TestUtil import Test


class Solution:
    LEFT = 1
    RIGHT = -1
    UP = 2
    DOWN = -2
    """
    @param grid: Given a 2D grid, each cell is either 'W', 'E' or '0'
    @return: an integer, the maximum enemies you can kill using one bomb
    """

    def maxKilledEnemies(self, grid: list) -> int:
        grid = list(map(list, grid))
        if not grid or not grid[0]:
            return 0
        n_rows = len(grid)
        n_cols = len(grid[0])

        kills = [[0 for i in range(n_cols)] for j in range(n_rows)]
        for i in range(n_rows):
            for j in range(n_cols):
                if grid[i][j] == '0':
                    sizhou = self.scan(grid, self.UP, i, j, n_rows, n_cols) + \
                             self.scan(grid, self.DOWN, i, j, n_rows, n_cols) + \
                             self.scan(grid, self.LEFT, i, j, n_rows, n_cols) + \
                             self.scan(grid, self.RIGHT, i, j, n_rows, n_cols)
                    kills[i][j] = sizhou if (grid[i][j] != 'E') else sizhou + 1
        return max(x for row in kills for x in row)

    def scan(self, grid, direction, x, y, n_rows, n_cols):
        n = 0
        if direction == self.UP:
            i = x - 1
            while i >= 0:
                if grid[i][y] == 'W':
                    break
                if grid[i][y] == 'E':
                    n += 1
                i -= 1

        elif direction == self.LEFT:
            i = y - 1
            while i >= 0:
                if grid[x][i] == 'W':
                    break
                if grid[x][i] == 'E':
                    n += 1
                i -= 1

        elif direction == self.DOWN:
            for i in range(x + 1, n_rows):
                if grid[i][y] == 'W':
                    break
                if grid[i][y] == 'E':
                    n += 1

        elif direction == self.RIGHT:
            for i in range(y + 1, n_cols):
                if grid[x][i] == 'W':
                    break
                if grid[x][i] == 'E':
                    n += 1

        return n


if __name__ == '__main__':
    test = Test(Solution())
    cases = [["E"]]
    test.run(cases, 'maxKilledEnemies')
