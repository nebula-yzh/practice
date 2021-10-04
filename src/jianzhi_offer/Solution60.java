package jianzhi_offer;

import java.util.Arrays;

/**
 * 剑指 Offer 60. n个骰子的点数 中等
 * <p>
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * <p>
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * <p>
 * 动态规划题
 * 1.表示状态
 * 2.找出状态转移方程
 * 3.边界处理
 * <p>
 * n个骰子的概率，由n-1个骰子的概率推出
 * 从1个骰子开始推出n个骰子的概率
 * <p>
 * 只要找出状态转移方程，就是怎么实现的问题了
 */
public class Solution60 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dicesProbability(3)));
    }

    /**
     * 复杂版，边界条件确定很复杂
     *
     * @param n
     * @return
     */
    public static double[] dicesProbability(int n) {
        //当只有一个骰子时，所有概率为1/6
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        if (n == 1) {
            return dp;
        }
        //从2个骰子开始，最终计算n个骰子，若为一个骰子直接返回
        double[] res = new double[0];

        for (int i = 2; i <= n; i++) {
            //5*i+1为和种类的个数
            int numbers = 5 * i + 1;
            //最大值,最小值
            int max = 6 * i;
            int min = i;
            //临时数组
            double[] temp = new double[numbers];
            //l从最小值开始
            for (int l = min; l <= max; l++) {
                double sum = 0;
                //l-k>i-2确定边界 k只有6个取值
                for (int k = 1; l - k > i - 2 && k <= 6; k++) {
                    if (i == 2 && l - k <= dp.length) {
                        sum += dp[l - k - 1];
                        //l-k-i+1，将数值大小，与数组下标对应
                    } else if (i > 2 && l - k - i + 1 < res.length) {
                        sum += res[l - k - i + 1];
                    }
                }
                temp[l - i] = sum * (1 / 6.0);
            }
            res = temp;
        }

        return res;
    }
}
