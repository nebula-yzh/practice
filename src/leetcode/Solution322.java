package leetcode;

import java.util.Arrays;

/**
 * leetcode 零钱兑换 中等
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 * @author 应志豪
 */
public class Solution322 {

    public static void main(String[] args) {
        int[] coins=new int[]{1,2,5};
        int amount=11;
        int i = coinChange(coins, amount);
        System.out.println(i);
    }
    private static int[] memo;
    private static final int VAR = -666;
    public static int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        //dp数组全部初始化为特殊值
        Arrays.fill(memo, VAR);

        return dp(coins,amount);
    }

    private static int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        //查备忘录防止重复计算
        if (memo[amount] != VAR) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            //计算子问题的结果
            int subProblem = dp(coins, amount - coin);
            //子问题无解则跳过
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }
        //把计算结果存入备忘录
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }
}
