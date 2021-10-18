package codetop;

import java.util.HashMap;

/**
 * @author Nebula
 * @date 2021/10/11 9:56
 * @description: 1. 两数之和 简单
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出和为目标值 target的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 法1，暴力法：双重循环，每次将一个数与后面所有数依次求和，计算是否有满足条件的值，若有则返回两个位置的下标
 * 法2，map存储数值，顺序根据数组的值，每次查找map，若找不到，则将当前数值放入map中，若有满足条件的值，有则返回当前数组下标和满足条件的value
 * 将值存为key，数组下标存为value
 */
public class TwoSumS01 {
    public static void main(String[] args) {
        int[] nums = new int[]{
                2,7,11,15
        };
        int[] res = twoSum(nums,9);
        for (int re : res) {
            System.out.println(re);
        }
    }
    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            //查找是否有满足条件的值
            Integer anotherNum = map.get(target-nums[i]);
            if (anotherNum!=null){
                return new int[]{i,anotherNum};
            }
            //若无满足的值，则将当前值加入map，不能提前将所有值加入map否则查找时会与当前数组值重复，只能一个个加
            else {
                map.put(nums[i],i);
            }
        }
        return new int[0];
    }
}
