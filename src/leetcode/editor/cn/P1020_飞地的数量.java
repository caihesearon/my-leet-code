//给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。 
//
// 移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。 
//
// 返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量。 
//
// 
//
// 示例 1： 
//
// 输入：[
// [0,0,0,0],
// [1,0,1,0],
// [0,1,1,0],
// [0,0,0,0]]
//输出：3
//解释： 
//有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。 
//
// 示例 2： 
//
// 输入：[
// [0,1,1,0],
// [0,0,1,0],
// [0,0,1,0],
// [0,0,0,0]]
//输出：0
//解释：
//所有 1 都在边界上或可以到达边界。 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 500 
// 1 <= A[i].length <= 500 
// 0 <= A[i][j] <= 1 
// 所有行的大小都相同 
// 
// 👍 57 👎 0


package leetcode.editor.cn;

//飞地的数量

public class P1020_飞地的数量 {
    public static void main(String[] args) {
        Solution solution = new P1020_飞地的数量().new Solution();
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}};
        solution.numEnclaves(grid);
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numEnclaves(int[][] grid) {
            // 思路：还是将地图周围的检查一遍  如果是陆地就全部淹了  剩下的用for循环去检查有几个
            for (int i = 0; i < grid.length; i++) {
                dfs(grid, i, 0);
                dfs(grid, i, grid[0].length - 1);
            }
            for (int j = 0; j < grid[0].length; j++) {
                dfs(grid, 0, j);
                dfs(grid, grid.length - 1, j);
            }
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        count++;
                    }
                }
            }
            return count;
        }

        private void dfs(int[][] grid, int x, int y) {
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
                return;
            }
            if (grid[x][y] == 0) {
                return;
            }
            grid[x][y] = 0;
            dfs(grid, x - 1, y);
            dfs(grid, x + 1, y);
            dfs(grid, x, y - 1);
            dfs(grid, x, y + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}