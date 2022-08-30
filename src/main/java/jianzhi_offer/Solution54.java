package jianzhi_offer;


/**
 * 二叉搜索树的第K大结点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 */
public class Solution54 {

    /**
     * 中序遍历二叉搜索树，为一个递增序列，左根右，第k大的结点就是第n-k+1个，n为结点个数
     * 右根左，则为一个递减序列，第k大的结点，就是第k个
     *
     * @param root
     * @param k
     * @return
     */
    //使用两个类变量
    private  int cnt = 1;
    private  int finalVal = 0;
    /*
        不要使用static 可以直接使用普通类变量来维护两个值
     */
    int kthLargest(TreeNode root, int k) {
        InOrder(root,k);
        return finalVal;
    }

    void InOrder(TreeNode root, int k) {
        if (root == null) {
            return ;
        }
        InOrder(root.right, k);
        if (cnt++ == k) {
            finalVal = root.val;
        }
        InOrder(root.left, k);
    }

}

