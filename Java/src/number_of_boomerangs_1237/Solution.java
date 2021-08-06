package src.number_of_boomerangs_1237;

import java.util.HashMap;

public class Solution {
    /**
     * 在平面中给定n个点，每一对点都是不同的，“回旋镖”是一个点的的元组 (i, j, k)，其中 i 和 j 之间的距离与i和k之间的距离相同 （元组的顺序是重要的）。
     * 找到回旋镖的数量。 您可以假设n最多为500并且点的坐标都在 [-10000, 10000] （包括）范围内。
     *
     * 解法：
     * 1. 计算两两距离矩阵
     * 2. 遍历距离矩阵每一行，统计每种距离出现次数
     * 3. 如果一个距离出现了x次，那么会有x!个回旋镖出现
     * @param points: a 2D array
     * @return the number of boomerangs
     */
    public int numberOfBoomerangs(int[][] points) {
        double[][] distMatrix = new double[points.length][points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                distMatrix[i][j] = distance(points[i], points[j]);
                distMatrix[j][i] = distMatrix[i][j];
            }
        }

        int res = 0;
        for (double[] dists : distMatrix) {
            HashMap<Double, Integer> map = new HashMap<>(dists.length);
            for (double dist : dists) {
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            for (Integer currency : map.values()) {
                if (currency > 1) {
                    res += fact(currency) / fact(currency - 2);
                }
            }
        }

        return res;
    }

    public double distance(int[] a, int[] b) {
        return Math.pow(b[0] - a[0], 2) + Math.pow(b[1] - a[1], 2); // sqrt is not necessary 'cause 10000^2 is smaller than MAX_DOUBLE
    }

    public int fact(int x) {
        if (x <= 1) {
            return 1;
        }
        int res = x;
        for (int i = 2; i < x; i++) {
            res *= i;
        }
        return res;
    }
}
