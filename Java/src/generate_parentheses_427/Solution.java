package src.generate_parentheses_427;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int n;
    private final ArrayList<String> res = new ArrayList<>();

    /**
     * @param n: n pairs
     * @return res: All combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        this.n = n;
        helper("", 0, 0);
        return res;
    }

    private void helper(String string, int left, int right) {
        if (left == n && right == n) {
            res.add(string);
            return;
        }
        if (left < n) {
            helper(string + '(', left + 1, right);
        }
        if (left > right) {
            helper(string + ')', left, right + 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.generateParenthesis(2);
        for (String string : strings){
            System.out.println(string);
        }
    }
}