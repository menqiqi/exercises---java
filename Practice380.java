/**
 * 前几个月放映的头号玩家简直火得不能再火了，作为一个探索终极AI的研究人员，月神自然去看了此神剧。
 * 由于太过兴奋，晚上月神做了一个奇怪的梦，月神梦见自己掉入了一个被施放了魔法的深渊，月神想要爬上此深渊。
 *
 * 已知深渊有N层台阶构成（1 <= N <= 1000)，并且每次月神仅可往上爬2的整数次幂个台阶(1、2、4、....)，请你编程告诉月神，月神有多少种方法爬出深渊
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Practice380 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        int n = Integer.parseInt( br.readLine() );
        long[] dp = null;
        int s = 0;
        int step = 0;
        while( n-- > 0 ){
            s = Integer.parseInt( br.readLine() );
            dp = new long[s+1];
            dp[0] = 1;
            for( int i=1; i<=s; i++ ){
                step = 1;
                while( i-step >= 0 ){
                    dp[i] += dp[i-step];
                    dp[i] %= 1000000003;
                    step = step*2;
                }
            }
            System.out.println( dp[s] );
        }
        return;
    }
}