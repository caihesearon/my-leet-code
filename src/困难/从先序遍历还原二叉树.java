package 困难;

import java.util.Deque;
import java.util.LinkedList;

import Entity.TreeNode;

/**
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D +
 * 1。根节点的深度为 0）。 如果节点只有一个子节点，那么保证该子节点为左子节点。 给出遍历输出 S，还原树并返回其根节点 root。 示例 1：
 * 输入："1-2--3--4-5--6--7" 输出：[1,2,5,3,4,6,7]
 * 
 * @author hecai
 * @date 2020年6月18日
 */
public class 从先序遍历还原二叉树 {
	public static TreeNode recoverFromPreorder(String S) {
		//定义一个栈 用于存放不同等级的元素
		Deque<TreeNode> path = new LinkedList<TreeNode>();
		int pos = 0;
		//遍历S字符串
		while (pos < S.length()) {
			//初始化元素等级为0
			int level = 0;
			//计算元素等级
			while (S.charAt(pos) == '-') {
				++level;//等级加1
				++pos;//移动下标
			}
			//计算元素的值value
			int value = 0;
			while (pos < S.length() && Character.isDigit(S.charAt(pos))) {
				value = value * 10 + (S.charAt(pos) - '0');
				++pos;//移动下标
			}
			//通过value定义TreeNode
			TreeNode node = new TreeNode(value);
			//根据元素等级判断
			//如果元素等级和栈的长度一致就说明新的元素是栈顶元素子元素
			if (level == path.size()) {
				//如果栈不为空
				if (!path.isEmpty()) {
					//就使栈顶元素的左子元素设置为node
					path.peek().left = node;
				}				
			} else {
				//一旦长度和元素等级不一致就说明元素等级一定是小于栈的长度的
				while (level != path.size()) {
					//需要一直pop 直到元素等级和长度一致 这个时候栈顶元素就是这个元素的父元素
					path.pop();
				}
				//是栈顶元素的右子元素设置为node
				path.peek().right = node;
			}
			//并将新的元素push到栈中
			path.push(node);
		}
		//删掉所有的节点 除了root节点
		while (path.size() > 1) {
			path.pop();
		}
		return path.peek();
	}
	
	public static void main(String[] args) {
		recoverFromPreorder("1-2--3--4-5--6--7");
	}

}
