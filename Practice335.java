/**
 * 牛牛准备参加学校组织的春游, 出发前牛牛准备往背包里装入一些零食, 牛牛的背包容量为w。
 * 牛牛家里一共有n袋零食, 第i袋零食体积为v[i]。
 * 牛牛想知道在总体积不超过背包容量的情况下,他一共有多少种零食放法(总体积为0也算一种放法)。
 * 输入描述:
 * 输入包括两行
 * 第一行为两个正整数n和w(1 <= n <= 30, 1 <= w <= 2 * 10^9),表示零食的数量和背包的容量。
 * 第二行n个正整数v[i](0 <= v[i] <= 10^9),表示每袋零食的体积。
 * 输出描述:
 * 输出一个正整数, 表示牛牛一共有多少种零食放法。
 */

import java.util.*;
public class Practice335 {
    public static long result = 1;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();  //零食的数量
        int w = in.nextInt();  //背包的容量
        long[] v = new long[n];
        long sum = 0;
        for(int i = 0; i < n; i++){
            v[i] = in.nextInt();
            sum += v[i];
        }
        if(sum < w){
            System.out.println((int)Math.pow(2,n));
        }else{
            des(v,0,w,0);
            System.out.println(result);
        }
    }

    public static void des(long[] v,int index, long w, long current){
        if(index == v.length){
            return;
        }
        if(current+v[index] <= w){
            result++;
            des(v,index+1,w,current+v[index]);
        }
        des(v,index+1,w,current);
    }
}