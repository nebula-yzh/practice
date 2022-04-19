package codetop.medium;

import java.util.HashMap;

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
     * 两个前缀和之差是其中间的几个值之和，这样就可转变为求子数组之和
     * 且pre[i] = pre[i-1] + nums[i];当前值的前缀和等于前一个前缀和加当前值
     * <p>
     * 其实我们不关心具体是哪两项的前缀和之差等于k，只关心等于 k 的前缀和之差出现的次数c，
     * 就知道了有c个子数组求和等于k。
     * 遍历 nums 之前，我们让 -1 对应的前缀和为 0，这样通式在边界情况也成立。
     * 即在遍历之前，map 初始放入 0:1 键值对（前缀和为0出现1次了）。
     * 遍历 nums 数组，求每一项的前缀和，统计对应的出现次数，以键值对存入 map。
     * 边存边查看 map，如果 map 中存在 key 为「当前前缀和 - k」，说明这个之前出现的前缀和，
     * 满足「当前前缀和 - 该前缀和 == k」，它出现的次数，累加给 count。
     */
    public int subarraySum2(int[] nums, int k) {
        int pre = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        //初始化pre
        map.put(pre, 1);
        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
