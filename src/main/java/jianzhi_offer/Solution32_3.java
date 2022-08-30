package jianzhi_offer;

import java.util.*;

/**
 * 从上到下打印二叉树
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * 例如:
 * 给定二叉树:[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class Solution32_3 {
    /**
     * 类似32_2
     * 但在加入返回集合时，将暂存结点的集合做一个翻转
     * 使用队列辅助，非递归
     * <p>
     * 1.根节点入队
     * 2.判断队列是否为空，若不为空则头结点出队并访问，将该结点左右结点入队(若存在)，重复2
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        Queue<TreeNode> queue = new LinkedList();  //队列
        List<List<Integer>> retList = new ArrayList<>(); //返回的集合
        queue.add(root);//根节点入队
        int k=0; //用作层数的标识
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();//暂存各节点的值
            k++;
            for (int i = queue.size(); i > 0; i--) {  //逐层打印，根据队列的节点数
                TreeNode head = queue.poll();
                list.add(head.val);
                if (head.left != null) queue.add(head.left);
                if (head.right != null) queue.add(head.right);
            }
            if(k%2==0){//偶数层
                Collections.reverse(list); //翻转
            }
            retList.add(list);
        }
        return retList;
    }

}
