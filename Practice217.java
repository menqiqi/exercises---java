/**
 * 对于给定的正整数n，计算其十进制下所有位置数字之和，并计算其平方的各位数字之和。
 */

import java.util.*;
public class Practice217 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int res1 = add(n);
            int res2 = add(n*n);
            System.out.println(res1+" "+res2);
        }
    }

    //计算n的各个位数之和
    private static int add(int n){
        int res = 0;
        while(n != 0){
            res = res + n%10;
            n = n/10;
        }
        return res;
    }
}