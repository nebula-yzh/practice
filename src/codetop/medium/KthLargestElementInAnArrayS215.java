package codetop.medium;

/**
 * @author Nebula
 * @date 2021/11/6 16:21
 * @description: 215. 数组中的第K个最大元素 中等
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 第k个最大，也就是排序后倒数第k个，或正数len-k个
 * <p>
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 */
public class KthLargestElementInAnArrayS215 {
    public static void main(String[] args) {
        KthLargestElementInAnArrayS215 k = new KthLargestElementInAnArrayS215();
        int[] arr = new int[]{2, 5, 6, 7, 1};
        k.findKthLargest(arr, 2);
    }

    /**
     * 法1：使用快速排序或堆排后，找到倒数第k元素,时间复杂度O(nlogn)
     * <p>
     * 法2：快速排序的变型,时间复杂度O(n)
     * 在快排期间找到下标为倒数第k的已排元素
     * 每一趟快排都会确定一个pivot，左边小于pivot，右边大于pivot
     * 看数组下标，若数组下标值大于len-k,则快排左边，右边取消，
     * 数组下标小于len-k,快排右边，左边取消
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

        return quickSortAnother(nums, 0, nums.length - 1, k);
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
     * 快速排序,找到第k最大元素
     * 保证一定能找到，因此无需单独递归退出条件
     *
     * @param arr  待排序数组
     * @param low  待排序左
     * @param high 待排序右
     */
    public int quickSortAnother(int[] arr, int low, int high, int k) {
        //先划分数组
        int pivotPos = partition(arr, low, high);
        //相当于递归退出条件，只要找到，就返回
        if (pivotPos == arr.length - k) {
            return arr[pivotPos];
        }
        //if (pivotPos > arr.length - k) {
        //    //划分左边
        //    return quickSortAnother(arr, low, pivotPos - 1, k);
        //}
        //if (pivotPos < arr.length - k) {
        //    //划分右边
        //    return quickSortAnother(arr, pivotPos + 1, high, k);
        //}
        //该返回不可达，因为保证能找到
        //return arr[pivotPos];
        //可简化返回
        return pivotPos > arr.length - k ? quickSortAnother(arr, low, pivotPos - 1, k) : quickSortAnother(arr, pivotPos + 1, high, k);
    }

}
