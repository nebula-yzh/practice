package codetop.medium;

import java.util.Arrays;

/**
 * @author Nebula
 * @date 2022/4/17 9:48
 * @description: 48. 旋转图像 medium
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * 输入：matrix = [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * 输出：[
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]]
 */
public class S48RotateImage {

    /**
     * 2、m*n 使用额外矩阵，同时也满足n*n
     * 使用一个n*m的矩阵，m*n顺时针旋转就是n*m的
     * 就是将原来矩阵的行变成新矩阵的列即可
     * 第一行变最后一列，第二行变倒数第二列以此类推
     *
     * @param matrix
     */
    public static int[][] rotate2(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] res = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[j][row - i - 1] = matrix[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };
        int[][] res = rotate2(matrix);
        System.out.println(Arrays.deepToString(res));
    }

    /**
     * 题目是n*n的矩阵，因此可以不使用额外矩阵原地翻转
     * 若题目改成m*n矩阵，则需要额外矩阵进行翻转
     * <p>
     * 1、n*n 原地翻转
     * 使用一个tmp值临时存储左上角值，然后进行逐个旋转
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        //行列数相同
        int len = matrix.length;
        //i<len/2 是因为前面旋转到后面，后面部分不用旋转,已经转过了
        for (int i = 0; i < len / 2; i++) {
            //j
            for (int j = 0; j < (len + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - j - 1][i];
                matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
                matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
                matrix[j][len - i - 1] = temp;
            }
        }
    }
}
