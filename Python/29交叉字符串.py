class Solution:
    def isInterleave(self, s1, s2, s3):
        """
        dp[i][j] 为 s1[:i] s2[:j] 能否组成 s3[:i+j]
        dp[i][j] = True 必须满足以下一条
            dp[i][j-1] and s2[j-1] == s3[i+j-1]
            dp[i-1][j] and s1[i-1] == s3[i+j-1]
        @param s1: A string
        @param s2: A string
        @param s3: A string
        @return: Determine whether s3 is formed by interleaving of s1 and s2
        """
        if len(s1) < len(s2):
            s1, s2 = s2, s1
        if not s2:
            return s1 == s3
        dp = [[False for _ in range(len(s2) + 1)] for _ in range(len(s1) + 1)]
        if s1[0] == s3[0]:
            dp[1][0] = True
        if s2[0] == s3[0]:
            dp[0][1] = True

        for i in range(len(s1) + 1):
            for j in range(len(s2) + 1):
                if dp[i][j - 1] and s2[j - 1] == s3[i + j - 1]:
                    dp[i][j] = True
                elif dp[i - 1][j] and s1[i - 1] == s3[i + j - 1]:
                    dp[i][j] = True

        return dp[len(s1)][len(s2)]


from TestUtil import Test

if __name__ == '__main__':
    test = Test(Solution())
    cases = [("", "", "")]
    test.run(cases, 'isInterleave')
