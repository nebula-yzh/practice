package code_practice;

import java.util.*;

/**
 * @author yingzhihao
 * @date 2022/8/7 18:07
 * @description: TODO
 */
public class Solution4 {

    public static String reverseWords(String s) {
        //翻转字符串
        String str = s.trim();
        int len = str.length();
        ArrayList<String> res = new ArrayList<>();
        int begin = 0;
        int end = 0;
        int cur = 0;
        //如何手动分割字符串
        while (cur < len) {
            if (str.charAt(cur) == ' ') {
                end = cur;
                res.add(str.substring(begin, end));
                while (str.charAt(cur) == ' ') {
                    cur++;
                }
                begin = cur;

            }
            cur++;
            if (cur == len) {
                res.add(str.substring(begin, cur));
            }
        }
        Collections.reverse(res);
        return String.join(" ", res);
    }

    /**
     * 利用动态规划记忆化搜索。
     * 将字典保存在哈希表，方便查找。
     * 设置长度为s串长度+1的一维数组来表示字符串每个切点是否能在字典中匹配。
     * 设置哨兵位，从而不会影响s为1的情况。
     * 遍历s串，依次判断末尾为i的情况下，能否在字典找到。
     * 遍历结束，返回dp[s.length()].
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        //动态规划
        int len = s.length();
        Set<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[len + 1];

        dp[0] = true;
        //dp[i]表示[1,i]的字符串能否在wordDict中找到
        for (int i = 1; i < len + 1; i++) {
            //  设置j指针从头扫到当前切点
            //  j指针每次后移都要确保以j为切点的前缀满足
            for (int j = 0; j < i; j++) {
                //只有当0-j，也就是dp[j]为true，表示能构成，然后再去匹配后面剩余的是否能被构成
                if (dp[j] && set.contains(s.substring(j, i))) {
                    //  找到切点就退出
                    //  只要当前切点字符串满足就跳出j循环
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {

    }
}
