class Solution:
    def longestIncreasingSubsequence(self, a):
        """
        排序后的nums与nums取最长公共子序列长度即可
        @param a An integer array
        @return: The length of LIS (longest increasing subsequence)
        """
        if not a:
            return 0
        # 排序 O(n*log(n))
        sa = sorted(a)
        # 去重 O(n)
        cur = sa[0]
        b = [cur]
        for na in sa[1:]:
            if cur != na:
                b.append(na)
                cur = na
        # DP O(n)
        dp = [[0 for _ in range(1 + len(b))] for _ in range(1 + len(a))]
        # dp[i][j] a[:i] 与 b[:j] 最长公共子序列长度
        for i in range(len(a)):
            for j in range(len(b)):
                if a[i] == b[j]:
                    dp[i + 1][j + 1] = dp[i][j] + 1
                else:
                    dp[i + 1][j + 1] = max(dp[i][j + 1], dp[i + 1][j])
        return dp[len(a)][len(b)]


from TestUtil import Test

if __name__ == '__main__':
    test = Test(Solution())
    cases = [[-2, -1, 2, 5, 6, 7]]
    test.run(cases, 'longestIncreasingSubsequence')
