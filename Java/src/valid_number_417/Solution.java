package src.valid_number_417;

public class Solution {
    String valid_chars = "1234567890.";
    /**
     * @param s: the string that represents a number
     * @return: whether the string is a valid number
     */
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0 || s.charAt(s.length()-1)=='e') return false;
        String[] split = s.split("e");
        if (split.length > 2 || split.length == 0) return false;
        if (split.length == 1) return check(split[0], true);
        else return check(split[0], true) && check(split[1], false);
    }

    public boolean check(String s, boolean dot){
        int length = s.length();
        // empty string
        if (length == 0) return false;
        // starts with simble
        int start = 0;
        char first = s.charAt(0);
        if (first == '+' || first == '-'){
            if (length == 1) return false;
            start = 1;
        }
        // iter
        for (int i = start; i < length; i++) {
            char c = s.charAt(i);
            if (valid_chars.indexOf(c) == -1) return false;
            if (c == '.'){
                // dot count
                if (dot) dot = false;
                else return false;
                // num count
                if (length == 1) return false;
            }
        }
        return true;
    }
}
