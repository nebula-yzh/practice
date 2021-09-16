package jianzhi_offer;

/**
 * 剑指 Offer 42. 连续子数组的最大和 easy
 * <p>
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 */
public class Solution42 {

    /**
     * 使用动态规划方法
     * 从最小推到最大，求到num[i]位置之前的连续数组的最大值，将每个位置的最大值直接赋给数组，每次计算出后与当前最大值比较，不用一次次循环找，只需要循环一次
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //若之前的数大于0则加上，否则不加
            nums[i] += Math.max(nums[i - 1], 0);
            //每次与res比较，大的保留
            res=Math.max(res,nums[i]);
        }
        return res;
    }
}
