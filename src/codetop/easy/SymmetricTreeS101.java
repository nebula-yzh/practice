package codetop.easy;

import jianzhi_offer.TreeNode;

/**
 * @author Nebula
 * @date 2021/11/9 23:37
 * @description: 101. 对称二叉树 简单
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class SymmetricTreeS101 {

    /**
     * 1.可以将根节点左子树翻转(226题)，再判断左右子树是否相同(100题)
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return false;
    }
}
