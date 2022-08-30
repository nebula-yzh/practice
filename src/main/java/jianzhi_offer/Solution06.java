package jianzhi_offer;

/**
 * 从尾到头打印链表，简单
 */
public class Solution06 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        int[] a = reversePrint(head);
        for (int temp : a) {
            System.out.print(temp);

        }

    }

    public static int[] reversePrint(ListNode head) {
        //用数组,可以用递归
        if (head == null) return new int[0];
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        int[] ret = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            ret[i] = head.val;
            head = head.next;
        }
        return ret;
    }


}
