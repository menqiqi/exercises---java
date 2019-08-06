/**
 * 今天上课，老师教了小易怎么计算加法和乘法，乘法的优先级大于加法，但是如果一个运算加了括号，那么它的优先级是最高的。例如：
 * 1+2*3=7
 * 1*(2+3)=5
 * 1*2*3=6
 * (1+2)*3=9
 * 现在小易希望你帮他计算给定3个数a，b，c，在它们中间添加"+"， "*"， "("， ")"符号，能够获得的最大值。
 */

import java.util.Scanner;

public class Practice332 {

    public static int max1(int a, int b) {
        return Math.max(a + b, a * b);
    }

    public static int max2(int a, int b, int c) {
        return max1(max1(a, b), c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] num =  new int[3];
        for (int i = 0; i < 3; i++) {
            num[i] = sc.nextInt();
        }
        System.out.println(max2(num[0], num[1], num[2]));
    }
}