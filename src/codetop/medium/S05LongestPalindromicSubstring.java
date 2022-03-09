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
public class S05LongestPalindromicSubstring {
    public static void main(String[] args) {
        S05LongestPalindromicSubstring s05 = new S05LongestPalindromicSubstring();

        String s = "bb";
        String s1 = s05.longestPalindrome1(s);
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
     * <p>
     * 可以将中心扩散抽取成函数。
     *
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

    /**
     * 将扩散部分抽取成函数
     * 不在变量名上区分奇偶，通过i来区分
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        int len = s.length();
        if (len == 1) {
            return s;
        }
        int evenLen;
        int oddLen;

        int start = 0;
        int end = 0;
        //外层对每个字符的循环,已经判断只有一个的情况
        //直接从第二个字符开始
        for (int i = 1; i < len; i++) {
            //内层中心扩散，分奇数偶数
            //偶数s.charAt(i-1) == s.charAt(i)
            evenLen = expandAroundCenter(s, i - 1, i);

            //奇数s.charAt(i-1)==s.charAt(i+1)
            oddLen = expandAroundCenter(s, i - 1, i + 1);

            //判断奇数与偶数回文串那个长
            int maxLen = Math.max(evenLen, oddLen);

            //记录最大回文串起始结束位置，end - start + 1最大回文串长度
            //计算起始和结束位置，通过返回的回文串长度计算，奇数偶数计算方法相同
            //因为是从i开始计算，两边长度对称
            if (maxLen > end - start + 1) {
                start = i - (maxLen / 2);
                end = i + (maxLen - 1) / 2;
            }
        }
        //substring 是左闭右开
        return s.substring(start, end + 1);
    }

    /**
     * 中心扩散
     *
     * @param s     待扩散字符串
     * @param left  扩散位置左
     * @param right 扩散位置右
     * @return 返回当前回文字符长度
     */
    public int expandAroundCenter(String s, int left, int right) {
        //满足此条件则进行扩散
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
