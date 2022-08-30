package codetop.easy;

/**
 * @author Nebula
 * @date 2021/11/1 18:35
 * @description: 88. 合并两个有序数组 简单
 * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 */
public class MergeSortedArrayS88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{
            1,2,3,0,0,0
        };
        int[] nums2 = new int[]{
                2,5,6
        };
        merge(nums1,3,nums2,3);
    }
    /**
     * 类似归并，将归并后排序数组，放入原数组1
     * 1.还是需要开辟一个数组存放两个数组归并后的数据，只是最后再复制到nums1
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //先判断，有一个数组为空，返回另一个数组
        if (n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        int[] nums = new int[m + n];
        int i = 0, j = 0, k = 0;
        while ( i < m && j < n && k < m + n) {
            if (nums1[i] <= nums2[j]) {
                nums[k]=nums1[i];
                i++;
            }else {
                nums[k] = nums2[j];
                j++;
            }
            k++;
        }
        //将未走完的数组复制到另外的数组
        if (i>=m){
            System.arraycopy(nums2,j,nums,i+j,n-j);
        }
        if (j>=n){
            System.arraycopy(nums1,i,nums,i+j,m-i);
        }
        //最后将归并后结果复制到nums1
        System.arraycopy(nums,0,nums1,0,m+n);
    }
}
