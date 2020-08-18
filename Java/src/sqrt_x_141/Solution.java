package src.sqrt_x_141;

public class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        long l = 0, r = x;
        while (l <= r){
            if (r - l <= 1) return (int) (r * r == x?r:l);
            long mid = (l+r)/2;
            long square = mid * mid;
            if (square == x) return (int) mid;
            if (square > x) r = mid;
            else l = mid;
        }
        return -1;
    }
}