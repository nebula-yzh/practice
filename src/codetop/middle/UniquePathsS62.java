package codetop.middle;

/**
 * @author Nebula
 * @date 2021/12/11 19:58
 * @description: 62. 不同路径 中等
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 */
public class UniquePathsS62 {
    public static void main(String[] args) {
        int i = uniquePaths(23, 12);
        System.out.println(i);
    }

        /**
         * 动态规划,不用深度优先搜索
         * 记录到达当前位置的路径数，当前路径只跟左跟上有关
         * 第一行跟第一列路径全为1
         *
         * @param m
         * @param n
         * @return
         */
        public static int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int i = 0; i < n; i++) {
                dp[0][i] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
            return dp[m - 1][n - 1];
        }

}
