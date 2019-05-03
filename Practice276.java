/**
 * 今天，在冬木市举行了一场盛大的舞会。
 * 参加舞会的有n 位男士，从 1 到 n 编号；有 m 位女士，从 1 到 m 编号。
 * 对于每一位男士，他们心中都有各自心仪的一些女士，在这次舞会中，
 * 他们希望能与每一位自己心仪的女士跳一次舞。同样的，对于每一位女士，
 * 她们心中也有各自心仪的一些男士，她们也希望能与每一位自己心仪的男士跳一次舞。
 * 在舞会中，对于每一首舞曲，你可以选择一些男士和女士出来跳舞。
 * 但是显然的，一首舞曲中一位男士只能和一位女士跳舞，一位女士也只能和一位男士跳舞。
 * 由于舞会的时间有限，现在你想知道你最少需要准备多少首舞曲，才能使所有人的心愿都得到满足？
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice276 {
    /**
     * 1.用一个二维数组来表示男女之间的心仪关系，如bool[i][j]=true表示：男i对女j心仪或女j对男i心仪
     * 2.遍历这个数组，从每个男人开始，记录每个男人需要的舞曲次数，为了实现愿望，返回最大的舞曲次数
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] line1=br.readLine().split(" ");
        int n=Integer.parseInt(line1[0]),m=Integer.parseInt(line1[1]);
        boolean[][] bool=new boolean[n+1][m+1];
        for(int i=1;i<=n;i++) {
            String[] temp=br.readLine().split(" ");
            for(int j=1;j<=Integer.parseInt(temp[0]);j++) {
                bool[i][Integer.parseInt(temp[j])]=true;
            }
        }
        for(int i=1;i<=m;i++) {
            String[] temp=br.readLine().split(" ");
            for(int j=1;j<=Integer.parseInt(temp[0]);j++) {
                bool[Integer.parseInt(temp[j])][i]=true;
            }
        }
        br.close();
        int res=0;
        for(int i=1;i<=n;i++) {
            int tmp=0;
            for(int j=1;j<=m;j++) {
                if(bool[i][j])tmp++;
            }
            if(tmp>res)res=tmp;
        }
        System.out.println(res);
    }

}

