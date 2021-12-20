package codetop.medium;


import java.util.HashMap;
import java.util.Objects;

/**
 * @author Nebula
 * @date 2021/11/17 20:55
 * @description: 138. 复制带随机指针的链表 中等
 *
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的深拷贝。深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
 * 复制链表中的指针都不应指向原链表中的节点 。
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * 返回复制链表的头节点。
 * 用一个由n个节点组成的链表来表示输入/输出中的链表。每个节点用一个[val, random_index]表示：
 * val：一个表示Node.val的整数。
 * random_index：随机指针指向的节点索引（范围从0到n-1）；如果不指向任何节点，则为null。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 */
public class CopyListWithRandomPointerS138 {
    /**
     * 法 1：利用hashmap复制
     * 1.将待复制链表中的每个结点依次复制（新建结点）到map中，用原来的结点作为key，新建的结点作为value
     * 2.再根据原来的结点在map中找到复制的结点，将结点next连接起来，random结点也连接起来
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        HashMap<Node,Node> map = new HashMap<>(16);
        //当前操作的结点
        Node cur = head;

        while (cur!=null){
            //新建结点并放入map
            map.put(cur, new Node(cur.val));
            cur=cur.next;
        }
        cur = head;
        while (cur!=null){
            //将链表根据原链表的顺序连接起来
            map.get(cur).next = map.get(cur.next);
            //将链表的random结点连接起来
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);

    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Node)) {
            return false;
        }
        Node node = (Node) o;
        return val == node.val && next.equals(node.next) && random.equals(node.random);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next, random);
    }
}
