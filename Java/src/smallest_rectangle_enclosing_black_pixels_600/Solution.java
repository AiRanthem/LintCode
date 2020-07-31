package src.smallest_rectangle_enclosing_black_pixels_600;

public class Solution {
    int left, right, up, down, xbound, ybound;
    char[][] image;
    boolean[][] visited;

    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x:     the location of one of the black pixels
     * @param y:     the location of one of the black pixels
     * @return an integer
     */
    public int minArea(char[][] image, int x, int y) {
        this.image = image;
        up = down = x;
        left = right = y;
        xbound = image.length - 1;
        ybound = image[0].length - 1;
        visited = new boolean[image.length][image[0].length];

        dfs(x, y);
        return (right - left + 1) * (down - up + 1);
    }

    public void dfs(int x, int y) {
        if (x < up) up = x;
        if (x > down) down = x;
        if (y < left) left = y;
        if (y > right) right = y;

        visited[x][y] = true;

        if (x > 0 && !visited[x - 1][y] && image[x - 1][y] == '1') dfs(x - 1, y);
        if (x < xbound && !visited[x + 1][y] && image[x + 1][y] == '1') dfs(x + 1, y);
        if (y > 0 && !visited[x][y - 1] && image[x][y - 1] == '1') dfs(x, y - 1);
        if (y < ybound && !visited[x][y + 1] && image[x][y + 1] == '1') dfs(x, y + 1);
    }
}