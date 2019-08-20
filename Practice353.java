/**
 * 字符串旋转:
 * 给定两字符串A和B，如果能将A从中间某个位置分割为左右两部分字符串（都不为空串），并将左边的字符串移动到右边字符串后面组成新的字符串可以变为字符串B时返回true。
 * 例如：如果A=‘youzan’，B=‘zanyou’，A按‘you’‘zan’切割换位后得到‘zanyou’和B相同返回true。
 */

import java.util.*;
public class Practice353 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(";");
        String a = str[0];
        String b = str[1];
        if(a.equals(b)){
            System.out.println("true");
            return;
        }
        if(a.length() != b.length()){
            System.out.println("false");
            return;
        }
        int n = a.length();
        int c = b.charAt(0);
        for(int i = 0; i < n; i++){
            if(a.charAt(i) == c){
                String stra1 = a.substring(0,i);
                String stra2 = a.substring(i,n);
                String strb1 = b.substring(0,stra2.length());
                String strb2 = b.substring(stra2.length(),n);
                if(stra1.equals(strb2) && stra2.equals(strb1)){
                    System.out.println("true");
                    return;
                }
            }
        }
        System.out.println("false");
    }
}
