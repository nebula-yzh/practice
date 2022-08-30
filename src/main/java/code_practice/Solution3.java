package code_practice;

import jianzhi_offer.ListNode;
import jianzhi_offer.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yingzhihao
 * @date 2022/7/10 23:52
 * @description: TODO
 */
public class Solution3 {
    int max = Integer.MIN_VALUE;
    /**
     * 46. 全排列
     *
     * @param nums
     * @return
     */
    LinkedList<Integer> list = new LinkedList<>();
    List<List<Integer>> result = new LinkedList<>();

    /**
     * 143. 重排链表
     *
     * @param head
     */
    public static void reorderList(ListNode head) {
        //1.利用队列,类似回文，回文是比较值是否相同
        //此处是进行重新排列
        //2.使用快慢指针找中点，反转链表进行重组也可

        LinkedList<ListNode> queue = new LinkedList<>();

        while (head != null) {
            queue.add(head);
            head = head.next;
        }
        ListNode left;
        ListNode right;
        ListNode res = new ListNode();
        head = res;
        while (!queue.isEmpty()) {
            left = queue.pollFirst();
            head.next = left;
            head = head.next;
            if (queue.isEmpty()) {
                break;
            } else {
                right = queue.pollLast();
                head.next = right;
                head = head.next;
            }
        }
        head.next = null;
    }

    /**
     * 328. 奇偶链表
     *
     * @param head
     * @return
     */
    public static ListNode oddEvenList(ListNode head) {
        // 遍历判断奇偶

        boolean isOdd = true;
        ListNode oddHead = new ListNode(-1);
        ListNode odd = oddHead;
        ListNode evenHead = new ListNode(-1);
        ListNode even = evenHead;

        while (head != null) {
            if (isOdd) {
                oddHead.next = head;
                oddHead = oddHead.next;
            } else {
                evenHead.next = head;
                evenHead = evenHead.next;
            }
            head = head.next;
            isOdd = !isOdd;
        }
        //连接奇偶结点
        oddHead.next = even.next;
        //断链，防止循环
        evenHead.next = null;
        return odd.next;
    }

    /**
     * 200. 岛屿数量
     *
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;

        boolean[][] isVisited = new boolean[rowLength][colLength];
        int area = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                //只有未被访问，且为陆地才会深搜
                if (isVisited[i][j] || grid[i][j] == '0') {
                    continue;
                }
                //一次深搜，确定一个岛屿
                dfs(grid, isVisited, i, j);
                area++;
            }
        }
        return area;
    }

    public static void dfs(char[][] grid, boolean[][] isVisited, int row, int col) {
        //边界条件
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }
        if (grid[row][col] == '0' || isVisited[row][col]) {
            return;
        }
        isVisited[row][col] = true;

        dfs(grid, isVisited, row + 1, col);
        dfs(grid, isVisited, row - 1, col);
        dfs(grid, isVisited, row, col - 1);
        dfs(grid, isVisited, row, col + 1);
    }

    /**
     * 300. 最长递增子序列
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        //最短的子序列为1
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) {
                    continue;
                }
                dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        Solution3 solution3 = new Solution3();
        solution3.sortList(root);
    }

    /**
     * 236. 二叉树的最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //二叉树，深搜，递归
        //递归的返回条件,递归到最底，返回null
        if (root == null) {
            return null;
        }
        // 当待查结点有一个为当前根节点，即当前根节点为最近公共祖先
        if (p == root || q == root) {
            return root;
        }
        //左子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //右子树
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //将当前找到的祖先返回，若为null，则还未找到，从下往上找
        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }
        //左右子树都不为null，待查结点在异侧，返回root
        return root;
    }

    /**
     * 5. 最长回文子串
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        //中心扩散
        int len = s.length();

        int left = 0;
        int right = 0;
        int max = 0;
        //遍历整个字符串，进行查找
        for (int cur = 1; cur < len; cur++) {
            Palindrome odd = expand(cur - 1, cur + 1, len, s);
            Palindrome even = expand(cur - 1, cur, len, s);
            if (odd.len > even.len) {
                if (max < odd.len) {
                    max = odd.len;
                    left = odd.left;
                    right = odd.right;
                }
            } else {
                if (max < even.len) {
                    max = even.len;
                    left = even.left;
                    right = even.right;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    /**
     * @param left  待扩散左
     * @param right 待扩散右
     * @return
     */
    public Palindrome expand(int left, int right, int len, String s) {
        Palindrome palindrome = new Palindrome();
        //扩散,通过传参进行分辨奇偶
        while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        left++;
        right--;
        palindrome.left = left;
        palindrome.right = right;
        palindrome.len = right - left + 1;
        return palindrome;
    }

