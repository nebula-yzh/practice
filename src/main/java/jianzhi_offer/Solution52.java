package jianzhi_offer;

import java.util.HashSet;

/**
 * 两个链表的第一个公共结点
 */
public class Solution52 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //使用集合
        if(headA==null||headB==null) {
            return null;
        }
        HashSet set = new HashSet();
        while(headA!=null){
            set.add(headA);
            headA = headA.next;
        }
        while(headB!=null){
            boolean b = set.contains(headB);
            if(b) {
                return headB;
            }
            headB=headB.next;
        }
        return null;
    }
}
