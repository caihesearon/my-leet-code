//让我们一起来玩扫雷游戏！ 
//
// 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）
//地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。 
//
// 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板： 
//
// 
// 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。 
// 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。 
// 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。 
// 如果在此次点击中，若无更多方块可被揭露，则返回面板。 
// 
//
// 
//
// 示例 1： 
//
// 输入: 
//
//[['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'M', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E']]
//
//Click : [3,0]
//
//输出: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//解释:
//
// 
//
// 示例 2： 
//
// 输入: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//Click : [1,2]
//
//输出: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'X', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//解释:
//
// 
//
// 
//
// 注意： 
//
// 
// 输入矩阵的宽和高的范围为 [1,50]。 
// 点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。 
// 输入面板不会是游戏结束的状态（即有地雷已被挖出）。 
// 简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。 
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 128 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.classification.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：扫雷游戏
class P529扫雷游戏 implements BFS {

    private static Boolean flag;
    public static void main(String[] args) {
//        Solution solution = new P529扫雷游戏().new Solution();
//        char[][] board = {{'E', 'E', 'E', 'E', 'E'},
//                {'E', 'E', 'M', 'E', 'E'},
//                {'E', 'E', 'E', 'E', 'E'},
//                {'E', 'E', 'E', 'E', 'E'}};
//        board = solution.updateBoard(board, new int[]{3, 0});
//        for (char[] chars : board) {
//            for (char aChar : chars) {
//                System.out.print(aChar + " ");
//            }
//            System.out.println();
//        }


//        List<List<String>> list = new ArrayList<>();
//        list.add(Arrays.asList("aaa"));
//        System.out.println(list);
//        test(list);
//        System.out.println(list);

        Boolean b = null;
        System.out.println(b);
        System.out.println(flag);


    }
    public static void test(List<List<String>> list){
        list.clear();
        list.add(Arrays.asList("BBB"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //定义方向      上      下           左      右     左上       右上     左下     右下
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int rows = 0;
        int cols = 0;

        public char[][] updateBoard(char[][] board, int[] click) {
            //获取地图的大小
            rows = board.length;
            cols = board[0].length;
            //判断是否第一次就点中了雷
            if (board[click[0]][click[1]] == 'M') {
                board[click[0]][click[1]] = 'X';
                return board;
            }
            bfs(board, click[0], click[1]);
            return board;
        }

        //对这个坐标的值进行8个方向的遍历判断和修改
        void bfs(char[][] board, int x, int y) {
            //计算当前坐标附近所有的雷
            int count = 0;
            for (int[] i : dir) {
                int xx = x + i[0];
                int yy = y + i[1];
                if (xx < 0 || xx >= rows || yy < 0 || yy >= cols ) {
                    continue;
                }
                if(board[xx][yy] == 'M'){
                    count++;
                }
            }
            //如果附近有雷  对地图进行改变
            if (count > 0) {
                board[x][y] = (char) (count + '0');
            } else {//没有雷就需要进行8个方向上的搜索和改变自己的标识
                board[x][y] = 'B';
                for (int[] ints : dir) {
                    int xx = x + ints[0];
                    int yy = y + ints[1];
                    //下一步只能为未被点击的方块
                    if (xx < 0 || xx >= rows || yy < 0 || yy >= cols || board[xx][yy] != 'E') {
                        continue;
                    }
                    bfs(board, xx, yy);
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
