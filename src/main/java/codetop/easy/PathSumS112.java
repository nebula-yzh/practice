package codetop.easy;

import jianzhi_offer.TreeNode;

/**
 * @author Nebula
 * @date 2021/11/16 21:14
 * @description: 112. 路径总和 简单
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum ，
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
 * 叶子节点 是指没有子节点的节点。
 */
public class PathSumS112 {
    /**
     * 该题只用判断是否存在一个路径所有结点和等于目标值，不用讲所有路径输出，将所有路径输出是中等题
     *
     * 法1:递归搜索即可，存在返回true，不存在返回false
     * 一直到叶子节点
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //递归返回条件
        if(root==null){
            return false;
        }
        //到达叶子节点时，判断最后一个结点的值是否等于剩下的值
        if (root.left==null&&root.right==null){
            return root.val==targetSum;
        }
        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }
}
