import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 :
 *
 * 输入: "()"
 * 输出: true
 */

class Solution {
    public boolean isValid(String s) {
        char[] data = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < data.length; i++){
            if(stack.size()==0 && (data[i]==')'||data[i]==']'||data[i]=='}')){
                return false;
            }
            if(data[i]=='('||data[i]=='{'||data[i]=='['){
                stack.push(data[i]);
            }
            else if(stack.peek()=='(' && data[i]==')'){
                stack.pop();
            }else if(stack.peek()=='{' && data[i]=='}'){
                stack.pop();
            }else if(stack.peek()=='[' && data[i]==']'){
                stack.pop();
            }else{
                stack.push(data[i]);
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}

public class Practice81 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
    }
}
