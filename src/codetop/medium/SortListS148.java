package codetop.medium;

import jianzhi_offer.ListNode;

/**
 * @author Nebula
 * @date 2021/11/16 10:59
 * @description: 148. 排序链表 中等
 * 给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
 * 进阶：
 * 你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * <p>
 * 只有归并排序符合条件，快排也可，但会复杂一些
 */
public class SortListS148 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4,new ListNode(2,new ListNode(1,new ListNode(3))));
        SortListS148 s148 = new SortListS148();
        s148.sortList(head);
    }
    /**
     * 使用归并排序(时间复杂度符合，空间复杂度不符合)
     * 与数组不同，数组需要额外空间复制元素进行存储，链表可以不需要复制元素
     * 归并排序：
     * 1.递归分割，从中间开始分割，一步步分到最小，一个结点之后
     * 2.开始归并排序，先归并单个结点，再一步步往上归并
     * <p>
     * 步骤：
     * 1.找到中点，开始分割，递归到只有一个元素
     * 2.归并元素，一步步往上归并，最终返回升序链表
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        return mergeSort(head);
    }

    /**
     * 递归分割链表，再归并
     * 递归退出条件head.next=null，即只有一个结点时
     *
     * @param head
     * @return
     */
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //使用快慢指针找到中点,slow为中点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //一直递归分割链表
        //注意断链
        ListNode newHead = slow.next;
        slow.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(newHead);
        //归并
        return merge(left, right);
    }


    /**
     * 归并两个链表
     *
     * @param node1 链表1
     * @param node2 链表2
     * @return 返回归并后的链表的头结点
     */
    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode dump = new ListNode();
        ListNode temp = dump;
        while (node1 != null && node2 != null) {
            //比较结点大小，再进行连接
            if (node1.val < node2.val) {
                temp.next = node1;
                node1 = node1.next;

            } else {
                temp.next = node2;
                node2 = node2.next;
            }
            temp = temp.next;
            //逻辑置null,断链
            temp.next = null;
        }
        //将未比较的结点，直接连接在主链表后
        if (node1 != null) {
            temp.next = node1;
        }
        if (node2 != null) {
            temp.next = node2;
        }
        return dump.next;
    }
}
