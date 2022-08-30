package codetop.medium;

import jianzhi_offer.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Nebula
 * @date 2022/4/12 16:44
 * @description: 107. 二叉树的层序遍历 II MEDIUM
 * <p>
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[15,7],[9,20],[3]]
 */
public class S107BinaryTreeLevelOrderTraversal2 {

    /**
     * 自底向上层序遍历二叉树
     * 1、可以从上往下遍历层序遍历二叉树，然后reverse输出
     * 2、可以在添加集合的时候反向添加
     * 速度其实差不多
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int size = queue.size();
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            //弹出size个
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.pollFirst();
                list.add(tmp.val);
                if (tmp.left != null) {
                    queue.addLast(tmp.left);
                }
                if (tmp.right != null) {
                    queue.addLast(tmp.right);
                }
            }
            size = queue.size();
            res.addFirst(list);
        }
        //Collections.reverse(res);
        return res;
    }
}
