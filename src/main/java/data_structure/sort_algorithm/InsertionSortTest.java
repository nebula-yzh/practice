package data_structure.sort_algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingzhihao
 * @date 2022/9/3 12:01
 * @description: 插入排序
 */
public class InsertionSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 2, 5, 4, 3, 6, 8, 7, 9};
        List<Integer> list = insertSort(arr);
        System.out.println(list);
    }

    /**
     * 直接插入排序(Straight Insertion Sort)的基本思想是:
     * 把n个待排序的元素看成为一个有序表和一个无序表。
     * 开始时有序表中只包含1个元素，无序表中包含有n-1个元素，排序过程中每次从无序表中取出第一个元素，
     * 将它插入到有序表中的适当位置，使之成为新的有序表，重复n-1次可完成排序过程
     * 时间复杂度O(n^2)
     *
     * @param arr
     */
    public static List<Integer> insertSort(int[] arr) {
        ArrayList<Integer> sorted = new ArrayList<>();
        int len = arr.length;
        sorted.add(arr[0]);
        //记录当前已排序数组最大值，进行优化
        int max = arr[0];
        //第一个循环，遍历所有待排元素
        for (int i = 1; i < len; i++) {
            int size = sorted.size();
            //第二个循环遍历已排序元素，找到插入位置
            for (int j = 0; j < size; j++) {
                //若待插入元素大于最大值则直接插入
                if (arr[i] > max) {
                    sorted.add(arr[i]);
                    //更新最大值
                    max = arr[i];
                    break;
                }
                //待排元素小于已排数组的元素，直接插入
                if (arr[i] <= sorted.get(j)) {
                    sorted.add(j, arr[i]);
                    break;
                }
            }
        }
        return sorted;
    }
}
