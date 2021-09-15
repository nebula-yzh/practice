package jianzhi_offer;

/**
 * 剑指 Offer 13. 机器人的运动范围 中等
 * 搜索题
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
public class Solution13 {

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        System.out.println(solution13.movingCount(16, 8, 4));
    }

    public int movingCount(int m, int n, int k) {
        int temp = m;
        //最小就是一位数
        int cnt_m = 1;
        int cnt_n = 1;
        if (m > 9) {
            cnt_m = countNums(temp);
        }
        temp = n;
        if (n > 9) {
            cnt_n = countNums(temp);
        }
        int[][] board = new int[m][n];

        return dfs(board, m, n, k, 0, 0, cnt_m, cnt_n);
    }

    /**
     * 深度优先搜索
     *
     * @param board 记录走过的格子
     * @param m     行数
     * @param n     列数
     * @param k     k数
     * @param i     在哪行
     * @param j     在哪列
     * @param cnt_m 行的数字位数
     * @param cnt_n 列的数字位数
     * @return 到达多少个格子
     */
    public int dfs(int[][] board, int m, int n, int k, int i, int j, int cnt_m, int cnt_n) {
        //计算和
        int sum_i = 0;
        int sum_j = 0;
        sum_i = sumNums(cnt_m, i);
        sum_j = sumNums(cnt_n, j);
        //递归中止条件，要判断i+j是否小于k若小于则直接返回，不再递归下去
        if (i >= m || j >= n || sum_i + sum_j > k || board[i][j] == -1) {
            return 0;
        }

        //标志已访问
        board[i][j] = -1;
        //无需再向上向左搜索
        //下
        int down = dfs(board, m, n, k, i + 1, j, cnt_m, cnt_n);
        //右
        int right = dfs(board, m, n, k, i, j + 1, cnt_m, cnt_n);
        return 1 + down + right;
    }

    /**
     * 计算一个数的位数
     *
     * @param temp 输入的数 100
     * @return 数的位数 3位
     */
    public int countNums(int temp) {
        int cnt = 0;
        while (temp != 0) {
            cnt += 1;
            temp /= 10;
        }
        return cnt;
    }

    /**
     * 计算各位数和
     *
     * @param cnt  位数
     * @param nums 数字
     * @return 每个位数字和
     */
    public int sumNums(int cnt, int nums) {
        int sum = 0;
        for (; cnt > 0; cnt--) {
            sum += nums % 10;
            nums /= 10;
        }
        return sum;
    }
}
