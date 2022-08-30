package codetop.easy;

/**
 * @author Nebula
 * @date 2021/12/14 21:17
 * @description: 26. 删除有序数组中的重复项 简单
 * <p>
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1)额外空间的条件下完成。
 * 说明:
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicatesFromSortedArrayS26 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]+" ");
        }
    }
    /**
     * 删除有序数组的重复元素
     * 法1：时间复杂度高
     * 1.设置一个变量保存需要删除的元素
     * 2.遍历数组，找到需要删除的变量，逐个标记（表示删除)
     * 3.将不用删除的值往前移动
     *
     * 法2：利用双指针，快慢指针
     * slow指针指向不重复元素的最后一位，fast指针进行移动比较
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        //法1
        //待删除的值
        int delVal = Integer.MIN_VALUE;
        //遍历标记
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == delVal) {
                nums[i] = Integer.MIN_VALUE;
            } else {
                //判断是否存在重复
                if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    delVal = nums[i];
                }
            }
        }
        int res = 0;
        //循环处理标记的值，将不用删除的值往前移动
        for (int i = 0; i < nums.length; i++) {
            //记录最终的个数
            if (nums[i] != Integer.MIN_VALUE) {
                res++;
            } else {
                //找到第一个不用删除的值
                for (int j=i+1;j<nums.length;j++){
                    if (nums[j] != Integer.MIN_VALUE){
                        nums[i] = nums[j];
                        //移动后再置为删除标志
                        nums[j] = Integer.MIN_VALUE;
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 法2
     * 利用双指针，时间复杂度低
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        int len = nums.length;
        if (len<=1){
            return len;
        }
        int slow=1;
        int fast=1;
        while (fast<len){
            //当前值与前一位进行比较
            //需要对slow进行赋值
            if (nums[fast]!=nums[fast-1]){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
