import java.util.Scanner;

/**
 * 给定一个有n个正整数的数组A和一个整数sum，求选择A中部分数字和为sum的方案数。
 * 当两个方案中有一个数组下标不同，我们就认为是两个不同的方案。
 * <p>
 * 输入描述：
 * 第一行输入n和sum
 * 第二行输入数组
 * <p>
 * <p>
 * 解题思路：
 * methodNum(i,j)代表前i个数中和为j的方案数
 * 如果j >= data[i],methodNum(i,j) = methodNum(i-1,j)+methodNum(i-1,j-data[i])
 * 否则 methodNum(i,j) = methodNum(i-1,j)
 */

public class Practice225 {
    public static int n=0;
    public static long calSum1(int a[],int sum){
        long dp[][]=new long[n+1][sum+1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(j>=a[i])
                    dp[i][j]=dp[i-1][j-a[i]]+dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            n=in.nextInt();
            int a[]=new int[n+1];
            int sum=in.nextInt();
            for(int i=1;i<=n;i++){
                a[i]=in.nextInt();
            }
            System.out.println(calSum1(a,sum));
        }
        in.close();
    }

}