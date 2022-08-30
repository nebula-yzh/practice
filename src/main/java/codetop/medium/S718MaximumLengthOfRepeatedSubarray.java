package codetop.medium;

/**
 * @author Nebula
 * @date 2022/3/15 15:10
 * @description: 718. 最长重复子数组
 * <p>
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * 输出：3
 * 解释：长度最长的公共子数组是 [3,2,1] 。
 * 示例 2：
 * 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * 输出：5
 * <p>
 * 提示：
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 100
 */
public class S718MaximumLengthOfRepeatedSubarray {

    /**
     * 最长重复子数组，与1143最长公共字串类似,但不完全相同，需要修改
     * <p>
     * 1143的字串可以连续，子数组一定要连续
     * 使用二维动态规划
     * 进行打表
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int findLength(int[] nums1, int[] nums2) {
        int row = nums1.length;
        int col = nums2.length;
        int[][] dp = new int[row + 1][col + 1];
        int res = 0;
        //二维遍历，从1开始
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    //相等dp值为左上角+1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{0, 1, 1, 1, 1};
        int[] num2 = new int[]{1, 0, 1, 0, 1};
        int length = findLength(num1, num2);
        System.out.println(length);
    }
}
