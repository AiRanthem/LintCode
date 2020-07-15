package src.stat_number_3;

public class Solution {
    /**
     * @param k: An integer
     * @param n: An integer
     * @return An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        int cnt = 0;
        for (int i = k; i <= n; i++) {
            cnt += singleCounts(k, i);
        }
        return cnt;
    }

    /**
     * 一个数n中k出现几次
     */
    public int singleCounts(int k, int n) {
        if (n == 0 && k == 0) return 1;
        int cnt = 0;
        while (n > 0) {
            if (n % 10 == k) cnt++;
            n /= 10;
        }
        return cnt;
    }
}
