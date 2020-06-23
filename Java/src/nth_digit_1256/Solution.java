package src.nth_digit_1256;

public class Solution {
    /**
     * @param n: a positive integer
     * @return the nth digit of the infinite integer sequence
     */
    public int findNthDigit(int n) {
        if (n < 10) return n;
        long cur_num = 10; // 当前开始的数字
        long len = 2;    // 位数
        long n_nums = 90;     // 当前位数下数字的总数
        n -= 9;
        while (n > len * n_nums) {
            // 定位到符合的位数
            n -= n_nums * len;
            cur_num *= 10;
            len += 1;
            n_nums *= 10;
        }
        cur_num += (n - 1) / len;
        n = (int) ((n-1) % len) + 1;
//        while (n > len) {
//            // 定位到第n个数位属于的数字
//            n -= len;
//            cur_num++;
//        }
        return (int) ((cur_num / Math.pow(10, (len-n))) % 10);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int nthDigit = solution.findNthDigit(971335639);
        System.out.println("nthDigit = " + nthDigit);
    }
}
