import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice148 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String A = bf.readLine();
        String B = bf.readLine();
        int res = 0;
        int len = A.length();
        if (len == 0){
            System.out.println(0);
            return;
        }
        for (int i = 0; i < len; i++){
            //一个位置一个位置的插入
            String cur = A.substring(0,i) + B + A.substring(i,len);
            //判断cur是否是回文串
            if (isHui(cur)){
                res++;
            }
        }
        //B字符串插入到字符串的末尾
        String cur = A + B;
        if(isHui(cur))
            res++;
        System.out.println(res);
    }

    private static boolean isHui(String cur){
        int len = cur.length();
        int left = 0;
        int right = len-1;
        while (left <= right){
            if (cur.charAt(left) != cur.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}