package jianzhi_offer;

/**
 * 剑指 Offer 12. 矩阵中的路径 中等
 * <p>
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class Solution12 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'a', 'b', 'c', 'e'},
                {'s', 'f', 'c', 's'},
                {'a', 'd', 'e', 'e'}
        };
        char[][] board1 = new char[][]{
                {'a','a' }
        };
        String word = new String("aaa");
        System.out.println(exist(board1, word));
    }

    public static boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        //两层循环，遍历二维数组
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //进行深度优先搜索，只有当每一个都找到时返回true
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
    public static boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        //若i或j超出边界，或者当前位置字符不是我们要查找字符，返回false
        //递归退出条件,不满足搜索条件

        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        if(k==word.length-1) {
            return true;
        }
        //将已访问字符标记为'\0'，否则若出现重复字符算法会再次访问导致错误
        board[i][j]='\0';
        //进行上、下、左、右的深度优先搜索,哪个方向成功都可
        boolean ret = dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i + 1, j, k + 1)
                || dfs(board, word, i, j - 1, k + 1) || dfs(board, word, i, j + 1, k + 1);
        //本次搜索换成后，还原当前矩阵元素，否则后序要是再用到该字符则会错误
        board[i][j]=word[k];
        return ret;
    }
}
