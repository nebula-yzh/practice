package jianzhi_offer;

/**
 * @author Nebula
 * @date 2021/10/5 15:33
 * @description: 剑指 Offer 14- II. 剪绳子 II 中等
 * <p>
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class Solution14_2 {
    public static void main(String[] args) {
        System.out.println(cuttingRope(127));
    }

    /**
     * 大数，不能用math，循环求余
     *
     * @param n
     * @return
     */
    public static int cuttingRope(int n) {
        //n=2 或 n=3时直接返回
        if (n == 2 || n == 3) {
            return n - 1;
        }
        int p=1000000007;
        //返回的结果
        long res = 1;
        while (n > 4) {
            res = res * 3%p;
            n -= 3;
        }
        return (int) (res*n%p);
    }
}
