package codetop.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nebula
 * @date 2021/11/13 9:32
 * @description: 54. 螺旋矩阵 中等
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 实例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrixS54 {
    /**
     * 一圈圈的遍历，左-右，上-下，右-左，下-上
     * 每一圈都按照这个顺序，需要判断其中是否已经遍历完,若遍历完了就退出外层循环
     * 难点：怎么换方向，怎么判断是否遍历完
     * 特殊情况，一行或一列的时候，一个的时候
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        //列数
        int right = matrix[0].length-1;
        int top = 0;
        //行数
        int bottom = matrix.length-1;
        List<Integer> res = new ArrayList<>();
        while (true){
            //从左到右
            for (int i=left;i<=right;i++){
                res.add(matrix[top][i]);
            }
            //判断下面是否还有数据,若有，top自加1，换到下一行
            if (++top>bottom){
                break;
            }
            //从上到下
            for (int i=top;i<=bottom;i++){
                res.add(matrix[i][right]);
            }
            //换到左边一列
            if (--right<left){
                break;
            }
            //从右到左
            for (int i=right;i>=left;i--){
                res.add(matrix[bottom][i]);
            }
            //换到上一行
            if (--bottom<top){
                break;
            }
            //从下到上
            for (int i=bottom;i>=top;i--){
                res.add(matrix[i][left]);
            }
            //重新一圈
            if (++left>right){
                break;
            }
        }
        return res;
    }
}
