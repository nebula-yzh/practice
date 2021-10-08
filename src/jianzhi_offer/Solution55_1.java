package jianzhi_offer;

/**
 * LeetCode 剑指offer55题 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度3 。
 */
public class Solution55_1 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        root.left = node2;
        root.right = node3;
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node2.left = node4;
        node3.right = node5;
        System.out.println(Solution55_1.maxDepth(root));
    }

    /**
     * 求二叉树最大深度
     * 类似后序遍历，左右根
     * 利用递归
     * 计算左右子树的深度，然后比较返回深度大的值
     * 递归中止条件：当前结点为空
     *
     * **还可以使用层序遍历**
     * @param root
     * @return 最大深度
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftValue = maxDepth(root.left) + 1;
        int rightValue = maxDepth(root.right) + 1;
        return leftValue > rightValue ? leftValue : rightValue;
    }
}


