package codetop.medium;

import jianzhi_offer.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Nebula
 * @date 2021/11/10 12:10
 * @description: 143. 重排链表 中等
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0→ L1→ … → Ln-1→ Ln
 * 请将其重新排列后变为：
 * L0→Ln→L1→Ln-1→L2→Ln-2→ …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 * 输入: head = [1,2,3,4]
 * 输出: [1,4,2,3]
 * 示例 2:
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,5,2,4,3]
 */
public class S143ReorderList {
    /**
     * 法1：可以先用快慢指针找到链表中点，再将链表的后半部分反转
     * 从链表头开始，每个链表取一个结点，拼在一起。
     * 考察了双指针找中点，反转链表，归并两个链表。
     *
     * 法2：利用双端队列，将链表入队，分别从头尾出队，将出队的结点连在一起。
     * @param head
     */
    public void reorderList(ListNode head) {
        //法2
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode temp = new ListNode();
        //入队
        while (head!=null){
            deque.offerLast(head);
            head=head.next;
        }
        while (!deque.isEmpty()){
            temp.next=deque.pollFirst();
            temp = temp.next;
            //奇数个结点时会少一个，偶数个结点队列刚好取完，多加一个判断
            if (!deque.isEmpty()){
                temp.next = deque.pollLast();
                temp = temp.next;
            }
        }
        //最后注意结点置null，否则形成环
        temp.next=null;
    }
}
