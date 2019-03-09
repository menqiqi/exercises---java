import java.util.Scanner;

/**
 * A B C三个人是好朋友，每个人手中都有一些糖果。不知道每个人具体有多少糖果，但是我们知道以下信息：
 * A-B B-C A+B B+C 这四个数值，每个字母代表一个人的糖果数。
 * 现需要通过这四个数值计算出每个人手中有多少糖果，即A B C
 */

public class Practice156 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int x = Integer.parseInt(str[0]);  //A - B
        int y = Integer.parseInt(str[1]);  //B - C
        int z = Integer.parseInt(str[2]);  //A + B
        int w = Integer.parseInt(str[3]);  //B + C
        int[] res = new int[3];
        res[0] = (x + z)/2;
        res[1] = (y + w)/2;
        res[2] = res[1] - y;
        if (res[0] < 0 || res[1] < 0 || res[2] < 0 || (res[0] - res[1]) != x || (res[1] - res[2]) != y){
            System.out.println("No");
            return;
        }
        for (int i = 0; i < 3; i++){
            System.out.print(res[i] + " ");
        }
    }
}
