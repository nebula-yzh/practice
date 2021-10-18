package codetop;

/**
 * @author Nebula
 * @date 2021/10/18 9:36
 * @description: 415. 字符串相加 简单
 * 给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 跟AddTwoNumbersS02 两数相加有些类似，两数相加是链表操作，该题是字符串
 * <p>
 * 示例 1：
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 3：
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 */
public class AddStringsS415 {
    public static void main(String[] args) {
        System.out.println(addStrings("9999999999999", "99999999999999999999999999999999999"));
    }

    /**
     * 法1.将两个字符串，从个位开始逐个取出数字，将两数相加，注意进位，以及最后一位也进位时，多一个1
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int carry = 0;
        int nn1;
        int nn2;
        StringBuilder res = new StringBuilder();
        for (int i = n1.length - 1, j = n2.length - 1; i >= 0 || j >= 0 || carry > 0; i--, j--) {
            //从个位开始处理字符的数，当某个数结束了，就补0
            if (i >= 0) {
                nn1 = n1[i] - '0';
            } else {
                nn1 = 0;
            }
            if (j >= 0) {
                nn2 = n2[j] - '0';
            } else {
                nn2 = 0;
            }
            //两个一位数和,再加上进位
            int sum = nn1 + nn2 + carry;
            //当前位的数
            int temp = sum % 10;
            //获得进位
            carry = sum / 10;
            res.append(temp);
        }
        return res.reverse().toString();
    }
}
