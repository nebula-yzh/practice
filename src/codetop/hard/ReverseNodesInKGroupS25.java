package codetop.hard;

import jianzhi_offer.ListNode;

/**
 * @author Nebula
 * @date 2021/11/14 9:08
 * @description: 25. K 个一组翻转链表  困难
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 * k是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 进阶：
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 实例 2：
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * 示例 3：
 * 输入：head = [1,2,3,4,5], k = 1
 * 输出：[1,2,3,4,5]
 */
public class ReverseNodesInKGroupS25 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode node = reverseKGroup(head, 3);
        System.out.println(node);
    }
    /**
     * K个一组反转链表
     * 反转链表需要保存待反转链表的前一个结点
     * 每k链表反转一次，需要有变量计数num
     * 法1：直接每k个反转，当计数到达k时重新计数，最后若不足k个，再将反转的链表再反转回来，注意不要断链
     * 难点：怎么在每次反转后连接到前一个链表的尾结点，可以保留前一次反转的链表的第一个结点
     * 法2：先数链表是否有k个，再开始反转，若未达到k个不反转
     * <p>
     *
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        //法1
        ListNode dump = new ListNode();
        ListNode res = dump;

        ListNode temp;
        ListNode first;
        while (head != null) {
            int num= 0;
            //暂存待反转链表的第一个结点
            first = head;
            //进行链表反转
            while (num < k && head != null) {
                temp = head.next;
                head.next = dump.next;
                dump.next = head;
                head = temp;
                num++;
            }
            //最后剩余的链表未达k个，再反转回来,注意最后num可能会加到k-1
            if (num < k) {
                head = dump.next;
                //避免形成环
                dump.next = null;
                //反转链表
                while (head != null) {
                    temp = head.next;
                    head.next = dump.next;
                    dump.next = head;
                    head = temp;
                }
                break;
            }
            //重新给dump赋值
            dump = first;
            //dump.next = null;
        }
        return res.next;
    }
}
