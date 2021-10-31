package codetop;

import jianzhi_offer.TreeNode;

/**
 * @author Nebula
 * @date 2021/10/31 20:52
 * @description: 236. 二叉树的最近公共祖先 中等
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 */
public class LowestCommonAncestorOfABinaryTreeS236 {

    /**
     * 递归法，递归到最后,从底往上进行判断（深度优先搜索）
     * 递归中止条件
     * 可以当做后序遍历自底向上，遇到p返回p，遇到q返回q，都没遇到返回空
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归退出条件，当前结点为null或者等于待搜索结点时返回
        if (root == null || root == q || root == p) {
            return root;
        }
        //进入左子树
        TreeNode leftAncestor = lowestCommonAncestor(root.left, p, q);
        //进入右子树
        TreeNode rightAncestor = lowestCommonAncestor(root.right, p, q);
        //左边不为空，那么在左边找到了结点
        if (leftAncestor != null) {
            //右边不为空则在右边找到了结点
            if (rightAncestor != null) {
                //因此返回当前结点，作为祖先
                return root;
            }
            //右节点为空，则返回左节点作为祖先
            return leftAncestor;
        }
        //左节点为空，返回右节点作为祖先，左右结点都为空就返回null即可
        return rightAncestor;
    }
}
