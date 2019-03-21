import java.util.Scanner;

/**
 * 验证尼克斯撤定理
 * 任何一个数m的立方都能写成m个奇数之和
 *
 * 1^3 = 1
 * 2^3 = 3+5
 */

public class Practice186 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int sum = 0;
        for (int i = 1; i < m; i++){
            sum = sum + i;
        }
        int j = 0;
        //int tmp = 0;
        int mm = 1;
        while (j < sum){
            mm = mm + 2;
            j++;
        }

        //String str = "";
        for (int i = 0; i < m-1; i++){
          //  str = str + (mm+2) + "+" +(mm+4);
            System.out.print((mm)+"+");
            mm = mm + 2;
        }
        System.out.println(mm);

    }
}
