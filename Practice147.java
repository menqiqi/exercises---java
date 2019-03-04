/**
 * 牛牛的老师给出了一个区间的定义:对于x ≤ y,[x, y]表示x到y之间(包括x和y)的所有连续整数集合。
 * 例如[3,3] = {3}, [4,7] = {4,5,6,7}.
 * 牛牛现在有一个长度为n的递增序列,牛牛想知道需要多少个区间并起来等于这个序列。
 * 例如:
 * {1,2,3,4,5,6,7,8,9,10}最少只需要[1,10]这一个区间
 * {1,3,5,6,7}最少只需要[1,1],[3,3],[5,7]这三个区间
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice147{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] num = bf.readLine().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(num[i]);
        }

        int res = 1;
        for(int j = 0; j < n-1; j++){
            if((a[j]+1) != a[j+1]){
                res++;
            }
        }
        System.out.println(res);
    }
}