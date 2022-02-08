package codetop.medium;

import jianzhi_offer.TreeNode;

/**
 * @author Nebula
 * @date 2022/2/5 12:42
 * @description: 129. 求根节点到叶节点数字之和 中等
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 * 提示：
 * 树中节点的数目在范围 [1, 1000] 内
 * 0 <= Node.val <= 9
 * 树的深度不超过 10
 */
public class S129SumRootToLeafNumbers {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
        S129SumRootToLeafNumbers s129SumRootToLeafNumbers = new S129SumRootToLeafNumbers();
        int i = s129SumRootToLeafNumbers.sumNumbers(root);
        System.out.println(i);
    }


    /**
     * 二叉树遍历
     * 1.利用深度优先搜索，递归
     * 设置类变量集合
     * 每次到叶子节点时，计算当前路径值添加到集合中
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return 0;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1;
    }
}
