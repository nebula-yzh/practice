package jianzhi_offer;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字 easy
 * <p>
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */
public class Solution53_2 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 5, 6, 7};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        //暴力法时间复杂度O(n)
        //还可以使用二分查找
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //逐个判断是否有缺少，若与i不等则返回i
            if (nums[i] != i) {
                return i;
            }
        }
        //当不缺少时，返回最后一个数组最后一个数字加1
        return nums[len - 1] + 1;

    }


    public static int missingNumberWay2(int[] nums) {
        //二分查找法
        int i, j;
        j = nums.length - 1;
        i = 0;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

}
