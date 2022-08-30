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
        int n = 1690;
        //System.out.println(nthUglyNumber(n));

        System.out.println(nthUglyNumberDp(n));
    }

    /**
     * 题目要求只包含质因子2,3,5
     * 该方法错误
     *
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
        return i - 1;
    }

    /**
     * 由丑数构成的数也为丑数，
     * 思路，可以把丑数算出来放入数组中，每次去找
     * 找到第n个丑数
     *
     * @param n
     * @return
     */
    public static int nthUglyNumberDp(int n) {
        //三个指针
        int flagA = 0;
        int flagB = 0;
        int flagC = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[flagA] * 2;
            int n3 = dp[flagB] * 3;
            int n5 = dp[flagC] * 5;
            dp[i] = Math.min(Math.min(n2,n3),n5);
            if (dp[i] == n2) {
                flagA++;
            }
            if (dp[i] == n3) {
                flagB++;
            }
            if (dp[i] == n5) {
                flagC++;
            }
        }
        return dp[n - 1];
    }

    /**
     * 超时方法，运行时间过长，时间复杂度高
     * 可以不用计数
     * @param n
     * @return
     */
    public int nthUglyNumberDp2(int n) {
        //三个指针
        int flagA = 0;
        int flagB = 0;
        int flagC = 0;
        int cnt = 1;
        boolean flag;
        int[] dp = new int[n];
        dp[0]=1;
        for (int i = 2; cnt < n; i++) {
            flag=false;
            int n2=dp[flagA]*2;
            int n3=dp[flagB]*3;
            int n5=dp[flagC]*5;
            if (i == n2){
                flagA++;
                flag=true;
            }
            if (i == n3){
                flagB++;
                flag=true;
            }
            if (i == n5){
                flagC++;
                flag=true;
            }
            if (flag){
                dp[cnt]=i;
                cnt++;
            }
        }
        return dp[n-1];
    }
}
