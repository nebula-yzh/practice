package data_structure.sort_algorithm;


import java.util.Arrays;

/**
 * @author yingzhihao
 * @date 2022/9/3 15:23
 * @description: 插入排序
 */
public class SelectedSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 2, 5, 4, 3, 6, 8, 7, 9};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 它的基本思想是: 首先在未排序的数列中找到最小(or最大)元素，然后将其存放到数列的起始位置；
     * 接着，再从剩余未排序的元素中继续寻找最小(or最大)元素，然后放到已排序序列的末尾。
     * 以此类推，直到所有元素均排序完毕
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {

        int len = arr.length;
        for (int k = 0; k < len; k++) {
            int min = arr[k];
            int index = k;
            //寻找待排数组中最小的值
            for (int i = k; i < len; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                    index = i;
                }
            }
            //交换,减少一次
            if (index != k) {
                int temp = arr[k];
                arr[k] = min;
                arr[index] = temp;
            }
        }
    }
}
