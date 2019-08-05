/**
 * 小Q正在给一条长度为n的道路设计路灯安置方案。
 *
 * 为了让问题更简单,小Q把道路视为n个方格,需要照亮的地方用'.'表示, 不需要照亮的障碍物格子用'X'表示。
 *
 * 小Q现在要在道路上设置一些路灯, 对于安置在pos位置的路灯, 这盏路灯可以照亮pos - 1, pos, pos + 1这三个位置。
 *
 * 小Q希望能安置尽量少的路灯照亮所有'.'区域, 希望你能帮他计算一下最少需要多少盏路灯。
 */

import java.io.*;
public class Practice329 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] length = new int[t];
        String[] roads = new String[t];
        for(int i=0;i<t;i++) {
            length[i] = Integer.parseInt(br.readLine());
            roads[i] = br.readLine();
        }
        for(int i=0;i<t;i++) {
            System.out.println(LightCount(roads[i]));
        }
    }
    private static int LightCount(String road) {
        int counts = 0;
        for(int i=0;i<road.length();i++) {
            if(road.charAt(i)=='.') {
                counts++;
                i+=2;
            }
        }
        return counts;
    }
}