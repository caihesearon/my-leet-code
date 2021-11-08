//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// 👍 612 👎 0


package leetcode.editor.cn;

//从中序与后序遍历序列构造二叉树

import Entity.TreeNode;
import leetcode.editor.cn.classification.二叉树;

public class P106_从中序与后序遍历序列构造二叉树 implements 二叉树 {
    public static void main(String[] args) {
        Solution solution = new P106_从中序与后序遍历序列构造二叉树().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // https://mp.weixin.qq.com/s/OlpaDhPDTJlQ5MJ8tsARlA
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            TreeNode deal = deal(inorder, 0, inorder.length - 1,
                    postorder, 0, postorder.length - 1);
            return deal;
        }

        TreeNode deal(int[] inorder, int inStart, int inEnd,
                      int[] postorder, int posStart, int posEnd) {
            if (inStart > inEnd || posStart > posEnd) {
                return null;
            }
            int rootVal = postorder[posEnd];
            // 获取rootVal在中序数组中的位置
            int inRootIndex = -1;
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == rootVal) {
                    inRootIndex = i;
                }
            }
            // 获取子树的长度
            int leftSize = inRootIndex - inStart;
            TreeNode root = new TreeNode(rootVal);

            root.left = deal(inorder, inStart, inRootIndex - 1,
                    postorder, posStart, posStart + leftSize - 1);
            root.right = deal(inorder, inRootIndex + 1, inEnd,
                    postorder, posStart + leftSize , posEnd - 1);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}