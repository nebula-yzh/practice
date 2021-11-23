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
    /**
     * 可以利用HashSet可以去重，并且查找为O(1)
     * 将数组所有元素插入set，循环查找连续的最大值
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        HashSet<Integer> set = new HashSet();
        int max=1;
        int res;
        //将元素都插入set集合
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        //利用迭代器遍历
        Iterator<Integer> iterator = set.iterator();

        while (iterator.hasNext()){
            Integer temp = iterator.next();

            if (set.contains(++temp)){
                max++;
            }

        }
    }
}
