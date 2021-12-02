package codetop.easy;

import jianzhi_offer.TreeNode;

/**
 * @author Nebula
 * @date 2021/12/2 9:29
 * @description: 543. 二叉树的直径 简单
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 */
public class DiameterOfBinaryTreeS543 {
    /**
     * 与 “124. 二叉树中的最大路径和” 困难，一个套路，深度优先遍历
     *
     * 深度优先遍历计算左子树的最大深度，右子树的最大深度，相加
     * 路径长度为边的个数，是节点数-1
     *
     * 问题：直径，不一定经过根节点！  因此不是左子树最大深度加上右子树最大深度
     * 需要设置一个全局变量res（作为当前最长路径），在每次计算左右子树的深度后就将当前的左右子树的路径长度与res比较，大于则更新res
     *
     * 最后再将res与经过根节点的路径比较，返回较大的
     * @param root
     * @return
     */
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        //最后将不经过根节点的最大路径与经过根节点的路径比较，返回较大值
        return Math.max(res,left+right);
    }

    /**
     * 求最大深度
     * @param node
     * @return
     */
    public int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        //每次记录当前节点的最大路径值
        res = Math.max(res,left+right);
        return Math.max(left,right)+1;
    }
}
