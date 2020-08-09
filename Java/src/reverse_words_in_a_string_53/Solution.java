package src.reverse_words_in_a_string_53;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    /**
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        Scanner scanner = new Scanner(s);
        while (scanner.hasNext()) {
            String next = scanner.next();
            stack.push(next);
        }
        StringBuilder sb = new StringBuilder();
        if (!stack.empty())
            sb.append(stack.pop());
        while (!stack.empty()) {
            sb.append(' ');
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
