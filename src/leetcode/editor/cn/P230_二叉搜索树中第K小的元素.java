//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 10⁴ 
// 0 <= Node.val <= 10⁴ 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
// 👍 520 👎 0


package leetcode.editor.cn;

//二叉搜索树中第K小的元素

import Entity.TreeNode;
import leetcode.editor.cn.classification.二叉搜索树;
import leetcode.editor.cn.classification.二叉树;

public class P230_二叉搜索树中第K小的元素 implements 二叉树, 二叉搜索树 {
    public static void main(String[] args) {
        Solution solution = new P230_二叉搜索树中第K小的元素().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res = -1;
        int deep = 0;

        public int kthSmallest(TreeNode root, int k) {
            deal(root, k);
            return res;
        }
        
        void deal(TreeNode root, int k) {
            if (root == null) {
                return;
            }
            deal(root.left, k);
            deep++;
            if (k == deep) {
                res = root.val;
                return;
            }
            deal(root.right, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}