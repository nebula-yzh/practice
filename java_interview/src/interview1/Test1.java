package interview1;

public class Test1 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        //node2.next=node3;
//        node3.next=node4;
//        node4.next=node5;
        ListNode listNode = reverseBetween(head, 1, 2);
        System.out.println(listNode);
    }

//    反转链表，反转部分链表，leetcode92中等
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        //迭代
        if(left==right) return head;  //若只有一个结点
        int lFlag=1,rFlag=1;
        ListNode lNode=head;
        ListNode temp;
        ListNode preLNode=head;
        while(lFlag<left){
            if(lFlag==left-1) preLNode = lNode;
            lNode=lNode.next;
            lFlag++;
        }
        ListNode rNode=lNode;
        while(rFlag<=right-left){
            rNode=rNode.next;
            rFlag++;
        }
        ListNode newLeft = rNode.next;
        for(int i=0;i<=right-left;i++) {
            temp = lNode.next;
            lNode.next = newLeft;
            newLeft = lNode;
            lNode = temp;

        }
        if (left == 1) return rNode;  //若从头开始反转
        else preLNode.next = rNode;
        return head;

    }

}
