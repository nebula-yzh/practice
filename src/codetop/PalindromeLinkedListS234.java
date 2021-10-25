package codetop;

import jianzhi_offer.ListNode;

import java.util.*;

/**
 * @author Nebula
 * @date 2021/10/24 8:39
 * @description: 234. 回文链表 简单
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 示例 1:
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2:
 * 输入：head = [1,2]
 * 输出：false
 * <p>
 * 法1：
 * 空间复杂度O(1)，只是会破坏链表原来结构，可以再反转回来
 * 可以使用链表反转，找到中点(使用快慢指针，走一步走两步，当快指针到尾时，慢指针到中点)，注意奇数偶数个结点不相同
 * 1.将中点后的链表结点反转
 * 2.与中点前的结点从头结点开始逐个比较，若不同则返回false，直到链表比较结束返回true
 * 法2：
 * 空间复杂度O(n)
 * 将链表遍历放入数组中，根据下标判断，一个从前往后，一个从后往前，双指针，注意奇数偶数个结点
 * 法3：
 * 利用栈 ，空间复杂度O(n),
 * 1.使用快慢指针找到中间结点
 * 2.将前半部分入栈
 * 3.出栈与后半部分进行比较
 */
public class PalindromeLinkedListS234 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(1)));
        ListNode node = new ListNode(1);
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(2, new ListNode(1)))));
        System.out.println(isPalindrome(head));
    }

    /**
     * 利用栈
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        //找中点
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode mid;
        if (fast==null){
            mid = slow;
        }
        else {
            mid = slow.next;
        }
        //入栈
        ListNode cur = head;
        Deque<ListNode> stack = new ArrayDeque<>();
        while (cur!=slow){
            stack.push(cur);
            cur=cur.next;
        }
        //比较
        while (mid!=null){
            if (stack.pop().val!=mid.val){
                return false;
            }else {
                mid = mid.next;
            }
        }
        return true;
    }

    /**
     * 错误方法，只有部分例子可以通过
     *
     * @param head
     * @return
     */
    public static boolean isPalindromeFalse(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode cur = new ListNode();
        cur.next = head;
        while (cur.next != null) {
            if (stack.peekLast() != null && stack.peekLast().val == cur.next.val) {
                stack.removeLast();
                cur = cur.next;
            } else if (stack.peekLast() != null && stack.peekLast().val != cur.next.val) {
                ListNode tailNode = stack.getLast();
                stack.removeLast();
                if (stack.peekLast() != null && stack.peekLast().val == cur.next.val) {
                    stack.removeLast();
                } else {
                    stack.offerLast(tailNode);
                    stack.offerLast(cur.next);
                }
                cur = cur.next;
            } else {
                stack.offerLast(cur.next);
                cur = cur.next;
            }

        }
        return stack.isEmpty();
    }
}
