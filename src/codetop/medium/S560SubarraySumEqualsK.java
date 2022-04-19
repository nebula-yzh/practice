package codetop.medium;

/**
 * @author Nebula
 * @date 2022/4/19 16:52
 * @description: 给你一个整数数组 nums 和一个整数 k ，
 * 请你统计并返回 该数组中和为 k 的子数组的个数 。 medium
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 */
public class S560SubarraySumEqualsK {

    /**
     * 1、统计和为k的连续子数组的个数，
     * 枚举所有可能，所有子数组（暴力）
     * 因为是连续子数组，所以可以直接遍历
     */
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                //子数组累加求和
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 2、利用前缀和+哈希表优化
     * 类似两数之和的做法
     * 以和为键，出现次数为对应的值
     * <p>
     * 是否有值
     * TODO
     */
    public int subarraySum2(int[] nums, int k) {

        return 0;
    }
}
