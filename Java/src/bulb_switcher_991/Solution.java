package src.bulb_switcher_991;

public class Solution {
    /**
     * 第k回合，第i个灯泡，当且仅当 i%k==0 该灯泡会被切换
     * 非平方数，有偶数个因子，会 i%k==0 偶数次，所以最后会被关闭
     * 完全平方数则会被打开
     * 即找小于等于n的完全平方数的数量
     *
     * @param n: a Integer
     * @return how many bulbs are on after n rounds
     */
    public int bulbSwitch(int n) {
        if (n == 0) return 0;
        int i = 1;
        while (i * i <= n) {
            i++;
        }
        return i - 1;
    }
}
