package src.graph_valid_tree_178;

public class Solution {
    /**
     * @param n:     An integer
     * @param edges: a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        if (n > edges.length + 1) return false; // requirement

        int[] D = new int[n];
        int[][] A = new int[n][n];
        for (int[] edge : edges) {
            D[edge[0]]++;
            D[edge[1]]++;
            A[edge[0]][edge[1]] = A[edge[1]][edge[0]] = 1;
        }

        int[] nodes = new int[n];
        int[] leaves = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = 1;
        }

        while (true) {
            // update leaves
            for (int i = 0; i < n; i++) {
                if (nodes[i] == 1 && D[i] == 1) leaves[i] = 1;
                else leaves[i] = 0;
            }
            int n_nodes = sum(nodes);
            int n_leaves = sum(leaves);
            if(n_leaves == 0){
                return n_nodes == 0 || n_nodes == 1;
            }
            // iter leaves
            for (int i = 0; i < n; i++) {
                if (leaves[i] == 1) {
                    // remove them from node set
                    nodes[i] = 0;
                    // dec parent nodes' degree
                    for (int j = 0; j < n; j++) {
                        if (A[i][j] == 1) {
                            D[j]--;
                        }
                    }
                }
            }
        }

    }

    public int sum(int[] D) {
        int sum = 0;
        for (int i : D) {
            sum += i;
        }
        return sum;
    }
}
