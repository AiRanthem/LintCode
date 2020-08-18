package src.split_string_680;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    List<List<String>> split;
    String s;

    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        split = new ArrayList<>();
        this.s = s;
        Stack<String> cur = new Stack<>();
        helper(cur, 0);
        return split;
    }

    public void helper(Stack<String> cur, int pos) {
        if (pos >= s.length()) {
            ArrayList<String> ans = new ArrayList<>(cur.size());
            ans.addAll(cur);
            split.add(ans);
            return;
        }
        // +1
        String temp = s.substring(pos, pos + 1);
        cur.push(temp);
        helper(cur, pos+1);
        cur.pop();
        // +2
        if (pos + 1 < s.length()){
            temp = s.substring(pos, pos + 2);
            cur.push(temp);
            helper(cur, pos+2);
            cur.pop();
        }
    }
}