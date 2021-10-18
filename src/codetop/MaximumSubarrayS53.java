package codetop;

/**
 * @author Nebula
 * @date 2021/10/12 22:06
 * @description: 53. 最大子序和 简单
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 */
public class MaximumSubarrayS53 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    /**
     * 动态规划
     * 法1：动态规划
     * 当前位置连续子数组的最大值取决于之前的i-1位置，n[i]=n[i-1]+nums[i]，
     * 只有当前一个位置的值大于0时，才能使当前位置的值增大，若小于0则丢弃，重新开始计算连续子数组
     * nums = [-2,1,-3,4,-1,2,1,-5,4]
     * n =    [-2,1,-2,4,3,5,6,1,5]  可以得到连续子数组的和最大为6
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        //假设初始值最大
        int max=nums[0];
        for (int i=1;i<len;i++){
            //跟0做比较，只有大于0才能加，小于0则取本身值
            nums[i] += Math.max(nums[i-1],0);
            max=Math.max(max,nums[i]);
        }
        return max;
    }
}
