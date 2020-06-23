package src.find_diff_1266;

public class Solution {
    /**
     * @param s: a string
     * @param t: a string
     * @return the letter that was added in t
     */
    public char findTheDifference(String s, String t) {
        int[][] counter = new int[2][26];
        for (int i = 0; i < s.length(); i++) {
            counter[0][s.charAt(i) - 'a'] ++;
            counter[1][t.charAt(i) - 'a'] ++;
        }
        counter[1][t.charAt(t.length()-1)]++;
        for (int i = 0; i < s.length(); i++) {
            if(counter[0][i] != counter[1][i])
                return (char) (i+'a');
        }
        return t.charAt(t.length() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char ret = solution.findTheDifference("abcd", "abcde");
        System.out.println("ret = " + ret);
    }
}
