//有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。 
//
// 我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。 
//
// 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。 
//
// 请返回封闭岛屿的数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [
// [1,1,1,1,1,1,1,0],
// [1,0,0,0,0,1,1,0],
// [1,0,1,0,1,1,1,0],
// [1,0,0,0,0,1,0,1],
// [1,1,1,1,1,1,1,0]]
//输出：2
//解释：
//灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。 
//
// 示例 2： 
//
// 
//
// 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
//输出：1
// 
//
// 示例 3： 
//
// 输入：grid = [[1,1,1,1,1,1,1],
//             [1,0,0,0,0,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,1,0,1,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,0,0,0,0,1],
//             [1,1,1,1,1,1,1]]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[0].length <= 100 
// 0 <= grid[i][j] <=1 
// 
// 👍 97 👎 0


package leetcode.editor.cn;

//统计封闭岛屿的数目

public class P1254_统计封闭岛屿的数目 {
    public static void main(String[] args) {
        Solution solution = new P1254_统计封闭岛屿的数目().new Solution();
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}};
        solution.closedIsland(grid);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int closedIsland(int[][] grid) {
            int count = 0;
            // 把周围四边的岛屿清理掉 剩下的就是封闭岛屿
            for (int i = 0; i < grid.length; i++) {
                dfs(grid, i, 0);
                dfs(grid, i, grid[0].length - 1);
            }
            for (int j = 0; j < grid[0].length; j++) {
                dfs(grid, 0, j);
                dfs(grid, grid.length - 1, j);
            }
            // 剩下就是封闭岛屿
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 0) {
                        dfs(grid, i, j);
                        count++;
                    }
                }
            }
            return count;
        }

        private void dfs(int[][] grid, int x, int y) {
            // 边界条件
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[x].length) {
                return;
            }
            // 遇到海水就返回
            if (grid[x][y] == 1) {
                return;
            }
            // 陆地变为海水
            grid[x][y] = 1;
            dfs(grid, x + 1, y);
            dfs(grid, x - 1, y);
            dfs(grid, x, y + 1);
            dfs(grid, x, y - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}