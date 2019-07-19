/**
 * 输入两个字符，从第一个字符中删除第二个字符中的所有字符。
 */

import java.util.*;

public class Practice321{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        String res = "";
        for(int i = 0; i < str1.length(); i++){
            if (!str2.contains(str1.charAt(i)+"")) {
                res = res + str1.charAt(i);
            }

        }
        System.out.println(res);
    }
}