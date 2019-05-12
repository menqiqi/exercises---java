/**
 * A string s is LUCKY if and only if the number of different characters in s is a fibonacci number. Given a string consisting of only lower case letters , output all its lucky non-empty substrings in lexicographical order. Same substrings should be printed once.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Practice294 {
    private static boolean isOk(String s) {//判断是否是斐波拉契数列
        boolean[] x = new boolean[26];
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!x[s.charAt(i) - 'a']) {
                x[s.charAt(i) - 'a'] = true;
                ans++;
            }
        }
        int[] fib = {1, 2, 3, 5, 8, 13, 21};
        for(int i = 0; i < fib.length; i++) {
            if (fib[i] == ans) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] vec = new String[10005];
        int len = s.length();
        int k = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {//固定i来取后面的长度
                String sub = s.substring(i, j);//取i到J长度
                if (isOk(sub))//判断，是的话就赋值输出
                    vec[k++] = sub;
            }
        }
        Arrays.sort(vec, 0, k);//0到k排序
        System.out.println(vec[0]);
        for (int i = 1; i < k; i++) {
            if (!vec[i].equals(vec[i - 1])) {//不等于就输出
                System.out.println(vec[i]);
            }
        }
        in.close();
    }
}
