package codetop.middle;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Nebula
 * @date 2021/12/6 9:29
 * @description: 151. 翻转字符串里的单词 中等
 * 给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
 * 说明：
 * 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
 * 翻转后单词间应当仅用一个空格分隔。
 * 翻转后的字符串中不应包含额外的空格。
 * <p>
 * 示例 1：
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：输入字符串可以在前面或者后面包含多余的空格，但是翻转后的字符不能包括。
 * <p>
 * 进阶：
 * 请尝试使用 O(1) 额外空间复杂度的原地解法。
 * java中String是不可变的，没办法写出来O(1)的。
 */
public class ReverseWordsInAStringS151 {
    public static void main(String[] args) {
        String s = "  the   sky   is   blue  ";
        String s1 = reverseWords2(s);
        System.out.println(s1);
    }
    /**
     * 法1：利用String的内置函数，trim，spilt，reverse,join等（时间复杂度，空间复杂度都为O(n)）
     * <p>
     * 法2：利用双指针，从尾开始取单词，找到两个空格字符之间的单词进行截取
     *
     * 进阶：
     *  * 请尝试使用 O(1) 额外空间复杂度的原地解法。
     *  * java中String是不可变的，没办法写出来O(1)的。
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        //法1
        //删除字符串前导和尾随空格
        s = s.trim();
        //正则匹配连续的空白字符作为分隔符分割
        String[] s1 = s.split("\\s+");
        List<String> strings = Arrays.asList(s1);
        Collections.reverse(strings);
        return String.join(" ", strings);
    }

    /**
     * 利用双指针,
     * 使用StringBuilder
     *
     * @param s
     * @return
     */
    public static String reverseWords2(String s) {
        //法2
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = s.length() - 1;
        int start;
        int end;
        while (left <= right) {
            //找到单词右边界
            end = right;
            while (left <= end && s.charAt(end) == ' ') {
                end--;
            }
            start = end;
            //找到单词左边界
            while (left <= start && s.charAt(start) != ' ') {
                start--;
            }
            //截取字符串添加到sb
            sb.append(s, start + 1, end + 1).append(" ");
            right = start;
        }
        //删除最后一个空格
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

}
