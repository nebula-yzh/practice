package codetop.easy;

/**
 * @author Nebula
 * @date 2022/4/5 17:40
 * @description: 191. 位1的个数 EASY
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * <p>
 * 提示：
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，
 * 并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的示例 3中，输入表示有符号整数 -3。
 * <p>
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011中，共有三位为 '1'。
 */
public class S191NumberOf1Bits {
    public static void main(String[] args) {

        int i = hammingWeight(-Integer.MAX_VALUE);
        System.out.println(i);
    }

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt = cnt + (n & 1);
            //>> 算术右移 舍弃最低位，高位用符号位填补； 当为负数时
            // 负数的最高位为1，n永远不会为0，会陷入死循环
            //>>> 逻辑右移 舍弃最低位，高位用 0 填补。
            n = n >>> 1;
        }
        return cnt;
    }
}
