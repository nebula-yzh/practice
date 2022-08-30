package jianzhi_offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Nebula
 * @date 2021/10/25 18:50
 * @description: 剑指 Offer 22. 链表中倒数第k个节点 简单
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 * <p>
 * 法1：快慢指针
 * 1.快慢指针指向dump结点，快指针先走k步，
 * 2.快慢指针同时移动最终慢指针到达倒数第k个结点,快指针指向null
 * <p>
 * 法2：利用栈，将所有结点压入栈，出栈第k个
 */
public class Solution22 {

    /**
     * 双指针，快慢指针
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode dump = new ListNode();
        ListNode fast;
        ListNode slow;
        dump.next = head;
        fast = dump;
        slow = dump;
        for (int i = k; i > 0; i--) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 利用栈
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEndUseStack(ListNode head, int k) {
        Deque<ListNode> stack = new ArrayDeque<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        for (int i = k; i > 1; i--) {
            stack.pop();
        }
        return stack.pop();
    }
}
