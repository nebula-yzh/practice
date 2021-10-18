package codetop;

import jianzhi_offer.ListNode;

/**
 * @author Nebula
 * @date 2021/10/17 10:15
 * @description: 160. 相交链表 简单
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表没有交点，返回 null 。
 */
public class IntersectionOfTwoLinkedListsS160 {

    /**
     * 使用两个指针，分别在两个链表上移动，若交点前两链表结点数不同，当A链表指针移动到尾结点后，重新将指针指到B链表头，
     * B链表指针同A，当A链表指针等于B链表指针时，说明有交点，两个指针移动了相同个数的结点，指到了相交结点。
     * 当交点前链表结点数相同，当两指针相等时，可直接找到该交点。
     *
     *
     * 法1：双指针 时间O(n),空间O(1)
     * 法2: 用set集合，空间O(n) 使用集合将一个链表存入，再将另一个链表遍历存入，遇到的第一个存不进去的结点即相交结点，
     * 若都存入则无相交结点。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) {
            return null;
        }
        ListNode pointerA;
        ListNode pointerB;
        pointerA = headA;
        pointerB = headB;
        while (pointerA!=pointerB){
            pointerA=pointerA.next;
            pointerB=pointerB.next;
            //当无交点时
            if (pointerA==null&&pointerB==null){
                return null;
            }
            //有交点时，或无交点，结点个数不同
            if (pointerA==null){
                pointerA=headB;
            }
            if (pointerB==null){
                pointerB=headA;
            }
        }
        return pointerA;
    }
}
