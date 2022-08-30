package jianzhi_offer;

import java.util.Stack;

/**
 * 用两个栈实现队列 09 简单
 */
public class Solution09 {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        int a = cQueue.deleteHead();
        int b = cQueue.deleteHead();
        cQueue.appendTail(4);
        System.out.println(a+" "+b);

    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
class CQueue {
    private Stack<Integer> in = new Stack();
    private Stack<Integer> out =new Stack();
    public CQueue() {

    }

    public void appendTail(int value) {
        //入队
        in.push(value);
    }

    public int deleteHead() {
        //out为空，将in中的元素都出栈入out
        if(out.isEmpty()){
            //两个栈都为空，直接返回-1
            if (in.isEmpty()) {
                return -1;
            }
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }

        return out.pop();
    }
}