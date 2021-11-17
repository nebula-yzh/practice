package codetop.middle;

import jianzhi_offer.ListNode;

/**
 * @author Nebula
 * @date 2021/11/17 16:02
 * @description: 92. 反转链表 II 反转链表2 中等
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回反转后的链表 。
 * 第一个结点为1
 * 示例1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 */
public class ReverseLinkedList2S92 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode node = reverseBetween(head, 2, 4);
        System.out.println(node);
    }
    /**
     * 反转某范围内的链表,类似每k个反转链表
     * 1.设立一个dump结点,最终返回结点res
     * 2.找到需要反转范围头结点的前一个结点
     * 3.反转right-left+1个结点
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dump = new ListNode();
        ListNode res = dump;
        dump.next = head;
        //找到待反转范围头结点的前一个结点dump
        for (int i = 0; i < left - 1; i++) {
            dump = dump.next;
        }
        //待反转链表的头节点
        head = dump.next;
        //断链，可断可不断
        dump.next = null;
        //暂存结点
        ListNode temp;
        //保存第一个待反转结点
        ListNode first = head;
        //反转dump结点后的链表
        for (int i = 0; i < right - left + 1; i++) {
            temp = head.next;
            head.next = dump.next;
            dump.next = head;
            head = temp;
        }
        //用于连接链表
        dump = first;
        //连接链表,与后半部分连接
        dump.next = head;
        return res.next;
    }
}
