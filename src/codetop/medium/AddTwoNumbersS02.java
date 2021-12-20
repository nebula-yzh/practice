package codetop.medium;

import jianzhi_offer.ListNode;

/**
 * @author Nebula
 * @date 2021/10/11 10:34
 * @description: 2. 两数相加 中等
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 法1：每位数字以逆序存储，我们先计算低位，将低位和的除10余数作为新节点的值，将除10十位数作为进位值传递到高位，高位将该值加到原来的值
 * 步骤同上。
 */
public class AddTwoNumbersS02 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode l2 = new ListNode(9, new ListNode(9));
        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //低位进位
        int carry = 0;
        //低位余数
        int remainder = 0;
        //返回的链表
        ListNode resHead = new ListNode();
        ListNode node = resHead;
        //只有当两个链表都计算完时才退出循环,若进位还存在说明还需要一个结点
        while (l1 != null || l2 != null || carry != 0) {
            int l1Value;
            int l2Value;
            //判断当前链表是否已经结束，结束了，将值给0
            if (l1 == null) {
                l1Value = 0;
            } else {
                l1Value = l1.val;
            }
            if (l2 == null) {
                l2Value = 0;
            } else {
                l2Value = l2.val;
            }
            //两个结点值的和,再加上前一个结点的进位，为当前结点的值
            int nodeValSum = l1Value + l2Value + carry;
            //进位
            carry = nodeValSum / 10;
            //余数，新链表值
            remainder = nodeValSum % 10;
            //新链表
            node.next = new ListNode(remainder);
            node = node.next;
            //当两指针不为空时，才进行后移
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return resHead.next;
    }
}
