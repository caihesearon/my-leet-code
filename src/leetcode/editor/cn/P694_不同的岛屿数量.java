package leetcode.editor.cn;

/**
 * 这是本文的最后一道岛屿题目，作为压轴题，当然是最有意思的。
 * <p>
 * 力扣第 694 题「不同的岛屿数量」，题目还是输入一个二维矩阵，0表示海水，1表示陆地，这次让你计算 不同的 (distinct) 岛屿数量，函数签名如下：
 * <p>
 * int numDistinctIslands(int[][] grid)
 * 比如题目输入下面这个二维矩阵：
 *
 * @author caihe
 * @date 2021/10/28 10:59
 */
public class P694_不同的岛屿数量 {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder str = new StringBuilder();
                    dfs(grid, i, j, 1, str);
                    System.out.println(i + " " + j + " -- "+ str);
                }
            }
        }

    }

    private static void dfs(int[][] grid, int x, int y, int dir, StringBuilder str) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
            return;
        }
        grid[x][y] = 0;
        // 进
        str.append(dir).append(" ");
        dfs(grid, x - 1, y, 1, str);
        dfs(grid, x + 1, y, 2, str);
        dfs(grid, x, y - 1, 3, str);
        dfs(grid, x, y + 1, 4, str);
        // 出
        str.append(-dir).append(" ");
    }


}
