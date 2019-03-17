/**
 * 牛牛养了n只奶牛,牛牛想给每只奶牛编号,这样就可以轻而易举地分辨它们了。
 * 每个奶牛对于数字都有自己的喜好,第i只奶牛想要一个1和x[i]之间的整数(其中包含1和x[i])。
 * 牛牛需要满足所有奶牛的喜好,请帮助牛牛计算牛牛有多少种给奶牛编号的方法,输出符合要求的编号方法总数。
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 解决方法：
 * 给奶牛所希望的数字排个序，然后第一个奶牛有X[0]种方法，第二个奶牛有X[1]-1种方法。。。
 */

public class Practice180{
    private static final long MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(bf.readLine());
        String[] str = bf.readLine().split(" ");
        int[] num = new int[str.length];
        for (int i = 0; i < n; i++){
            num[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(num);
        long res = 1;
        for (int j = 0; j < str.length; j++){
            res = res * ((num[j] - j) % MOD);
            res = res % MOD;
        }
        System.out.println(res);
    }
}