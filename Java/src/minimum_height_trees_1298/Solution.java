package src.minimum_height_trees_1298;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int n;
    int[] D;       // degree matrix
    boolean[][] A; // adjacent matrix
    List<Integer> res; // results
    List<Integer> queue; // BFS queue

    /**
     * 拓扑排序，看做由叶子节点向根的拓扑排序，按照这个顺序进行BFS，剪枝。
     *
     * @param n:     n nodes labeled from 0 to n - 1
     * @param edges: a undirected graph
     * @return a list of all the MHTs root labels
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // init
        this.n = n;
        D = new int[n];
        A = new boolean[n][n];
        queue=new ArrayList<>(n);

        // stat
        for (int[] edge : edges) {
            // degree
            D[edge[0]]++;
            D[edge[1]]++;
            A[edge[0]][edge[1]] = A[edge[1]][edge[0]] = true;
        }

        // iter BFS
        while (max(D) > 1) {
            findLeaves();
            // remove them
            for (Integer leaf : queue) {
                D[leaf]=-1;
                for (int i = 0; i < n; i++) {
                    if(A[leaf][i]){
                        D[i]--;
                    }
                }
            }
        }
        findLeaves();
        return queue;
    }

    public int max(int[] array) {
        int m = 0;
        for (int i : array) {
            if (i > m) m = i;
        }
        return m;
    }

    public void findLeaves(){
        queue.clear();
        for (int i = 0; i < n; i++) {
            if(D[i]==1 || D[i]==0) queue.add(i);
        }
    }

}
