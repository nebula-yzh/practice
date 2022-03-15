package codetop.medium;

/**
 * @author Nebula
 * @date 2021/12/9 15:40
 * @description: 1143. 最长公共子序列 中等
 * 给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * 示例 1：
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 */
public class S1143LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abbbb";
        String text2 = "babab";
        System.out.println(longestCommonSubsequence(text1,text2));
    }

    /**
     * 二维动态规划，利用一个二维数组，根据题解
     * 背+理解
     * <p>
     * 打表，第一个字符串作为行数，第二个字符串作为列数
     *
     * 当前位置的最长公共子序列
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        //数组长度加1，空出一行一列
        int[][] dp = new int[len1 + 1][len2 + 1];
        //从1开始
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    //当两个字符相等，等于左上角长度加1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //当两个字符不相等，取左边和上面的最大值
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}
