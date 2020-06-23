class Solution:
    """
    @param matrix: the given matrix
    @return: True if and only if the matrix is Toeplitz
    """
    # 按照题意枚举每条对角线
    def isToeplitzMatrix(self, matrix):
        T = list(map(list, zip(*matrix)))

        for i in range(len(T)-1):
            if not T[i][:-1] == T[i+1][1:]:
                return False

        return True


if __name__ == '__main__':
    matrix = [[1, 2, 3, 4], [5, 1, 2, 3], [9, 5, 1, 2]]
    solution = Solution()
    print(solution.isToeplitzMatrix(matrix))
