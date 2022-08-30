package code_practice;

import codetop.common.Node;
import jianzhi_offer.ListNode;
import jianzhi_offer.TreeNode;

import java.util.LinkedList;

/**
 * @author yingzhihao
 * @date 2022/6/30 21:59
 * @description: TODO
 */
public class Solution2 {
    int maxDia;
    private int area;

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        dummy.next = head;
        for (int i = 0; i < m - 1; i++) {
            dummy = dummy.next;
        }
        ListNode reverseHead = dummy.next;
        ListNode tempHead = reverseHead;
        ListNode temp = null;
        //断链
        dummy.next = null;
        for (int i = 0; i < n - m + 1; i++) {
            temp = reverseHead.next;
            reverseHead.next = dummy.next;
            dummy.next = reverseHead;
            reverseHead = temp;
        }
        //与后面的链表连接
        tempHead.next = temp;
        return res.next;
    }

    /**
     * 链表求和，低位在尾结点
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        //注意进位，从尾开始累加，先翻转链表（或使用栈）
        LinkedList<ListNode> stack1 = new LinkedList<>();
        LinkedList<ListNode> stack2 = new LinkedList<>();

        while (head1 != null) {
            stack1.push(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            stack2.push(head2);
            head2 = head2.next;
        }
        //进位
        int carry = 0;
        int sum;
        int val;

        ListNode dummy = new ListNode(-1);
        int h1;
        int h2;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            if (!stack1.isEmpty()) {
                h1 = stack1.pop().val;
            } else {
                h1 = 0;
            }

            if (!stack2.isEmpty()) {
                h2 = stack2.pop().val;
            } else {
                h2 = 0;
            }

            sum = h1 + h2 + carry;
            val = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(val);
            //连接
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(9, new ListNode(3, new ListNode(7)));
        ListNode head2 = new ListNode(6, new ListNode(3));
        ListNode node = addInList(head1, head2);
        System.out.println(node);

    }

    /**
     * 剑指 Offer 62. 圆圈中最后剩下的数字
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        //数学推导法，反向推导，正向迭代
        // 最后剩下的数字的下标为0，
        // 倒数第二个值的下标f(1) = (f(0) + m) % 2
        // 初始化第一个位置的值
        int result = 0;

        //个数从两个开始
        for (int i = 2; i <= n; i++) {
            result = (result + m) % i;
        }
        return result;
    }

    /**
     * 剑指 Offer 22. 链表中倒数第k个节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        //双指针，快慢
        ListNode slow;
        ListNode fast;
        ListNode dummy = new ListNode();
        dummy.next = head;
        slow = head;
        fast = dummy;
        while (k > 0 && fast != null) {
            fast = fast.next;
            k--;
        }
        if (fast == null) {
            return null;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 1306. 跳跃游戏 III
     * <p>
     * 时间最优
     *
     * @param arr
     * @param start
     * @return
     */
    public boolean canReach(int[] arr, int start) {
        //类似层序遍历，但要记录当前位置是否访问
        int len = arr.length;
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[len];
        queue.add(start);
        int size = queue.size();

        while (!queue.isEmpty()) {
            for (int i = 0; i < size; i++) {
                Integer val = queue.pop();
                int leftVal = val - arr[val];
                int rightVal = val + arr[val];

                //考虑边界，是否被访问
                //速度更快，一次循环判断两个位置
                if (leftVal >= 0 && !isVisited[leftVal]) {
                    if (arr[leftVal] == 0) {
                        return true;
                    }
                    isVisited[leftVal] = true;
                    queue.add(leftVal);
                }
                if (rightVal < len && !isVisited[rightVal]) {
                    if (arr[rightVal] == 0) {
                        return true;
                    }
                    isVisited[rightVal] = true;
                    queue.add(rightVal);
                }
            }
            size = queue.size();
        }
        return false;
    }

    /**
     * 1143. 最长公共子序列
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        //二维动态规划，打表
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] arr = new int[len1 + 1][len2 + 1];
        int max = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                //当字符相等,左上角+1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    //不相等，左上选较大值
                    arr[i][j] = Math.max(arr[i][j - 1], arr[i - 1][j]);
                }
                max = Math.max(max, arr[i][j]);
            }
        }
        return max;
    }

    /**
     * 958. 二叉树的完全性检验
     *
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {
        //完全二叉树的定义，最后一个叶子节点前全不为空，之后全为空
        //利用层序遍历，遍历二叉树，将所有结点入队，
        // 当有空节点时之后所有结点出队进行判断
        //之后结点是否全为空，为空则为完全二叉树
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = queue.size();

        while (!queue.isEmpty()) {
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                //当前出队结点为空
                if (node == null) {
                    //遍历之后所有结点
                    for (TreeNode temp : queue) {
                        if (temp != null) {
                            return false;
                        }
                    }
                    return true;
                }
                queue.add(node.left);
                queue.add(node.right);

            }
            size = queue.size();
        }
        return true;
    }

    /**
     * 704. 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 559. N 叉树的最大深度
     *
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        //二叉树的进阶，思路转换
        //递归，每次返回+1
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (Node node : root.children) {
            int maxDepth = maxDepth(node);
            //计算最大深度
            max = Math.max(max, maxDepth);
        }
        return max + 1;
    }

    /**
     * 718. 最长重复子数组
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        //与最长重复子串类似，但不同，子数组需要连续
        //有变化，不是通过二维数组最后返回最大值，而是要记录
        //每次遇到不同的值，都要重新计算，而不是延续
        int len1 = nums1.length;
        int len2 = nums2.length;
        int max = 0;
        int[][] arr = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                    max = Math.max(max, arr[i][j]);
                }
            }
        }
        return max;
    }

    /**
     * 695. 岛屿的最大面积
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        //深搜，递归，记录是否访问
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] isVisited = new boolean[row][col];
        int max = 0;
        //遍历整个面积，对每一块土地进行深搜
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //为陆地，且未被访问
                if (grid[i][j] == 1 && !isVisited[i][j]) {
                    //清零
                    area = 0;
                    dfs(grid, isVisited, i, j);
                    max = Math.max(area, max);
                }
            }
        }
        return max;
    }

    public void dfs(int[][] grid, boolean[][] isVisited, int row, int col) {
        //递归返回条件
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1) {
            return;
        }
        if (grid[row][col] == 0 || isVisited[row][col]) {
            return;
        }
        //陆地记录
        if (grid[row][col] == 1) {
            area += 1;
            isVisited[row][col] = true;
        }
        dfs(grid, isVisited, row - 1, col);
        dfs(grid, isVisited, row + 1, col);
        dfs(grid, isVisited, row, col - 1);
        dfs(grid, isVisited, row, col + 1);
    }

    /**
     * 617. 合并二叉树
     *
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //从根节点开始，自上而下进行合并，递归
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        //若两结点都不为null，需要新建一个结点作为新树的节点
        TreeNode newNode = new TreeNode(root1.val + root2.val);
        //合并左子树
        newNode.left = mergeTrees(root1.left, root2.left);
        //合并右子树
        newNode.right = mergeTrees(root1.right, root2.right);
        return newNode;
    }

    /**
     * 543. 二叉树的直径
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        //类似于计算二叉树深度，但要每次计算当前结点直径后，要与当前最大直径比较
        dfs(root);
        return maxDia;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        maxDia = Math.max(maxDia, left + right);
        return Math.max(left, right) + 1;
    }

    /**
     * 88. 合并两个有序数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //三指针，从两个数组尾部开始比较，一个指针记录最终数组位置
        int pos1 = m - 1;
        int pos2 = n - 1;
        int pos = m + n - 1;
        while (pos1 >= 0 && pos2 >= 0) {
            if (nums1[pos1] > nums2[pos2]) {
                nums1[pos] = nums1[pos1--];
            } else {
                nums1[pos] = nums2[pos2--];
            }
            pos--;
        }
        //数组有剩余,进行剩余的值复制,只有数组2剩余需要复制
        System.arraycopy(nums2, 0, nums1, 0, pos2 + 1);
    }

    /**
     * 415. 字符串相加
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        //注意进位,从低位开始累加

        int len1 = num1.length();
        int len2 = num2.length();

        int n1;
        int n2;

        StringBuilder res = new StringBuilder();

        //只要有一个字符串不为0或进位不为0即可继续进行
        for (int i = len1 - 1, j = len2 - 1, carry = 0; i >= 0 || j >= 0 || carry > 0; i--, j--) {
            //当一个字符串结束就补0
            if (i >= 0) {
                n1 = num1.charAt(i) - '0';
            } else {
                n1 = 0;
            }
            if (j >= 0) {
                n2 = num2.charAt(j) - '0';
            } else {
                n2 = 0;
            }

            int sum = n1 + n2 + carry;
            int remainder = sum % 10;
            carry = sum / 10;

            res.append(remainder);
        }
        return res.reverse().toString();
    }

}
