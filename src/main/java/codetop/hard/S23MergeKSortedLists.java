package codetop.hard;

import jianzhi_offer.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Nebula
 * @date 2022/3/9 15:56
 * @description: 23. 合并K个升序链表 困难
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * <p>
 * 提示：
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 */
public class S23MergeKSortedLists {

    /**
     * 法1：
     * 使用归并排序，将所有链表进行归并(归并排序中的归并步骤)
     * 每次使用一个临时节点，一步步将所有链表归并
     * 法2：
     * 使用优先队列，将所有节点塞进队列
     * <p>
     * 快手一面，先让合并两个有序链表，然后让分析复杂度，接着让口述合并k个排序链表的思路，
     * 答出排序后又问有没有其他办法，当时不知道优先队列可以解，这应该是一套组合拳。
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        //法1 归并
        if (lists.length == 0) {
            return null;
        }
        ListNode newHead = new ListNode();
        //因为每次要归并两个链表，因此需先拿出一个
        newHead.next = lists[0];

        //遍历每个链表
        for (int i = 1; i < lists.length; i++) {
            //归并后链表
            ListNode cur = new ListNode();
            //暂存头节点
            ListNode head = cur;
            //待归并的两个链表
            ListNode node1 = newHead.next;
            ListNode node2 = lists[i];
            //开始归并
            while (node1 != null && node2 != null) {
                if (node1.val <= node2.val) {
                    cur.next = node1;
                    node1 = node1.next;
                } else {
                    cur.next = node2;
                    node2 = node2.next;
                }
                cur = cur.next;
            }
            //连接最后部分
            if (node1 == null) {
                cur.next = node2;
            }
            if (node2 == null) {
                cur.next = node1;
            }
            //将归并后的节点连接到下一次归并的节点
            newHead.next = head.next;
        }

        return newHead.next;
    }

    /**
     * 法2
     * 使用优先队列
     * 使用val作为比较值，将节点塞进队列，再一个个取出
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            while (node != null) {
                queue.add(node);
                node = node.next;
            }
        }
        ListNode temp = new ListNode();
        ListNode head = temp;
        while (!queue.isEmpty()) {
            temp.next = queue.poll();
            //断链，避免形成环
            temp.next.next = null;
            temp = temp.next;
        }
        return head.next;
    }


}
