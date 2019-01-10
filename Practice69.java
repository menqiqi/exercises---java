import java.util.Stack;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 *
 * 示例 ：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 */

class Solution {
    public boolean backspaceCompare(String S, String T) {
        //栈
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        char[] data1 = S.toCharArray();
        char[] data2 = T.toCharArray();
        int tmp1 = 0;
        if(data1[0] == '#'){
            tmp1 = 1;
        }
        for(int i = tmp1; i < data1.length; i++){
            if(data1[i] == '#' && stack1.size() > 0){
                stack1.pop();
                continue;
            }
            if(data1[i] != '#'){
                stack1.push(data1[i]);
            }
        }
        String str1 = "";
        for(int i = 0; i < stack1.size(); i++){
            str1 = str1 + stack1.get(i);
        }
        int tmp2 = 0;
        if(data2[0] == '#'){
            tmp2 = 1;
        }
        for(int j = tmp2; j < data2.length; j++){
            if(data2[j] == '#' && stack2.size() > 0){
                stack2.pop();
                continue;
            }
            if(data2[j] != '#'){
                stack2.push(data2[j]);
            }
        }
        String str2 = "";
        for(int j = 0; j < stack2.size(); j++){
            str2 = str2 + stack2.get(j);
        }
        if(str1.equals(str2))
            return true;
        return false;
    }
}

public class Practice69 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.backspaceCompare("a##c","#a#c"));
    }
}
