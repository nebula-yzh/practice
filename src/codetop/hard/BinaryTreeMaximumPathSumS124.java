package codetop.hard;

import jianzhi_offer.TreeNode;

/**
 * @author Nebula
 * @date 2021/12/2 10:45
 * @description: 124. 二叉树中的最大路径和 困难
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。
 * 该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * 示例1：
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 *
 */
public class BinaryTreeMaximumPathSumS124 {

    /**
     * 二叉树中的最大路径和，不一定经过根节点，利用深度优先遍历
     *
     * 用一个全局变量记录当前最大的路径和
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return resMax;
    }

    /**
     * 未定初始值时，默认为0
     */
    int resMax=Integer.MIN_VALUE;
    /**
     * 深度优先
     * 从底层开始计算路径，保留值大的
     * 需要计算每个节点的路径和，与resMax比较
     * @param node
     * @return
     */
    public int dfs(TreeNode node){
        if (node==null){
            return 0;
        }
        //只有大于0的节点才能做路径共享，当前的节点的左右子树的路径和
        int left = Math.max(dfs(node.left),0);
        int right = Math.max(dfs(node.right),0);

        //经过当前节点路径的最大值,将当前节点的值与左右子树中的节点值相加
        int max = node.val+left+right;
        //最终路径的最大值，每个节点的路径和都要计算并比较，保留下最大的
        resMax = Math.max(resMax,max);
        //返回左右子树中的较大值，只返回一边
        return node.val+Math.max(left,right);
    }
}
