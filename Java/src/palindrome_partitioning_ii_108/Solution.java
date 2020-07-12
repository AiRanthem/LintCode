package src.palindrome_partitioning_ii_108;

public class Solution {
    /**
     * @param s: A string
     * @return An integer
     */
    public int minCut(String s) {
        if (s.length() == 0) return 0;
        boolean[][] isPalindrome = getIsPalindrome(s);
        int[] dp = new int[s.length() + 1];
        dp[0] = -1;
        for (int i = 1; i < s.length(); i++) {
            int min = 10000;
            for (int j = i; j >= 0; j--) {
                if (isPalindrome[j][i] && 1 + dp[j] < min) {
                    min = 1 + dp[j];
                }
            }
            dp[i + 1] = min;
        }
        return dp[s.length()];
    }

    private boolean[][] getIsPalindrome(String s) {
        int len = s.length();
        boolean[][] isPalindrome = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            // offset = 0
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < len - 1; i++) {
            // offset = 1
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        for (int offset = 2; offset < len; offset++) {
            // offset >= 2
            for (int i = 0; i + offset < len; i++) {
                isPalindrome[i][i + offset] = (isPalindrome[i + 1][i + offset - 1] && s.charAt(i) == s.charAt(i + offset));
            }
        }
        return isPalindrome;
    }
}
