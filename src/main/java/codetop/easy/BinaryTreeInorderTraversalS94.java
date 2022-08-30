package codetop.easy;

import jianzhi_offer.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Nebula
 * @date 2021/10/26 19:47
 * @description: 94. 二叉树的中序遍历 简单
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 * 法1：递归实现中序，左根右
 * 法2：迭代实现中序
 */
public class BinaryTreeInorderTraversalS94 {
    /**
     * 递归实现中序，注意递归中止条件
     * @param root
     * @return
     */
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return res;
    }
    public void inorder(TreeNode root) {
        //递归中止条件
        if (root != null) {
            inorder(root.left);
            res.add(root.val);
            inorder(root.right);
        }
    }

    /**
     * 迭代法,递归隐式的维护了一个栈，迭代我们自己手动模拟一个栈
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalInter(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        while (root!=null || !stack.isEmpty()){
            //一个结点一直向左找到尾，触底反弹
            while (root!=null){
                //将沿路结点都入栈
                stack.push(root);
                root = root.left;
            }
            //当某个结点的左到边界时，弹出栈，访问该值，并将该右节点如同左节点做一次循环
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

}
