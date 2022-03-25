package codetop.medium;

/**
 * @author Nebula
 * @date 2022/3/25 11:07
 * @description: 122. 买卖股票的最佳时机 II medium
 * 给定一个数组 prices ，其中prices[i] 表示股票第 i 天的价格。
 * 在每一天，你可能会决定购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润。
 * <p>
 * 示例 1:
 * 输入: prices = [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 * 输入: prices = [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 */
public class S122BestTimeToBuyAndSellStock2 {


    /**
     * 1、贪心算法
     * 贪心思路：如果这个股票今天买明天卖可以赚钱，那就买，可以在同一天进行股票的买卖，
     * 也就是，可以先卖再买
     * <p>
     * 1.使用两个指针，比较今天和明天的股票价格
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxPro = 0;
        int len = prices.length;
        for (int i = 0; i < len - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                //买进，卖出
                maxPro += prices[i + 1] - prices[i];
            }
        }
        return maxPro;
    }
}
