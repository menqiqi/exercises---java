/**
 * 牛牛有一个正整数x,牛牛需要把数字x中的数位进行重排得到一个新数(不同于x的数),牛牛想知道这个新数是否可能是原x的倍数。请你来帮他解决这个问题。
 * 输入描述:
 *
 * 输入包括t+1行,第一行包括一个整数t(1 ≤ t ≤ 10),
 * 接下来t行,每行一个整数x(1 ≤ x ≤ 10^6)
 *
 * 输出描述:
 *
 * 对于每个x,如果可能重排之后变为自己的倍数输出"Possible", 否则输出"Impossible".
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Practice204{
    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);
        while(in.hasNext()){
            int n = Integer.parseInt(in.nextLine());
            int i = 0;
            List<String> res = new ArrayList<>();
            while(i < n){
                int x = Integer.parseInt(in.nextLine());
                if(isIllegal(x)){
                    res.add("Possible");
                }else{
                    res.add("Impossible");
                }
                i++;
            }

            for(String str : res){
                System.out.println(str);
            }
        }
    }

    private static boolean isIllegal(int x){
        if(x/10 == 0){
            return true;
        }
        //将每个数从2乘到9，看有没有数位和自己相同的
        int j = 2;
        String str = String.valueOf(x);
        int len = str.length();
        //将x的每一位放在数组中，进行排序
        int[] source = new int[len];
        int tmp = x;
        int index = 0;
        while(tmp > 0){
            source[index++] = tmp%10;
            tmp = tmp/10;
        }
        Arrays.sort(source);
        while(j <= 9){
            int tmp1 = x * j;
            int[] des = new int[len];
            int index1 = 0;
            int len1 = String.valueOf(tmp1).length();
            while(tmp1 > 0 && len1 == len){
                des[index1++] = tmp1%10;
                tmp1 = tmp1/10;
            }
            Arrays.sort(des);

            //进行判断
            int k = 0;
            for(k = 0; k < len; k++){
                if(source[k] != des[k])
                    break;
            }
            if(k == len)
                return true;
            j++;
        }
        return false;
    }
}
