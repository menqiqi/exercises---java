import java.util.Stack;

/**
 * 根据逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 *
 *     整数除法只保留整数部分。
 *     给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * 示例 1：
 *
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 *
 * 示例 2：
 *
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 *
 * 示例 3：
 *
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 */

class Solution {
    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        Stack<String> stack = new Stack<>();
        int res = 0;
        if(len == 1){
            return Integer.parseInt(tokens[0]);
        }
        for(int i = 0; i < len; i++){
            if(tokens[i].equals("+")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                res = a + b;
                String c = String.valueOf(res);
                stack.push(c);
            }else if(tokens[i].equals("-")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                res = b - a;
                String c = String.valueOf(res);
                stack.push(c);
            }else if(tokens[i].equals("*")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                res = b * a;
                String c = String.valueOf(res);
                stack.push(c);
            }else if(tokens[i].equals("/")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                res = b / a;
                String c = String.valueOf(res);
                stack.push(c);
            }else{
                stack.push(tokens[i]);
            }
        }
        return res;
    }
}

public class Practice86 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] data1 = new String[]{"18"};
        String[] data2 = new String[]{"2", "1", "+", "3", "*"};
        String[] data3 = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(solution.evalRPN(data1));
        System.out.println(solution.evalRPN(data2));
        System.out.println(solution.evalRPN(data3));
    }
}