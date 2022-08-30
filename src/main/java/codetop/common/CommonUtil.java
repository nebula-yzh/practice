package codetop.common;

import jianzhi_offer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Nebula
 * @date 2022/3/1 10:22
 * @description: TODO
 */
public class CommonUtil {
    /**
     * 构建一棵二叉树
     * @param array
     * @return
     */
    public static TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            TreeNode node = queue.peek();
            if (isLeft) {
                if (array[i] != null) {
                    node.left = new TreeNode(array[i]);
                    queue.offer(node.left);
                }
                isLeft = false;
            } else {
                if (array[i] != null) {
                    node.right = new TreeNode(array[i]);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
    }
}
