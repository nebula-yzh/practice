package codetop;

import jianzhi_offer.ListNode;

/**
 * @author Nebula
 * @date 2021/10/23 22:41
 * @description: 83. 删除排序链表中的重复元素 简单
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 */
public class RemoveDuplicatesFromSortedList1S83 {

    /**
     * 判断当前指针cur.val是否与cur.next.val相等，若相等删除后一个指针
     * 不相等则后移
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode cur=head;
        while (cur.next!=null){
            if (cur.val==cur.next.val){
                cur.next = cur.next.next;
            }
            else {
                cur = cur.next;
            }
        }
        return head;
    }
}
