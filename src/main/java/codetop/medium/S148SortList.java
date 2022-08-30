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
public class S148SortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        S148SortList s148 = new S148SortList();
        s148.sortList(head);
    }

    /**
     * 法1：使用归并排序(时间复杂度符合，空间复杂度符合)
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

    /**
     * 法2：使用快速排序
     * 1.头节点作为pivot，每次排序使得pivot左边小于它，右边大于它
     * 2.需要考虑每次分割后如何连接，不断链
     * 从最小的链表开始连接
     * 3.比数组快排复杂
     * 也需要知道链表的头和尾
     *
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //使用一个prev节点作为伪头节点
        ListNode prev = new ListNode();
        prev.next = head;
        quickSort(prev, null);
        //最终返回，因此每次都要将prev往下层传递
        return prev.next;
    }

    /**
     * 快速排序
     * 递归返回条件：递归到最后只有一个元素
     *
     * @param prev 待排链表头节点(就是pivot)的前一个节点
     * @return
     */
    public void quickSort(ListNode prev, ListNode end) {
        if (prev == end || prev.next == end) {
            return;
        }
        //临时链表，保存左边小于的节点
        ListNode left = new ListNode();
        //第一个节点为基准
        ListNode pivot = prev.next;
        //保存左边开头
        ListNode start = left;
        //右边
        ListNode right = pivot;
        //链表长度
        while (right.next != end) {
            //使用right.next可以直接断链
            //小于pivot，链接在临时链表上
            if (pivot.val > right.next.val) {
                left.next = right.next;
                left = left.next;
                //直接断开下一节点
                right.next = right.next.next;
            } else {
                //大于pivot直接往后移动
                right = right.next;
            }
        }
        //每次当前pivot排序结束，将节点连接起来
        left.next = prev.next;
        //保证不断链
        prev.next = start.next;
        //继续往下排序，需要将prev传递
        quickSort(prev, pivot);
        quickSort(pivot, end);
    }
}
