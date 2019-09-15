/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */

import java.util.Stack;

class Solution {
    Stack<Integer> stackNormal = new Stack<>();
    Stack<Integer> stackMin = new Stack<>();

    public void push(int node) {
        if(stackMin.isEmpty()){
            stackMin.push(node);
        }else{
            int num = stackMin.pop();
            stackMin.push(num);
            if(node <= num){
                stackMin.push(node);
            }
        }
        stackNormal.push(node);
    }

    //栈没有top的方法，如果直接pop的话，栈中的元素就会被pop掉
    public void pop() {
        int num1 = stackNormal.pop();
        int num2 = stackMin.pop();
        stackNormal.push(num1);
        stackMin.push(num2);
        if (num1 == num2){
            stackMin.pop();
        }
        stackNormal.pop();
    }

    public int top() {
        int num1 = stackNormal.pop();
        //int num2 = stackMin.pop();
        stackNormal.push(num1);
        //stackMin.push(num2);
        return num1;
    }

    public int min() {
        int num = stackMin.pop();
        stackMin.push(num);
        return num;
    }
}

public class Practice382 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(3);
        System.out.println(solution.min());
        solution.push(4);
        System.out.println(solution.min());
        System.out.println(solution.top());
        solution.push(2);
        System.out.println(solution.min());
        solution.push(3);
        System.out.println(solution.min());
        solution.pop();
        System.out.println(solution.min());
        solution.pop();
        System.out.println(solution.min());
        solution.pop();
        System.out.println(solution.min());
        solution.push(0);
        System.out.println(solution.min());

    }
}