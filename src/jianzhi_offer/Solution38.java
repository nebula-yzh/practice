package jianzhi_offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 剑指 Offer 38. 字符串的排列  中等
 * <p>
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
public class Solution38 {


    public static void main(String[] args) {
        Solution38 solution38 = new Solution38();
        System.out.println(solution38.permutation("abc"));
    }

    List<String> list = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {

        c = s.toCharArray();
        dfs(0);
        return list.toArray(new String[list.size()]);
    }

    /**
     * 深度优先搜索
     *
     * @param x 当前固定的位置
     */
    public void dfs(int x) {
        //递归中止条件
        if (x == c.length - 1) {
            //添加进集合
            list.add(String.valueOf(c));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])){
                continue;
            }
            set.add(c[i]);
            //先交换
            swap(x, i);
            //搜索
            dfs(x + 1);
            //再还原
            swap(x, i);
        }
    }

    /**
     * 交换函数，交换字符数组中的两个字符
     *
     * @param x 参数
     * @param i 参数
     * @return 返回字符数组
     */
    public char[] swap(int x, int i) {
        char temp = c[x];
        c[x] = c[i];
        c[i] = temp;
        return c;
    }
}
