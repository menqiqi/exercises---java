/**
 * 我们定义一个由数字 0 和 1 组成的序列是交错序列，当且仅当在这个序列中 0 和 1 是轮流 出现的，
 * 比如，0，010，10101 都是交错序列。
 *
 * 现在给出了一个由数字0和1组成的序列𝐴，它可能不是一个交错序列，
 * 但是你可以从这个序列中选择一些数字出来，按他们在序列𝐴中原有的相对顺序排列(即选取𝐴的一个子序列)，
 * 使得你最后得到的是一个交错序列。
 * 问这样能得到的交错序列的最长长度是多少。
 */

import java.util.*;

public class Practice213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        int[] in = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[][] dp = new int[2][2];
        for (int i =1; i<=n; i++) {
            int x = in[i-1]; int rx = (in[i-1] + 1) % 2;
            dp[i%2][x] = Math.max(dp[(i-1)%2][rx]+1, dp[(i-1)%2][x]);
            dp[i%2][rx] = dp[(i-1)%2][rx];
        }
        System.out.println(Math.max(dp[n%2][0], dp[n%2][1]));
    }
}