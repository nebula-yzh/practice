package codetop.easy;

import java.util.Stack;

/**
 * @author Nebula
 * @date 2021/10/17 11:36
 * @description: 20. 有效的括号 简单
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 输入：s = "([)]"
 * 输出：false
 * 输入：s = "{[]}"
 * 输出：true
 */
public class ValidParenthesesS20 {

    /**
     * 利用栈，遇到左括号就入栈，遇到右括号就判断栈顶元素是否为匹配的左括号，若是则出栈，直到栈为空，为匹配
     * 空字符串满足条件。
     * 注意只有右括号的情况
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int pointer = 0;
        int len = s.length();

        while (pointer < len) {
            char c = s.charAt(pointer);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                if ((c == '}' && stack.peek() == '{') ||
                        (c == ')' && stack.peek() == '(') ||
                        (c == ']' && stack.peek() == '[')) {
                    stack.pop();
                }
                else {
                    return false;
                }
            }else {
                return false;
            }
            pointer++;

        }
        return stack.isEmpty();
    }

}
