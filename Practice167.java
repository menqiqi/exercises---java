import java.util.Scanner;
import java.util.Stack;

/**
 * 一个完整的括号字符串定义规则如下:
 * 1、空字符串是完整的。
 * 2、如果s是完整的字符串，那么(s)也是完整的。
 * 3、如果s和t是完整的字符串，将它们连接起来形成的st也是完整的。
 * 例如，"(()())", ""和"(())()"是完整的括号字符串，"())(", "()(" 和 ")"是不完整的括号字符串。
 * 牛牛有一个括号字符串s,现在需要在其中任意位置尽量少地添加括号,将其转化为一个完整的括号字符串。
 * 请问牛牛至少需要添加多少个括号。
 */

public class Practice167 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (str == ""){
            System.out.println(0);
            return;
        }
        Stack<Character> stackleft = new Stack<>();
        Stack<Character> stackright = new Stack<>();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '('){
                stackleft.add('(');
            }else{
                if (stackleft.isEmpty()){
                    stackright.add(')');
                }else {
                    stackleft.pop();
                }
            }
        }
        System.out.println(stackleft.size()+stackright.size());
    }
}
