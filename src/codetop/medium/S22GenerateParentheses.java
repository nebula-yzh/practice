package codetop.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nebula
 * @date 2022/2/28 16:10
 * @description: 22. 括号生成 中等
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 1 <= n <= 8
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 */
public class S22GenerateParentheses {
    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        strings.forEach(System.out::println);
    }

    /**
     * 深度优先搜索+剪枝
     * <p>
     * 二叉树递归遍历就是典型的深度优先搜索，可通过画图来描述
     * <p>
     * 题目解释：括号分为左括号和右括号，n为生成括号的对数，左右括号闭合情况下，有很多种可能，需要最终返回组合列表
     * 1.通过深度优先搜索，将根节点定位空串，将左分支定为 (，右分支定为 )，每次递归往下传递res集合，左括号个数，右括号个数，
     * str字符串表示当前括号组合可能的结果，并加入res
     * 2.进入左分支条件，左括号个数大于0
     * 3.进入右分支条件，右括号个数大于左括号个数（此时剪枝）
     * 4.不满足进入分支，减去当前分支（else，可不加）
     * 5.若左括号个数和右括号个数均等于0，则代表此组合可行，加入res，返回上层（递归返回条件）
     * <p>
     * 错误：不应该将本来的左右括号数减1作为参数传递下去，只需要将减小的值传下去即可，否则返回递归时，当前括号数变了，会出错
     *
     * @param n 括号对数
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfsGenerateParenthesis(res, n, n, "");
        return res;
    }

    /**
     * @param res        最终列表
     * @param leftCount  左括号可使用个数
     * @param rightCount 右括号可使用个数
     * @param str        当前递归结果
     */
    public static void dfsGenerateParenthesis(List<String> res, int leftCount, int rightCount, String str) {
        //递归结束条件，即到最深处
        if (leftCount == 0 && rightCount == 0) {
            res.add(str);
            return;
        }
        //剪枝，当左括号个数严格大于右括号
        //if (leftCount > rightCount) {
        //    return;
        //}
        //进入左分支 不能是--leftCount，不能在自己变量加减
        if (leftCount > 0) {
            dfsGenerateParenthesis(res, leftCount - 1, rightCount, str + "(");
        }
        //进入右分支，将剪枝放在判断，或剪枝时rightCount>0
        if (rightCount > leftCount) {
            dfsGenerateParenthesis(res, leftCount, rightCount - 1, str + ")");
        }
    }
}
