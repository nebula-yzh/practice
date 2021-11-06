package data_structure.sort_algorithm;

/**
 * 快速排序
 * <p>
 * 算法思想：在待排序L[1...n]中任取一个元素pivot作为枢轴（基准，通常取首元素），通过一趟排序将待排序表划分独立的两部分L1[1...k-1]和L2[k...n]，
 * 使得两部分左边小于pivot，右边大于pivot，pivot在L[k]的位置上，这称为一次划分。然后分别递归的对两个子表重复上述过程，直到每部分只有一个元素或为空为止，
 * 所有元素都正确排序。
 *
 * @author Nebula
 */
public class QuickSortTest {
    public static void main(String[] args) {
        QuickSortTest quickSortTest = new QuickSortTest();
        int[] l = new int[]{21, 6, 5, 9, 3, 1, 9, 23, 152, 5, 3, 6, 1};
        //quickSortTest.quickSort(l, 0, l.length - 1);
        quickSortTest.quickSortAnother(l, 0, l.length - 1);
        for (int i : l) {
            System.out.println(i);
        }
    }


    /**
     * 快排，将所有操作写在一个函数中
     * 也可将其中操作再单独写成函数
     * <p>
     * 可以将分成两部分的代码单独成一个函数
     * <p>
     * 分两部分主要是找到下一个pivot位置，及分界线
     *
     * @param L    待排序数组
     * @param low  待排序数组的最小值
     * @param high 待排序数组的最大值
     */
    public void quickSort(int[] L, int low, int high) {
        //递归退出条件
        if (low >= high) {
            return;
        }
        //定义枢轴为每部分的第一个元素
        int pivot = L[low];
        //保存左边起点,递归要用
        int tempLow = low;
        //保存右边起点，递归要用
        int tempHigh = high;
        //找到枢轴的位置，分割两部分，只要low<high,一直循环将数组排完为止，pivot左边小于，右边大于
        while (low < high) {
            //以第一个元素作为枢轴，只能从高位开始比较，将数组高位元素与枢轴比较
            while (pivot <= L[high] && low < high) {
                high--;
            }
            //将比枢轴小的元素移到左边
            L[low] = L[high];
            //将数组低位元素与枢轴比较
            while (pivot >= L[low] && low < high) {
                low++;
            }
            //将比枢轴大的元素移到右边
            L[high] = L[low];
        }
        //最后放置枢轴位置，此时low=high
        L[low] = pivot;

        //左边，再进行快排
        quickSort(L, tempLow, low - 1);
        //右边
        quickSort(L, low + 1, tempHigh);

    }

    /**
     * 将数组根据low和high内数据划分成两部分
     *
     * @param arr  待划分数组
     * @param low  待划分左
     * @param high 待划分右
     * @return 返回pivot的数组下标
     */
    public int partition(int[] arr, int low, int high) {
        //将第一个元素记为基准，被比较的值
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
     * 快速排序
     *
     * @param arr  待排序数组
     * @param low  待排序左
     * @param high 待排序右
     */
    public void quickSortAnother(int[] arr, int low, int high) {
        //递归退出条件
        if (low >= high) {
            return;
        }
        //先划分数组
        int pivotPos = partition(arr, low, high);
        //划分左边
        quickSortAnother(arr, low, pivotPos - 1);
        //划分右边
        quickSortAnother(arr, pivotPos + 1, high);
    }


}
