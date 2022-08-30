package codetop.easy;

import codetop.common.Node;

import java.util.List;

/**
 * @author Nebula
 * @date 2021/11/25 19:59
 * @description: 559. N 叉树的最大深度 简单 飞书一面
 * 给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 */
public class MaximumDepthOfNAryTreeS559 {

    /**
     * 类比二叉树的最大深度，递归
     * 这种写法有错误，因为当无孩子节点时，不会进入循环，导致少了一层深度
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        List<Node> children = root.children;
        //遍历每个节点
        for (Node child : children) {
            int value = maxDepth(child)+1;
            maxDepth = Math.max(maxDepth, value);
        }
        return maxDepth;
    }

    /**
     * 需要多加一个判断，保证当无孩子时深度返回1
     * @param root
     * @return
     */
    public int maxDepth1(Node root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        List<Node> children = root.children;
        //当无孩子节点时直接返回1
        if (children.isEmpty()){
            return 1;
        }
        //遍历每个节点
        for (Node child : children) {
            int value = maxDepth(child)+1;
            maxDepth = Math.max(maxDepth, value);
        }
        return maxDepth;
    }

    /**
     * 也可在最后返回时加1深度
     * @param root
     * @return
     */
    public int maxDepth2(Node root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        List<Node> children = root.children;
        //遍历每个节点
        for (Node child : children) {
            int value = maxDepth(child);
            maxDepth = Math.max(maxDepth, value);
        }
        return maxDepth+1;
    }
}
