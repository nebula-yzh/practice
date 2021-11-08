package codetop.middle;

/**
 * @author Nebula
 * @date 2021/11/8 19:59
 * @description: 33. 搜索旋转排序数组 中等
 * 整数数组 nums 按升序排列，数组中的值互不相同。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 * 给你旋转后的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 * <p>
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 */
public class SearchInRotatedSortedArrayS33 {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int i = search(nums, 0);
        System.out.println(i);
    }

    /**
     * 二分搜索的变体,难度大，反复练习思路
     * 细节多，边界条件复杂
     * 现在数组前面⼀段是数值⽐较⼤的数，后面⼀段是数值偏小的数。
     * 1.如果 mid 落在了前⼀段数值⽐较⼤的区间内了，那么⼀定有 nums[mid] >= nums[0] ，
     * 2.如果是落在后面⼀段数值⽐较⼩的区间内，nums[mid] < nums[0] 。
     * 3.如果 mid 落在了后⼀段数值⽐较⼩的区间内了，那么⼀定有nums[mid] < nums[high]，
     * 4.如果是落在前⾯⼀段数值⽐较⼤的区间内， 有nums[mid] ≤ nums[high]，也有≥。
     * 5.还有 nums[low] == nums[mid] 和 nums[high] == nums[mid] 的情况，单独处理即可。
     * 最后找到则输出 mid，没有找到则输出 -1 。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            //取中值
            mid = low + (high - low >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            //mid在值大的部分
            if (nums[mid] >= nums[0]) {
                //target在大的部分，且在mid左边
                if (target >= nums[0] && target < nums[mid]) {
                    high = mid - 1;

                } else {//target在小的部分，或target在大的部分且在mid右边
                    low = mid + 1;
                }
            }
            //mid在值小的部分
            else {
                //target在小的部分,在mid右边
                if (target > nums[mid] && target <= nums[nums.length - 1]) {
                    low = mid + 1;
                }else {//target在mid的左边
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
