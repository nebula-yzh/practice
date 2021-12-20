package codetop.medium;

import jianzhi_offer.TreeNode;

import java.util.*;

/**
 * @author Nebula
 * @date 2021/11/15 20:40
 * @description: 199. 二叉树的右视图 中等
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 示例 1:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * 示例 3:
 * 输入: []
 * 输出: []
 */
public class BinaryTreeRightSideViewS199 {
    /**
     * 利用层序遍历，将除根节点外每层的最后一个结点加入返回的链表即可
     * 层序遍历使用队列,当队列不为空时，出队，将出队结点的左右(非空)结点入队
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root==null){
            return Collections.emptyList();
        }
        Deque<TreeNode> queue = new ArrayDeque();
        queue.addLast(root);
        //队列大小（该层结点个数）
        int size = queue.size();
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.pollFirst();
                if (temp.left!=null){
                    queue.addLast(temp.left);
                }
                if (temp.right!=null){
                    queue.addLast(temp.right);
                }
                //将该层最后一个结点加入链表
                if (i==size-1){
                    res.add(temp.val);
                }
            }
            //重新更新队列大小（该层结点个数）
            size = queue.size();
        }
        return res;
    }
}
