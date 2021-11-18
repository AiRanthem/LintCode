package src.sum_of_two_strings_1343;

public class Solution {
    /**
     * @param A: a string
     * @param B: a string
     * @return return the sum of two strings
     */
    public String SumofTwoStrings(String A, String B) {
        if (A.length() < B.length()) {
            return SumofTwoStrings(B, A);
        }
        int diffLen = A.length() - B.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < diffLen; i++) {
            sb.append(A.charAt(i));
        }
        for (int i = 0; i < B.length(); i++) {
            sb.append(
                    A.charAt(i + diffLen) - '0' + B.charAt(i) - '0'
            );
        }
        return sb.toString();
    }
}