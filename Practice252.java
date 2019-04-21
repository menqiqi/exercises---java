/**
 *  创建一个CPoint 类，代表平面直角坐标系中的点，创建构造函数和运算符重载函数，
 *  运算符重载为类重载（非友元重载），可以实现计算两个点之间的距离。
 *
 * 要求：
 *
 * 1。输入两个点的坐标，输出两个点之间的距离
 *
 * 2。重载运算符为“-”
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice252 {

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(buf.readLine());
        while (m -->0){
            String[] node = buf.readLine().split(" ");
            double[] nodes = new double[4];
            for(int i=0;i<4;i++){
                nodes[i] = Double.parseDouble(node[i]);
            }
            double len = Math.sqrt((nodes[3] - nodes[1])*(nodes[3] - nodes[1]) + (nodes[2] - nodes[0])*(nodes[2] - nodes[0]));
            System.out.printf("%.2f",len);
            System.out.println();
        }
    }
}
