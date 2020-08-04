package src.repeated_substring_pattern_1227;

public class Solution {
    /**
     * @param s: a string
     * @return return a boolean
     */
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length() / 2;
        while (len > 0){
            if(s.length() % len == 0){
                String pattern = s.substring(0, len);
                boolean ok = true;
                for (int i=len; i<s.length();i+=len){
                    String substring = s.substring(i, i + len);
                    if(!pattern.equals(substring)){
                        ok=false;
                        break;
                    }
                }
                if(ok) return true;
            }
            len--;
        }
        return false;
    }
}
