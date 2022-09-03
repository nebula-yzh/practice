package data_structure.sort_algorithm;

import java.util.Random;

/**
 * 快速排序
 * <p>
 * 算法思想：在待排序L[1...n]中任取一个元素pivot作为枢轴（基准，通常取首元素），
 * 通过一趟排序将待排序表划分独立的两部分L1[1...k-1]和L2[k...n]，
 * 使得两部分左边小于pivot，右边大于pivot，pivot在L[k]的位置上，
 * 这称为一次划分。然后分别递归的对两个子表重复上述过程，直到每部分只有一个元素或为空为止，
 * 所有元素都正确排序。
 * <p>
 * 不稳定，时间复杂度最差O(n^2)，平均O(nlogn)
 * <p>
 * 这句话很好理解: 假设被排序的数列中有N个数。遍历一次的时间复杂度是O(N)，需要遍历多少次呢?
 * 至少lg(N+1)次，最多N次。
 * <p>
 * 为什么最少是lg(N+1)次? 快速排序是采用的分治法进行遍历的，我们将它看作一棵二叉树，
 * 它需要遍历的次数就是二叉树的深度，而根据完全二叉树的定义，它的深度至少是lg(N+1)。
 * 因此，快速排序的遍历次数最少是lg(N+1)次。
 * <p>
 * 为什么最多是N次? 这个应该非常简单，还是将快速排序看作一棵二叉树，它的深度最大是N，只有一个分支。
 * 因此，快读排序的遍历次数最多是N次。
 *
 * @author Nebula
 */
public class QuickSortTest {
    public static void main(String[] args) {
        QuickSortTest quickSortTest = new QuickSortTest();
        int[] l = new int[]{21, 6, 5, 9, 3, 1, 9, 23, 152, 5, 3, 6, 1};
        quickSortTest.quickSort(l, 0, l.length - 1);
        for (int i : l) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    /**
     * 将数组根据low和high内数据划分成两部分
     * <p>
     * 我们现在是选择第一个元素作为pivot
     * 可以随机选择一个值作为pivot，在待划分范围之内，利用random
     * 但选择pivot后要将该值与第一个元素交换（或最后一个），之后才能进行划分
     *
     * @param arr  待划分数组
     * @param low  待划分左
     * @param high 待划分右
     * @return 返回pivot的数组下标，划分点
     */
    public int partition(int[] arr, int low, int high) {
        //随机选择一个值作为pivot,生成0到high-low+1的数，再加上low，pivot即在待划分范围内
        //但还要跟low的位置交换
        int pivotPos = new Random().nextInt(high - low + 1) + low;
        //将第一个元素记为基准，被比较的值
        //int pivot = arr[low];
        swap(arr, pivotPos, low);
        int pivot = arr[low];
        while (low < high) {
            while (pivot <= arr[high] && low < high) {
                high--;
            }
            arr[low] = arr[high];
            while (pivot >= arr[low] && low < high) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;

        return low;
    }

    /**
     * 交换函数
     *
     * @param arr 待交换数组
     * @param a   待交换值下标
     * @param b   待交换值下标
     */
    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 快速排序
     *
     * @param arr  待排序数组
     * @param low  待排序左
     * @param high 待排序右
     */
    public void quickSort(int[] arr, int low, int high) {
        //递归退出条件
        if (low >= high) {
            return;
        }
        //先划分数组
        int pivotPos = partition(arr, low, high);
        //划分左边
        quickSort(arr, low, pivotPos - 1);
        //划分右边
        quickSort(arr, pivotPos + 1, high);
    }


}
