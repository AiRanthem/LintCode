from TestUtil import Test

"""
给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞具有一个初始状态 live（1）即为活细胞， 或 dead（0）即为死细胞。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：

如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
"""


class Solution:
    board = None

    def getAliveNeighbourNum(self, x, y):
        board = self.board
        up = max(0, x - 1)
        right = min(len(board[0]) - 1, y + 1)
        left = max(0, y - 1)
        down = min(len(board) - 1, x + 1)

        lives = 0
        for row in range(up, down+1):
            for col in range(left, right+1):
                if row == x and col == y:
                    continue
                if board[row][col] == 1 or board[row][col] == 3:
                    lives += 1
        return lives

    """
    @param board: the given board
    @return: nothing
    
    通过二进制最后两位来表示当前状态和未来状态：
    
        0: 00, d->d
        1: 01, l->d
        2: 10, d->l
        3: 11, l->l

    那么更新完之后只需要
    0->0, 1->0, 2->1, 3->1
    """

    def gameOfLife(self, board):
        self.board = board
        # update
        for x in range(len(board)):
            for y in range(len(board[0])):
                num = self.getAliveNeighbourNum(x, y)
                # 如果活细胞
                if board[x][y] == 1 or board[x][y] == 3:
                    # 周围八个位置的活细胞数少于两个，或有超过三个活细胞则该位置活细胞死亡；
                    if num < 2 or num > 3:
                        board[x][y] = 1
                    # 周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
                    else:
                        board[x][y] = 3
                # 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
                else:
                    if num == 3:
                        board[x][y] = 2
        # merge
        for x in range(len(board)):
            for y in range(len(board[0])):
                board[x][y] >>= 1

        return board


if __name__ == '__main__':
    test = Test(Solution())
    cases = [[
        [0, 1, 0],
        [0, 0, 1],
        [1, 1, 1],
        [0, 0, 0]
    ]]
    test.run(cases, 'gameOfLife')
