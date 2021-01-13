package 困难;

import Entity.ListNode;

/**
 *
 * @author hecai
 * @date 2020年5月16日
 */
public class K个一组翻转链表 {
	
	//使用递归
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null) {
			return null;
		}
		//根据k找到找到一段的尾部
		ListNode end = head;
		 int count = k;
		while(--count > 0) {
			end = end.next;
			if(end == null)//到最后不满足条件
				return head;
		}
//		for (int i = 0; i < k - 1; i++) {
//            end = end.next;
//            if (end == null) {
//                return head;
//            }
//        }
		//记录下一次翻转开始的头部 就是本段翻转前的尾部
		ListNode nextNode = end.next;
		//开始翻转
		ListNode deal = deal(head, k);
		head.next = reverseKGroup(nextNode, k);
		return deal;
	}
	
	public ListNode deal(ListNode head, int k) {
		ListNode pre = null;
		while(k-- > 0) {
			//保存head的下一个结点
			ListNode next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	
	
//错误	
//	public ListNode reverseKGroup(ListNode head, int k) {
//		//定义一个结点保存结果的头结点
//		ListNode res = new ListNode(0);
//		res.next = head;
//		ListNode node = res;
//		
//		while(head != null) {
//			//记录尾结点
//			ListNode tail = node;
//			while(k-- > 0) {
//				tail = tail.next;
//				if(tail == null) {
//					return res.next;
//				}
//			}
//			//找到k段尾结点
//			if(tail == node) {
//				continue;
//			}
//			ListNode nex = tail.next;
//			ListNode deal = deal(node.next, k);
//			//node.next是反转后的尾结点 deal是头结点
//			node.next = deal;
//			tail.next.next = nex;
//			node = tail;
//			head = tail.next;
//		}
//		
//		return res.next;
//	}
//	
//	//返回该结点到前k个的反转链表的头结点  node就变为尾结点
//	ListNode deal(ListNode node, int k) {
//		ListNode pre = null, curr = node;
//		while(k-- > 0) {
//			ListNode nextTemp = curr.next;
//			curr.next = pre;
//			pre = curr;
//			curr = nextTemp;
//		}
//		return pre;
//	}
}
