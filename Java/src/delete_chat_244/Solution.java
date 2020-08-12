package src.delete_chat_244;

public class Solution {
    /**
     * @param str: the string
     * @param k:   the length
     * @return: the substring with  the smallest lexicographic order
     */
    public String deleteChar(String str, int k) {
        int start = 0;
        final int end = str.length() - 1;
        StringBuilder res = new StringBuilder();
        while (k != 0) {
            char small = Character.MAX_VALUE;
            int idx = 0;
            for (int i = start; i <= end - k + 1; i++) {
                char c = str.charAt(i);
                if (c < small) {
                    small = c;
                    idx = i;
                }
            }
            res.append(small);
            start = idx + 1;
            k--;
        }
        return res.toString();
    }
}
