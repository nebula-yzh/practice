package codetop.easy;

import java.util.HashMap;

/**
 * @author Nebula
 * @date 2021/11/17 16:34
 * @description: 169. 多数元素 简单
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊n/2⌋的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1：
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * 进阶：
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class MajorityElementS169 {
    /**
     * 法1：使用哈希表来存储每个元素的个数（key为值，value为个数），每次存完之后判断该值的value是否大于n/2，
     * 不大于继续存直到结束，大于则返回该key，就不用后面再遍历了（时间O(n),空间O(n)）
     * <p>
     * 法2：投票法，设置一个投票值，当下一个值与该值相同，则投票数加1，不相同则投票数减1，当投票数减为0时，
     * 设置下一个值为投票值，重新开始，最后剩下的值即为个数大于n/2的值（题目一定有多数元素）
     * 时间复杂度为 O(n)、空间复杂度为 O(1)
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        //法2
        //还可以简化或优化代码
        //初始投票值
        int vote = nums[0];
        //投票数
        int voteCount = 1;
        for (int i = 1; i < nums.length; i++) {
            //判断是否与当前投票值相等
            if (vote == nums[i]) {
                voteCount++;
            } else {
                voteCount--;
                if (voteCount == 0) {
                    //++i，跳过被设置的投票值，从下一个开始
                    vote = nums[++i];
                    //投票数重设为1
                    voteCount = 1;
                }
            }
        }
        return vote;
    }

    /**
     * 使用哈希表
     *
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        //法1
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap(len / 2);
        for (int num : nums) {
            Integer value = map.get(num);
            if (value == null) {
                map.put(num, 1);
            } else {
                if (++value > len / 2) {
                    return num;
                } else {
                    map.put(num, value);
                }
            }
        }
        return nums[0];
    }

}
