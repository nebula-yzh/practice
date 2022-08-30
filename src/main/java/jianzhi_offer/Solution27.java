package jianzhi_offer;


/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 例如输入：
 *     4
 *   /   \
 *  2     7
 * / \   / \
 * 1  3 6  9
 * 镜像输出：
 *     4
 *   /   \
 *   7    2
 *  / \  / \
 *  9  6 3 1
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 */
public class Solution27 {

    /**
     * 二叉树镜像
     * 可以从上往下镜像，也可以从叶子节点往上镜像
     * 我们从叶子往上：
     * 递归中止条件：节点为空
     * 类似后序遍历，左右根
     * 也可以为根左右，先对根节点做交换，再依次做交换
     * @param root
     * @return
     */
     TreeNode mirrorTree(TreeNode root) {
         if(root==null){
             return null;
         }
         mirrorTree(root.left);
         mirrorTree(root.right);
         //交换左右结点
         if(root.left!=null||root.right!=null){
             TreeNode tempNode;
             tempNode = root.left;
             root.left = root.right;
             root.right = tempNode;
         }
        return root;
    }

}

