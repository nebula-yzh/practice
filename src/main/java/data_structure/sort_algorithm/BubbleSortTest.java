package data_structure.sort_algorithm;

import java.util.Arrays;

/**
 * @author yingzhihao
 * @date 2022/9/3 11:18
 * @description: 冒泡排序
 */
public class BubbleSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 2, 5, 4, 3, 6, 8, 7, 9};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 冒泡排序
     * 它会遍历若干次要排序的数列，每次遍历时，它都会从前往后依次的比较相邻两个数的大小；
     * 如果前者比后者大，则交换它们的位置。这样，一次遍历之后，最大的元素就在数列的末尾！
     * 采用相同的方法再次遍历时，第二大的元素就被排列在最大元素之前。重复此操作，直到整个数列都有序为止
     * 时间复杂度 O(n^2),稳定排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        //每次循环将大的值往后放
        int len = arr.length;
        long l1 = System.currentTimeMillis();
        boolean flag;
        for (int i = 0; i < len - 1; i++) {
            flag = false;
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            //没发生交换，已经有序，提前退出
            if (!flag) {
                break;
            }
        }
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);
    }
}
