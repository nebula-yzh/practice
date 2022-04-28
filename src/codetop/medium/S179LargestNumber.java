package codetop.medium;

import java.util.PriorityQueue;

/**
 * @author Nebula
 * @date 2022/4/28 9:06
 * @description: 179. 最大数 medium
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 */
public class S179LargestNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{
                3, 30, 34, 5, 9
        };
        String s = largestNumber(nums);
        System.out.println(s);
    }

    /**
     * 输出一个最大的数(字符串)
     * 想法：根据数字第一个值进行排序，取第一个位置最大的数字，若第一个位置的值一样大，比较第二个，但不好实现（可以实现）
     * <p>
     * 法1.将两个数字组合，即a+b，以字符串的形式，比较a+b与b+a的大小，返回大的，最终返回的就是最大的值(不是)
     * 因为这个数的每个位置都要是最大的，因此，利用贪心的思想，逐渐实现。
     * 需要使用优先队列，比较每个字符，底层是比较ASCII码
     * <p>
     * 法2：利用深搜也可，需要回溯，时间复杂度高
     *
     * @param nums
     * @return
     */
    public static String largestNumber(int[] nums) {
        //法1 贪心
        PriorityQueue<String> heap = new PriorityQueue<>((x, y) -> (y + x).compareTo(x + y));
        //使用优先队列进行排序,两个值的和比较
        //比如[3,30,34,5,9]，排序好之后就是[9,5,34,3,30]
        for (int num : nums) {
            heap.add(String.valueOf(num));
        }
        StringBuilder res = new StringBuilder();
        while (!heap.isEmpty()) {
            res.append(heap.poll());
        }
        //全为0的情况
        if (res.charAt(0) == '0') {
            return "0";
        }
        return res.toString();
    }
}
