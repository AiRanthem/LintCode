package src.utils;

public class GridFactory {
    public static boolean[][] makeBooleanGrid(int[][] input) {
        boolean[][] grid = new boolean[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                grid[i][j] = input[i][j] != 0;
            }
        }
        return grid;
    }
}
