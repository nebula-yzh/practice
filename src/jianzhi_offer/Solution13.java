package jianzhi_offer;

/**
 * 剑指 Offer 13. 机器人的运动范围 中等
 * 搜索题
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
public class Solution13 {
    int count;

    public int movingCount(int m, int n, int k) {
        int temp1 = m;
        int cnt_m = 0;
        while (temp1 != 0) {
            cnt_m += 1;
            temp1 /= 10;
        }
        temp1 = n;
        int cnt_n=0;
        while (temp1!=0){
            cnt_n+=1;
            temp1/=10;
        }
        return 0;
    }

    public int dfs(int m, int n, int k, int i, int j,int cnt_m, int cnt_n) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        if (i <= 9 && j <= 9 && i + j <= k) {
            count += 1;
        }
        return 0;
    }

}
