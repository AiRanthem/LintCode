package src.number_of_islands2_434;

import src.utils.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private int n_rows, n_cols, parts;
    private int[] pre;

    /**
     * @param n:         An integer
     * @param m:         An integer
     * @param operators: an array of point
     * @return res: an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> res = new ArrayList<Integer>();
        this.n_rows = n;
        this.n_cols = m;
        this.parts = 0;
        if (operators == null) {
            return res;
        }

        pre = new int[m * n]; // x的父节点是pre[x], 有且仅有根节点r: r=pre[r]
        Arrays.fill(pre, -1); // 初始化-1为空

        for (Point point :
                operators) {
            int pos = serialize(point.x, point.y);
            // 以自己为root建立一个新的部
            if(pre[pos] == -1) {
                pre[pos] = pos;
                parts++;
            }
            // 与四周的合并
            if (point.x > 0) {
                // 查看上邻, npos = neighbour position
                int npos = serialize(point.x - 1, point.y);
                merge_with_neighbours(npos, pos);
            }
            if (point.y > 0) {
                // 左
                int npos = serialize(point.x, point.y - 1);
                merge_with_neighbours(npos, pos);
            }
            if (point.y < n_cols - 1) {
                // 右
                int npos = serialize(point.x, point.y + 1);
                merge_with_neighbours(npos, pos);
            }
            if (point.x < n_rows - 1) {
                // 下
                int npos = serialize(point.x + 1, point.y);
                merge_with_neighbours(npos, pos);
            }
            // 记录当前部数
            res.add(parts);
        }
        return res;
    }

    /**
     * 将二维坐标线性化为一维坐标
     *
     * @param x 横坐标
     * @param y 纵坐标
     * @return 一维坐标
     */
    private int serialize(int x, int y) {
        return n_cols * x + y;
    }

    /**
     * 两个部进行融合,后面的部归入前面的部
     *
     * @param p1 部1的root
     * @param p2 部2的root
     */
    private void merge(int p1, int p2) {
        for (int i = 0; i < pre.length; i++) {
            if (pre[i] == p2) {
                pre[i] = p1;
            }
        }
    }

    private void merge_with_neighbours(int npos, int pos){
        if (pre[npos] != -1 && pre[npos] != pre[pos]) {
            merge(pre[npos], pre[pos]);
            parts--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Point[] operators = {
                new Point(0,0),
                new Point(0,1),
                new Point(2,2),
                new Point(2,1)
        };
        List<Integer> res = solution.numIslands2(3, 3, operators);
        for (int x :
                res) {
            System.out.println(x);
        }
    }
}
