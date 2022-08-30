package jianzhi_offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上到下打印二叉树
 * 给定二叉树:[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 * [3,9,20,15,7]
 */
public class Solution32_1 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        root.left = node2;
        root.right = node3;
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node3.left = node4;
        node3.right = node5;
        System.out.println(Solution32_1.levelOrder(root));
    }
    public static int[] levelOrder(TreeNode root) {
        //二叉树层序遍历
        //可以利用一个队列
        /*
        1.根节点入队
        2.若队列非空，队列头结点出队，访问，头结点的左右结点入队(若存在)，然后重复此步骤
        */
        int[] zero = new int[0];
        if (root==null) return zero;
        LinkedList<TreeNode> list = new LinkedList();
        list.add(root);
        ArrayList<Integer> retArr = new ArrayList<>();
        while(!list.isEmpty()){
            TreeNode head = list.pop();
            retArr.add(head.val);
            if(head.left!=null) list.add(head.left);
            if(head.right!=null) list.add(head.right);
        }
        int[] ret = new int[retArr.size()];
        for(int i=0;i<ret.length;i++){
            ret[i] = retArr.get(i);
        }
        return ret;
    }
}
