import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/473c219f9e4d4ab2851ed388895a9c86
 * 来源：牛客网
 *
 * 给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：
 *
 *
 *
 * A1 = 能被5整除的数字中所有偶数的和；
 *
 * A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
 *
 * A3 = 被5除后余2的数字的个数；
 *
 * A4 = 被5除后余3的数字的平均数，精确到小数点后1位；
 *
 * A5 = 被5除后余4的数字中最大数字。
 * 输入描述:
 *
 * 每个输入包含1个测试用例。每个测试用例先给出一个不超过1000的正整数N，随后给出N个不超过1000的待分类的正整数。数字间以空格分隔。
 *
 *
 *
 * 输出描述:
 *
 * 对给定的N个正整数，按题目要求计算A1~A5并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。
 * 若其中某一类数字不存在，则在相应位置输出“N”。
 */

public class Practice208 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int[] data = new int[str.length];
        for(int i = 0; i < str.length; i++){
            data[i] = Integer.parseInt(str[i]);
        }

        int A1 = 0, A2 = 0, A3 = 0, A4 = 0, A5 = 0;
        int f1 = 0, f2 = 0, f3 = 0, f4 = 0, f5 = 0;
        int flag = 1;  //方便进行A2的运算
        int count = 0;
        for(int j = 1; j < data.length; j++){
            if(data[j]%5 == 0 && data[j]%2 == 0){
                A1 = A1 + data[j];
                f1 = 1;
            }
            if(data[j] % 5 == 1){
                A2 = A2 + data[j]*flag;
                flag = flag * (-1);
                f2 = 1;
            }
            if(data[j] % 5 == 2){
                A3 += 1;
                f3 = 1;
            }
            if(data[j] % 5 == 3){
                count++;
                A4 = A4 + data[j];
                f4 = 1;
            }
            if(data[j] % 5 == 4){
                if(data[j] > A5)
                    A5 = data[j];
                f5 = 1;
            }
        }
        if(f1 == 0){
            System.out.print("N"+" ");
        }else{
            System.out.print(A1+" ");
        }
        if(f2 == 0){
            System.out.print("N ");
        }else {
            System.out.print(A2+" ");
        }
        if(f3 == 0){
            System.out.print("N ");
        }else {
            System.out.print(A3+" ");
        }
        if (f4 == 0){
            System.out.print("N ");
        }else {
            System.out.print(new DecimalFormat("0.0").format(A4*1.0/count) +" ");
        }
        if (f5 == 0){
            System.out.print("N ");
        }else {
            System.out.print(A5);
        }

    }
}