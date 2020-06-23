from Python.TestUtil import Test

"""
我们有一个栅栏，它有n个柱子，现在要给柱子染色，有k种颜色可以染。
必须保证不存在超过2个相邻的柱子颜色相同，求有多少种染色方案。

思路：
    如果第n个柱子和前面的颜色不一样，有k-1种颜色，前面有dp[n-1]种，所以有dp[n-1]*(k-1)种
    如果和前面的一个颜色一样，那么相当于和n-2颜色不一样连续两个，则有dp[n-2]*(k-1)种
    两种显然是互斥的，做加法即可。
"""


class Solution:

    def numWays(self, n, k):
        """
        @param n: non-negative integer, n posts
        @param k: non-negative integer, k colors
        @return: an integer, the total number of ways
        """
        # dp[i] = i个柱子最多方案
        dp = [0 for i in range(n+2)]
        dp[1] = k
        dp[2] = k * k
        for i in range(3, n+1):
            dp[i] = dp[i-1]*(k-1) + dp[i-2]*(k-1)
        return dp[n]


if __name__ == '__main__':
    test = Test(Solution())
    cases = [(1, 1), (3, 2), (2, 2)]
    test.run(cases, 'numWays')
