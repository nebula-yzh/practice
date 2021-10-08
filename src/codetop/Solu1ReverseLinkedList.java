package codetop;

import jianzhi_offer.ListNode;

/**
 * @author Nebula
 * @date 2021/10/8 17:01
 * @description:
 * 反转链表 简单
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 反转链表两种方法，一般情况下考察迭代较多
 * 1.迭代，使用头插法，原地反转
 * 2.递归
 */
public class Solu1ReverseLinkedList {
    /**
     * 迭代法
     * @param head
     * @return
     */
    public ListNode iterationReverseList(ListNode head){
        if (head==null) {
            return null;
        }
        ListNode dump = new ListNode();
        ListNode temp = head.next;
        head.next = null;
        dump.next = head;
        while (temp!=null){
            head=temp;
            temp=temp.next;
            head.next=dump.next;
            dump.next=head;
        }
        return dump.next;
    }

    public ListNode recursionReverseList(ListNode head){

    }
}
