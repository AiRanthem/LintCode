class Solution:
    def minCut(self, s: str):
        """
        @param s: A string
        @return: An integer
        """
        s = ' ' + s
        n = len(s)
        dp = [-1 for _ in range(n + 1)]
        for right in range(1, n + 1):
            to_choose = []
            for left in range(1, right + 1):
                temp = s[left:right + 1]
                if temp == temp[::-1]:
                    to_choose.append(dp[left - 1])
            dp[right] = 1 + min(to_choose)
        return dp[n]


from TestUtil import Test

if __name__ == '__main__':
    test = Test(Solution())
    cases = ["cabababcbc"]
    test.run(cases, 'minCut')
