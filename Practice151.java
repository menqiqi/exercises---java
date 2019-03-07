import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Soultion{
    public boolean isIegal(String A, int n){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++){
            char a = A.charAt(i);
            if (a == '('){
                //如果是左括号，入栈
                stack.push(a);
            }else if(a == ')'){
                //若栈非空，则左括号出栈
                if (!stack.isEmpty()){
                    stack.pop();
                }else {
                    return false;
                }
            }else {
                //出现字母，直接返回
                return false;
            }
        }
        //当栈为空时，返回true
        if (stack.isEmpty())
            return true;
        return false;
    }
}

public class Practice151 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String A = bf.readLine();
        int n = Integer.parseInt(bf.readLine());
        Soultion soultion = new Soultion();
        System.out.println(soultion.isIegal(A,n));
    }
}
