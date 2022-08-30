package codetop.common;

import java.util.List;

/**
 * @author Nebula
 * @date 2021/11/25 20:00
 * @description: N叉树
 *
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
