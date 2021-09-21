package jianzhi_offer;

import java.util.Arrays;

/**
 * 剑指 Offer 63. 股票的最大利润 中等
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class Solution63 {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfitDP(prices));
    }

    /**
     * 该方法只是暴力的遍历了数组，时间复杂度过高 O(n^2)
     * 可以使用动态规划
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (prices[i] < prices[j]) {
                    res = Math.max(res, prices[j] - prices[i]);

                }
            }
        }
        return res;
    }

    /**
     * 前i日最大利润=(第i日价格-前i日最小价格)
     * 计算当前日之前的最大利润
     *
     *
     * @param prices
     * @return
     */
    public static int maxProfitDP(int[] prices) {
        int len = prices.length;
        if (len == 0 || len == 1) {
            return 0;
        }
        int res = 0;
        //用来记录i前面的最小值
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            //int[] arr = Arrays.copyOf(prices, i);。。。时间更长了。。。时间复杂度更高了
            //Arrays.sort(arr);
            //res = Math.max(res, prices[i] - arr[0]);
            if (prices[i - 1] < min) {
                min = prices[i - 1];
            }
            res = Math.max(res, prices[i] - min);

        }
        return res;
    }
}
