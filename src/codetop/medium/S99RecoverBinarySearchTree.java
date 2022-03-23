package codetop.medium;

import codetop.common.CommonUtil;
import jianzhi_offer.ListNode;
import jianzhi_offer.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Nebula
 * @date 2022/3/23 9:57
 * @description: 99. 恢复二叉搜索树 medium
 * 给你二叉搜索树的根节点 root ，
 * 该树中的 恰好 两个节点的值被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树 。
 * <p>
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 的左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 */
public class S99RecoverBinarySearchTree {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3, 1, 4, null, null, 2};
        TreeNode root = CommonUtil.buildTree(arr);
        S99RecoverBinarySearchTree s99 = new S99RecoverBinarySearchTree();
        //s99.recoverTree(root);
        s99.recoverTree2(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 传入的是一个二叉树的根节点
     * 由于是二叉搜索树，满足左子树小于根节点，右子树大于根节点
     * O(n)空间复杂度
     * 1.使用中序遍历遍历遍，记录下节点(TreeNode)数组
     * （也可以使用一个pre记录前一个节点的值，直接进行比较）
     * 2.再遍历一遍找出不是顺序排序的两个节点，若完全有序直接返回
     * 第一个节点，是第一个按照中序遍历时候前一个节点大于后一个节点，我们选取前一个节点pre
     * 第二个节点，是在第一个节点找到之后，后面出现前一个节点大于后一个节点，我们选择后一个节点node
     * （两个节点找的方式不同）
     * 为什么呢？因为有两个错误节点，一个是大的，一个是小的，大的在前面，小的在后面
     * 大的在前面是跟小于它的节点比较（因此选择pre），小的在后面是跟大于它的节点比较（因此选择node）
     * 3.最后将记录的两个节点的值进行交换,直接交换即可
     *
     * @param root
     */
    public void recoverTree(TreeNode root) {
        dfs1(root);
        swapTreeNodeVal(err1, err2);
    }

    TreeNode pre = null;
    TreeNode err1 = null;
    TreeNode err2 = null;

    /**
     * 使用pre记录前一个节点
     * 递归中序遍历，左根右
     *
     * @param root
     */
    public void dfs1(TreeNode root) {
        if (root == null) {
            return;
        }
        //左子树
        dfs1(root.left);
        if (pre != null) {
            //找到错误节点,注意两个错误节点相邻
            if (pre.val > root.val) {
                if (err1 == null) {
                    //第一个错误节点，是选择pre
                    err1 = pre;
                }
                //第二个错误节点，第二个错误节点是选择当前节点
                err2 = root;

            }
        }
        //pre赋值
        pre = root;
        dfs1(root.right);
    }

    public void swapTreeNodeVal(TreeNode node1, TreeNode node2) {
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }


    /**
     * 假设传入的是一个二叉树数组
     * 输入：[1,3,null,null,2]
     * 输出：[3,1,null,null,2]
     *
     * @param arr
     */
    public void recoverTree2(Integer[] arr) {
        inorder(arr, 0);
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    List<Integer> list = new ArrayList<>();
    int prev = -1;
    int index1 = -1;
    int index2 = -1;

    /**
     * 中序遍历二叉树数组
     * 左根右
     *
     * @param arr
     * @param index
     */
    public void inorder(Integer[] arr, int index) {
        //递归结束
        if (index >= arr.length || arr[index] == null) {
            return;
        }
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (left <= arr.length) {
            inorder(arr, left);
        }
        //通过记录下标
        if (prev != -1) {
            if (arr[prev] > arr[index]) {
                if (index1 == -1) {
                    index1 = prev;
                }
                index2 = index;
            }
        }
        prev = index;
        //list.add(arr[index]);
        if (right <= arr.length) {
            inorder(arr, right);
        }
    }
}
