package codetop.medium;

/**
 * @author Nebula
 * @date 2021/12/8 9:28
 * @description: 8. 字符串转换整数 (atoi) 中等
 *
 * 请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数myAtoi(string s) 的算法如下：
 * 1.读入字符串并丢弃无用的前导空格
 * 2.检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 3.读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 4.将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 5.如果整数数超过 32 位有符号整数范围 [−2^31, 2^31− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2^31 的整数应该被固定为 −2^31 ，
 * 大于 2^31− 1 的整数应该被固定为 2^31− 1 。
 * 6.返回整数作为最终结果。
 * 注意：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略任何其他字符。
 *
 * 提示：
 * 0 <= s.length <= 200
 * s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
 */
public class StringToIntegerAtoiS08 {
    public static void main(String[] args) {
        String s = " -42";
        int i = myAtoi(s);
        System.out.println(i);
        System.out.println();
    }

    /**
     * 字符串转整数
     * 提取每个字符通过减'0'得到差，得到数字
     *
     * 1.丢弃前导空格,后导空格
     * 2.对每个字母判断是否为数字，记录首尾
     * 3.数字截取，并将截取的数字进行转换,在转换时进行截断判断
     * 4.进行截断判断，数字是否越界
     *
     * 注意：
     * 多个空格，越界，字符.问题
     *
     * @param s
     * @return
     */
    public static int myAtoi(String s) {
        s = s.trim();
        if (s.length()==0){
            return 0;
        }
        int start=0;
        int end=0;
        //对第一个值进行判断
        if (s.charAt(0)=='+'||s.charAt(0)=='-'||(s.charAt(0)>='0'&&s.charAt(0)<='9')){
            //对后续的数字进行判断
            while (end<s.length()-1&&s.charAt(end+1)>='0'&&s.charAt(end+1)<='9'){
                end++;
            }
        }
        //截取数字
        String resNumber = s.substring(start,end+1);
        //当第一个字符为字母时
        if ((resNumber.charAt(0)>='a'&&resNumber.charAt(0)<='z')||(resNumber.charAt(0)=='.')||
                (resNumber.charAt(0)>='A'&&resNumber.charAt(0)<='Z')){
            return 0;
        }

        //进行字符数字转换
        long number = 0;
        int res = 0;
        if (resNumber.charAt(0)=='+'){
            for (int k=1;k<resNumber.length();k++){
                number = number*10 + resNumber.charAt(k)-'0';
                //进行截断判断
                if (number>Math.pow(2,31)-1){
                    res = (int) (Math.pow(2,31)-1);
                    return res;
                }
            }
        } else if (resNumber.charAt(0)=='-'){
            for (int k=1;k<resNumber.length();k++){
                number = number*10 - (resNumber.charAt(k)-'0');
                if (number<-Math.pow(2,31)){
                    res = (int) -Math.pow(2,31);
                    return res;
                }
            }
        } else {
            for (int k=0;k<resNumber.length();k++){
                number = number*10 + resNumber.charAt(k)-'0';
                //进行截断判断
                if (number>Math.pow(2,31)-1){
                    res = (int) (Math.pow(2,31)-1);
                    return res;
                }
            }
        }
        res = (int) number;
        return res;
    }
}
