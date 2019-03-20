import java.util.Scanner;

/**
 * 输入数组中的数代表从0到9的数的个数
 * 输出所能组成的最小数
 */

public class Practice185 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int[] num = new int[str.length];
        for (int i = 0; i < str.length; i++){
            num[i] = Integer.parseInt(str[i]);
        }
        int t = 0;  //第一个不为0的数
        int sum = 0;
        for (int i = 0; i < str.length; i++){
            sum = sum + num[i];
        }
        for (int i = 1; i < str.length; i++){
            if (num[i] != 0){
                t = i;
                break;
            }
        }
        String string = String.valueOf(t);
        for (int i = 0; i < num[0]; i++){
            string = string + String.valueOf(0);
        }
        num[t] = num[t] - 1;
        for (int i = t; i < str.length; i++){
            if (num[i] != 0){
                for (int j = 0; j < num[i]; j++){
                    string = string + String.valueOf(i);
                }
            }
        }

        int res = Integer.parseInt(string);
        System.out.println(res);

    }
}
