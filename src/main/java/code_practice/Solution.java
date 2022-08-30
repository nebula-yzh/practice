package code_practice;

import jianzhi_offer.ListNode;
import jianzhi_offer.TreeNode;

import java.util.*;

/**
 * @author yingzhihao
 * @date 2022/6/25 9:42
 * @description: TODO
 */
public class Solution {

    int res;

    /**
     * 3. 无重复字符的最长子串
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // 无重复，最长
        // 因此需要记录判断字符是否重复set，记录当前最长子字符串
        // 遍历每个字符，滑动窗口 (肯定有左窗口，右窗口)
        HashSet<Character> set = new HashSet<>();
        int resMax = 0;
        int length = s.length();
        for (int left = 0, right = 0; left < length; left++) {
            //右窗口需要自己控制扩展
            while (right < length && set.add(s.charAt(right))) {
                right++;
            }
            //有重复字符，计算当前最大值
            resMax = Math.max(resMax, set.size());
            //每次移除左边窗口值
            set.remove(s.charAt(left));
        }
        return resMax;
    }

    /**
     * 215. 数组中的第K个最大元素
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        //排序，快排变体
        quickSort(nums, 0, nums.length - 1, k);
        return res;
    }

    /**
     * 快速排序
     * 是一个不断分割递归的过程
     * 快排变型，第k大元素
     * 就是partition的值为len-k
     *
     * @param nums
     * @param left
     * @param right
     * @param k
     */
    public void quickSort(int[] nums, int left, int right, int k) {
        //先对数组进行分割
        int partition = partition(nums, left, right);
        int kthVal = nums.length - k;
        if (partition == kthVal) {
            res = nums[partition];
            return;
        }
        if (partition > kthVal) {
            //左边递归
            quickSort(nums, left, partition - 1, k);
        } else {
            //右边递归
            quickSort(nums, partition + 1, right, k);
        }
    }

    /**
     * 分割函数（核心）
     * 将数组分为左边小于pivot
     * 右边大于pivot
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] nums, int left, int right) {
        //随机pivot 下标
        int randomPivot = new Random().nextInt(right - left + 1) + left;
        //通过下标 交换数组中的值
        swap(nums, randomPivot, left);
        //真正的pivot
        int pivot = nums[left];

        while (left < right) {
            //右边开始比较
            //右边要大于pivot
            while (pivot <= nums[right] && left < right) {
                right--;
            }
            nums[left] = nums[right];
            while (pivot >= nums[left] && left < right) {
                left++;
            }
            nums[right] = nums[left];
        }
        //将pivot放在数组中
        nums[left] = pivot;
        return left;
    }

    /**
     * 通过下标交换数组中的值
     *
     * @param nums
     * @param randomPivot
     * @param val
     */
    public void swap(int[] nums, int randomPivot, int val) {
        int temp = nums[val];
        nums[val] = nums[randomPivot];
        nums[randomPivot] = temp;
    }

