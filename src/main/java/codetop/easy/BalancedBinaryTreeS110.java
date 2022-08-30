package codetop.easy;

import jianzhi_offer.TreeNode;

/**
 * @author Nebula
 * @date 2021/11/4 17:05
 * @description: 110. 平衡二叉树 简单
 * <p>
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 */
public class BalancedBinaryTreeS110 {
    public static void main(String[] args) {
        //[1,2,2,3,null,null,3,4,null,null,4]
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(3,new TreeNode(4),null),null),new TreeNode(2,null,new TreeNode(3,null,new TreeNode(4))));
        boolean balanced = isBalanced(root);
        System.out.println(balanced);
    }
    /**
     *
     * 方法错误
     * 类比求树的最大深度
     * 当左右子树的高度差大于1，直接返回false
     * 若未大于1，最终返回true
     *
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        int res = maxDepth(root);
        return res > 0;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right);
    }

}
