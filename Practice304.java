/**
 * 你就是一个画家！你现在想绘制一幅画，但是你现在没有足够颜色的颜料。为了让问题简单，我们用正整数表示不同颜色的颜料。你知道这幅画需要的n种颜色的颜料，你现在可以去商店购买一些颜料，但是商店不能保证能供应所有颜色的颜料，所以你需要自己混合一些颜料。混合两种不一样的颜色A和颜色B颜料可以产生(A XOR B)这种颜色的颜料(新产生的颜料也可以用作继续混合产生新的颜色,XOR表示异或操作)。本着勤俭节约的精神，你想购买更少的颜料就满足要求，所以兼职程序员的你需要编程来计算出最少需要购买几种颜色的颜料？
 */

import java.io.*;
import java.util.*;

public class Practice304 {
    private static int high(int n) {
        int cnt = 0;
        while(n > 0) {
            cnt++;
            n /= 2;
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        br.close();
        int[] arr = new int[s.length];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(arr);
        int last = arr.length - 1;
        int cnt = 1;
        while(last > 0 && arr[last-1] != 0) {
            int num1 = arr[last];
            int num2 = arr[last-1];
            if(high(num1) == high(num2)) {
                arr[last-1] = num1 ^ num2;
                Arrays.sort(arr);
            }
            else {
                last--;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
