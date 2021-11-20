package codetop.middle;

/**
 * @author Nebula
 * @date 2021/11/20 15:11
 * @description: 200. 岛屿数量 中等
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向 和/或 竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 示例 1：
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 */
public class NumberOfIslandsS200 {
    public static void main(String[] args) {
        NumberOfIslandsS200 numberOfIslands = new NumberOfIslandsS200();
        //char[][] grid = new char[][]{
        //        {'1', '1', '0', '0', '0'},
        //        {'1', '1', '0', '0', '0'},
        //        {'0', '0', '1', '0', '0'},
        //        {'0', '0', '0', '1', '1'}
        //};
        char[][] grid = new char[][]{
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        int numIslands = numberOfIslands.numIslands(grid);
        System.out.println(numIslands);
    }

    /**
     * 可以利用深度优先搜索
     * 深度优先搜索是利用递归进行，找到递归返回条件，和往哪些方向进行搜索，搜索成功或者失败的返回值是什么
     * 关于岛屿的dfs：
     * 1.递归返回条件，不要超出二维数组边界
     * 2.可以用一个二维数组记录是否访问过，或者将访问过的数进行修改（避免重复遍历）；
     * 3.若非岛屿直接返回
     * 4.进行上下左右深度优先搜索（根据题目要求进行搜索）
     * 5.外部需要遍历数组的每个元素，根据是否被访问和是否为岛屿来判断是否进入深搜
     * <p>
     * <p>
     * 本题上下左右都需搜索
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int colLen = grid[0].length;
        int rowLen = grid.length;
        boolean[][] visited = new boolean[rowLen][colLen];
        //最终岛屿个数
        int res = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                //若未被访问且为岛屿则从当前位置进行深搜
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j, visited);
                    //深搜结束，即有一个岛屿，每次加1
                    ++res;
                }
            }
        }
        return res;
    }

    /**
     * 深度优先搜索
     * @param grid 被搜索数组
     * @param row 当前行
     * @param col 当前列
     * @param visited 是否被访问数组
     */
    public void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        //递归返回条件，超出边界
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }
        //若当前网格不是陆地,或已经被访问直接返回
        if (grid[row][col] != '1'||visited[row][col]) {
            return;
        }
        //若当前是岛屿，标记为已访问
        if (grid[row][col] == '1') {
            visited[row][col] = true;
        }
        //继续上下左右搜索，当无岛屿时返回
        //往上搜索
        dfs(grid, row - 1, col, visited);
        //往下搜索
        dfs(grid,   row + 1, col, visited);
        //往左搜索
        dfs(grid, row, col - 1, visited);
        //往右搜索
        dfs(grid, row, col + 1, visited);
    }
}
