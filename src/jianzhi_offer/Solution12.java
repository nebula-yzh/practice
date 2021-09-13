package jianzhi_offer;

/**
 * 剑指 Offer 12. 矩阵中的路径 中等
 * <p>
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class Solution12 {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        //两层循环，遍历二维数组
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, chars, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 深度优先算法
     *
     * @param board 查找的二维数组
     * @param word  需要查找的单词数组
     * @param i     记录当前行数
     * @param j     记录当前列数
     * @param k     记录当前比对到哪个单词
     * @return 是否查到
     */
    public boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i>board.length||i<0||j>board[0].length||j<0||board[i][j]!=word[k]){
            return false;
        }
         return true;
    }
}
