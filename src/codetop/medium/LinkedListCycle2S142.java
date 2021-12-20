package codetop.medium;

import jianzhi_offer.ListNode;

/**
 * @author Nebula
 * @date 2021/11/22 20:56
 * @description: 142. 环形链表 II 中等
 * 给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 * <p>
 * 示例1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 */
public class LinkedListCycle2S142 {

    /**
     * 简单版只需判断是否有环
     * 中等版需要找到开始入环的第一个结点
     * <p>
     * 法1：可以用set集合，第一个加不进去的结点就是入环的第一个结点（空间复杂度高）
     * <p>
     * 法2：利用快慢指针，快指针走两步，慢指针走一步，当快慢指针相等时表示有环，此时让快指针等于head，快慢指针继续走,
     * 且每次都走一步，当再次相遇时，就是入环的第一个结点。（掌握数学推导）
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                //当存在环环就退出循环
                fast = head;
                break;
            }
        }
        //判断是否满足条件，以及一个两个结点的特殊情况
        if (fast!=head||fast.next==null||fast.next.next == null){
            return null;
        }
        //走到入环第一个结点
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
