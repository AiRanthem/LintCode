"""
假设你有 N 个从 1 到 N 的整数。我们将一个美丽的排列定义为：如果一个数组由这给出的 N 个整数构成，
且满足下列任意一个条件对此数组中的第i个位置（1 <= i <= N）的要求，则这个数组为美丽的排列：
    第 i 个 位置的元素可以被 i 整除。
    i 可以被第 i 个元素整除。
现在给出 N，你可以构造出多少美丽的排列？

算法思路：使用array，初始化为0表示最终的”美丽排列“

遍历array的每一个位置，如果这个位置是0（就是空闲，能放）且该数字在这个位置”美丽“，则放在这个位置
递归下一个数字，直到生成一个“美丽”序列，count++
返回后把array该位置的值置为1，继续下一个位置
"""

from TestUtil import Test


class Solution:
    count = 0
    array = None
    """
    @param N: The number of integers
    @return: The number of beautiful arrangements you can construct
    """

    def countArrangement(self, N):
        # init
        self.array = [0 for i in range(N)]
        self.count = 0
        # recursion
        self.helper(N)
        return self.count

    def helper(self, N):
        # output
        if N == 0:
            self.count += 1
            return

        # recur
        for i in range(len(self.array)):
            if self.array[i] == 0 and ((i + 1) % N == 0 or N % (i + 1) == 0):
                self.array[i] = N
                self.helper(N - 1)
                self.array[i] = 0


if __name__ == '__main__':
    test = Test(Solution())
    cases = [1,2,3]
    test.run(cases, 'countArrangement')
