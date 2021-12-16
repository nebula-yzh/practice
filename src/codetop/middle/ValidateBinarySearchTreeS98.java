package codetop.middle;

import jianzhi_offer.TreeNode;

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
     * 法1：递归，从底向上进行判断
     * 1.递归到最底层，若左右子树都为null返回true，还有一个子节点为null的情况
     * 2.判断当前节点的左节点是否小于当前节点，右节点是否大于当前节点，是返回true，否返回false
     * 问题：
     * 当前节点满足二叉搜索树。但上一节点不一定满足，需要当前节点，大于所有左子树节点，小于右子树节点，才能算满足二叉搜索树
     * <p>
     * 法2：中序遍历
     *
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        return isValid(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    /**
     * 利用左右边界
     *
     * @param root
     * @param lower 左边界 (lower,upper)
     * @param upper 有边界
     * @return
     */
    public static boolean isValid(TreeNode root, int lower, int upper) {
        if (root == null) {
            return false;
        }

        if (root.val <= lower || root.val >= upper) {
            return false;
        }

        return isValid(root.left,lower,root.val)&&isValid(root.right,root.val,upper);
    }
}
