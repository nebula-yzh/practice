package codetop.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Nebula
 * @date 2022/3/11 18:47
 * @description: 763. 划分字母区间 中等
 *
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，
 * 同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 *
 * 美团2020笔试题
 * 示例：
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 */
public class S763PartitionLabels {

    /**
     * 题解
     * 贪心
     * 美团笔试
     *
     * @param s
     * @return
     */
    public static List<Integer> partitionLabels(String s) {
        List<Integer> res = new LinkedList<>();
        // 获取所有字母的最后一个位置，并存在对应位置
        int[] lastCharPos = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastCharPos[s.charAt(i) - 'a'] = i;
        }

        // 双指针
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //更新end
            end = Math.max(end, lastCharPos[s.charAt(i) - 'a']);
            //当最后位置值等于字符当前字符的位置，加入res
            if (end == i) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
