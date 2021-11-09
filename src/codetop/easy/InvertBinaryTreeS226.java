package codetop.easy;

import jianzhi_offer.TreeNode;

/**
 * @author Nebula
 * @date 2021/11/9 23:14
 * @description: 226. 翻转二叉树 简单
 * 翻转一棵二叉树。
 * 示例：
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class InvertBinaryTreeS226 {
    /**
     * 法1：使用递归翻转一棵二叉树
     * 从底向上翻转，先翻转最底的结点，再逐个往上翻转，最后翻转根节点左右子树即可完成翻转
     * 若想从顶向下，调换递归和交换代码的位置
     *
     * 法2：可以使用迭代，利用栈或队列
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        //递归到最后的结点
        invertTree(root.left);
        invertTree(root.right);
        //当当前结点左右子树不为null时，分别翻转当前结点的左右子树
        if (root.left!=null||root.right!=null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }


}
