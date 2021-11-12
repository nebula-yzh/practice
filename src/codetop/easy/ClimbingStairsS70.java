package codetop.easy;

/**
 * @author Nebula
 * @date 2021/11/12 9:00
 * @description: 70. 爬楼梯 简单
 * 假设你正在爬楼梯。需要 n阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class ClimbingStairsS70 {
    public static void main(String[] args) {
        int i = climbStairsExtend(10);
        System.out.println(i);
    }
    /**
     * 动态规划问题，根据前一个或两个状态确定当前状态
     * 类似斐波那契数列，f(n) = f(n-1)+(n-2) (n>1)
     * 解题思路：
     * 当前层可以由前一层走一步，或前两层走一步到达，因此能到达当前层的方法，前一层的方法数+前两层的方法数
     * 0个台阶时为1，1个台阶时为1，n从2开始
     * 用两个变量保存到达前一层和前两层的方法数
     *
     * 扩展：不能爬到7及7的倍数 2021.3 字节跳动-教育-后端-一面
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        //前一层
        int pre=1;
        //前两层
        int pre2=1;
        int res=1;
        for (int i=2;i<=n;i++){
            res=pre+pre2;
            pre2=pre;
            pre=res;
        }
        return res;
    }

    /**
     * 扩展：不能爬到7或7的倍数，当循环到7或7的倍数时，将到达当前阶梯的方法数置0
     * @param n
     * @return
     */
    public static int climbStairsExtend(int n) {
        //前一层
        int pre=1;
        //前两层
        int pre2=1;
        int res=1;
        for (int i=2;i<=n;i++){
            res=pre+pre2;
            if (i%7==0){
                res=0;
            }
            pre2=pre;
            pre=res;
        }
        return res;
    }
}
