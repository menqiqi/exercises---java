/**
 * 小易有一些彩色的砖块。每种颜色由一个大写字母表示。各个颜色砖块看起来都完全一样。
 * 现在有一个给定的字符串s,s中每个字符代表小易的某个砖块的颜色。小易想把他所有的砖块排成一行。
 * 如果最多存在一对不同颜色的相邻砖块,那么这行砖块就很漂亮的。
 * 请你帮助小易计算有多少种方式将他所有砖块排成漂亮的一行。
 * (如果两种方式所对应的砖块颜色序列是相同的,那么认为这两种方式是一样的。)
 * 例如: s = "ABAB",那么小易有六种排列的结果:
 * "AABB","ABAB","ABBA","BAAB","BABA","BBAA"
 * 其中只有"AABB"和"BBAA"满足最多只有一对不同颜色的相邻砖块。
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Practice139{
public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if(s == ""){
        System.out.println(0);
        return;
        }
        //首先计算字符串中的字符的种类
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++)
        set.add(s.charAt(i));
        int count = set.size();
        if(count > 2){
        //字符串超过两种，不可能满足题目要求
            System.out.println(0);
            return;
        }else if (count == 2){
            //两种字符串只会有两种排列方法
        System.out.println(2);
        return;
        }else{
        //一种字符串只会有一种方法
            System.out.println(1);
        }
}
}