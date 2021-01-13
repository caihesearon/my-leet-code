package 剑指Offer.中等;

import Entity.TreeNode;
import com.sun.deploy.panel.ITreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @author hecai
 * @date 2020/7/28
 */
public class 剑指Offer07重建二叉树 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    //定义一个map来保存中序的下标键值对
    Map<Integer,Integer> map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, 0, inorder.length-1);
    }

    /**
     * @param preIndex 前序遍历的根节点下标
     * @param leftIndex 中序遍历的左界
     * @param rightIndex 中序遍历的右界
     */
    public TreeNode buildTree(int[] preorder, int preIndex, int leftIndex, int rightIndex){
        //不能越界
        if(leftIndex > rightIndex)
            return null;
        //根节点的值
        int rootVal = preorder[preIndex];
        //创建根节点
        TreeNode root = new TreeNode(rootVal);
        if(leftIndex == rightIndex)
            return root;
        //找到根节点在中序中的下标
        int inIndex = map.get(rootVal);
        //preIndex：前序中左子树的根节点
        root.left = buildTree(preorder, preIndex+1, leftIndex, inIndex-1);
        //preIndex：前序中右子树的根节点  计算左子树的节点个数(inIndex-leftIndex) 然后和preIndex相加
        root.right = buildTree(preorder, preIndex+1+inIndex-leftIndex, inIndex+1,rightIndex);
        return root;
    }
}
