from Python.TestUtil import Test


class Solution:
    """
    @param grid: Given a 2D grid, each cell is either 'W', 'E' or '0'
    @return: an integer, the maximum enemies you can kill using one bomb
    """

    def maxKilledEnemies(self, grid: list) -> int:
        m, n = len(grid), 0
        if m:
            n = len(grid[0])

        cols = [0 for i in range(n)]
        rows = 0

        result = 0

        for i in range(m):
            for j in range(n):
                # scan row from wall
                if j == 0 or grid[i][j - 1] == 'W':
                    rows = 0
                    for k in range(j, n):
                        if grid[i][k] == 'W':
                            break
                        if grid[i][k] == 'E':
                            rows += 1

                # scan col from wall
                if i == 0 or grid[i - 1][j] == 'W':
                    cols[j] = 0
                    for k in range(i, m):
                        if grid[k][j] == 'W':
                            break
                        if grid[k][j] == 'E':
                            cols[j] += 1

                # see if is best
                if grid[i][j] == '0' and cols[j] + rows > result:
                    result = cols[j] + rows
        return result


if __name__ == '__main__':
    test = Test(Solution())
    cases = [["E0"]]
    test.run(cases, 'maxKilledEnemies')
