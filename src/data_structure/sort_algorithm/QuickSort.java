package data_structure.sort_algorithm;

/**
 * 快速排序
 * <p>
 * 算法思想：在待排序L[1...n]中任取一个元素pivot作为枢轴（基准，通常取首元素），通过一趟排序将待排序表划分独立的两部分L1[1...k-1]和L2[k...n]，
 * 使得两部分左边小于pivot，右边大于pivot，pivot在L[k]的位置上，这称为一次划分。然后分别递归的对两个子表重复上述过程，直到每部分只有一个元素或为空为止，
 * 所有元素都正确排序。
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] L = new int[]{21, 6, 5, 9, 3, 1, 9, 23, 152, 5, 3, 6, 1};
        quickSort.quickS(L, 0, L.length - 1);
        for (int i : L) {
            System.out.println(i);
        }
    }


    public void quickS(int[] L, int low, int high) {
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
        //找到枢轴的位置，分割两部分
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
        //最后放置枢轴位置
        L[low] = pivot;

        //左边
        quickS(L, tempLow, low - 1);
        //右边
        quickS(L, low + 1, tempHigh);

    }
}
