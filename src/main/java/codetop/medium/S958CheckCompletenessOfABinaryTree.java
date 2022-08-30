package codetop.medium;

import jianzhi_offer.TreeNode;

import java.util.LinkedList;

/**
 * @author Nebula
 * @date 2021/11/16 18:02
 * @description: 958. 二叉树的完全性检验 中等
 * 给定一个二叉树，确定它是否是一个完全二叉树。
 *
 * 百度百科中对完全二叉树的定义如下：
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，
 * 这就是完全二叉树。（注：第 h 层可能包含 1~2h个节点。）
 * 实例 1：
 * 输入：[1,2,3,4,5,6]
 * 输出：true
 * 解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），
 * 且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
 *
 */
public class S958CheckCompletenessOfABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,new TreeNode(6),null));
        boolean is = isCompleteTree(root);
        System.out.println(is);
    }
    /**
     * 二叉树完全性检验
     * 1.使用层序遍历，将所有结点入队，null值也入队，出队时若为null (不能使用双端队列，不支持null,可以使用链表)
     * 2.则查看队列中后续所有结点是否为null
     * 3.若是则是完全，不是则非完全二叉树
     * @param root
     * @return
     */
    public static boolean isCompleteTree(TreeNode root) {
        if (root==null){
            return false;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.addLast(root);
        int size = queue.size();
        while (!queue.isEmpty()){
            for (int i=0;i<size;i++){
                //出队
                TreeNode temp = queue.removeFirst();
                //当出队结点为null时，判断队列后续结点是否都为null
                if (temp==null){
                    for (TreeNode node:queue) {
                        //只要有一个不为null，返回false
                        if (node!=null){
                            return false;
                        }
                    }
                    //全为null，返回true
                    return true;
                }
                //无论是否为null，都加入队列
                queue.addLast(temp.left);
                queue.addLast(temp.right);
            }
            //更新队列大小
            size = queue.size();
        }
        return true;
    }
}
