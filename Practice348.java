/**
 * 已知一个字符串数组words，要求寻找其中两个没有重复字符的字符串，使得这两个字符串的长度乘积最大，输出这个最大的乘积。如：
 * words=["abcd","wxyh","defgh"], 其中不包含重复字符的两个字符串是"abcd"和"wxyh"，则输出16
 * words=["a","aa","aaa","aaaa"], 找不到满足要求的两个字符串，则输出0
 */

import java.util.*;
public class Practice348{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String s = str.substring(1,str.length()-1);
        s = s.replace("\"","");
        String[] words = s.split(",");
        int n = words.length;
        int max = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            int len = words[i].length();
            for(int j = i+1; j < n; j++){
                int k = 0;
                for(k = 0; k < len; k++){
                    if(words[j].contains(words[i].charAt(k)+""))
                        break;
                }
                if(k == len)
                    sum = words[i].length()*words[j].length();
                if(sum > max)
                    max = sum;
            }
        }
        System.out.println(max);
    }
}