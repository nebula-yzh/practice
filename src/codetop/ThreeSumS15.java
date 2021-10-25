package codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Nebula
 * @date 2021/10/20 19:53
 * @description: 15. 三数之和 中等
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 */
public class ThreeSumS15 {
    /**
     * 法1：排序+首尾双指针
     * 相当于三个指针，一个固定从前到后扫描，另外两个前后扫描
     * 难点在于如何去除重复解
     * 1.特例，对于数组长度 n，如果数组为 null 或者数组长度小于 3，返回 []。
     * 2.对数组进行排序。
     * 3.遍历排序后数组：
     * 执行外循环：
     * 若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
     * 比较当前元素与前一个元素若相同，跳过此次循环，避免出现重复解。
     * 令左指针 L=i+1，右指针 R=n-1，当 L<R 时，执行内循环：
     *      当 nums[i]+nums[L]+nums[R]==0，进行循环判断，判断左界和右界是否和下一位置重复，重复则跳过将 L,R 移到下一位置，去除重复解，寻找新的解
     *      若和大于 0，说明 nums[R]太大，R左移
     *      若和小于 0，说明 nums[L]太小，L右移
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        //升序排列，只有当排序的数组才能进行后序操作
        Arrays.sort(nums);
        int left;
        int right;
        for (int cur = 0; cur < len; cur++) {
            if (nums[cur]>0){
                return res;
            }
            //在外循环中通过跳过相同数，去重
            if (cur>0&&nums[cur]==nums[cur-1]){
                continue;
            }
            left=cur+1;
            right=len-1;
            while (left < right){
                int sum = nums[cur]+nums[left]+nums[right];
                if (sum>0){
                    right--;
                }
                else if (sum<0){
                    left++;
                }
                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[cur]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    //在内循环中通过跳过相同数，去重
                    while (left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    while (left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
