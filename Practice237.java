import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 知道球的中心点和某一点的坐标，求球的半径和体积。
 */

public class Practice237 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            double x0 = in.nextFloat();
            double y0 = in.nextFloat();
            double z0 = in.nextFloat();
            double x1 = in.nextFloat();
            double y1 = in.nextFloat();
            double z1 = in.nextFloat();
            double r = Math.sqrt((x0-x1)*(x0-x1)
                    +(y0-y1)*(y0-y1)+(z0-z1)*(z0-z1));
            double volume = 4*Math.acos(-1)*Math.pow(r, 3)/3;
            DecimalFormat df = new DecimalFormat("#.000");
            System.out.println(df.format(r)+" "+df.format(volume));
        }
    }
}



