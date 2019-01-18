import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 *     push(x) -- 将元素 x 推入栈中。
 *     pop() -- 删除栈顶的元素。
 *     top() -- 获取栈顶元素。
 *     getMin() -- 检索栈中的最小元素。
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */

class MinStack {
    Stack<Integer> stackNormal = new Stack<>(); //普通栈，存放所有数据
    Stack<Integer> stackMin = new Stack<>(); //最小栈，存放小的数据

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        //普通栈直接push
        stackNormal.push(x);
        //如果是第一个数，最小栈push
        if(stackMin.isEmpty()){
            stackMin.push(x);
            return;
        }
        //如果小于最小栈的top,就push
        if(x <= stackMin.peek())
            stackMin.push(x);
    }

    public void pop() {
        //当普通栈和最小栈的top相等的时候，最小栈就pop
        if(stackNormal.peek().equals(stackMin.peek())){  //注意：用equals而不是==
            stackMin.pop();
        }
        stackNormal.pop();
    }

    public int top() {
        return stackNormal.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

public class Practice80 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
       minStack.push(512);
       minStack.push(-1024);
       minStack.push(-1024);
       minStack.push(512);
       minStack.pop();
        System.out.println(minStack.getMin());
       minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
