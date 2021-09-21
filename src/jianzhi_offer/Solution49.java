package jianzhi_offer;

/**
 * 剑指 Offer 49. 丑数 中等
 * <p>
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 动态规划题
 * 最优子结构
 * 重复子问题
 * 思路，可以把丑数算出来放入数组中，每次去找
 */
public class Solution49 {

    public static void main(String[] args) {
        int n=1690;
        System.out.println(nthUglyNumber(n));
    }

    /**
     * 题目要求只包含质因子2,3,5
     * 该方法错误
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {

        if (n <= 6) {
            return n;
        }
        int cnt = 6;
        int i;
        for (i = 8; cnt < n; i++) {
            if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0) {
                cnt++;
            }
        }
        return i-1;
    }
}
