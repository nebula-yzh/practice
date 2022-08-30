package codetop.medium;

import java.util.HashSet;

/**
 * @author Nebula
 * @date 2021/10/10 7:09
 * @description: 3. 无重复字符的最长子串 中等
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * <p>
 * 只使用一次遍历
 * 法1：利用set记录字符判断是否有重复,再利用滑动窗口表示最大子串范围
 */
public class S03LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbc";
        int max = lengthOfLongestSubstring(s);
        System.out.println(max);
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return len;
        }
        //也可直接使用charAt(),但速度没有提升
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        set.add(chars[0]);
        int max = 0;
        for (int i = 0, right = 0; i < len; i++) {
            //窗口右边，不断向右扩展，扩展不了时退出，即集合中已存在该字符
            while (right + 1 < len && set.add(chars[right + 1])) {
                right += 1;
            }
            //存下当前最长值，子串长度为窗口大小
            max = Math.max(right - i + 1, max);
            //删除左边一个窗口，直到删除了与右边窗口相同的字符
            set.remove(chars[i]);

        }
        return max;
    }
}
