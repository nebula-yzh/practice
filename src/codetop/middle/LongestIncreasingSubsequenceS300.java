package codetop.middle;

import java.util.Arrays;

/**
 * @author Nebula
 * @date 2021/11/26 9:28
 * @description: 300. 最长递增子序列 中等
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 */
public class LongestIncreasingSubsequenceS300 {
    public static void main(String[] args) {
        int[] nums = new int[]{
                10,9,2,5,3,7,101,18
        };
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }
    /**
     * 动态规划（时间复杂度O(n^2)）
     *
     * 1.使用一个dp数组记录当前位置的最长递增子序列
     * 2.外层循环，循环每个元素，进行计算dp
     * 3.内层循环，每次计算当前元素的最长dp时都从数组的第一个元素开始计算，
     *  当某个元素大于当前元素直接跳过，当某个元素小于当前元素时，将那个元素当前位置的dp值+1，跟当前元素的dp值比较，大的赋值给当前元素dp值
     * 4.再使用一个返回最大值，记录最长递增子序列值
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len==1){
            return 1;
        }
        //dp数组，记录当前元素之前的最大递增子序列
        int[] dp = new int[len];
        int resMax=1;
        //dp初始值全为1
        Arrays.fill(dp,1);
        for(int i=1;i<len;i++){
            //从开始计算到当前元素位置
            for (int j=0;j<i;j++){
                //大于时才比较，小于直接跳过
                if (nums[i]>nums[j]){
                    //比较谁大
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
                resMax = Math.max(resMax,dp[i]);
            }
        }
        return resMax;
    }
}
