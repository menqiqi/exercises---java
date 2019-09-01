/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */

import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();//只负责push
    Stack<Integer> stack2 = new Stack<Integer>();//只负责pop

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        //如果stack2为空，将数据从stack1中导入
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}