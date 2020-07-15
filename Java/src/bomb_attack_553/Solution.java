package src.bomb_attack_553;

public class Solution {
    /**
     * @param grid: Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0) return 0;
        int[] col = new int[grid[0].length];
        int row = 0;
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // scan row from wall
                if (j == 0 || grid[i][j - 1] == 'W') {
                    row = 0;
                    for (int k = j; k < grid[0].length; k++) {
                        if (grid[i][k] == 'E') row++;
                        if (grid[i][k] == 'W') break;
                    }
                }
                // scan col from wall
                if (i == 0 || grid[i - 1][j] == 'W') {
                    col[j] = 0;
                    for (int k = i; k < grid.length; k++) {
                        if (grid[k][j] == 'E') col[j]++;
                        if (grid[k][j] == 'W') break;
                    }
                }
                // place the bomb
                if (grid[i][j] == '0' && row + col[j] > result) {
                    result = row + col[j];
                }
            }
        }
        return result;
    }
}
