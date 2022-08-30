package jianzhi_offer;

/**
 * 剑指offer 64题 easy 不用加减乘除做加法
 */
public class Solution65 {
    public static void main(String[] args) {
        System.out.println(add(7, 1));
    }

    /**
     * 使用位运算，与、或、异或等
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
        int c;
        //当进位为0时跳出
        while (b != 0) {
            //c用来保存进位
            c = (a & b) << 1;
            //当无需进位时，异或的结果就是和
            a ^= b;
            //将进位赋给b，再进行运算
            b = c;
        }
        return a;
    }
}
