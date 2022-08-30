package codetop.medium;

/**
 * @author Nebula
 * @date 2022/3/25 14:29
 * @description: 55. 跳跃游戏 medium
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 示例1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class S55JumpGame {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        boolean b = canJump(nums);
        System.out.println(b);
    }

    /**
     * 跳跃游戏，贪心算法
     * <p>
     * 贪心策略：每次跳到能够跳最大的地方
     * <p>
     * 1.判断能够跳达的位置，其值是否能直接跳到最后，若能直接返回true
     * 2.若不能，则跳到最大值的地方
     * 注意：直接跳到值最大的地方会有特例过不去[4,2,0,0,1,1,4,4,4,0,4,0]
     * 将当前的最大值 与 不为零的值的索引下标减去开始跳的位置下标比较，选择较大的
     * 3.继续往下跳，直到其值为0，无法跳了
     * <p>
     * 其实不属于贪心了，属于暴力了
     * 因为把每个选择都跳了
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] < 1) {
            return false;
        }
        int i = 0;
        int len = nums.length;
        while (i < len - 1) {
            int jump = 1;
            if (nums[i] == 0) {
                return false;
            }
            int maxJumpIndex = i + jump;
            //当前位置能够跳的个数
            while (jump <= nums[i]) {
                //判断跳到的位置，是否能直接到达最后
                if (nums[i + jump] >= len - 1 - i - jump) {
                    return true;
                }
                //记录能够跳最远的位置
                if (nums[i + jump] != 0 && nums[maxJumpIndex] <= nums[i + jump]) {
                    maxJumpIndex = i + jump;
                }
                if (nums[i + jump] != 0 && jump > nums[maxJumpIndex]) {
                    maxJumpIndex = i + jump;
                }
                jump++;
            }
            i = maxJumpIndex;
        }
        return false;
    }

    /**
     * 题解-贪心算法
     * 贪心策略：每个都往右跳，直接跳最大的距离，记录能跳最远的值
     * 遍历每个跳跃，看是否能直接跳到最后
     * <p>
     * 这才是贪心
     * 这种方法所依据的核心特性：如果一个位置能够到达，那么这个位置左侧所有位置都能到达
     * <p>
     * 更简洁
     * [2,3,1,1,4]
     *
     * @param nums
     * @return
     */
    public static boolean canJump1(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            //判断当前位置是否小于之前可以最远达到的位置，若到达不了，则也到达不了最后
            if (i <= rightmost) {
                //更新最远可以到达的位置
                rightmost = Math.max(rightmost, i + nums[i]);
                //看能否直接跳到最后
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
