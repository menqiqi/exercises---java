/**
 * C市现在要转移一批罪犯到D市，C市有n名罪犯，按照入狱时间有顺序，另外每个罪犯有一个罪行值，值越大罪越重。现在为了方便管理，市长决定转移入狱时间连续的c名犯人，同时要求转移犯人的罪行值之和不超过t，问有多少种选择的方式（一组测试用例可能包含多组数据，请注意处理）？
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Practice297 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null)
        {
            String[] s = str.trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int t = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            int[] value = new int[n];
            if((str=br.readLine())!=null)
            {
                String[] s2 = str.trim().split(" ");
                for(int i =0;i<n;i++)
                {
                    value[i] = Integer.parseInt(s2[i]);
                }
            }
            System.out.println(carryMan(n,t,c,value));
        }
        br.close();
    }
    public static int carryMan(int n,int t,int c,int[] value)
    {
        int count=0;
        int sum=0;
        for(int j=0;j<c;j++){
            sum+=value[j];
        }
        if(sum<=t){
            count++;
        }
        for(int i=c;i<n;i++){
            sum=sum+value[i]-value[i-c];
            if(sum<=t){
                count++;
            }
        }
        return count;
    }
}
