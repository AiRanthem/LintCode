package src.interleaving_string_29;

public class Solution {
    private int[][] dp;

    /**
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        if (s1.length() == 0) return s2.equals(s3);
        if (s2.length() == 0) return s1.equals(s3);

        /*
          dp[i][j] 表示第s1的前i位和s2的前j位能否组成s3的前i+j位
         */
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            dp[i+1][0] = s1.charAt(i) == s3.charAt(i);
        }
        for (int i = 0; i < s2.length(); i++) {
            dp[0][i+1] = s2.charAt(i) == s3.charAt(i);
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                boolean s1_ok = s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j];
                boolean s2_ok = s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1];
                dp[i][j] = s1_ok || s2_ok;
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
