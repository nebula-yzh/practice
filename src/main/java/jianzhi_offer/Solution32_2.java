package jianzhi_offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * <p>
 * 例如:
 * 给定二叉树:[3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class Solution32_2 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        TreeNode node2 = new TreeNode(9);
//        TreeNode node3 = new TreeNode(20);
//        root.left = node2;
//        root.right = node3;
//        TreeNode node4 = new TreeNode(15);
//        TreeNode node5 = new TreeNode(7);
//        node3.left = node4;
//        node3.right = node5;
        Solution32_2 solution32_2 = new Solution32_2();
        TreeNode root = null;
        System.out.println(solution32_2.levelOrder(null));
    }
    List<List<Integer>> levelOrder(TreeNode root) {
        //层序遍历
        //利用队列来进行层序遍历
        //根节点入队，
        //若队列非空，队头结点出队，访问该结点，并将该结点的左右孩子入队（若有）(重复此步骤)
        //需要分层打印,每层打印不同
        if(root==null) return Collections.emptyList();//返回空集合而不是null
        LinkedList<TreeNode> queue = new LinkedList(); //队列
        List<List<Integer>> retList = new ArrayList<>(); //返回的集合
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> l1 = new LinkedList<>(); //暂存各结点值
            for (int i = queue.size(); i > 0; i--) {
                //不能使用(i=0;i<queue.size();i++) 因为随着下面左右结点的入队会使队列size变化
                TreeNode head = queue.pop(); //队列头出队并访问
                l1.add(head.val);
                if (head.left != null) {
                    queue.add(head.left);
                }
                if (head.right != null) {
                    queue.add(head.right);
                }
            }
            retList.add(l1);
        }
        return retList;
    }
}
