package codetop;

import jianzhi_offer.TreeNode;

/**
 * @author Nebula
 * @date 2021/11/3 17:05
 * @description: 104. 二叉树的最大深度 简单
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度3 。
 */
public class MaximumDepthOfBinaryTreeS104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        maxDepth(root);
    }
    /**
     * 深度优先搜索
     * 记录最大深度，递归返回
     * 分别递归访问左右结点，到叶子结点后，返回左右子树中的深度较大值
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //每进入一层递归，就加1
        int left = dfs(root.left) + 1;
        int right = dfs(root.right) + 1;
        //返回当前层，左右子树中更大的深度
        return Math.max(left, right);
    }
}
