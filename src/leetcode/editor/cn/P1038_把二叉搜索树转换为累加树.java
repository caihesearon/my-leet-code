//给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。 
//
// 提醒一下，二叉搜索树满足下列约束条件： 
//
// 
// 节点的左子树仅包含键 小于 节点键的节点。 
// 节点的右子树仅包含键 大于 节点键的节点。 
// 左右子树也必须是二叉搜索树。 
// 
//
// 注意：该题目与 538: https://leetcode-cn.com/problems/convert-bst-to-greater-tree/ 相同
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
// 
//
// 示例 2： 
//
// 
//输入：root = [0,null,1]
//输出：[1,null,1]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,0,2]
//输出：[3,3,2]
// 
//
// 示例 4： 
//
// 
//输入：root = [3,2,4,1]
//输出：[7,9,4,10]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数介于 1 和 100 之间。 
// 每个节点的值介于 0 和 100 之间。 
// 树中的所有值 互不相同 。 
// 给定的树为二叉搜索树。 
// 
// 👍 134 👎 0


package leetcode.editor.cn;

//把二叉搜索树转换为累加树

import Entity.TreeNode;
import leetcode.editor.cn.classification.二叉搜索树;
import leetcode.editor.cn.classification.二叉树;

public class P1038_把二叉搜索树转换为累加树 implements 二叉树, 二叉搜索树 {
    public static void main(String[] args) {
        Solution solution = new P1038_把二叉搜索树转换为累加树().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int sum = 0;

        public TreeNode bstToGst(TreeNode root) {
            if (root == null) {
                return null;
            }
            bstToGst(root.right);
            sum += root.val;
            root.val = sum;
            bstToGst(root.left);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}