package codetop;

/**
 * @author Nebula
 * @date 2021/10/19 17:36
 * @description: 69. Sqrt(x) 简单
 * 给你一个非负整数 x ，计算并返回x的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 * 示例 1：
 * 输入：x = 4
 * 输出：2
 * 示例 2：
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 */
public class SqrtxS69 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int res = mySqrt(655999999);
        long end = System.currentTimeMillis();

        System.out.println((end-start)+"ms");
        System.out.println(res);
    }

    /**
     * 法1：根据算术平方根的大小，算术平方根一定在(0,x)，该范围有序且递增，
     * 可以使用二分搜索，比较在范围内数字的平方与所求数x，用x/mid与mid比较，
     * 使用 mid > x / mid 作为判断条件是因为 mid * mid > x 在 mid 很大的时候，mid * mid 有可能会整型溢出
     * 大于则在左边[left,mid-1]，小于在右边[mid+1,right]，逐渐缩小，找到一个整数。
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = x;
        int mid;
        while (left <= right) {
            //求中点，防止溢出
            mid = left + ((right - left) >> 1);
            //进行二分查找
            if (mid > x / mid) {
                right = mid - 1;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        //当退出循环时，right一定小于left，判断一下right与x/right，最终结果要么是right，要么是right-1
        if (right > x / right) {
            return right - 1;
        }
        return right;

    }
}
