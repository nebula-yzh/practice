package codetop.medium;

import jianzhi_offer.TreeNode;

import java.util.*;

/**
 * @author Nebula
 * @date 2021/10/27 17:01
 * @description: 145. 二叉树的后序遍历
 * 递归简单，迭代中等
 * 给定一个二叉树，返回它的后序遍历。
 * 示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * <p>
 * 后序遍历：左右根
 */
public class BinaryTreePostorderTraversalS145 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(postorderTraversalIter(root));
    }

    /**
     * 递归方法
     *
     * @param root
     * @return
     */
    List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return res;
    }

    public void postorder(TreeNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            res.add(node.val);
        }
    }

    /**
     * 迭代法，后序，左右根，不容易实现，根右左容易实现，
     * 只需将前序遍历根左右稍作修改即可
     *
     * @param node
     * @return
     */
    public static List<Integer> postorderTraversalIter2(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            node = node.left;
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * 迭代方法
     * 直接实现左右根，不容易
     * 参考题解，非反转
     *
     * @param node
     * @return
     */
    public static List<Integer> postorderTraversalIter(TreeNode node) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        TreeNode prev = null;
        while (node != null || !stack.isEmpty()) {
            //左边结点
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            //使用栈顶元素
            node = stack.pop();
            //右边结点
            if (node.right == null || node.right == prev) {
                res.add(node.val);
                //保存当前结点，当下一个结点进行判断时，认为该节点已被排序
                prev = node;
                //逻辑上置null，便于下个循环判断
                node = null;
            } else {
                stack.push(node);
                node = node.right;
            }

        }
        return res;
    }


}
