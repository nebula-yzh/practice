package codetop.easy;

/**
 * @author Nebula
 * @date 2021/11/1 18:09
 * @description: 121. 买卖股票的最佳时机 简单
 * 给定一个数组 prices ，它的第i个元素prices[i] 表示一支给定股票第i天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0。
 * 示例 1：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 */
public class BestTimeToBuyAndSellStockS121 {
    /**
     * 动态规划
     * 分成一个个子阶段，得到状态转移方程
     * 1.需要记录股票的最低价格，及当前最大利润
     * 2.第一天一定是买入,设为最低价格min
     * 3.向后遍历，若当前价格小于min则将min替换
     * 4.若大于min，相减与max利润比较，小于向后遍历，大于替换
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len==0||len==1){
            return 0;
        }
        int min = prices[0];
        int max = 0;
        int differ;
        for (int i=1;i<len;i++){
            differ = prices[i]-min;
            if (differ<0){
                min = prices[i];
            }
            if (differ>0){
                max = Math.max(prices[i] - min, max);
            }
        }
        return max;
    }
}
