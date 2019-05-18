/**
 * 牛牛和 15 个朋友来玩打土豪分田地的游戏，牛牛决定让你来分田地，地主的田地可以看成是一个矩形，每个位置有一个价值。分割田地的方法是横竖各切三刀，分成 16 份，作为领导干部，牛牛总是会选择其中总价值最小的一份田地， 作为牛牛最好的朋友，你希望牛牛取得的田地的价值和尽可能大，你知道这个值最大可以是多少吗？
 */

import java.util.*;

public class Practice303 {
    static int[][] dp;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        int[][] land = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String cur = s.next();
            for (int j = 1; j <= m; j++) {
                land[i][j] = cur.charAt(j - 1) - '0';
            }
        }

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= m; j++) {
                sum += land[i][j];
                dp[i][j] = sum + dp[i - 1][j];
            }
        }

        int l = 0;
        int r = n * m * 9;//最大和

        while (l <= r) {
            int mid = (r + l) >> 1;
            if (judge(mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(l - 1);
    }

    private static boolean judgeCol(int a, int b, int c, int x) {
        int count = 0;
        int before = 1;
        for (int i = 1; i <= m; i++) {
            int s1 = getA(1, before, a, i);
            int s2 = getA(a + 1, before, b, i);
            int s3 = getA(b + 1, before, c, i);
            int s4 = getA(c + 1, before, n, i);

            if (s1 >= x && s2 >= x && s3 >= x && s4 >= x) {
                before = i + 1;
                count++;
                if (count == 4) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean judge(int x) {

        for (int i = 1; i <= n; i++) {
            if (getA(1, 1, i, m) < (x << 2)) {
                continue;
            }
            for (int j = i + 1; j <= n; j++) {
                if (getA(i + 1, 1, j, m) < (x << 2)) {
                    continue;
                }
                for (int k = j + 1; k <= n; k++) {
                    if (getA(j + 1, 1, k, m) < (x << 2)) {
                        continue;
                    }
                    if (getA(k + 1, 1, n, m) < (x << 2)) {
                        continue;
                    }
                    if (judgeCol(i, j, k, x)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static int getA(int x1, int y1, int x2, int y2) {
        return (dp[x2][y2] - dp[x1 - 1][y2])
                - (dp[x2][y1 - 1] - dp[x1 - 1][y1 - 1]);
    }
}