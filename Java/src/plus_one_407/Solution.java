package src.plus_one_407;

public class Solution {
    /**
     * @param digits: a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        boolean plus = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (plus)
            {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i] += 1;
                    plus = false;
                }
            }
        }
        if(digits[0] == 0){
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            return ret;
        }
        return digits;
    }
}
