package src.fetch_supplies_ii_1899;

public class Solution {
    /**
     * 在一个二维地图上有很多军营，每个军营的坐标为(x,y)，现在你要在x轴上设置一个补给站，补给站不一定要在整点上，现在想让军营到补给站的距离的最大值最小。请问最小的最大距离是多少。
     * 兵营的数量小于等于10^4
     * 坐标(x,y)保证绝对值小于10000
     * <p>
     * 思路：三分法搜索。
     * 假设所求点为(m, 0)，可以证明距离最大值是在m处取全局唯一极小值的先递减再递增函数。
     * 在备选区间[l, r]上，取两个点a, b（可以是三等分点）将区间分成三份。设max(x)为点(x, 0)处的距离最大值。
     * 如果max(a) > max(b)，那么一定有 m > a > l
     * 如果max(a) <= max(b)，那么一定有 m <= b < r
     * 目标精度取10^-6，当r - l小于精度时取l的值为m。
     * 为了实现方便，不采用三等分点，而是使用二等分点和3/4等分点充当两个分割点。
     *
     * @param barracks: the position of barracks
     * @return the minimum of the maximum of the distance
     */
    public double fetchSuppliesII(int[][] barracks) {
        double l = -10000, r = 10000, mida, midb;
        while (r - l >= 0.00000001) {
            mida = (l + r) / 2;
            midb = (mida + r) / 2;
            if (maxDist(mida, barracks) > maxDist(midb, barracks)) {
                l = mida;
            } else {
                r = midb;
            }
        }
        return Math.sqrt(maxDist(l, barracks));
    }

    public double maxDist(double x, int[][] barracks) {
        // will not perform sqlt as 10000 * 10000 is always smaller than Double.MAX_VALUE for better performance
        double max = 0;
        for (int[] barrack : barracks) {
            max = Math.max(
                    max,
                    (barrack[0] - x) * (barrack[0] - x) + barrack[1] * barrack[1]
            );
        }
        return max;
    }
}