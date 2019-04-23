import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 健身
 *
 * 小王是一个喜欢健身的人，他每天都会围着一个n*n的场地外侧跑步，他是一个有强迫症的人，每跑(n+1)个单位长度，他就要在地上做一个标记，
 * 当他在一个点重复标记的时候，他就会结束一天的锻炼，显然当n一定时，他每天打标记的数量也是一定的，请你计算出来他每天打多少个标记。
 * (最后一次重复标记也要计数)
 *
 *
 * 输入
 * 第一行包含一个正整数t，表示询问的数量。(1<=t<10000)
 *
 * 第二行包含t个整数，中间用空格隔开，每个整数表示一个询问所给出的n。0<=|ai|<=1000。
 *
 * 输出
 * 输出应该有t行，每行仅包含一个正整数，第i行的正整数表示对与第i个询问的答案。
 *
 */

public class Practice255 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        String[] data = bf.readLine().split(" ");
        for (int i = 0; i < t; i++){
            int count = 0;
            int n = Integer.parseInt(data[i]);
            int tag = n+1;  //打标机的长度
            //将一个n*n的正方形操场看作4*n的直线
            int l = 4 * n;
            int tmp = tag%l;  //每次跑的要标记位置
            List<Integer> list = new ArrayList<>();  //存放标记
            while (!list.contains(tmp)){
                list.add(tmp);
                count++;
                tmp = (tmp+tag)%l;
            }
            System.out.println(count+1);
        }
    }
}
