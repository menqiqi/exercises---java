import java.util.Scanner;

/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 */

public class  Practice365{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(repeatedSubstringPattern(s));
        in.close();
    }

    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if(len == 0 || len == 1){
            return false;
        }
        char c = s.charAt(0);
        //判断如果为单个字符组成的字符串，直接返回true
        if(s.split(String.valueOf(c)).length == 0){
            return true;
        }
        for(int i = 1; i < len; i++){
            if(s.charAt(i) == c){
                int arrLen = i;
                String arr = s.substring(0,arrLen);  //子字符串
                if(len % arrLen == 0){
                    int a = len / arrLen;
                    String res = "";
                    for(int j = 0; j < a; j++){
                        res += arr;
                    }
                    if(res.equals(s)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}