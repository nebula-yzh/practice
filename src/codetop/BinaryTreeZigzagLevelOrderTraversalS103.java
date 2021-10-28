package codetop;

import jianzhi_offer.TreeNode;

import java.util.*;

/**
 * @author Nebula
 * @date 2021/10/28 15:33
 * @description: 103. 二叉树的锯齿形层序遍历 中等
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树[3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层序遍历如下：
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * 法1：类似层序遍历，利用一个双端队列，上一层从左往右，下一层则从右往左，奇数层从左往右，偶数层从右往左
 * 难点，奇数偶数层之间，出队入队顺序如何转换（无需转换）
 * 1.奇数层，从队头入队，队头出队，入队结点从左往右，出队结点从左往右
 * 2.偶数层，从队尾入队，队尾出队，入队结点从左往右，出队结点从右往左
 * <p>
 * 难点：怎么分辨不同的层，将不同层的结点值加入不同的集合
 * 不用分辨不同的层
 * 法2：先进行层序遍历，层序遍历从左到右，将偶数的集合，逆序，从右到左
 * 时间复杂度高，因为后续的逆序
 */
public class BinaryTreeZigzagLevelOrderTraversalS103 {

    /**
     * 类似层序遍历
     * 利用一个队列，上一层从左往右，下一层则从右往左，奇数层从左往右，偶数层从右往左
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offerFirst(root);
        int size = queue.size();
        //判断是奇数层还是偶数层
        boolean oddLevel = true;
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                if(oddLevel){
                    //奇数层出队
                    TreeNode popNode = queue.pollFirst();
                    temp.add(popNode.val);
                    //偶数层入队
                    if (popNode.left != null) {
                        queue.offerLast(popNode.left);
                    }
                    if (popNode.right != null) {
                        queue.offerLast(popNode.right);
                    }
                }
                else {
                    //偶数层出队
                    TreeNode popNode = queue.pollLast();
                    temp.add(popNode.val);
                    //奇数层入队
                    if (popNode.right != null) {
                        queue.offerFirst(popNode.right);
                    }
                    if (popNode.left != null) {
                        queue.offerFirst(popNode.left);
                    }
                }
            }
            oddLevel = !oddLevel;
            size = queue.size();
            res.add(temp);
        }
        return res;
    }


    /**
     * 先层序遍历，再将偶数层逆序
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offerLast(root);
        int size = queue.size();
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode popNode = queue.pollFirst();
                temp.add(popNode.val);
                if (popNode.left != null) {
                    queue.offerLast(popNode.left);
                }
                if (popNode.right != null) {
                    queue.offerLast(popNode.right);
                }
            }
            size = queue.size();
            res.add(temp);
        }
        for (int i = 0, len = res.size(); i < len; i++) {
            //偶数
            if (i%2==1){
                Collections.reverse(res.get(i));
            }
        }
        return res;
    }
}
