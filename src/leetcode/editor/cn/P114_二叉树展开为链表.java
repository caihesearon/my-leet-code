//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
// 👍 968 👎 0


package leetcode.editor.cn;

//二叉树展开为链表

import Entity.TreeNode;
import leetcode.editor.cn.classification.二叉树;

public class P114_二叉树展开为链表 implements 二叉树 {
    public static void main(String[] args) {
        Solution solution = new P114_二叉树展开为链表().new Solution();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        a.left = b;
        a.right = e;
        b.left = c;
        b.right = d;
        e.right = f;
        solution.flatten(a);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 采用前序遍历 将左子树的节点转移到右子树 右子树转移到左子树的右子树中
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
           
            flatten(root.left);
            flatten(root.right);

            TreeNode left = root.left;
            TreeNode right = root.right;
            // 将左子树变为右子树
            root.left = null;
            root.right = left;
            // 然后将原本的右子树添加到现右子树的最右端
            TreeNode p = root;
            while(p.right != null) {
                p = p.right;
            }
            p.right = right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}