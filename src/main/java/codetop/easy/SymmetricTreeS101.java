package codetop.easy;

import jianzhi_offer.TreeNode;

import java.util.LinkedList;

/**
 * @author Nebula
 * @date 2021/11/9 23:37
 * @description: 101. 对称二叉树 简单
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 *  
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 */
public class SymmetricTreeS101 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        SymmetricTreeS101 s101 = new SymmetricTreeS101();
        boolean b = s101.isSymmetric(root);
        System.out.println(b);
    }

    /**
     * 递归
     * 法1：可以将根节点左子树翻转(226题)，再判断左右子树是否相同(100题)（其实直接利用100题就可）
     * <p>
     * 法2：
     * 1.可以使用两个指针p,q，分别遍历左子树与右子树
     * 2.当p指向左时，q指向右；p指向右时，q指向左，判断两结点值是否相同
     * <p>
     * 迭代
     * 法3：利用队列，层序遍历判断
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        //法2
        if (root == null) {
            return true;
        }
        return checkNodeInter(root.left, root.right);
    }

    public boolean checkNode(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        //类似(100)题，只是将根结点提前判断，一个从左节点开始递归，一个从右结点开始递归
        //都是自顶向下判断
        if (node1 != null && node2 != null && node1.val == node2.val) {
            return checkNode(node1.left, node2.right) && checkNode(node1.right, node2.left);
        }
        return false;
    }

    /**
     * 使用迭代的方法判断两颗子树是否镜像
     * 1.利用队列，层序遍历，传入两颗子树的根节点
     * 2.判断队列不为空时，出队两个结点p,q，并判断这两个结点值是否相同，不同返回false
     * 3.相同,若两结点左右子树都不为空，将p左入队，q右入队，再将p右入队,q左入队
     * 4.最后队列为空返回true
     *
     * @param node1
     * @param node2
     * @return
     */
    public boolean checkNodeInter(TreeNode node1, TreeNode node2) {
        //用链表来做队列，可以添加null元素，双端队列不可以添加null,但链表添加的null还需要poll出去，增加了时间复杂度
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(node1);
        queue.offer(node2);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            //当两个poll出来的结点都为null时，循环继续，将剩下所有的null都poll出来才能退出循环
            if (p == null && q == null) {
                continue;
            }
            if (p != null && q != null && p.val == q.val) {

                queue.offer(p.left);
                queue.offer(q.right);

                queue.offer(p.right);
                queue.offer(q.left);

            } else {
                return false;
            }

        }
        return true;
    }
}
