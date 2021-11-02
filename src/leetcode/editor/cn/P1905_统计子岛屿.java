//给你两个 m x n 的二进制矩阵 grid1 和 grid2 ，它们只包含 0 （表示水域）和 1 （表示陆地）。一个 岛屿 是由 四个方向 （水平或者竖
//直）上相邻的 1 组成的区域。任何矩阵以外的区域都视为水域。 
//
// 如果 grid2 的一个岛屿，被 grid1 的一个岛屿 完全 包含，也就是说 grid2 中该岛屿的每一个格子都被 grid1 中同一个岛屿完全包含，那
//么我们称 grid2 中的这个岛屿为 子岛屿 。 
//
// 请你返回 grid2 中 子岛屿 的 数目 。 
//
// 
//
// 示例 1： 
//
// 输入：grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], 
//grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
//输出：3
//解释：如上图所示，左边为 grid1 ，右边为 grid2 。
//grid2 中标红的 1 区域是子岛屿，总共有 3 个子岛屿。
// 
//
// 示例 2： 
//
// 输入：grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]], 
//grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
//输出：2 
//解释：如上图所示，左边为 grid1 ，右边为 grid2 。
//grid2 中标红的 1 区域是子岛屿，总共有 2 个子岛屿。
// 
//
// 
//
// 提示： 
//
// 
// m == grid1.length == grid2.length 
// n == grid1[i].length == grid2[i].length 
// 1 <= m, n <= 500 
// grid1[i][j] 和 grid2[i][j] 都要么是 0 要么是 1 。 
// 
// 👍 23 👎 0


package leetcode.editor.cn;

//统计子岛屿

import leetcode.editor.cn.classification.DFS;

public class P1905_统计子岛屿 implements DFS {
    public static void main(String[] args) {
        Solution solution = new P1905_统计子岛屿().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            // 这是一个包含问题  b地图的岛屿位置对应在a地图的位置 如果是海水就不是包含
            for (int i = 0; i < grid2.length; i++) {
                for (int j = 0; j < grid2[0].length; j++) {
                    // 如果b地图是陆地 而 a地图是海水
                    if (grid2[i][j] == 1 && grid1[i][j] == 0) {
                        // 淹掉b地图
                        dfs(grid2, i, j);
                    }
                }
            }
            int count = 0;
            // 剩下就是判断b地图上还有多少个岛屿了
            for (int i = 0; i < grid2.length; i++) {
                for (int j = 0; j < grid2[0].length; j++) {
                    if (grid2[i][j] == 1) {
                        dfs(grid2, i, j);
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