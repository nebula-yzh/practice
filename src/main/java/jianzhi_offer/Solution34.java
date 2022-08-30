package jianzhi_offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Nebula
 * @date 2021/10/5 12:13
 * @description: 剑指 Offer 34. 二叉树中和为某一值的路径 中等
 *
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的 所有路径。
 * 从树的根节点 开始往下一直到 叶节点 所经过的节点 形成一条路径。
 *
 * 给定如下二叉树，以及目标和target = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class Solution34 {
    /**
     * 返回的集合
     */
    List<List<Integer>> resList = new LinkedList<>();
    /**
     * 返回的路径，这样可以防止重复创建集合，只需要一个计算路径的集合
     */
    List<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recursive(root,target);
        return resList;
    }
    /**
     * 递归,前序遍历(根左右)+记录结点(使用一个集合-类中属性)
     * @param root
     * @param target
     * @return
     */
    public void recursive(TreeNode root,int target){
        if (root==null){
            return;
        }
        path.add(root.val);
        //用减法，不用求和，省去一个求和参数
        target -= root.val;
        //当和符合条件，且当前结点为叶子节点
        if (target==0&&root.left==null&&root.right==null){
            //重新new一个集合加入最终返回的集合中，若直接加入，当path改变时，res中的对象也会改变，重新new相当于复制集合
            resList.add(new LinkedList<>(path));
        }
        recursive(root.left,target);
        recursive(root.right,target);
        //当返回上层时，移除路径最后一个元素
        path.remove(path.size()-1);
    }
}
