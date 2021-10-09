package codetop;

import jianzhi_offer.ListNode;

/**
 * @author Nebula
 * @date 2021/10/8 17:01
 * @description:
 * 146 反转链表 简单
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 反转链表两种方法，一般情况下考察迭代较多
 * 1.迭代，使用头插法，原地反转
 * 2.递归，一直递归到尾，从尾开始反转到头
 */
public class ReverseLinkedListS206 {

    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode head=new ListNode(1,node2);
        System.out.println(recursionReverseList(head));

    }
    /**
     * 迭代法
     * 使用头插法，原地反转
     * @param head
     * @return
     */
    public ListNode iterationReverseList(ListNode head){
        if (head==null) {
            return null;
        }
        //设置一个空结点作为新头结点，便于操作结点
        ListNode dump = new ListNode();
        //保存下一个结点，防止断链
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

    /**
     * 递归实现反转链表
     * 一直递归到尾，从尾开始反转到头
     * @param head
     * @return
     */
    static ListNode newHead;
    public static ListNode recursionReverseList(ListNode head){
        if(head==null) {
            return null;
        }
        recurse(head);
        //将尾结点置null
        head.next=null;
        return newHead;
    }

    public static void recurse(ListNode head){
        //确定新的头结点，即原来链表的尾结点
        if (head.next==null){
            newHead = head;
            return;
        }
        recurse(head.next);
        //将链表反转
        head.next.next=head;
    }

}
