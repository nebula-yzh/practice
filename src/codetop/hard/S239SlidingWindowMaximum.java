package codetop.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Nebula
 * @date 2022/3/31 22:37
 * @description: 239. 滑动窗口最大值 hard
 * <p>
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k个数字。
 * 滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */
public class S239SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 2, 4};
        int[] numbers = maxSlidingWindow2(nums, 2);
        System.out.println(Arrays.toString(numbers));
    }

    /**
     * 类似滑动窗口中位数
     * 滑动窗口中的最大值
     * 1.暴力解(超出时间限制)
     * 直接使用滑动窗口，利用将窗口内数字排序，得到最大值。
     * 或者不用排序直接得到最大值
     * 2.利用单调队列或者优先队列
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        //滑动窗口做法
        if (k == 0) {
            return new int[0];
        }
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        int[] window = new int[k];
        //窗口右边为i+k-1
        for (int i = 0; i <= len - k; i++) {
            //添加进窗口数组
            System.arraycopy(nums, i, window, 0, k);
            int max = Arrays.stream(window).max().getAsInt();
            res.add(max);
        }
        return res.stream().mapToInt(d -> d).toArray();
    }

    /**
     * 2.利用优先队列
     * 可以通过使用优先队列，对窗口中值进行排序，但如果只存值，
     * 窗口移动没办法确定窗口最左边是什么值，不好移除，因此可以存两个值，
     * 一个是值，一个是值在数组中的下标，存一个数组
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        //从大到小,数组第一个值为在nums中的下标，第二个为值
        PriorityQueue<int[]> slideQueue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < k; i++) {
            slideQueue.add(new int[]{i, nums[i]});
        }
        List<Integer> res = new ArrayList<>();
        for (int i = k - 1, len = nums.length; i < len; i++) {
            //删除窗口左边值,不用通过循环比较，
            // 只要每次判断堆顶元素是否在窗口外，是就移除
            // 在窗口内就是最大值了
            // 不用每次都删除窗口最左元素，只要不是最大值，也就是堆顶可以不用删除
            while (slideQueue.peek()[0] <= i - k) {
                slideQueue.poll();
            }
            //堆顶在窗口内，那就是最大值
            res.add(slideQueue.peek()[1]);
            if (i + 1 == len) {
                break;
            }
            //窗口向右移动
            slideQueue.add(new int[]{i + 1, nums[i + 1]});
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
