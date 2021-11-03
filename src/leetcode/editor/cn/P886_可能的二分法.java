//给定一组 N 人（编号为 1, 2, ..., N）， 我们想把每个人分进任意大小的两组。 
//
// 每个人都可能不喜欢其他人，那么他们不应该属于同一组。 
//
// 形式上，如果 dislikes[i] = [a, b]，表示不允许将编号为 a 和 b 的人归入同一组。 
//
// 当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：N = 4, dislikes = [[1,2],[1,3],[2,4]]
//输出：true
//解释：group1 [1,4], group2 [2,3]
// 
//
// 示例 2： 
//
// 
//输入：N = 3, dislikes = [[1,2],[1,3],[2,3]]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 2000 
// 0 <= dislikes.length <= 10000 
// dislikes[i].length == 2 
// 1 <= dislikes[i][j] <= N 
// dislikes[i][0] < dislikes[i][1] 
// 对于 dislikes[i] == dislikes[j] 不存在 i != j 
// 
// 👍 139 👎 0


package leetcode.editor.cn;

//可能的二分法

import leetcode.editor.cn.classification.图;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P886_可能的二分法 implements 图 {
    public static void main(String[] args) {
        Solution solution = new P886_可能的二分法().new Solution();
        int[][] s = {{1, 2}, {1, 3}, {2, 4}};
        solution.possibleBipartition(4, s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        boolean[] visited;// 每个人是否已访问
        boolean[] colors;// 每个人所在的组颜色
        boolean res = true;

        public boolean possibleBipartition(int n, int[][] dislikes) {
            visited = new boolean[n + 1];
            colors = new boolean[n + 1];
            // 构建图
            List<List<Integer>> graph = buildMap(n, dislikes);
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    traverse(i, graph);
                }
            }
            return res;
        }

        private List<List<Integer>> buildMap(int n, int[][] dislikes) {
            List<List<Integer>> map = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                map.add(new ArrayList<>());
            }
            for (int[] nextDis : dislikes) {
                int pre = nextDis[0];
                int tail = nextDis[1];
                map.get(pre).add(tail);
                map.get(tail).add(pre);
            }
            return map;
        }

        private void traverse(int pos, List<List<Integer>> graph) {
            if (!res) {
                return;
            }
            visited[pos] = true;
            for (Integer nextPos : graph.get(pos)) {
                if (visited[nextPos]) {
                    if (colors[nextPos] == colors[pos]) {
                        res = false;
                    }
                } else {
                    colors[nextPos] = !colors[pos];
                    traverse(nextPos, graph);
                }
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}