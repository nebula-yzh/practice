package codetop.medium;

import jianzhi_offer.TreeNode;

import java.util.ArrayList;

/**
 * @author Nebula
 * @date 2022/2/5 12:42
 * @description: 129. 求根节点到叶节点数字之和 中等
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 * 提示：
 * 树中节点的数目在范围 [1, 1000] 内
 * 0 <= Node.val <= 9
 * 树的深度不超过 10
 */
public class S129SumRootToLeafNumbers {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
        S129SumRootToLeafNumbers s129SumRootToLeafNumbers = new S129SumRootToLeafNumbers();
        int i = s129SumRootToLeafNumbers.sumNumbers(root);
        System.out.println(i);
    }


    /**
     * 思路一：回溯
     * 借助集合path保存走过的路径，当走到叶子结点时，遍历集合里之前的值，并构成一个整数，然后保存在sum中
     * 每次计算结束一条路径后要移除集合中的最后一个元素
     * 计算sum，注意为多条路径的sum
     * 思路二：
     * 带着sum逐层深入，每往下一层sum就*10，最后返回左边+右边的值；
     */
    int sum = 0;
    ArrayList<Integer> path = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        dfs1(root);
        return sum;
        //return dfs2(root,0);
    }

    /**
     * 法1：回溯
     * 借助集合path保存走过的路径，当走到叶子结点时，遍历集合里之前的值，并构成一个整数，然后保存在sum中
     *
     * @param node
     */
    public void dfs1(TreeNode node) {
        //递归结束条件
        if (node == null) {
            return;
        }
        //添加路径上的值
        path.add(node.val);
        //到达叶子节点
        if (node.left == null && node.right == null) {
            for (int i = 0, size = path.size(); i < size; i++) {
                //sum为所有路径的和，因此每次与其他路径相加时，从高位开始计算
                //或者，单独写一个方法，每次将集合中元素的和求出来，与之前的路径的相加
                sum = sum + (int) Math.pow(10, size - 1 - i) * path.get(i);
            }
        }
        dfs1(node.left);
        dfs1(node.right);
        //回溯，删除最后一个元素
        path.remove(path.size() - 1);
    }

    /**
     * 法2：
     * 带着sum逐层深入，每往下一层sum就*10，最后返回左边+右边的值；
     * 每个节点的值为其左右节点的和，上一层往下一层送的值都需要*10
     *
     * @param node
     */
    public int dfs2(TreeNode node, int prevSum) {
        if (node == null) {
            return 0;
        }
        //计算当前节点的值（往下层送的值）
        int sum = prevSum * 10 + node.val;
        //若到了叶子节点
        if (node.left == null && node.right == null) {
            //直接返回当前的值
            return sum;
        } else {
            //最后返回左右节点的和
            return dfs2(node.left, sum) + dfs2(node.right, sum);
        }
    }
}