    /**
     * 124. 二叉树中的最大路径和
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    /**
     * @return 需要返回当前结点左右子树的路径值
     */
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //返回大于零的路径值
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        //记录当前最大路径值
        max = Math.max(max, left + right + root.val);
        //返回左右路径中的较大值,作为该结点的值
        return Math.max(left, right) + root.val;
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        boolean[] isUsed = new boolean[len];
        dfs(isUsed, nums);
        return result;
    }

    public void dfs(boolean[] isUsed, int[] nums) {
        // 深搜退出条件
        // 当暂存列表满了
        if (list.size() == nums.length) {
            //将该次排列放入最终结果
            result.add(new LinkedList<>(list));
            return;
        }
        //遍历所有的元素
        for (int cur = 0, len = nums.length; cur < len; cur++) {
            //如果当前元素被使用，跳过本次循环
            if (isUsed[cur]) {
                continue;
            }
            list.add(nums[cur]);
            isUsed[cur] = true;
            //然后从当前元素开始继续深搜
            dfs(isUsed, nums);
            //当结束本次深搜，说明排列完整
            //移除当前元素cur,回溯到上一次
            list.removeLast();
            isUsed[cur] = false;
        }
    }


    /**
     * 94. 二叉树的中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                //从根节点开始，将沿路左子树结点都先入栈
                stack.push(root);
                root = root.left;
            }
            //到达最末的位置了,出栈
            root = stack.pop();
            //访问当前结点
            res.add(root.val);
            //处理右节点
            root = root.right;
        }
        return res;
    }


    public void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }


    /**
     * 69. x 的平方根
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        //二分查找
        if (x == 0) {
            return 0;
        }
        int low = 1;
        int high = x;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (mid < x / mid) {
                low = mid + 1;
            } else if (mid > x / mid) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        //当退出循环时，low>high
        if (high > x / high) {
            return high - 1;
        }
        return high;
    }


    /**
     * 148. 排序链表
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //链表快排
        ListNode prev = new ListNode();
        prev.next = head;
        quickSort(prev, null);
        return prev.next;
    }


    /**
     * 链表快排不需要交换结点,但需要保存下一个结点
     *
     * @param prev 当前待快排链表头结点的前一个结点
     * @param end  当前待排链表的最后一个结点的后一个结点
     */
    public void quickSort(ListNode prev, ListNode end) {
        //递归结束条件
        if (prev == end || prev.next == end) {
            return;
        }
        //使用头结点作为基点
        ListNode pivot = prev.next;

        //记录小于pivot链表
        ListNode lowCur = new ListNode();
        ListNode lowHead = lowCur;

        //大于pivot结点,也作为待比较结点
        ListNode highCur = pivot;

        //判断链表未到达尾结点,进行排序
        while (highCur.next != end) {
            if (pivot.val <= highCur.next.val) {
                //移动节点即可
                highCur = highCur.next;
            } else {
                lowCur.next = highCur.next;
                lowCur = lowCur.next;
                //跳过结点
                highCur.next = highCur.next.next;
            }
        }
        //进行链表结点的连接

        //小于pivot
        lowCur.next = pivot;
        //大于pivot
        prev.next = lowHead.next;
        //递归
        //左边
        quickSort(prev, pivot);
        //右边
        quickSort(pivot, end);
    }

    private static class Palindrome {
        int left;
        int right;
        int len;
    }


}
