package 中等;

import java.util.ArrayList;
import java.util.List;

import Entity.TreeNode;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4] 解释:
 * 
 * 1 <--- / \ 2 3 <--- \ \ 5 4 <---
 * 
 * @author hecai
 * @date 2020年4月22日
 * 思路：
 * 	只需要前序遍历右子树保存每一层的的右子树
 */
public class 二叉树的右视图 {
	public List<Integer> rightSideView(TreeNode root) {
		
		List<Integer> list = new ArrayList<Integer>();
		deal(root, 1,list);
		return list;
    }
	
	void deal(TreeNode node, int k, List<Integer> list) {
		if(node == null)
			return ;
		if(k > list.size()) {
			list.add(node.val);				
		}
		deal(node.right, k+1,  list);
		deal(node.left, k+1,  list);
	}
}
/**
 * 49 - 25 = 24
 * r = 24
 * a = r - (r%10) = 24-4=20
 * 
 */
