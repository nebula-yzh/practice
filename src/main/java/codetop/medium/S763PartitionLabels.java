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
     * 由于同一个字母只能出现在同一个片段，显然同一个字母的第一次出现的下标位置
     * 和最后一次出现的下标位置必须出现在同一个片段。
     * 因此需要遍历字符串，得到每个字母最后一次出现的下标位置。
     * 在得到每个字母最后一次出现的下标位置之后，可以使用贪心的方法将字符串划分为尽可能多的片段，
     * 具体做法如下:
     * 1.从左到右遍历字符串，遍历的同时维护当前片段的开始下标 {start}和结束下标 {end}，初始时 {start}={end}=0。
     * 2.对于每个访问到的字母 c，得到当前字母的最后一次出现的下标位置 {end}_c，
     * 则当前片段的结束下标一定不会小于 {end}_c，因此令 {end}=max({end},{end}_c)。
     * 3.当访问到下标 {end} 时，当前片段访问结束，当前片段的下标范围是 [{start},{end}][start,end]，
     * 长度为 {end}-{start}+1end−start+1，将当前片段的长度添加到返回值，然后令 {start}={end}+1start=end+1，
     * 继续寻找下一个片段。
     * 4.重复上述过程，直到遍历完字符串。
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
        //遍历字符串，每次更新当前分区的end值
        for (int i = 0; i < s.length(); i++) {
            //更新分区end值
            end = Math.max(end, lastCharPos[s.charAt(i) - 'a']);
            //当分区最后位置值等于当前字符的位置，即为一个分区加入res
            if (end == i) {
                res.add(end - start + 1);
                //下一个分区
                start = end + 1;
            }
        }
        return res;
    }
}
