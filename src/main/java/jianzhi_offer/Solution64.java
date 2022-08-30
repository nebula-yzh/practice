package jianzhi_offer;

/**
 * leetcode 剑指offer 64题
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 示例 1：
 * 输入: n = 3
 * 输出: 6
 */
public class Solution64 {

    public static void main(String[] args) {
        Solution64 solution = new Solution64();
        System.out.println(solution.sumNums(3));
    }

    int sumNums(int n) {
        //递归？找到递归中止条件
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
