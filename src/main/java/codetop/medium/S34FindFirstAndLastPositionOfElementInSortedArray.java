package codetop.medium;

import java.util.Arrays;

/**
 * @author Nebula
 * @date 2022/4/8 14:54
 * @description: 34. 在排序数组中查找元素的第一个和最后一个位置 medium
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * 进阶：
 * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 */
public class S34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2};
        int target = 3;
        int[] range = searchRange(nums, target);
        System.out.println(Arrays.toString(range));
    }


    /**
     * 1、常规方法，遍历一遍，找到开始，结尾
     * <p>
     * 2、二分法
     * 找到到target，然后再往前遍历，往后遍历
     */
    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = len - 1;
        int mid;
        int[] res = new int[]{-1, -1};
        while (left <= right) {
            //注意括号
            mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                int tmp = mid;
                //找左边
                while (tmp >= 0 && nums[tmp] == target) {
                    tmp--;
                }
                res[0] = tmp + 1;
                tmp = mid;
                while (tmp < len && nums[tmp] == target) {
                    tmp++;
                }
                res[1] = tmp - 1;
                break;
            }
        }
        return res;
    }

}
