/**
 * 如果一个数列S满足对于所有的合法的i,都有S[i + 1] = S[i] + d, 这里的d也可以是负数和零,我们就称数列S为等差数列。
 * 小易现在有一个长度为n的数列x,小易想把x变为一个等差数列。
 * 小易允许在数列上做交换任意两个位置的数值的操作,并且交换操作允许交换多次。
 * 但是有些数列通过交换还是不能变成等差数列,小易需要判别一个数列是否能通过交换操作变成等差数列
 * 
 * 
 * 输入描述:
 *
 * 输入包括两行,第一行包含整数n(2 ≤ n ≤ 50),即数列的长度。
 * 第二行n个元素x[i](0 ≤ x[i] ≤ 1000),即数列中的每个整数。
 *
 * 输出描述:
 *
 * 如果可以变成等差数列输出"Possible",否则输出"Impossible"。
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice141{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] str = bf.readLine().split(" ");
        int[] x = new int[n];
        for(int i = 0; i < n; i++)
            x[i] = Integer.parseInt(str[i]);
        if(numLine(n,x)){
            System.out.println("Possible");
        }else{
            System.out.println("Impossible");
        }
    }

    public static boolean numLine(int n, int[] x){
        //先排序（插排）
        for(int i = 1; i < n; i++){
            int key = x[i];
            int end = i - 1;
            while(end >= 0 && x[end] > key){
                x[end+1] = x[end];
                end--;
            }
            x[end+1] = key;
        }
        //查看是否每两个元素之间的差值都相同
        int tmp = x[1] - x[0];
        for(int j = 1; j < n-1; j++){
            if(tmp != x[j+1] - x[j])
                return false;
        }
        return true;
    }
}
