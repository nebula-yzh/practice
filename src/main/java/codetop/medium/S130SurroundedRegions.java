package codetop.medium;

import java.util.Arrays;

/**
 * @author Nebula
 * @date 2022/4/13 11:12
 * @description: 130. 被围绕的区域 MEDIUM
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 输入：board = [["X","X","X","X"],
 * ["X","O","O","X"],
 * ["X","X","O","X"],
 * ["X","O","X","X"]]
 * 输出：[["X","X","X","X"],
 * ["X","X","X","X"],
 * ["X","X","X","X"],
 * ["X","O","X","X"]]
 * <p>
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的'O'都不会被填充为'X'。
 * 任何不在边界上，或不与边界上的'O'相连的'O'最终都会被填充为'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class S130SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'O', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'X'},
                {'O', 'X', 'X', 'X'},
                {'O', 'O', 'O', 'O'}
        };
        solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    /**
     * 深度优先搜索
     * 有些类似岛屿问题，但更复杂些，本质类似
     * <p>
     * 可以遍历每个O，搜索所有不在边界的O，当O在边界时不满足条件（错误）
     * 没办法直接判断O是否被X包围，只能反向思维，将没有被包围去除即可
     * 主要是怎么转换思路：
     * 只要和边界上的O连通的O就不可能被包围
     * 因此不是遍历整个二维数组进行深搜，而是通过边界上的O进行深搜，将所有与之连通的O都改为#(或者其他字符)
     * 然后结束深搜之后，再次遍历整个二维数组，将#改为O，将O为X
     *
     * @param board
     */
    public static void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        //遍历外层
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O' && (j == 0 || i == 0 || j == col - 1 || i == row - 1)) {
                    dfs(board, i, j, col, row);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }

    }


    public static void dfs(char[][] board, int i, int j, int col, int row) {
        //出口,不超出数组边界，其他条件
        if (i < 0 || i > row - 1 || j < 0 || j > col - 1 || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }
        //能做的事,进行改写
        board[i][j] = '#';
        //上
        dfs(board, i - 1, j, col, row);
        //下
        dfs(board, i + 1, j, col, row);
        //左
        dfs(board, i, j - 1, col, row);
        //右
        dfs(board, i, j + 1, col, row);
    }

}
