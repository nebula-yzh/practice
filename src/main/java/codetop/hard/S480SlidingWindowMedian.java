package codetop.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Nebula
 * @date 2022/3/26 21:38
 * @description: 480. 滑动窗口中位数 困难
 * 中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 * 例如：
 * [2,3,4]，中位数是3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。
 * 你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 * <p>
 * 示例：
 * 给出nums = [1,3,-1,-3,5,3,6,7]，以及k = 3。
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 * 1 [3  -1  -3] 5  3  6  7      -1
 * 1  3 [-1  -3  5] 3  6  7      -1
 * 1  3  -1 [-3  5  3] 6  7       3
 * 1  3  -1  -3 [5  3  6] 7       5
 * 1  3  -1  -3  5 [3  6  7]      6
 * 因此，返回该滑动窗口的中位数数组[1,-1,-1,3,5,6]。
 */
public class S480SlidingWindowMedian {
    public static void main(String[] args) {
        int[] nums = new int[]{2147483647, 2147483647};
        double[] doubles = medianSlidingWindow(nums, 2);
        System.out.println(Arrays.toString(doubles));
    }

    /**
     * 1、滑动窗口
     * 类似美团2022/3/26的笔试第四题
     * 2、可以用两个优先队列，大顶堆，和小顶堆
     * <p>
     * 该题需要返回每个中位数
     * <p>
     * 根据k，分窗口的奇偶，奇偶不同中位数计算方式不同
     *
     * @param nums 数组
     * @param k    滑动窗口的大小
     * @return
     */
    public static double[] medianSlidingWindow(int[] nums, int k) {
        //滑动窗口做法
        if (k == 0) {
            return new double[0];
        }
        int len = nums.length;
        List<Double> res = new ArrayList<>();
        int[] window = new int[k];
        //偶数
        if (k % 2 == 0) {
            //窗口右边为i+k-1
            for (int i = 0; i <= len - k; i++) {
                //添加进窗口数组
                System.arraycopy(nums, i, window, 0, k);
                Arrays.sort(window);
                double median = ((double) window[k / 2] + (double) window[k / 2 - 1]) / 2;
                res.add(median);
            }

        }
        //奇数
        if (k % 2 == 1) {
            //窗口右边为i+k-1
            for (int i = 0; i <= len - k; i++) {
                //添加进窗口数组
                System.arraycopy(nums, i, window, 0, k);
                //排序
                Arrays.sort(window);
                double median = window[k / 2];
                res.add(median);
            }
        }
        return res.stream().mapToDouble(d -> d).toArray();
    }
}
