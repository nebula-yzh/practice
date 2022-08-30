package jianzhi_offer;

/**
 * 剑指 Offer 47. 礼物的最大价值 中等
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 */
public class Solution47 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 2, 5},
                {3, 2, 1}

        };
        System.out.println(maxValueDP(grid));
    }

    /**
     * 要用动态规划，记录当前位置最大礼物数，返回最后一个位置的礼物数即可
     * 每次使用前一个状态的最大礼物数
     * @param grid
     * @return
     */
    public static int maxValueDP(int[][] grid) {
        int res=grid[0][0];
        int rowLen = grid.length;
        int colLen = grid[0].length;
        //单独处理第一行
        for (int j=1;j<colLen;j++){
            grid[0][j]+=grid[0][j-1];
        }
        //单独处理第一列
        for (int i=1;i<rowLen;i++){
            grid[i][0]+=grid[i-1][0];
        }
        //处理中间的部分，通过一步步计算出每个位置的最大礼物值，计算最后的礼物值
        for (int i=1;i<rowLen;i++){
            for (int j=1;j<colLen;j++){
                grid[i][j]+=Math.max(grid[i][j-1],grid[i-1][j]);
            }
        }
        return grid[rowLen-1][colLen-1];
    }

    /**
     * 方法使用错误
     * @param grid
     * @return
     */
    public static int maxValue(int[][] grid) {
        int sum = grid[0][0];
        int i = 0, j = 0;
        int rowCnt = grid.length;
        int colCnt = grid[0].length;
        while (i < rowCnt && j < colCnt) {
            //判断到达边界时情况
            if (i == rowCnt - 1 && j == colCnt - 1) {
                //保证退出循环
                i++;
            } else if (i == rowCnt - 1) {
                sum += grid[i][j + 1];
                j++;
            } else if (j == colCnt - 1) {
                sum += grid[i + 1][j];
                i++;
            }
            //对右和下的元素做比较
            if (i < rowCnt - 1 && j < colCnt - 1) {
                if (grid[i][j + 1] < grid[i + 1][j]) {
                    sum += grid[i + 1][j];
                    i++;
                } else if (grid[i][j + 1] >= grid[i + 1][j]) {
                    sum += grid[i][j + 1];
                    j++;
                }
            }
        }
        return sum;
    }
}
