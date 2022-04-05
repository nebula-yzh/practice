package codetop.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] numbers = maxSlidingWindow(nums, 3);
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
     * TODO
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        return new int[0];
    }
}
