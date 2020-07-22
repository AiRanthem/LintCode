package src.unique_substrings_in_wraparound_string_1223;
public class Solution {
    /**
     * stat the max lenth of eligible substrings end with each alphabeta
     * e.g. end_with['e'] = 3 that means there 3 unique substrings:
     * "e", "de", "cde"
     * so, sum(end_with) is the answer
     * @param p: the given string
     * @return the number of different non-empty substrings of p in the string s
     */
    public int findSubstringInWraproundString(String p) {
        int[] end_with = new int[26]; // end_with[i] = the max len of eligible substring end with i + 'a'
        int cur_len = 0;
        char char_before = '0'; // a char will never occur in p as the start

        // build
        for (int i = 0; i < p.length(); i++) {
            char char_cur = p.charAt(i);
            if (isNext(char_before, char_cur)) {
                cur_len++;
            } else {
                cur_len = 1;
            }
            if (cur_len > end_with[char_cur - 'a']) {
                end_with[char_cur - 'a'] = cur_len;
            }
            char_before = char_cur;
        }
        int result = 0;
        for (int i : end_with) {
            result+=i;
        }
        return result;
    }

    public boolean isNext(char before, char c) {
        return before == 'z' ? c == 'a' : c == before + 1;
    }
}