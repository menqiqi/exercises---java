import java.util.Arrays;
import java.util.Scanner;

/**
 * 最小长方形
 * 输入的坐标包括在长方形中，边界也算
 */

public class  Practice385{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(",");
        int len = str.length;
        int[] x = new int[len];
        int[] y = new int[len];
        for (int i = 0; i < str.length; i++){
            String[] tmp = str[i].split(" ");
            x[i] = Integer.parseInt(tmp[0]);
            y[i] = Integer.parseInt(tmp[1]);
        }
        Arrays.sort(x);
        Arrays.sort(y);
        int minX = x[0], maxX = x[len-1];
        int minY = y[0], maxY = y[len-1];
        String a = minX+" "+minY;
        String b = minX+" "+maxY;
        String c = maxX+" "+maxY;
        String d = maxX+" "+minY;
        System.out.println(a+","+b+","+c+","+d);
    }
}