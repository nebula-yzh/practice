package jianzhi_offer;

import java.util.Arrays;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数 中等
 *
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class Solution56_1 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,4,6};
        System.out.println(singleNumbers(nums));
    }
    public static int[] singleNumbers(int[] nums) {
        int[] ret = new int[2];
        Arrays.sort(nums);
        int i=0;
        int flag=0;
        int len = nums.length;
        while(i<len-1){
            if(nums[i]==nums[i+1]){
                i=i+2;
            }
            else{
                ret[flag]=nums[i];
                i=i+1;
                flag=flag+1;
            }
            if(flag==2){
                return ret;
            }
        }
        ret[flag]=nums[i];
        return ret;
    }
}
