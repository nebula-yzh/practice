package data_structure.sort_algorithm;

import java.util.Arrays;

/**
 * @author Nebula
 * @date 2021/10/8 14:47
 * @description: 归并排序
 * 算法思想：根本思想就是将两个有序序列合并成一个有序序列，将两组数复制到一个大数组进行比较
 * 若是一组无序序列，则每个数字看成有序序列，排序后再将已排序的序列进行归并，
 * 然后再排序，使用递归，从一个数字开始，逐渐归并成一个有序序列。
 */
public class MergeSortTest {
    public static void main(String[] args) {
        int[] array = new int[]{
                5, 3, 8, 0, 6, 8, 9, 12, 65, 45, 12, 32, 14, 75, 85
        };
        MergeSortTest mergeSortTest = new MergeSortTest();
        mergeSortTest.mergeSort(array);
        for (int i : array) {
            System.out.println(i);
        }
        Arrays.sort(array);
    }

    public void mergeSort(int[] array) {
        //复制数组
        int[] copyArray = new int[array.length];
        sort(0, array.length - 1, array, copyArray);
    }

    /**
     * 对无序数组进行排序
     * 递归切分，到最小只有一个后开始合并
     *
     * @param left
     * @param right
     * @param array
     */
    public void sort(int left, int right, int[] array, int[] copyArray) {
        if (left >= right) {
            return;
        }
        //切分，找中点
        int mid = (left + right) / 2;
        //左边
        sort(left, mid, array, copyArray);
        //右边
        sort(mid + 1, right, array, copyArray);
        //归并
        merge(left, mid, right, array, copyArray);
    }

    /**
     * 合并两个有序数组
     * 在原来的数组中合并，使用下标表示位置
     *
     * @param left  左边位置
     * @param mid   中间位置
     * @param right 右边位置
     * @return 返回排序后数组
     */
    public void merge(int left, int mid, int right, int[] array, int[] copyArray) {
        //将需要比较位置的数组范围复制到copyArray中
        for (int i=left;i<=right;i++){
            copyArray[i]=array[i];
        }
        //复制数组中，第一个待合并数组指针
        int i = left;
        //复制数组中，第二个待合并数组指针
        int j = mid + 1;
        //原数组中的指针，指向现在需要放置比较后的较小值的位置
        int k = i;
        //比较大小
        while (i <= mid && j <= right) {
            if (copyArray[i] <= copyArray[j]) {
                array[k] = copyArray[i++];
            } else {
                array[k] = copyArray[j++];
            }
            //将原数组中放置比较后较小值位置的指针向后移
            k++;
        }
        //将多余的数直接连接在排序数组后
        while (i <= mid) {
            array[k++] = copyArray[i++];
        }
        while (j <= right) {
            array[k++] = copyArray[j++];
        }
    }
}
