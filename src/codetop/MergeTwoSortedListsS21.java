package codetop;

import jianzhi_offer.ListNode;

/**
 * @author Nebula
 * @date 2021/10/13 17:15
 * @description: 21. 合并两个有序链表 简单
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * <p>
 *
 */
public class MergeTwoSortedListsS21 {
    /**
     * 法1：类似于归并两个有序数组
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //建立一个空头结点,便于连接结点
        ListNode dumpHead = new ListNode();
        ListNode resHead = dumpHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                dumpHead.next = l1;
                //往后比较
                l1 = l1.next;
                dumpHead = dumpHead.next;
                //断开结点
                dumpHead.next = null;
            }
            else {
                dumpHead.next = l2;
                l2 = l2.next;
                dumpHead = dumpHead.next;
                dumpHead.next = null;
            }
        }
        //若某个链表还有剩余，则直接连在新链表后
        if (l1!=null){
            dumpHead.next = l1;
        }
        if (l2!=null){
            dumpHead.next = l2;
        }
        return resHead.next;
    }
}
