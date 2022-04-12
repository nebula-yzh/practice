package codetop.medium;

import codetop.common.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Nebula
 * @date 2022/4/12 17:13
 * @description: 429. N 叉树的层序遍历 MEDIUM
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * <p>
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 */
public class S429NAryTreeLevelOrderTraversal {

    /**
     * N叉树的层序遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();

        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
        int size = queue.size();
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node tmp = queue.pollFirst();
                list.add(tmp.val);
                for (Node node : tmp.children) {
                    queue.addLast(node);
                }
            }
            size = queue.size();
            res.add(list);
        }
        return res;
    }
}
