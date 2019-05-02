/**
 * G社正在开发一个新的战棋类游戏，在这个游戏中，角色只能向2个方向移动：右、下。移动需要消耗行动力，游戏地图上划分M*N个格子，当角色移动到某个格子上时，行动力就会加上格子上的值K（-100~100），当行动力<=0时游戏失败，
 * 请问要从地图左上角移动到地图右下角至少需要多少起始行动力，注意（玩家初始化到起始的左上角格子时也需要消耗行动力）
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Practice273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int m = Integer.parseInt(str[0]);
        int n = Integer.parseInt(str[1]);
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        // dp[i][j] 表示到arr[i][j]格子至少需要的起始行动力
        int[][] dp = new int[m][n];
        // 初始化
        dp[m - 1][n - 1] = 1 - arr[m - 1][n - 1] <= 0 ? 1 : 1 - arr[m - 1][n - 1];
        for (int i = n - 2; i >= 0; i--) { // 最后一行
            dp[m - 1][i] = Math.max(1, dp[m - 1][i + 1]) - arr[m - 1][i] <= 0 ? 1 : Math.max(1, dp[m - 1][i + 1]) - arr[m - 1][i];
        }
        for (int i = m - 2; i >= 0; i--) { // 最后一列
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1]) - arr[i][n - 1] <= 0 ? 1 : Math.max(1, dp[i + 1][n - 1]) - arr[i][n - 1];
        }
        // 转换
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                // 公式：dp[i][j] + arr[i][j] >= Math.max(1, Math.min(dp[i+ 1][j], dp[i][j + 1]))
                dp[i][j] = Math.max(1, Math.min(dp[i+ 1][j], dp[i][j + 1])) - arr[i][j] <= 0 ? 1 : Math.max(1, Math.min(dp[i+ 1][j], dp[i][j + 1])) - arr[i][j];
            }
        }
        System.out.print(dp[0][0]);
    }
}
