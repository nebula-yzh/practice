package codetop.medium;

import jianzhi_offer.TreeNode;

import java.util.HashMap;

/**
 * @author Nebula
 * @date 2021/12/16 9:36
 * @description: 105. 从前序与中序遍历序列构造二叉树 中等
 * <p>
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 * 保证每个元素都不相同
 * <p>
 * 示例1：
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 */
public class S105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode node = buildTree(preorder, inorder);
        System.out.println(node);
    }

    /**
     * 递归构造，首先前序遍历是根左右，中序遍历左根右，可用通过找到前序遍历的根，划分中序遍历的左右子树，再找再划分
     * 1.通过前序的遍历的根节点，划分中序遍历的左右子树，当前根节点就是我们需要构造的节点
     * 2.记录当前根节点的位置，划分左右子树，每次递归需要将当前子树的起始和结束位置传入，以便划分
     * 3.递归到最后只有一个节点，即起始位置等于结束位置时返回（递归结束条件）
     * 注意边界条件
     * @param preorder
     * @param inorder
     * @return
     */
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    /**
     * 递归构造树
     * 法1：循环查找中序中根节点
     * 法2：可以使用HashMap，减少查找时间复杂度
     * @param preorder 先序遍历数组
     * @param pStart   待构造数组起始
     * @param pEnd     待构造数组结束 [pStart,pEnd)，左闭右开
     * @param inorder  中序遍历数组
     * @param iStart   待构造数组起始
     * @param iEnd     待构造数组结束
     * @return 返回二叉树节点
     */
    public static TreeNode buildTreeHelper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart == pEnd) {
            return null;
        }
        //记录根节点
        int pRoot = preorder[pStart];
        TreeNode node = new TreeNode(pRoot);
        //找到中序遍历中的根节点位置
        int iRootPos = map.get(pRoot);
        //for (int i = iStart; i < iEnd; i++) {
        //    if (inorder[i] == pRoot) {
        //        iRootPos = i;
        //        break;
        //    }
        //}
        //左子树节点个数
        int leftNum = iRootPos - iStart;
        //右子树节点个数
        int rightNum = iEnd - iRootPos - 1;
        //递归左子树
        node.left = buildTreeHelper(preorder, pStart + 1, pStart + leftNum + 1, inorder, iStart, iRootPos);

        //递归右子树
        node.right = buildTreeHelper(preorder, pStart + leftNum + 1, pStart + leftNum + rightNum + 1, inorder, iRootPos + 1, iRootPos + rightNum + 1);
        return node;
    }
}
