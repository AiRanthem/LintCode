package src.regex_match_154;

public class Solution {
    private boolean[][] memo, visited;
    private String s, p;

    /**
     * @param s: A string
     * @param p: A string includes "." and "*"
     * @return A boolean
     */
    public boolean isMatch(String s, String p) {
        memo = new boolean[s.length()][p.length()];
        visited = new boolean[s.length()][p.length()];
        this.s = s;
        this.p = p;
        return helper(0, 0);
    }

    /**
     * dfs search
     *
     * @param sIndex index in s
     * @param pIndex index in p
     * @return whether s[sIndex:] matches p[pIndex:]
     */
    public boolean helper(int sIndex, int pIndex) {
        if (pIndex >= p.length()) {
            // p finished, s have to finish.
            return sIndex == s.length();
        }
        if (sIndex >= s.length()) {
            // s finished
            return emptyMatch(pIndex);
        }
        if (visited[sIndex][pIndex]){
            // visited by a search before
            return memo[sIndex][pIndex];
        }

        boolean match;
        char sChar = s.charAt(sIndex);
        char pChar = p.charAt(pIndex);
        if (pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*') {
            match = helper(sIndex, pIndex + 2) || // not match this
                    (charMatch(sChar, pChar) && helper(sIndex + 1, pIndex)); // match this
        } else {
            match = charMatch(sChar, pChar) && helper(sIndex + 1, pIndex + 1);
        }

        // record
        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = match;
        return match;
    }

    public boolean charMatch(char sChar, char pChar) {
        return pChar == '.' || pChar == sChar;
    }

    /**
     * p matches an empty string when and only when it's like "x*x*x*"
     * where char 'x' represents to any character including '.'
     *
     * @param index pIndex
     * @return whether p[index:] matches an empty string
     */
    public boolean emptyMatch(int index) {
        if ((p.length() - index) % 2 == 1) return false;
        index += 1; // goto '*'
        while (index < p.length()) {
            if (p.charAt(index) != '*') return false;
            index += 2;
        }
        return true;
    }
}