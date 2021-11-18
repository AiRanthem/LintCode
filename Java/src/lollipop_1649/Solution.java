package src.lollipop_1649;

public class Solution {
    /**
     * 超人强和猪猪侠都进入了百米赛跑的决赛。猪猪侠的速度为v1,超人强的速度为v2,猪猪侠可以在比赛前吃至多一支超级棒棒糖，
     * 现在给定n种超级棒棒糖,第i种超级棒棒能让猪猪侠的速度提高si,而它的价格为wi.给定v1,v2,s,w,请问猪猪侠至少要花多少钱才能在百米赛跑中战胜超人强？
     * @param v1: the speed of GGbond
     * @param v2: the speed of SuperQ
     * @param s: the speed that lollipop can add
     * @param w: the cost of lollipop
     * @return the minimal price
     */
    public int getAns(int v1, int v2, int[] s, int[] w) {
        if (v1 > v2) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < s.length; i++) {
            if (v1 + s[i] > v2 && w[i] < ans) {
                ans = w[i];
            }
        }
        return ans;
    }
}