    /**
     * 25. K 个一组翻转链表
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        //注意：每k个反转，需要保留每组结点的前一个结点,
        // 也就是待反转的第一个结点，作为后一组的dummy结点
        //用一个cnt计数。反转个数，不足k个则反转后再反转回来
        ListNode dummy = new ListNode();
        //结果
        ListNode result = dummy;

        ListNode first;
        ListNode temp;
        int cnt;
        //外部大循环，控制链表走完
        while (head != null) {
            //暂存第一个结点
            first = head;
            //计数，每次初始化为0
            cnt = 0;

            //进行链表反转
            while (cnt < k && head != null) {
                //保存下一个结点
                temp = head.next;
                head.next = dummy.next;
                dummy.next = head;
                head = temp;
                cnt++;
            }

            //最后剩余链表未达k个，反转回来
            if (cnt < k) {
                //反转回来
                head = dummy.next;
                //避免形成环
                dummy.next = null;
                //开始反转
                while (head != null) {
                    temp = head.next;
                    head.next = dummy.next;
                    dummy.next = head;
                    head = temp;
                }
                break;
            }
            //重新给dummy赋值
            dummy = first;
        }
        return result.next;
    }

    /**
     * 1. 两数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        //使用map进行查找,返回的是两数的下标
        //因为查找的是下标，因此，map中key存值，value存数组下标
        // 通过值查找下标

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int findVal = target - nums[i];
            if (map.containsKey(findVal)) {
                return new int[]{i, map.get(findVal)};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }

    /**
     * 102. 二叉树的层序遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        //队列，一层一层遍历
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        List<List<Integer>> result = new ArrayList<>();

        int size = queue.size();
        while (!queue.isEmpty()) {
            List<Integer> levelValues = new ArrayList<>();
            //遍历队列中的结点，以及将子节点放入队列中
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                levelValues.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(levelValues);
            size = queue.size();
        }
        return result;
    }

    /**
     * 121. 买卖股票的最佳时机
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        //记录最小价格
        int min = prices[0];
        //记录最大利润
        int max = 0;
        int differ;
        for (int i = 1; i < len; i++) {
            differ = prices[i] - min; //利润
            if (differ < 0) {
                min = prices[i];   //更换最小价格
            }
            if (differ > 0) {
                max = Math.max(differ, max);
            }
        }

        return max;
    }

    /**
     * 20. 有效的括号
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            //左括号入栈
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (!stack.isEmpty()) {//避免栈为空
                if ((c == ')' && stack.peek() == '(')
                        || (c == ']' && stack.peek() == '[') ||
                        (c == '}' && stack.peek() == '{')) {//栈顶判断
                    stack.pop();
                } else {
                    // 中途有右括号开头
                    return false;
                }
            } else {
                // 开始有右括号开头
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 141. 环形链表
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        //双指针或set
        if (head == null || head.next == null) {
            return false;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    /**
     * 103. 二叉树的锯齿形层序遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int size = queue.size();

        List<List<Integer>> result = new ArrayList<>();

        //区分奇偶
        boolean oddLevel = true;

        while (!queue.isEmpty()) {

            List<Integer> temp = new ArrayList<>();
            TreeNode node;
            for (int i = 0; i < size; i++) {
                //奇数层
                if (oddLevel) {
                    //出队，从左到右
                    node = queue.removeFirst();
                    temp.add(node.val);
                    //入队,先左后右
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }

                } else {
                    //出队，从右到左
                    node = queue.removeLast();
                    temp.add(node.val);
                    //入队,先右后左
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.addFirst(node.left);
                    }
                }
            }
            oddLevel = !oddLevel;
            size = queue.size();
            result.add(temp);
        }
        return result;
    }


    /**
     * 42. 接雨水
     * <p>
     * 1、暴力法，时间复杂度高
     * 当前位置左右最高两个柱子的较小值min(left,right)，
     * 以及当前位置与较小值的柱子差min(left,right)-height[pos]，就是能够接的雨水的高度
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int result = 0;
        int len = height.length;
        for (int i = 0; i < len; i++) {
            result += calculate(height, i, len);
        }
        return result;
    }

    public int calculate(int[] height, int pos, int len) {
        //往左边找最高的柱子
        int leftMax = 0;
        for (int i = pos; i >= 0; i--) {
            leftMax = Math.max(leftMax, height[i]);
        }
        //往右边找到最高的柱子
        int rightMax = 0;
        for (int i = pos; i < len; i++) {
            //若当前右边最高大于左边最高，可直接退出
            if (rightMax >= leftMax) {
                break;
            }
            rightMax = Math.max(rightMax, height[i]);
        }
        int capacity = Math.min(leftMax, rightMax) - height[pos];
        return Math.max(capacity, 0);
    }

    /**
     * 42. 接雨水
     * 备忘录法
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int result = 0;
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        calculate(height, len, leftMax, rightMax);
        for (int i = 0; i < len; i++) {
            result += Math.max(Math.min(leftMax[i], rightMax[i]) - height[i], 0);
        }
        return result;
    }

    public void calculate(int[] height, int len, int[] leftMax, int[] rightMax) {
        leftMax[0] = height[0];
        rightMax[len - 1] = height[len - 1];
        //用leftMax[i]记录0-i最高的高度
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        //用rightMax[i]记录i-len-1最高的高度
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
    }
}
