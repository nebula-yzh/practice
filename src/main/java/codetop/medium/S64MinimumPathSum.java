package codetop.medium;

/**
 * @author Nebula
 * @date 2022/3/1 15:59
 * @description: 64. 最小路径和 中等
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 */
public class S64MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1}, {1, 5, 1}, {4, 2, 1}
        };
        int i = minPathSum(grid);
        System.out.println(i);
    }

    /**
     * 动态规划
     * 保存到达当前位置的最小路径和，只会从左和上得到值，比较获取较小值
     * 需要计算每个点的值
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        return dpMinPath(grid);
    }

    /**
     * 也可以直接用grid保存计算的值
     *
     * @param grid
     */
    public static int dpMinPath(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //最上面一行
                if (i - 1 < 0 && j - 1 >= 0) {
                    grid[i][j] += grid[i][j - 1];
                }
                //最左边一行
                if (i - 1 >= 0 && j - 1 < 0) {
                    grid[i][j] += grid[i - 1][j];
                }
                //其他部分
                if (i - 1 >= 0 && j - 1 >= 0) {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[row - 1][col - 1];
    }

}
