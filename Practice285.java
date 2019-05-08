/**
 * 一个小球，从高为H的地方下落，下落弹地之后弹起高度为下落时的一半，比如第一次弹起高度为H/2，
 * 如此往复，计算从小球H 高度下落到第n 次弹地往返的总路程。
 */

import java.io.*;

public class Practice285 {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bf.readLine());
        for (int i=0; i<m; i++) {
            String[] str = bf.readLine().split(" ");
            double h = Double.parseDouble(str[0]);
            int n = Integer.parseInt(str[1]);
            double k = 1;
            double result = 0;
            if (n==1) {
                System.out.printf("%.2f",h);
                System.out.println("");
            }
            else if (n==2) {
                System.out.printf("%.2f",2*h);
                System.out.println("");
            }
            else {
                for (int j=3; j<=n; j++) {
                    k *= 2;
                }
                result = (3*k-1)/k*h;
                System.out.printf("%.2f",result);
                System.out.println("");
            }
        }
    }
}
