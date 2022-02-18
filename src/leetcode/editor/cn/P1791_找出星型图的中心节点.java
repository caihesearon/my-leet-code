//有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。 
//
// 给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。请你找出并返回 edges 
//所表示星型图的中心节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：edges = [[1,2],[2,3],[4,2]]
//输出：2
//解释：如上图所示，节点 2 与其他每个节点都相连，所以节点 2 是中心节点。
// 
//
// 示例 2： 
//
// 
//输入：edges = [[1,2],[5,1],[1,3],[1,4]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 3 <= n <= 10⁵ 
// edges.length == n - 1 
// edges[i].length == 2 
// 1 <= ui, vi <= n 
// ui != vi 
// 题目数据给出的 edges 表示一个有效的星型图 
// 
// 👍 44 👎 0


package leetcode.editor.cn;

//找出星型图的中心节点

import leetcode.editor.cn.level.简单;

public class P1791_找出星型图的中心节点 implements 简单 {
    public static void main(String[] args) {
        Solution solution = new P1791_找出星型图的中心节点().new Solution();
        System.out.println(solution.findCenter(new int[][]{{1, 2}, {5, 1}, {1, 3}, {1, 4}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 技巧
         * 对于这种星状图的中心节点一定是和所有的节点相连 所以两个数组中同时存在的节点就是中心节点
         *
         * @param edges
         * @return
         */
        public int findCenter(int[][] edges) {
//            if (edges[0][0] == edges[1][0]) {
//                return edges[0][0];
//            }if (edges[0][0] == edges[1][1]){
//                return edges[0][0];
//            }
//            return edges[0][1];
            return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
        }

        /**
         * 暴力
         *
         * @param edges
         * @return
         */
        public int findCenter1(int[][] edges) {
            int[] counter = new int[edges.length + 2];
            for (int i = 0; i < edges.length; i++) {
                counter[edges[i][0]]++;
                counter[edges[i][1]]++;
            }
            int index = -1;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < counter.length; i++) {
                if (counter[i] > max) {
                    index = i;
                    max = counter[i];
                }
            }
            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}