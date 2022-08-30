package jianzhi_offer;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;

/**
 * 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 */
public class Solution28 {
    /**
     * 错误做法
     * 一个中序遍历无法确定只有一种二叉树结构
     */
    LinkedList<TreeNode> list = new LinkedList();
    public boolean isSymmetric(TreeNode root) {
        //可以借助双端链表
        //中序遍历，根节点前后是否对称
        InOrder(root);
        if(list.size()%2==0) return false; //若结点数为偶数，则必不是对称
        int size = list.size()-1;
        for(int i=0;i<size/2;i++){ //循环判断，从集合头尾取结点比较值
            if(list.get(i).val !=list.get(size--).val){
                return false;
            }
        }
        return true;
    }

    void InOrder(TreeNode root){
        if(root==null){
            return;
        }
        InOrder(root.left);
        list.add(root);
        InOrder(root.right);
        return;
    }

    /**
     * 另一种做法
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    boolean recur(TreeNode leftNode,TreeNode rightNode){
        if(leftNode==null&&rightNode==null) return true;
        if(leftNode==null||rightNode==null||leftNode.val!=rightNode.val) return false;
        return recur(leftNode.left,rightNode.right)&&recur(leftNode.right,rightNode.left);
    }
}
