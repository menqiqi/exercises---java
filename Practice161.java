import java.io.IOException;
import java.util.Scanner;

/**
 * 求最小公倍数
 *
 * 最大公约数和最小公倍数的乘积就是两个数的乘积
 * 最大公约数用辗转相除法
 * 例如：
 * （6,9）---> 9/6  余3
 * （3，9） ---> 9/3   余0
 * 所以最小公约数就是3
 */

public class Practice161 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int A = in.nextInt();
            int B = in.nextInt();
            System.out.println(A*B/commonMul(A,B));
        }
    }

    //最大公约数
    private static int commonMul(int x, int y){
        int max = x > y ? x : y;
        int min = x < y ? x : y;
        if (max % min == 0){
            return min;
        }else {
            return commonMul(max,max%min);
        }
    }
}
