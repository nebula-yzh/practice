package codetop.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Nebula
 * @date 2021/12/5 9:42
 * @description: 56. 合并区间 中等
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class S56MergeIntervals {
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1,3},
                {8,10},
                {2,6},
                {15,18}
        };
        merge(a);
    }

    /**
     * 1.先根据每个区间的第一个值进行排序，即对二维数组的行进行排序
     * 2.再依次判断后一个区间的最小值是否小于前一个区间的最大值，若小于则合并,在往后判断
     * 3.若大于，则继续往后判断
     * 难点：
     * 1.怎么排序
     * 2.怎么将区间合并并输出
     *
     * 有待优化，时间复杂度跟空间复杂度高
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        int row = intervals.length;

        if (row == 1) {
            return intervals;
        }
        //对数组的行根据第一个元素进行排序，升序,需要重写comparator
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        ArrayList<int[]> list = new ArrayList<>();
        //先将第一个区间添加进集合，与后面区间比较
        list.add(intervals[0]);
        //j是集合中的位置，i是数组中的位置
        for (int i = 1, j = 0; i < row; i++) {
            //将前一个区间的最大值与后一个区间最小值比较,若大于，
            if (list.get(j)[1] >= intervals[i][0]) {
                //且当前区间的最大值比后一个区间的最大值小
                if (list.get(j)[1]<=intervals[i][1]){
                    list.set(j, new int[]{list.get(j)[0], intervals[i][1]});
                }
            }
            //将后一个区间添加到集合
            else {
                list.add(intervals[i]);
                j++;
            }
        }
        return list.toArray(new int[0][]);
    }
}
