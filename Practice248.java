/**
 * 创建一个CTriangle 类，需要用到第二题中创建的类，即用3点来代表一个三角形，输入三个点的坐标，
 * 实现判断此三角形是不是直角三角形，并输出此三角形的周长。
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice248 {

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(buf.readLine());


        for(int i=0;i<m;i++){
            String[] node = buf.readLine().split(" ");
            double[] nodes = new double[6];
            double[] len_2 = new double[3];
            for(int j=0;j<6;j++){
                nodes[j] = Double.parseDouble(node[j]);
            }
            len_2[0] = (nodes[4]-nodes[2])*(nodes[4]-nodes[2])+(nodes[5]-nodes[3])*(nodes[5]-nodes[3]);
            len_2[1] = (nodes[4]-nodes[0])*(nodes[4]-nodes[0])+(nodes[5]-nodes[1])*(nodes[5]-nodes[1]);
            len_2[2] = (nodes[2]-nodes[0])*(nodes[2]-nodes[0])+(nodes[3]-nodes[1])*(nodes[3]-nodes[1]);

            if(len_2[0]<len_2[1]){
                double temp = len_2[0];
                len_2[0] = len_2[1];
                len_2[1] = temp;
            }
            if(len_2[0]<len_2[2]){
                double temp = len_2[0];
                len_2[0] = len_2[2];
                len_2[2] = temp;
            }

            if(len_2[0]==len_2[1]+len_2[2]){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
            System.out.printf("%.2f",Math.sqrt(len_2[0])+Math.sqrt(len_2[1])+Math.sqrt(len_2[2]));
            System.out.println();
        }
    }

}
