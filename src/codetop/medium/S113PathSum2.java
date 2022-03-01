package codetop.medium;

import codetop.common.CommonUtil;
import jianzhi_offer.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Nebula
 * @date 2022/3/1 9:27
 * @description: 113. 路径总和 II 中等
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 叶子节点是指没有子节点的节点。
 */
public class S113PathSum2 {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{
                5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1
        };
        TreeNode root = CommonUtil.buildTree(array);
        List<List<Integer>> lists = pathSum(root, 22);
        lists.forEach(System.out::println);
    }

    /**
     * 二叉树，计算路径值，并最终返回每个符合条件路径的列表
     * <p>
     * 深度优先搜索+回溯
     * 由于需要将每条符合条件的路径保留下来，因此判断当前结点不符合时，需要回溯到上一结点
     * 1.递归返回的条件：root==null
     * 2.有一个集合保存路径值，当到达叶子节点时，若该路径符合条件，将路径上的值加入res集合(需要重新new一个然后加入集合)，若不符合则直接返回
     * 3.当进行递归时，每次结束，需要删除路径最后一个元素，以便回溯
     *
     * @param root
     * @param targetSum
     * @return
     */
    static List<Integer> pathValue = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return Collections.emptyList();
        }
        dfsPathSum(root, targetSum);
        return res;
    }

    public static void dfsPathSum(TreeNode root, int targetSum) {
        //递归返回条件
        if (root == null) {
            return;
        }
        //添加路径
        pathValue.add(root.val);
        //到达叶子节点
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                res.add(new ArrayList<>(pathValue));
            }
        }
        dfsPathSum(root.left, targetSum - root.val);
        dfsPathSum(root.right, targetSum - root.val);
        //移除路径最后一个元素
        pathValue.remove(pathValue.size() - 1);
    }
}
