package jianzhi_offer;

public class Solution36 {
    public static void main(String[] args) {
        Node root = new Node(4);
        Node node2 = new Node(2);
        Node node3 = new Node(5);
        Node node4 = new Node(1);
        Node node5 = new Node(3);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;

        Solution36 solution36 = new Solution36();
        Node ret = solution36.treeToDoublyList(root);
        for(int i=0;i<20;i++){
            System.out.println(ret.val);
            ret = ret.right;
        }

    }

    Node pre,head;//pre结点不用new 若new的话就不是null而是有值了

    Node treeToDoublyList(Node root) {
        InOrder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    void InOrder(Node root) {
        if (root == null) return;
        InOrder(root.left);
        /*
        这里是线索化的步骤
         */
//        if (root.left == null) {//左节点
//            root.left = pre;
//        }
//        if (pre != null && pre.right == null) {//右节点
//            pre.right = root;
//        }
        /*
        变成双端链表与线索化类似但不同，需要将每个指针进行变动
         */
        root.left = pre;
        if (pre != null) {//右节点
            pre.right = root;
        }
        if(pre==null) head = root;
        pre = root;
        InOrder(root.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
