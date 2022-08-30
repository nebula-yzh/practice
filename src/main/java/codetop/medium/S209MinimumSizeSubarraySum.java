package codetop.medium;

/**
 * @author Nebula
 * @date 2022/4/29 14:14
 * @description: 209. 长度最小的子数组 medium
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组[4,3]是该条件下的长度最小的子数组。
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 */
public class S209MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int min = minSubArrayLen2(7, nums);
        System.out.println(min);
    }

    /**
     * 找出大于target的最小长度的连续子数组
     * target和数组中的值都大于1
     * <p>
     * 法1：暴力法 O(n^2)
     * 逐个遍历连续子数组，记录最小的子数组
     * <p>
     * 法2：前缀和+二分查找 O(nlogn)
     * <p>
     * 法3：滑动窗口 O(n)
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            int cnt = 0;
            for (int j = i; j < length; j++) {
                sum += nums[j];
                cnt++;
                if (sum >= target) {
                    min = Math.min(min, cnt);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * 法3：使用滑动窗口
     * 两个指针，start、end
     * 用sum记录窗口内的和，当sum>=target，start右移，
     * 当sum<target,end 右移，直到start=end=len-1
     * <p>
     * 可以使用两个循环控制左右窗口
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen2(int target, int[] nums) {
        int sum = 0;
        int start = 0;
        int end = -1;
        int min = Integer.MAX_VALUE;
        int len = nums.length;
        while (true) {
            if (sum >= target) {
                sum -= nums[start];
                min = Math.min(min, end - start + 1);
                start++;
            } else {
                ++end;
                if (end > len - 1) {
                    break;
                }
                sum += nums[end];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
