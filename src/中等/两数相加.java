package 中等;

import Entity.ListNode;

/**
 *给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 * @author hecai
 * @date 2020年4月15日
 */
public class 两数相加 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode a = l1, b= l2, curr = head;
		int count = 0;
		while(a != null || b != null) {
			int x = (a == null) ? 0 : a.val;
			int y = (b == null) ? 0 : b.val;
			int sum = x+y+count;
			count = sum /10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if(a != null)
				a = a.next;
			if(b != null)
				b = b.next;
		}
		if(count > 0) {
			curr.next = new ListNode(count);
		}
		return head.next;
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