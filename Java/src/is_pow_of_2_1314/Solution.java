package src.is_pow_of_2_1314;

public class Solution {
    /**
     * @param n: an integer
     * @return if n is a power of two
     */
    public boolean isPowerOfTwo(int n) {
        if(n < 1){
            return false;
        }
        return (n & (n - 1))==0;
    }
}
