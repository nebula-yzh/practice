package codetop.hard;

/**
 * @author Nebula
 * @date 2022/3/10 16:48
 * @description: 41. 缺失的第一个正数 困难
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 */
public class S41FirstMissingPositive {

    /**
     * 法1：做标记方式
     * 1.遍历一次，将负数转换为nums.length+1
     * 2.再遍历一次将对应的正数x（若为负数取绝对值在范围内）的x-1数组下标位置变为负，比如当前位置的值为2，且在数组范围内，将nums[1]变为负数
     * 3.结束之后，遍历一次，若每个位置都为负数，则返回nums.length
     * 4.否则返回第一个遇到的正数下标+1
     * <p>
     * 因为是正整数，不要算上0  1-N
     * <p>
     * 法2：置换方式
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        //法1
        int len = nums.length;

        //将负数或0转换成正数
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                nums[i] = len + 1;
            }
        }
        //做标记
        for (int i = 0; i < len; i++) {
            int n = Math.abs(nums[i]);
            if (n > 0 && n < len + 1) {
                //注意取正，否则若右两个数字相同会再次取反
                nums[n - 1] = -Math.abs(nums[n - 1]);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return len + 1;
    }
}
