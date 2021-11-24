package codetop.middle;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author Nebula
 * @date 2021/11/23 22:41
 * @description: 128. 最长连续序列 中等
 * <p>
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 */
public class LongestConsecutiveSequenceS128 {
    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        int i = longestConsecutive1(nums);
        System.out.println(i);
    }
    /**
     * 可以利用HashSet可以去重，使得查找为O(1)
     * 将数组所有元素插入set，循环查找连续序列的最大值
     *
     * 为了保证O(n)的时间复杂度，避免重复枚举一段序列，我们要从序列的起始数字向后枚举。
     * 也就是说如果有一个x, x+1, x+2,,,, x+y的连续序列，我们只会以x为起点向后枚举，而不会从x+1,x+2,,,向后枚举。
     * 如何每次只枚举连续序列的起始数字x？
     * 其实只需要每次在哈希表中检查是否存在 x−1即可。如果x-1存在，说明当前数x不是连续序列的起始数字，我们跳过这个数。
     *
     * 具体过程如下：
     *
     * 1、定义一个哈希表hash，将nums数组中的数都放入哈希表中。
     * 2、遍历哈希表hash，如果当前数x的前驱x-1不存在，我们就以当前数x为起点向后枚举。
     * 3、假设最长枚举到了数y，那么连续序列长度即为y-x+1。
     * 4、不断枚举更新答案。
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet();
        int max;
        int res = 0;
        //将元素都插入set集合
        for (int num : nums) {
            set.add(num);
        }

        for (Integer temp : set) {
            //max初始化
            max = 1;
            //在set种检查是否存在temp−1。如果temp-1存在，说明当前数temp不是连续序列的起始数字，我们跳过这个数
            // 否则会出现重复对子序列进行判断，增加了时间复杂度
            if (set.contains(temp-1)){
                continue;
            }
            //判断当前元素是否存在连续序列
            while (set.contains(++temp)) {
                max++;
            }
            //将大的赋给最终结果
            res = Math.max(max, res);
        }
        return res;
    }
    /**
     * 可以利用HashSet可以去重，使得查找为O(1)
     * 将数组所有元素插入set，循环查找连续序列的最大值
     *
     * 超出时间限制
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet();
        int max;
        int res = 0;
        //将元素都插入set集合
        for (int num : nums) {
            set.add(num);
        }

        for (Integer temp : set) {
            //max初始化
            max = 1;
            //判断当前元素是否存在连续序列
            while (set.contains(++temp)) {
                max++;
            }
            //将大的赋给最终结果
            res = Math.max(max, res);
        }
        return res;
    }
}
