import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 有一种有趣的字符串价值计算方式:统计字符串中每种字符出现的次数,然后求所有字符次数的平方和作为字符串的价值
 * 例如: 字符串"abacaba",里面包括4个'a',2个'b',1个'c',于是这个字符串的价值为4 * 4 + 2 * 2 + 1 * 1 = 21
 * 牛牛有一个字符串s,并且允许你从s中移除最多k个字符,你的目标是让得到的字符串的价值最小。
 */

public class Practice142 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int k = Integer.parseInt(bf.readLine());
        System.out.println(minValue(s,k));
    }

    public static int minValue(String s, int k){
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++){
            num[s.charAt(i)-'a']++;
        }

        for (int j = 0; j < k; j++){
            int max = 0;
            for (int m = 0; m < 26; m++){
                if (num[m] > num[max])
                    max = m;
            }
            num[max]--;
        }
        int res = 0;
        for (int i = 0; i < 26; i++){
            res += Math.pow(num[i], 2);
        }
        return res;

    }
}
