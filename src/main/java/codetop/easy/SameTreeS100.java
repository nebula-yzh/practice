package codetop.easy;

import jianzhi_offer.TreeNode;

/**
 * @author Nebula
 * @date 2021/11/10 9:26
 * @description: 100. 相同的树 简单
 * <p>
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1：
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 */
public class SameTreeS100 {
    /**
     * 利用递归分别进入两颗树,此时能够判断两颗树结构是否相同
     * 再判断当前结点的值是否相同
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        //从上往下判断，从根到叶子
        if (q != null && p != null && p.val == q.val) {
            //两棵树的左右子树都需要判断，都为true才为true
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}
