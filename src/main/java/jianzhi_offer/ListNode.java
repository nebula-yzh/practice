package jianzhi_offer;

import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ListNode)) {
            return false;
        }
        ListNode node = (ListNode) o;
        return val == node.val && next.equals(node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
