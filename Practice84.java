import java.util.Stack;

/**
 * 给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。
 *
 * 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
 *
 *     它是一个空字符串，或者
 *     它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 *     它可以被写作 (A)，其中 A 是有效字符串。
 *
 * 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
 *
 *
 *
 * 示例 ：
 *
 * 输入："())"
 * 输出：1
 */

class Solution {
    public int minAddToMakeValid(String S) {
        char[] data = S.toCharArray();
        int len = data.length;
        Stack<Character> stackLeft = new Stack<>(); //存放左括号
        Stack<Character> stackRight = new Stack<>(); //存放右括号
        for(int i = 0; i < len; i++){
            if(data[i] == '('){
                stackLeft.push(data[i]);
            }else {
                //先和左括号的栈比较，如果有左括号，就可以组成一对括号
                if(stackLeft.size() != 0){
                    stackLeft.pop();
                }else{
                    stackRight.push(data[i]);
                }
            }
        }
        return stackLeft.size() + stackRight.size();
    }
}

public class Practice84 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minAddToMakeValid("())"));
        System.out.println(solution.minAddToMakeValid("((("));
        System.out.println(solution.minAddToMakeValid("()()"));
        System.out.println(solution.minAddToMakeValid("))"));
    }
}
