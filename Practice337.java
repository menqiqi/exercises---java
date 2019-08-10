/**
 * 小易觉得高数课太无聊了，决定睡觉。不过他对课上的一些内容挺感兴趣，所以希望你在老师讲到有趣的部分的时候叫醒他一下。你知道了小易对一堂课每分钟知识点的感兴趣程度，并以分数量化，以及他在这堂课上每分钟是否会睡着，你可以叫醒他一次，这会使得他在接下来的k分钟内保持清醒。你需要选择一种方案最大化小易这堂课听到的知识点分值。
 * 输入描述:
 * 第一行 n, k (1 <= n, k <= 105) ，表示这堂课持续多少分钟，以及叫醒小易一次使他能够保持清醒的时间。
 * 第二行 n 个数，a1, a2, ... , an(1 <= ai <= 104) 表示小易对每分钟知识点的感兴趣评分。
 * 第三行 n 个数，t1, t2, ... , tn 表示每分钟小易是否清醒, 1表示清醒。
 * 输出描述:
 * 小易这堂课听到的知识点的最大兴趣值。
 */

/*
import java.util.*;
public class Practice337 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();  //课堂时长
        int k = in.nextInt();  //保持清醒的时长
        int[] inster = new int[n];  //感兴趣评分
        for(int i = 0; i < n; i++){
            inster[i] = in.nextInt();
        }
        int[] x = new int[n];  //是否清醒
        int count = 0;
        int max = 0;
        int countnosleep = 0;
        for(int i = 0; i < n; i++){
            x[i] = in.nextInt();
        }

        for(int i = 0; i < n; i++){
            count = 0;
            if(x[i] == 0){
                int tmp = i;
                int m = 0;
                while(m < k && tmp < n){
                    if(x[tmp] == 0){
                        count = count + inster[tmp];
                    }
                    m++;
                    tmp++;
                }
                if(max < count)
                    max = count;
            }else{
                countnosleep += inster[i];
            }
        }
        System.out.println(max+countnosleep);
    }
}*/


import java.util.Scanner;

public class Practice337 {

    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int[] value=new int[n];    //知识点的兴趣值
        int[] wake=new int[n];     //每分钟是否清醒
        for(int i=0;i<n;i++)
            value[i]=in.nextInt();
        for(int i=0;i<n;i++)
            wake[i]=in.nextInt();
        int sum=0;

        int[] leftv=new int[n];            //从左边开始统计此分钟之前清醒时所有的兴趣值
        for(int i=0;i<n;i++){
            if(wake[i]==1)sum+=value[i];
            leftv[i]=sum;
        }

        int[] rightv=new int[n];         //从右边开始统计此分钟之前清醒时所有的兴趣值
        sum=0;
        for(int i=n-1;i>=0;i--)
        {
            if(wake[i]==1)sum+=value[i];
            rightv[i]=sum;
        }

        int[] tolv=new int[n];         //记录此分钟之前的清醒和未清醒所有的兴趣值
        sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=value[i];
            tolv[i]=sum;
        }

        if(n==0)                 //如果n为0，结果一定为0
        {
            System.out.println(0);
        }
        else if(k==0)                 //如果K为0，那么结果就是所有清醒时的兴趣值
        {
            System.out.println(leftv[n-1]);
        }
        else                         //n不为0，K也不为0
        {
            int res=0;
            for(int i=0;i<n;i++)
            {
                if(wake[i]==0)
                {
                    int m=0;
                    if(i-1<0)
                        m+=0;      //考虑左边界的问题，
                    else
                        m+=leftv[i-1];  //睡着的时间之前的兴趣值之和
                    if(i+k>=n)
                        m+=0;     //考虑右边界的问题
                    else
                        m+=rightv[i+k];  //睡着的时间之后的兴趣值之和
                    m+=tolv[Math.min(i+k-1, n-1)]-(i<1?0:tolv[i-1]);  //在i时刻叫醒，接下来的k个时刻内的兴趣值
                    if(m>res)res=m;
                }
            }
            System.out.println(res);
        }
    }

}