/**
 * 如果一个整数只能被1和自己整除,就称这个数是素数。
 * 如果一个数正着反着都是一样,就称为这个数是回文数。例如:6, 66, 606, 6666
 * 如果一个数字既是素数也是回文数,就称这个数是回文素数
 * 牛牛现在给定一个区间[L, R],希望你能求出在这个区间内有多少个回文素数。
 */

import java.util.Scanner;

public class Practice146 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int L = Integer.parseInt(str.split(" ")[0]);
        int R = Integer.parseInt(str.split(" ")[1]);
        System.out.println(num(L,R));

    }

    private static int num(int L, int R){
        int count = 0;
        while (L <= R){
            if (L != 1 && isPrime(L) && palinNum(L))
                count++;
            L++;
        }
        return count;
    }


    /**
     * 判断一个数是否为素数
     * @param n
     * @return
     */
    private static boolean isPrime(int n){
        int i = 2;
        for (i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0)
                return false;
        }
        return true;
    }

    /**
     * 判断一个数是否为回文数
     * @param L
     * @return
     */
    private static boolean palinNum(int L){
        int res = 0;
        int tmp = L;
        while (tmp > 0){
            res = res*10 + tmp%10;
            tmp = tmp / 10;
        }
        if (res == L)
            return true;
        return false;
    }

}
