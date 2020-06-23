package src.pow_x_n_428;

/**
 * 这题中，给出的n可能比minint还要小1，所以要战术性+1.
 */
public class Solution {
    /**
     * @param x: the base number
     * @param n: the power number
     * @return res: the result
     */
    public double myPow(double x, int n) {
        // x^n = x^(n/2) * x^(n/2)
        boolean isNegative = false;
        if (n < 0) {
            n = -(n+1);
            x = 1 / x;
            isNegative = true;
        }
        double res = 1, tmp=x;
        while (n != 0) {
            if (n % 2 == 1) {
                res *= tmp;
            }
            tmp *= tmp;
            n /= 2;
        }
        if (isNegative){
            res *= x;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        double v = solution.myPow(2, 4);
        System.out.println(v);
    }
}
