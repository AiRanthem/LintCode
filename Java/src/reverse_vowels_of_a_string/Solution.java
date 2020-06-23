package src.reverse_vowels_of_a_string;

public class Solution {
    /**
     * @param s: a string
     * @return reverse only the vowels of a string
     */
    public String reverseVowels(String s) {
        int l = 0, r = s.length() - 1;
        boolean foundl = false, foundr = false;

        char[] chars = s.toCharArray();

        while (l < r) {
            foundl = isVowel(chars[l]);
            foundr = isVowel(chars[r]);
            if (foundl && foundr) {
                char tmp = chars[l];
                chars[l] = chars[r];
                chars[r] = tmp;
                foundl = foundr = false;
            }
            if (!foundl) l++;
            if (!foundr) r--;
        }
        return new String(chars);
    }

    private boolean isVowel(char c) {
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (char vowel : vowels) {
            if (c == vowel) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String ret = solution.reverseVowels("lintcode");
        System.out.println("ret = " + ret);
    }
}