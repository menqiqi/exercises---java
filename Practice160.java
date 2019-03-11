import java.util.Arrays;
import java.util.Scanner;

/**
 * 牛牛手中有三根木棍,长度分别是a,b,c。牛牛可以把任一一根木棍长度削短,
 * 牛牛的目标是让这三根木棍构成一个三角形,并且牛牛还希望这个三角形的周长越大越好。
 */

public class Practice160 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);
        int[] num = {a,b,c};
        Arrays.sort(num);
        int min = num[0];
        int mid = num[1];
        int max = num[2];
        if (max < (min+mid)){
            System.out.println(max+mid+min);
        }else if (max == (min+mid)){
            System.out.println(max+mid+min-1);
        }else {
            System.out.println(2*(min+mid)-1);
        }
    }
}
