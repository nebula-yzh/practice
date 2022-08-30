package codetop.medium;

import jianzhi_offer.ListNode;

/**
 * @author Nebula
 * @date 2021/10/25 19:04
 * @description: 19. 删除链表的倒数第N个结点 中等
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 * <p>
 * 示例1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 法1：双指针，类似剑指offer22，找到倒数第n个结点
 * 1.定义dump，快慢指针
 * 2.快指针先移动n位
 * 3.快慢指针同时移动，fast.next!=null,此时slow在待删除的前一个结点
 * 4.删除倒数第n个结点即可,slow.next = slow.next.next
 * 法2：利用栈
 */
public class S19RemoveNthNodeFromEndOfList {
    /**
     * 快慢指针
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dump = new ListNode();
        dump.next = head;
        ListNode fast;
        ListNode slow;
        fast = dump;
        slow = dump;
        for (int i = n; i > 0; i--) {
            fast = fast.next;
        }
        while (fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dump.next;
    }
}
