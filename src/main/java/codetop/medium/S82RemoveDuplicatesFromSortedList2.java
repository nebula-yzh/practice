package codetop.medium;

import jianzhi_offer.ListNode;

/**
 * @author Nebula
 * @date 2021/10/23 9:20
 * @description: 82. 删除排序链表中的重复元素 II 中等
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，
 * 只保留原始链表中没有重复出现的数字。
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 返回同样按升序排列的结果链表。
 */
public class S82RemoveDuplicatesFromSortedList2 {

    /**
     * 1.使用一个dump结点作为头结点，cur表示当前结点，deleteValue表示需要删除的结点值;
     * 2.判断cur.next.val是否等于deleteValue;相等删除，
     * 3.不相等再判断cur.next.val==cur.next.next.val ?，相等更新deleteValue,并删除相等的两个结点;
     * 4.不相等结点后移
     *
     * 题目要求删除所有相同的结点，只要有相同都删除
     * 通过前一个结点判断后一个或两个结点的值是否等于待删除结点，再进行删除
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        //设置一个空头节点
        ListNode dump = new ListNode(Integer.MIN_VALUE);
        dump.next = head;
        //设置待删除结点的值，保证第一个结点不会被删除
        int deleteValue = dump.val;
        //cur当前结点
        ListNode cur = dump;
        while (cur.next!=null&&cur.next.next!=null){
            //判断结点是否等于待删除结点的值
            if (cur.next.val==deleteValue){
                cur.next = cur.next.next;
            }
            else {
                if (cur.next.val==cur.next.next.val){
                    //有两个结点相等，更新待删除结点的值
                    deleteValue = cur.next.val;
                    //删除两个相同结点
                    cur.next = cur.next.next.next;
                }
                else {
                    cur = cur.next;
                }
            }
        }
        //判断最后一个结点的值
        if (cur.next!=null&&cur.next.val==deleteValue){
            cur.next = null;
        }
        return dump.next;
    }
}
