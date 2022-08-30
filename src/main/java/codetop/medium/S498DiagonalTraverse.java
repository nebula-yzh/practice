package codetop.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Nebula
 * @date 2022/4/5 15:51
 * @description: 498. 对角线遍历 medium
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * <p>
 * 输入：mat = [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ]
 * 输出：[1,2,4,7,5,3,6,8,9]
 */
public class S498DiagonalTraverse {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };
        int[] diagonalOrder = findDiagonalOrder2(arr);
        System.out.println(Arrays.toString(diagonalOrder));
    }


    public static int[] findDiagonalOrder(int[][] mat) {
        //将列值分奇偶，偶数从下往上，奇数从上往下
        //对角线值，从下往上为i-1,j+1
        //从上往下为，i+1,j-1
        //区分方阵与非方阵，普通m*n矩阵，m!=n
        int row = mat.length;
        int col = mat[0].length;
        int i = 0, j = 0;
        List<Integer> res = new ArrayList<>();
        int cnt = row * col;
        while (cnt > 0) {
            //偶数
            if ((i + j) % 2 == 0) {
                while (i >= 0 && j < col) {
                    res.add(mat[i][j]);
                    i--;
                    j++;
                    cnt--;
                }
                //加回来、减回来
                i++;
                j--;
                //考虑边界，非方阵
                if (j + 1 >= col) {
                    i++;
                } else {
                    j++;
                }
            } else {
                while (i < row && j >= 0) {
                    res.add(mat[i][j]);
                    i++;
                    j--;
                    cnt--;
                }
                i--;
                j++;
                if (i + 1 >= row) {
                    j++;
                } else {
                    i++;
                }
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 优化
     *
     * @param mat
     * @return
     */
    public static int[] findDiagonalOrder2(int[][] mat) {
        //将列值分奇偶，偶数从下往上，奇数从上往下
        //对角线值，从下往上为i-1,j+1
        //从上往下为，i+1,j-1
        //区分方阵与非方阵，普通m*n矩阵，m!=n
        int row = mat.length;
        int col = mat[0].length;
        int i = 0, j = 0;
        List<Integer> res = new ArrayList<>();
        int cnt = row * col;
        while (cnt > 0) {
            res.add(mat[i][j]);
            //偶数
            if ((i + j) % 2 == 0) {
                if (j + 1 >= col) {
                    //到右边界
                    i++;
                } else if (i - 1 < 0) {
                    //到上边界
                    j++;
                } else {
                    //正常往右上
                    i--;
                    j++;
                }
            } else {
                if (i + 1 >= row) {
                    //到下边界
                    j++;
                } else if (j - 1 < 0) {
                    //到左边界
                    i++;
                } else {
                    i++;
                    j--;
                }
            }
            cnt--;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
