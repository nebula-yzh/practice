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
     * 注意找到递归中止条件
     * 可以当做后序遍历自底向上，遇到p返回p，遇到q返回q，都没遇到返回空
     *
     * root是 p,q公共祖先有以下几种情况：
     * p 和 q 在 root 的子树中，且分列 root的 异侧（即分别在左、右子树中）；
     * p = root ，且 q 在 root 的左或右子树中；
     * q = root ，且 p 在 root 的左或右子树中；
     *
     * 返回值： 根据 left 和 right ，可展开为四种情况；
     * 当 left 和 right 同时为空 ：说明 root 的左 / 右子树中都不包含 p,q ，返回 null ；
     * 当 left 和 right 同时不为空 ：说明 p, q分列在 root 的 异侧 （分别在 左 / 右子树），因此 root为最近公共祖先，返回 root；
     * 当 left 为空 ，right 不为空 ：p,q 都不在 root 的左子树中，直接返回 right 。具体可分为两种情况：
     * p,q其中一个在 root 的 右子树 中，此时 right 指向 p（假设为 p ）；
     * p,q 两节点都在 root 的 右子树 中，此时的 right 指向 最近公共祖先节点 ；
     * 当 left 不为空 ， right 为空 ：与情况 3. 同理；
     *
     * @param root
     * @param p
     * @param q
     * @return 找到的 p或q
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
        //当左边为空时，未找到结点，那么直接返回右节点，无论右节点是否为空
        if(leftAncestor==null) {
            return rightAncestor;
        }
        //当左节点不为空，右节点为空时，返回左节点
        if(rightAncestor==null){
            return leftAncestor;
        }
        //当左右结点都不为空时，p，q在异侧，root为公共祖先
        return root;
    }
}
