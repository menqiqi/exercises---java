import java.util.Arrays;
import java.util.Scanner;

/**
 * 牛牛有四根木棍，长度分别为a,b,c,d。羊羊家提供改变木棍长度的服务，如果牛牛支付一个硬币就可以让一根木棍的
 * 长度加一或者减一。牛牛需要用这四根木棍拼接成一个正方形，牛牛最少需要支付多少硬币。
 */

public class Practice159 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int[] num = new int[4];
        for (int i = 0; i < 4; i++){
            num[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(num);
        int count1 = 0;
        int tmp1 = num[1];
        count1 = tmp1 - num[0] + num[2] - tmp1 + num[3] - tmp1;
        int count2 = 0;
        int tmp2 = num[2];
        count2 = tmp2 - num[0] + tmp2 - num[1] + num[3] - tmp2;
        if (count1 < count2)
            System.out.println(count1);
        else System.out.println(count2);
    }
}
