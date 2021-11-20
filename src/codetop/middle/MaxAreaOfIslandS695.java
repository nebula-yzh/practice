package codetop.middle;

/**
 * @author Nebula
 * @date 2021/11/20 17:42
 * @description: 695. 岛屿的最大面积 中等
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
 * 你可以假设grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 */
public class MaxAreaOfIslandS695 {
    /**
     * 类似于第200题
     * 利用深度优先搜索
     * 关于岛屿的dfs：
     * 1.递归返回条件，不要超出二维数组边界
     * 2.可以用一个二维数组记录是否访问过，或者将访问过的数进行修改（避免重复遍历）；
     * 3.若非岛屿，或已访问直接返回
     * 4.进行上下左右深度优先搜索（根据题目要求进行搜索）
     * 5.外部需要遍历数组的每个元素，根据是否被访问和是否为岛屿来判断是否进入深搜
     * <p>
     * 本题需要计算岛屿的最大面积，因此在每次对岛屿进行标记已访问时，记录岛屿面积的变量+1
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int colLen = grid[0].length;
        int rowLen = grid.length;
        boolean[][] visited = new boolean[rowLen][colLen];
        int res = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                //若未被访问且为岛屿则从当前位置进行深搜
                if (!visited[i][j] && grid[i][j] == 1) {
                    //每次重新初始化
                    area = 0;
                    dfs(grid, i, j, visited);
                    //将面积大的返回
                    res = Math.max(res, area);

                }
            }
        }
        return res;
    }

    int area;

    /**
     * 深度优先搜索
     *
     * @param grid    被搜索数组
     * @param row     当前行
     * @param col     当前列
     * @param visited 是否被访问数组
     */
    public void dfs(int[][] grid, int row, int col, boolean[][] visited) {
        //递归返回条件，超出边界
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }
        //若当前网格不是陆地,或已经被访问直接返回
        if (grid[row][col] != 1 || visited[row][col]) {
            return;
        }
        //若当前是岛屿，标记为已访问,当前岛屿面积+1
        if (grid[row][col] == 1) {
            visited[row][col] = true;
            area++;
        }
        //继续上下左右搜索，当无岛屿时返回
        //往上搜索
        dfs(grid, row - 1, col, visited);
        //往下搜索
        dfs(grid, row + 1, col, visited);
        //往左搜索
        dfs(grid, row, col - 1, visited);
        //往右搜索
        dfs(grid, row, col + 1, visited);
    }
}
