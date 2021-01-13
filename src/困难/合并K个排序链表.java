package 困难;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Entity.ListNode;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 示例: 输入: [   1->4->5,   1->3->4,   2->6 ]
 * 输出: 1->1->2->3->4->4->5->6
 * 
 * @author hecai
 * @date 2020年4月26日
 */
public class 合并K个排序链表 {
	/**
	 *暴力破解 
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		//将所有的节点遍历并保存到List中
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < lists.length; i++) {
			ListNode node = lists[i];
			while(node != null) {
				list.add(node.val);
				node = node.next;				
			}
		}
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) { 
				return o1-o2;
			}
		});
		ListNode root = new ListNode(0);
		ListNode p = root;
		for (Integer i : list) {
			p.next = new ListNode(i);
			p = p.next;
		}
		return root.next;
	}

}

//class ListNode {
//	int val;
//	ListNode next;
//
//	ListNode(int x) {
//		val = x;
//	}
//}
