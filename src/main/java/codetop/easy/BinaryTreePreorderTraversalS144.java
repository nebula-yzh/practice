package codetop.easy;


import jianzhi_offer.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Nebula
 * @date 2021/10/27 16:33
 * @description: 144. 二叉树的前序遍历 简单
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 前序遍历，根左右
 * 法1：递归方法
 * 法2：迭代方法
 */
public class BinaryTreePreorderTraversalS144 {


    /**
     * 递归法前序遍历二叉树
     *
     * @param root
     * @return
     */
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return res;
    }

    public void preorder(TreeNode root) {
        if (root != null) {
            res.add(root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }

    /**
     * 迭代法前序遍历二叉树
     * 手动维护一个栈
     *
     * @param node
     * @return
     */
    public List<Integer> preorderTraversalIter(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }
}
