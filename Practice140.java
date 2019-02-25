/**
 * 如果一个01串任意两个相邻位置的字符都是不一样的,我们就叫这个01串为交错01串。
 * 例如: "1","10101","0101010"都是交错01串。
 * 小易现在有一个01串s,小易想找出一个最长的连续子串,并且这个子串是一个交错01串。
 * 小易需要你帮帮忙求出最长的这样的子串的长度是多少。
 */


import java.util.Scanner;

public class Practice140 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int count = 1;
        int max = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i-1) != s.charAt(i)){
                count++;
            }else{
                count = 1;
            }
            if (count > max)
                max = count;
        }
        System.out.println(max);
    }
}