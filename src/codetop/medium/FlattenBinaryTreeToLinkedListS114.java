package codetop.medium;

import jianzhi_offer.TreeNode;

/**
 * @author Nebula
 * @date 2021/11/17 21:17
 * @description: 114. 二叉树展开为链表 中等
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * 示例 1：
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 */
public class FlattenBinaryTreeToLinkedListS114 {
    /**
     * 法1：递归，从底向上
     * 1.将左子树连接到右子树和根节点中间
     * 注意连接时应将左子树的最右结点跟右子树相连，根节点跟左子树根节点相连，左子树置null
     *
     * 法2：也可以使用迭代
     * 从上往下
     * @param root
     */
    public void flatten(TreeNode root) {
        //法1
        //递归中止条件
        if (root==null||(root.left==null&&root.right==null)){
            return;
        }
        //递归左子树右子树
        flatten(root.left);
        flatten(root.right);
        if (root.left!=null){
            TreeNode temp = root.left;
            //找到左子树的最右结点
            while (temp.right!=null){
                temp = temp.right;
            }
            //将左子树连接在根节点与右子树中间
            temp.right = root.right;
            root.right = root.left;
            //将左子树断开
            root.left=null;
        }
    }
}
