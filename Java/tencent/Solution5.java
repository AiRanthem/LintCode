package tencent;

import java.util.Scanner;

public class Solution5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int Q = scanner.nextInt(); // time of query
        int[][] isPalindrome = getPalindromeNum(s);
        for (int k = 0; k < Q; k++) {
            int l = scanner.nextInt() - 1;
            int r = scanner.nextInt() - 1;
            System.out.println(isPalindrome[l][r]);
        }
    }

    private static int[][] getPalindromeNum(String s) {
        int len = s.length();
        int[][] isPalindrome = new int[len][len];
        for (int i = 0; i < len; i++) {
            // offset = 0
            isPalindrome[i][i] = 1;
        }
        for (int i = 0; i < len - 1; i++) {
            // offset = 1
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1)) ? 1 : 2;
        }
        for (int offset = 2; offset < len; offset++) {
            // offset >= 2
            for (int i = 0; i + offset < len; i++) {
                if (isPalindrome[i + 1][i + offset - 1] == 1 && s.charAt(i) == s.charAt(i + offset)) {
                    isPalindrome[i][i + offset] = 1;
                } else {
                    int m = Integer.MAX_VALUE;
                    for (int j = i; j < i + offset; j++) {
                        m = Math.min(m, isPalindrome[i][j] + isPalindrome[j + 1][i + offset]);
                    }
                    isPalindrome[i][i + offset] = m;
                }

            }
        }
        return isPalindrome;
    }
}
