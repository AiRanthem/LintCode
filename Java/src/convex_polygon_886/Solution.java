package src.convex_polygon_886;

public class Solution {
    /**
     * 相邻两条边做向量叉乘，如果z分量正负变了说明拐向变了（右手法则）
     * (u1, u2, u3) x (v1, v2, v3) = (u2v3 - u3v2 , u3v1 - u1v3 , u1v2 - u2v1)
     * 由于叉积具有反交换性，所以要按照边给的顺序来算。
     * @param point: a list of two-tuples
     * @return a boolean, denote whether the polygon is convex
     */
    public boolean isConvex(int[][] point) {
        int length = point.length;
        int u1 = point[0][0] - point[length-1][0];
        int u2 = point[0][1] - point[length-1][1];
        int v1 = point[1][0] - point[0][0];
        int v2 = point[1][1] - point[0][1];
        int z = u1 * v2 - u2 * v1;
        int positive = 0;
        positive = z > 0 ? 1 : z < 0 ? -1 : positive;

        for (int i = 1; i < length - 1; i++) {
            u1 = v1;
            u2 = v2;
            v1 = point[i+1][0] - point[i][0];
            v2 = point[i+1][1] - point[i][1];
            z = u1 * v2 - u2 * v1;
            if(z == 0) continue;
            if(z * positive < 0) return false;
            positive = z > 0 ? 1 : z < 0 ? -1 : positive;
        }

        return true;
    }
}
