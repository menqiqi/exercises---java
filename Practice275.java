/**
 * 受到小人的设计，主人公暮小云落入一个名为神凛幻域的奇特地方。
 * 对于迷失在这里的人而言这个空间没有绝对的方向，想要脱离这个地方就必须向前走出n步。
 * 由于在这个空间内没有方向的概念，无论何时向任何方向迈出一步都是等效的
 * （哪怕你是原地转圈，只要走出N步即可脱离幻境）。不过，由于空间壁垒的原因，
 * 不同时刻向不同方向走所耗费的体力不同。现在已知不同时刻向某个方向跨出一步所需耗费的体力，
 * 请你告诉暮小云怎么走最省体力，以及需要耗费的最小体力。
 */

import java.io.*;
public class Practice275 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        char[] map = {'E','S','W','N'};
        while(T-- >0){
            int n = Integer.parseInt(br.readLine());
            String[][] direction = new String[4][];
            for(int i = 0; i < 4; i++)
                direction[i] = br.readLine().split(" ");
            StringBuilder res = new StringBuilder();
            int sum = 0;
            for(int i = 0; i < n; i++){
                int tmp = Integer.parseInt(direction[0][i]);
                res.append(map[0]);
                for(int j = 1; j < 4; j++)
                    if(Integer.parseInt(direction[j][i]) < tmp) {tmp = Integer.parseInt(direction[j][i]); res.setCharAt(i,map[j]);}
                sum += tmp;
            }
            System.out.println(sum);
            System.out.println(res);
        }
        br.close();
    }
}
