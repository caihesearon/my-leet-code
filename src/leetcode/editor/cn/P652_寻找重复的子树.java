//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。 
//
// 示例 1： 
//
//         1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
// 
//
// 下面是两个重复的子树： 
//
//       2
//     /
//    4
// 
//
// 和 
//
//     4
// 
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。 
// 👍 327 👎 0


package leetcode.editor.cn;

//寻找重复的子树

import Entity.TreeNode;
import leetcode.editor.cn.classification.二叉树;

import java.util.*;

public class P652_寻找重复的子树 implements 二叉树 {
    public static void main(String[] args) {
        Solution solution = new P652_寻找重复的子树().new Solution();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        e.left = g;

        List<TreeNode> duplicateSubtrees = solution.findDuplicateSubtrees(a);
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<String> set = new HashSet<>();
        Set<TreeNode> list = new HashSet<>();
        // 记录所有子树以及出现的次数
        HashMap<String, Integer> memo = new HashMap<>();

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            deal(root);
            return new ArrayList<>(list);
        }

        /* 辅助函数 */
        String deal1(TreeNode root) {
            if (root == null) {
                return "#";
            }

            String left = deal(root.left);
            String right = deal(root.right);

            String subTree = left + "," + right + "," + root.val;

            int freq = memo.getOrDefault(subTree, 0);
            // 多次重复也只会被加入结果集一次
            if (freq == 1) {
                list.add(root);
            }
            // 给子树对应的出现次数加一
            memo.put(subTree, freq + 1);
            return subTree;
        }

        private String deal(TreeNode root) {
            if (root == null) {
                return "#";
            }

//            path.delete(path.length() - 1, path.length());
            String left = deal(root.left);
            String right = deal(root.right);

            String path = left + "," + right + "," + root.val;
            if (set.contains(path)) {
                root.path = path;
                list.add(root);
            }
            set.add(path.toString());
            return path;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}