package codetop.medium;

/**
 * @author Nebula
 * @date 2021/11/16 16:04
 * @description: 5.最长回文子串 中等
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 */
public class LongestPalindromicSubstringS05 {
    public static void main(String[] args) {
        String s = "cbb";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }

    /**
     * 法1：中心扩散(时间复杂度O(n^2))
     * 每个回文子串都是中心的对称的，
     * 因此对每个字符从中间开始往两边扩散，直到有不相等的字符，记录最大回文子串
     * 1.将字符串转成字符数组，也可以不转用charAt()
     * 2.外层循环进行每个字符的循环
     * 3.内层循环进行中扩散，直到有两边不相等的字符,找到最大回文子串，还需要记录最大回文子串起始和结束位置
     * 注意：奇数数回文字符串和偶数回文字符串
     *
     * 可以将中心扩散抽取成函数。
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len == 1) {
            return s;
        }
        int evenLeft;
        int evenRight;

        int oddLeft;
        int oddRight;

        int evenLen;
        int oddLen;

        int start = 0;
        int end = 0;
        //外层对每个字符的循环
        for (int i = 1; i < len; i++) {
            evenLeft = i - 1;
            evenRight = i;
            oddLeft = i - 1;
            oddRight = i + 1;
            //内层中心扩散，分奇数偶数
            //偶数s.charAt(left) == s.charAt(right)
            //扩散
            while (evenLeft >= 0 && evenRight < len && s.charAt(evenLeft) == s.charAt(evenRight)) {
                evenLeft--;
                evenRight++;
            }
            //长度
            evenLen = evenRight - evenLeft - 1;
            //奇数s.charAt(left)==s.charAt(right+1)
            //扩散
            while (oddLeft >= 0 && oddRight < len && s.charAt(oddLeft) == s.charAt(oddRight)) {
                oddLeft--;
                oddRight++;
            }
            oddLen = oddRight - oddLeft - 1;
            //记录最大回文串起始结束位置，end - start + 1最大回文串长度
            //判断奇数与偶数回文串那个长
            if (evenLen > oddLen && evenLen > end - start + 1) {
                start = evenLeft + 1;
                end = evenRight - 1;
            } else if (oddLen > evenLen && oddLen > end - start + 1) {
                start = oddLeft + 1;
                end = oddRight - 1;
            }
        }
        return s.substring(start, end + 1);
    }
}
