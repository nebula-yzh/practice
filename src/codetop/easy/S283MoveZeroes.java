package codetop.easy;

/**
 * @author Nebula
 * @date 2022/4/29 15:20
 * @description: 283. 移动零 EASY
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class S283MoveZeroes {

    /**
     * 将0全部移动到后面，其他数字相对位置不变
     * 法1：使用双指针
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int start = 0;
        int end = 0;
        int len = nums.length;
        while (end < len) {
            //将后面的数字往前移动
            if (nums[end] != 0) {
                nums[start++] = nums[end];
            }
            end++;
        }
        //补0
        for (int i = start; i < len; i++) {
            nums[i] = 0;
        }
    }
}
