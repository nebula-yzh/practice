package codetop.medium;

/**
 * @author Nebula
 * @date 2022/3/25 16:09
 * @description: 45. 跳跃游戏 II medium
 * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用 最少的跳跃次数 到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 */
public class S45JumpGame2 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        int b = jump(nums);
        System.out.println(b);
    }

    /**
     * 贪心算法
     * 贪心跳最远
     * 每个都跳，跳一步记录一次，
     * <p>
     * [2,3,1,1,4]
     * 左边一定能跳到右边，从左开始
     *
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int len = nums.length;
        int minJump = 0;
        int rightmost = 0;
        //我们用 end 表示当前能跳的边界
        int end = 0;
        for (int i = 0; i < len - 1; i++) {
            //选择能跳的最远的
            rightmost = Math.max(rightmost, i + nums[i]);
            //遇到边界，就更新边界，并且步数加一
            if (i == end) {
                //更新
                end = rightmost;
                minJump++;
            }
        }
        return minJump;
    }
}
