package codetop.easy;

import java.util.LinkedList;

/**
 * @author Nebula
 * @date 2021/12/1 21:30
 * @description: 155. 最小栈 简单
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop()—— 删除栈顶的元素。
 * top()—— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 */
public class MinStackS155 {

    /**
     * 法1
     * 最小栈，每次记录入栈元素作为最小元素，当有更小的元素入栈进行更新min
     * 每次出栈重新查找最小值（出栈重新查找，时间复杂度高）
     *
     * 法2 可以使用辅助栈，存放主栈中每个元素对应的最小值
     * 1.当一个元素要入栈时，我们取当前辅助栈的栈顶存储的最小值，与当前元素比较得出最小值，将这个最小值插入辅助栈中；
     * 2.当一个元素要出栈时，我们把辅助栈的栈顶元素也一并弹出；
     * 3.在任意一个时刻，栈内元素的最小值就存储在辅助栈的栈顶元素中。
     */
    public MinStackS155() {

    }
    private LinkedList<Integer> stack = new LinkedList();
    private int min=Integer.MAX_VALUE;

    public void push(int val) {
        if (val<min){
            min = val;
        }
        stack.offer(val);

    }

    public void pop() {
        stack.removeLast();
        if (!stack.contains(min)) {
            min = Integer.MAX_VALUE;
            for (Integer i : stack) {
                if (i < min) {
                    min = i;
                }
            }
        }
    }

    public int top() {
        return stack.peekLast();
    }

    public int getMin() {
        return min;
    }
}
