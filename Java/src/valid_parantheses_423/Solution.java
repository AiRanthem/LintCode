package src.valid_parantheses_423;

import java.util.Stack;

public class Solution {
    /**
     * @param s: A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.empty() || !pair(stack.pop(), c)) return false;
            }
        }
        return stack.empty();
    }

    public boolean pair(Character a, Character b) {
        return (a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}');
    }
}
