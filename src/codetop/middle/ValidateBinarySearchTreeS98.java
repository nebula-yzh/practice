package codetop.middle;

import jianzhi_offer.TreeNode;

import java.util.*;

/**
 * @author Nebula
 * @date 2021/12/16 16:22
 * @description: 98. 验证二叉搜索树 中等
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 示例 1：
 * 输入：root = [2,1,3]
 * 输出：true
 * 示例 2：
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 */
public class ValidateBinarySearchTreeS98 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4, null, null), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        boolean validBST = isValidBST(root);
        System.out.println(validBST);
    }

    /**
     * 法1：递归，从上往下进行判断
     * 1.递归到最底层，若当前结点为null返回true
     * 2.利用左右边界，判断当前结点值是否在边界内，不在直接返回false
     * 3.若在，则继续往下递归
     * 问题：
     * 当前节点满足二叉搜索树。但上一节点不一定满足，需要当前节点，大于所有左子树节点，小于右子树节点，才能算满足二叉搜索树
     * 因此利用一个区间
     * <p>
     * 法2：中序遍历，利用栈，判断当前结点值，是否比前一个结点值大，若小返回false
     *
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 递归，利用左右边界
     * 法1：
     *
     * @param root
     * @param lower 左边界 (lower,upper)
     * @param upper 右边界
     * @return
     */
    public static boolean isValid(TreeNode root, long lower, long upper) {
        //递归返回条件，到叶子节点
        if (root == null) {
            return true;
        }

        if (root.val <= lower || root.val >= upper) {
            return false;
        }

        return isValid(root.left, lower, root.val) && isValid(root.right, root.val, upper);
    }

    /**
     * 法2:
     * 迭代中序遍历，手动模拟栈
     * 左根右
     * 每次判断当前元素，是否大于栈顶元素，大于则继续遍历，否则返回false
     * 用数组保存遍历的值，也可只保存前一个值即可
     * @param root
     * @return
     */
    public static boolean isValid2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> res = new ArrayDeque<>();
        //满足两个条件中任意一个，循环继续
        while (root != null || !stack.isEmpty()) {
            //一直找到底
            while (root!=null){
                //将沿路的结点都入栈，后续用
                stack.push(root);
                root=root.left;
            }
            //结点出栈,赋值给root
            root = stack.pop();
            //判断当前元素是否大于前一个元素
            if (!res.isEmpty()&&root.val<=res.peek()){
                return false;
            }
            res.push(root.val);
            //若当前结点存在右子树，继续
            root = root.right;
        }
        return true;
    }
}
