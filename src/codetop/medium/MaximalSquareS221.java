package codetop.medium;

/**
 * @author Nebula
 * @date 2021/12/22 13:33
 * @description: 221. 最大正方形 中等
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * 示例 2：
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 */
public class MaximalSquareS221 {

    /**
     * 法1：暴力法（时间复杂度高）
     * 遍历每一个元素，查找最大的正方形
     * 1.遍历矩阵中的每个元素，每次遇到 1，则将该元素作为正方形的左上角；
     * 2.确定正方形的左上角后，根据左上角所在的行和列计算可能的最大正方形的边长（正方形的范围不能超出矩阵的行数和列数），
     * 在该边长范围内寻找只包含 1 的最大正方形；
     * 3.每次在下方新增一行以及在右方新增一列，判断新增的行和列是否满足所有元素都是 1。
     *
     * 法2：动态规划
     * 我们用 dp(i, j)表示以(i,j)为右下角，且只包含 1 的正方形的边长最大值。
     * 如果我们能计算出所有 dp(i,j) 的值，那么其中的最大值即为矩阵中只包含 1 的正方形的边长最大值，其平方即为最大正方形的面积。
     * 对于每个位置 (i,j)，检查在矩阵中该位置的值：
     * 1.如果该位置的值是 0，则 dp(i, j) = 0，因为当前位置不可能在由 1组成的正方形中；
     * 2.如果该位置的值是 1，则 dp(i, j)的值由其上方、左方和左上方的三个相邻位置的 dp 值决定。具体而言，当前位置的元素值等于三个相邻位置的元素中的最小值加 1，
     * 状态转移方程如下：
     * dp(i, j)=min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1))+1
     * dp数组的元素的值，与三个位置有关，上方，左方，左上方
     *
     * 每次将当前dp值与最大边长比较，最后返回边长的平方即为正方形面积
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        //法2 动态规划
        int colLen = matrix[0].length;
        int rowLen = matrix.length;
        int[][] dp = new int[rowLen][colLen];
        int resMax=0;
        for (int i=0;i<rowLen;i++){
            for (int j=0;j<colLen;j++){
                if (matrix[i][j]=='1'){
                    //第一行或第一列的dp值，当矩阵为1时，dp值也为1，dp值默认为0
                    if (i==0||j==0){
                        dp[i][j]=1;
                    }else {
                        //选择最小的dp值加1
                        dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    }
                }
                resMax = Math.max(resMax,dp[i][j]);
            }
        }
        return resMax*resMax;
    }
}
