package codetop.middle;

/**
 * @author Nebula
 * @date 2021/11/15 18:16
 * @description: 162. 寻找峰值 中等
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设nums[-1] = nums[n] = -∞ 。
 * <p>
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * <p>
 * 示例2：
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；或者返回索引 5， 其峰值元素为 6。
 */
public class FindPeakElementS162 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 3, 2, 1};
        findPeakElement(nums);
    }

    /**
     * 寻找峰值
     * 就是找到极值，某个点的值大于左右两边的值，且在数组中只用找到一个即可。
     * 查找题，使用二分查找
     * 题目描述中出现了 nums[-1] = nums[n] = -∞，这就代表着
     * 对于一个满足 nums[x]>nums[x−1] 的位置，x 的右边一定存在峰值；
     * 或对于一个满足nums[x]>nums[x+1] 的位置，x 的左边一定存在峰值。
     * 需要证明，但可直接记结论使用二分即可
     *
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        int len = nums.length;
        //一个元素时直接返回
        if (len == 1) {
            return 0;
        }
        //判断左右两边是否存在峰值，有直接返回
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[len - 1] > nums[len - 2]) {
            return len - 1;
        }
        int left = 0;
        int right = len - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left >> 1);
            // 如果 mid 较⼤，则左侧存在峰值，right = mid，如果 mid + 1 较⼤，则右侧存在峰值，left= mid + 1
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
