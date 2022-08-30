package codetop.easy;

/**
 * @author Nebula
 * @date 2022/4/19 16:04
 * @description: 14. 最长公共前缀 easy
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 */
public class S14LongestCommonPrefix {

    /**
     * 依次遍历每个字符串，与第一个字符串比较，是否有相同前缀，
     * 相同记录
     * 不相同返回最长公共前缀
     * <p>
     * 遍历第一个字符串，判断后续字符串中是否有相同前缀
     * 注意字符串个数不同，越界
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        if (len == 1) {
            return strs[0];
        }
        StringBuilder res = new StringBuilder();
        retry:
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < len; j++) {
                if (strs[j].length() <= i) {
                    //直接退出外层循环
                    break retry;
                }
                if (strs[0].charAt(i) != strs[j].charAt(i)) {
                    break retry;
                }
            }
            res.append(strs[0].charAt(i));
        }
        return res.toString();
    }
}

