/**
 * 题目描述
 * 牛牛以前在老师那里得到了一个正整数数对(x, y), 牛牛忘记他们具体是多少了。
 *
 * 但是牛牛记得老师告诉过他x和y均不大于n, 并且x除以y的余数大于等于k。
 * 牛牛希望你能帮他计算一共有多少个可能的数对。
 *
 * 输入描述:
 * 输入包括两个正整数n,k(1 <= n <= 10^5, 0 <= k <= n - 1)。
 * 输出描述:
 * 对于每个测试用例, 输出一个正整数表示可能的数对数量。
 */

import java.util.*;

public class Practice331 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long k = in.nextLong();
        long result = 0;
        if (k == 0){
            System.out.println(n*n);
        }else{
            for(long y = k+1; y <= n; y++){
                result += (n/y)*(y-k)+(n%y>=k?n%y-k+1:0);
                //n/y是计算共有多少个这样数
                //y-k是计算这些数中余数大于等于k的个数
                //如果n除以y的余数大于等于k，就还有除以y的余数大于k的数
            }
            System.out.println(result);
        }
        in.close();
    }
}