/**
 * Fibonacci数列
 * 给你一个N，你想让其变为一个Fibonacci数，每一步你可以把当前数字X变为X-1或者X+1，现在给你一个数N求最少
 * 需要多少步可以变为Fibonacci数。
 */

import java.util.Scanner;

public class Practice328 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        int a = 0, b = 1, c = 1;
        if (in.hasNextInt()){
            n = in.nextInt();
        }

        while (c < n){
            a = b;
            b = c;
            c = a + b;
        }
        int t1 = c - n;
        int t2 = n - b;
        System.out.println(t1>t2?t2:t1);
    }
}
