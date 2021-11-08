//给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均无重复元素 
// inorder 均出现在 preorder 
// preorder 保证为二叉树的前序遍历序列 
// inorder 保证为二叉树的中序遍历序列 
// 
// 👍 1281 👎 0


package leetcode.editor.cn;

//从前序与中序遍历序列构造二叉树

import Entity.TreeNode;
import leetcode.editor.cn.classification.二叉树;

import java.util.Arrays;

public class P105_从前序与中序遍历序列构造二叉树 implements 二叉树 {
    public static void main(String[] args) {
        Solution solution = new P105_从前序与中序遍历序列构造二叉树().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // https://mp.weixin.qq.com/s/OlpaDhPDTJlQ5MJ8tsARlA
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            TreeNode root = deal(preorder, 0, preorder.length - 1,
                    inorder, 0, inorder.length - 1);
            return root;
        }

        TreeNode deal(int[] preorder, int preStart, int preEnd,
                      int[] inorder, int inStart, int inEnd) {
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }
            int rootVal = preorder[preStart];
            int inorderIndex = -1;
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == rootVal) {
                    inorderIndex = i;
                    break;
                }
            }
            int treeLen = inorderIndex - inStart;
            TreeNode root = new TreeNode(rootVal);
            root.left = deal(preorder, preStart + 1, preStart + treeLen,
                    inorder, inStart, inStart + treeLen);
            root.right = deal(preorder, preStart + 1 + treeLen, preEnd,
                    inorder, inStart + treeLen + 1, inEnd);

            return root;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}