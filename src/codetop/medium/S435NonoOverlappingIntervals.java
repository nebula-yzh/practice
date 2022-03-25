package codetop.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Nebula
 * @date 2022/3/25 10:18
 * @description: 435. 无重叠区间 medium
 * 给定一个区间的集合intervals，其中 intervals[i] = [starti, endi]。返回需要移除区间的最小数量，使剩余区间互不重叠。
 * <p>
 * 示例 1:
 * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 * 输入: intervals = [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 */
public class S435NonoOverlappingIntervals {

    /**
     * 1、贪心算法
     * 找出贪心的策略，如何贪心
     * 画出区间，直观的看需要移除哪些区间
     * <p>
     * 起止相连不算重叠
     * 在选择区间时，区间的结尾十分重要：选择的区间结尾越小，给其他区间的空间就越大，就越能保留更多的区间（这是该题贪心的策略）
     * 因此贪心策略为，我们优先保留结尾小且不相交的区间。
     * 1.先对数组按照结尾的大小进行排序，每次选择结尾小的区间且不和前一个区间重叠的区间。
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        int removeCount = 0;
        //按照数组第二个元素进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int col = intervals.length;
        //当前待比较的数组
        int i = 1;
        //前一个不被移除的数组
        int j = 0;
        while (i < col) {
            //判断是否和前一个区间有重叠
            if (intervals[i][0] < intervals[j][1]) {
                removeCount++;
            } else {
                //需要跳过被移除的数组
                j = i;
            }
            i++;
        }
        return removeCount;
    }

    /**
     * 也可以计算，保留的数组个数
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals2(int[][] intervals) {
        int count = 1;
        //按照数组第二个元素进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int col = intervals.length;

        //前一个不被移除的数组
        int pre = intervals[0][1];
        //当前待比较的数组
        for (int i = 1; i < col; i++) {
            //判断是否和前一个区间有重叠
            if (intervals[i][0] >= pre) {
                //无重叠
                count++;
                pre = intervals[i][1];
            }

        }
        return col - count;
    }
}
