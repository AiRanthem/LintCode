package src.find_nth_digit_1256;

import java.math.BigInteger;

public class Solution {
    /**
     * 找出无限正整数数列1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中的第n个数位。
     * <p>
     * 找规律：
     * 一位数 9个，共9位
     * 二位数 9 * 10 = 90个，共2 * 90 = 180位
     * 三位数 9 * 10 * 10 = 900个，共3 * 900 = 2700位
     * 因此，X位数会占 X * 9 * 10^(X-1) 位
     * 对于X位数列的第i位，首先通过i/X+1得出这个数字是几，然后通过i%X得出这一位是几。
     * <p>
     * 首先X设置为1，通过n不停减X * 9 * 10^(X-1)来定位到n是几位数列的第几位。
     * 然后通过n/X+1和n%X求解。
     *
     * @param n: a positive integer
     * @return the nth digit of the infinite integer sequence
     */
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        int x = 1;
        BigInteger maxDigit = BigInteger.valueOf(9);
        BigInteger bign = BigInteger.valueOf(n);
        int factor = 1;
        while (bign.compareTo(maxDigit) > 0) {
            bign = bign.subtract(maxDigit);
            x++;
            factor = Math.max(10, factor * 10);
            maxDigit = BigInteger.valueOf((long) x * 9 * factor);
        }
        n = bign.intValue();
        int whichNumber = (n - 1) / x + factor;
        int whichDigit = n % x == 0 ? 1 : x - n % x + 1; // from right
        while (whichDigit > 1) {
            whichNumber /= 10;
            whichDigit--;
        }
        return whichNumber % 10;
    }
}
