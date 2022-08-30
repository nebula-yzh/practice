package codetop.easy;

import jianzhi_offer.ListNode;

import java.util.HashSet;

/**
 * @author Nebula
 * @date 2021/10/12 22:38
 * @description: 141环形链表 简单
 *
 * 给定一个链表，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为
 * 了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点.
 */
public class LinkedListCycleS141 {

    /**
     * 法1：利用set集合的性质记录链表，当有链表结点无法加入时，则存在环，都加入了，则无环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head!=null){
            if (!set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 法2：利用双指针，快慢指针，因为又快又慢，因此当两个指针同时指导一个结点时证明有环，没有则无环
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        //在head结点前，连接一个空结点，便于快慢指针移动及循环判断
        ListNode slow = new ListNode();
        slow.next = head;
        ListNode fast = slow;

        while (slow.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                return true;
            }
            //特殊判断
            if (fast.next==null){
                return false;
            }
        }
        return false;
    }
}
