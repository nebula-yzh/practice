package codetop.medium;

import jianzhi_offer.TreeNode;

import java.util.*;

/**
 * @author Nebula
 * @date 2021/10/28 17:11
 * @description: 102. 二叉树的层序遍历 中等
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 */
public class BinaryTreeLevelOrderTraversalS102 {

    /**
     * 层序遍历，利用队列
     * 1.先将头结点入队，更新size，队列结点个数
     * 2.循环判断当队列非空时，依照队列中结点的个数size，依次将队列结点出队，并访问，并将该结点的非空左右结点入队
     * 3.更新size，将得到的结点值集合加入最终结果集合
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null){
            return Collections.emptyList();
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offerLast(root);
        int size = queue.size();
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode popNode = queue.pollFirst();
                temp.add(popNode.val);
                if (popNode.left != null) {
                    queue.offerLast(popNode.left);
                }
                if (popNode.right != null) {
                    queue.offerLast(popNode.right);
                }
            }
            size = queue.size();
            res.add(temp);
        }
        return res;
    }
}
