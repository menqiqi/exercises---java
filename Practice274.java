/**
 * 回形数是一个矩阵输出，从矩阵的左上角往右开始打印数字0，遇到矩阵边界时，顺时针90方向继续打印，并数字增长1，如此类推直到把矩阵填满，
 * 输入一个整形宽和高单位，每输出一个数字，占用1单位宽高空间，根据入参打印出对应的回形数
 */

import java.util.Scanner;

public class Practice274 {

    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        int m=scan.nextInt(), n=scan.nextInt();
        int[][] res = new int[n][m];
        int k = Math.min((n+1)/2, (m+1)/2);
        int t = 0;
        for (int i=0;i<k;i++) {
            for (int j=i;j<=m-1-i;j++) res[i][j]=t;
            t++;
            for (int j=i+1;j<=n-1-i;j++)  res[j][m-1-i]=t;
            t++;
            if (n-1-i==i||m-1-i==i)  break;
            for (int j=m-1-i-1;j>=i;j--)  res[n-1-i][j]=t;
            t++;
            for (int j=n-1-1-i;j>=i+1;j--)  res[j][i]= t;
            t++;
        }
        for (int i=0;i<n;i++) {
            StringBuffer sb =new StringBuffer();
            for (int j=0;j<m;j++) sb.append(res[i][j]);
            System.out.println(sb.toString());
        }

    }

}
