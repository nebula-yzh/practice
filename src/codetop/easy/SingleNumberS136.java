package codetop.easy;

import java.util.Arrays;

/**
 * @author Nebula
 * @date 2021/12/20 10:46
 * @description: 136. 只出现一次的数字 简单
 *给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * 示例2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumberS136 {
    /**
     * 法1：先排序，再遍历，若无两个相等，则返回(时间复杂度不符合，nlogn)
     * 法2：异或运算，将每个数字异或，相同的数字都会消去，最后剩下只有一个的数字
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        for (;i<nums.length-1;i+=2){
            if (nums[i]!=nums[i+1]){
                break;
            }
        }
        return nums[i];
    }

    /**
     * 异或方法
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
