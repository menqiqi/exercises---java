import java.util.*;

/**
 * 使用队列实现栈的下列操作：
 *
 *     push(x) -- 元素 x 入栈
 *     pop() -- 移除栈顶元素
 *     top() -- 获取栈顶元素
 *     empty() -- 返回栈是否为空
 *
 * 注意:
 *
 *     你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 *     你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 *     你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 */

/*使用两个队列实现一个栈*/
/*队列其实就是链表*/
class MyStack {
    List<Integer> queue1 = new LinkedList<>();
    List<Integer> queue2 = new LinkedList<>();


    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        //进入非空队列
        if(!(queue1.isEmpty())){
            queue1.add(x);
        }else{
            queue2.add(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        //将非空队列的前size-1个数移动到空队列中，pop非空队列的最后一个数
        List<Integer> empty = new LinkedList<>();
        List<Integer> noEmpty = new LinkedList<>();
        if(queue1.size() == 0){
            empty = queue1;
            noEmpty = queue2;
        }else {
            empty = queue2;
            noEmpty = queue1;
        }
        while (noEmpty.size() > 1){
            empty.add(noEmpty.remove(0));
        }
        return noEmpty.remove(0);
    }

    /** Get the top element. */
    public int top() {
        //从非空队列中移动size-1个数到空队列中，返回非空队列剩下的一个值，并且移动到空队列
        List<Integer> empty = new LinkedList<>();
        List<Integer> noEmpty = new LinkedList<>();
        if(queue1.size() == 0){
            empty = queue1;
            noEmpty = queue2;
        }else {
            empty = queue2;
            noEmpty = queue1;
        }
        while (noEmpty.size() > 1){
            empty.add(noEmpty.remove(0));
        }
        int res = noEmpty.remove(0);
        empty.add(res);
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(queue1.isEmpty() && queue2.isEmpty()){
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

public class Practice79 {
    public static void main(String[] args) {

        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }
}
