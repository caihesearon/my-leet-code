package 剑指Offer.简单;

import Entity.ListNode;

/**
 * @author hecai
 * @date 2020/12/11
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class 从尾到头打印链表 {

    /**
     * 顺序遍历head链表
     * 将遍历到的节点值使用StringBuilder的insert方法插入到头部
     * 拼接完成后使用split方法切割为String数组
     * 最后使用for循环将String数组转为int数组
     */
    public int[] reversePrint(ListNode head) {
        if (head == null){
            return new int[]{};
        }
        StringBuilder sb = new StringBuilder();
        sb.append(head.val);
        head = head.next;
        while((head != null)){
            sb.insert(0,head.val+" ");
            head = head.next;
        }
        String[] split = sb.toString().split(" ");
        int[] res = new int[split.length];
        for (int i = 0; i < split.length; i++){
            res[i] = Integer.parseInt(split[i]);
        }
        return res;
    }
}
