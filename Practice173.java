import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个数字，请编写程序统计每种不同的个位数字出现的次数。
 * 例如：给定N=100311，则有2个0，3个1,1个3。
 * 数字按升序排列。
 */

public class Practice173 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num = in.nextLine();
        //按照数字升序
        int length = num.length();
        int[] res = new int[length];
        for (int i = 0; i < length; i++){
            res[i] = num.charAt(i) - '0';
        }
        Arrays.sort(res);
        int count = 1;
        for (int j = 0; j < length-1; j++){
            if (res[j] == res[j+1]){
                count++;
            }else {
                System.out.println(res[j]+":"+count);
                count = 1;
            }
        }
        System.out.println(res[length-1]+":"+count);
    }
}
