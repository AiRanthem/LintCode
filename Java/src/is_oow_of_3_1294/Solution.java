package src.is_oow_of_3_1294;

/**
 * 设 n = m ^ k ，k in Q 有
 * lg(n) / lg(m) = lg(m^k) / lg(m) = klg(m) / lg(m) = k
 * k in Z 则满足题意。
 */

public class Solution {
    /**
     * @param n: an integer
     * @return if n is a power of three
     */
    public boolean isPowerOfThree(int n) {
        if(n < 1){
            return false;
        }
        return Math.log10(n)/Math.log10(3) % 1 == 0;
    }
}
