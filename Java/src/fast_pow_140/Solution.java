package src.fast_pow_140;

public class Solution {
    /**
     * @param aa: A 32bit integer
     * @param b:  A 32bit integer
     * @param n:  A 32bit integer
     * @return a^n % b
     */
    public int fastPower(int aa, int b, int n) {
        if (b == 0) {
            return 0;
        }
        long a = aa;
        long res = 1;
        while (n > 0) {
            if ((n & 0b01) != 0) {
                res = res * a % b;
            }
            a = a * a % b;
            n >>= 1;
        }
        return (int) (res % b);
    }
}
