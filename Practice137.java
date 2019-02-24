/**
 * 有两个用字符串表示的非常大的大整数,算出他们的乘积，也是用字符串表示。不能用系统自带的大整数类型。
 */

/*
import java.util.Scanner;

public class Practice137{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str[] = scanner.nextLine().split(" ");
        String result = multiBigInt(str[0].toCharArray(), str[1].toCharArray());

        //除去首位的0
        char[] temp = result.toCharArray();
        int i = 0;
        for (; i < temp.length; i++){
            if (temp[i] == '0')
                continue;
            else
                break;
        }
        System.out.println(result.substring(i, result.length()));
        scanner.close();

    }

    //计算单个字符 乘 一个字符串
    public static String multiBigIntSingle(char[] a, char b){
        int pre = 0;
        String result = "";
        for (int j = a.length-1; j >= 0; j--){
            int temp = a[j] - '0';
            int tempb = b - '0';
            int sum = temp * tempb + pre;
            pre = sum / 10;
            int left = sum % 10;
            result += left;
        }
        //查看最后一次相加是否会有进位
        if (pre != 0)
            result += pre;

        char[] sb = result.toCharArray();
        String value = "";
        for (int j = sb.length-1; j >= 0; j--)
            value += sb[j];
        return  value;
    }

    //用第二个字符串的每一位去乘以第一个字符串的数值，最后将每次的结果错位相加
    public static String multiBigInt(char[] a, char[] b){
        String c = "";  //保存每一行相加后的结果
        int j = 0;  //控制错位
        for (int i = b.length-1; i >= 0; i--){
            c = addBigInt(c.toCharArray(),multiBigIntSingle(a,b[i]).toCharArray(),j++);
        }
        return c;
    }

    //将两个大整数相加 len用于控制错位相加
    public static String addBigInt(char[] a, char[] b, int len){
        int maxlen = a.length + b.length;
        char[] revA = reverse(a);
        char[] revB = reverse(b);
        String sb = "";
        int tempa = 0;
        int tempb = 0;
        int pre = 0;
        for (int i = 0; i < maxlen; i++){
            tempa = 0;
            tempb = 0;
            if (i < revA.length)
                tempa = revA[i] - '0';
            //第二行要先以为len的距离，错位相加
            if (i < revB.length + len && i >= len)
                tempb = revB[i - len] - '0';

            int sum = tempa + tempb + pre;
            pre = sum/10;

            int left = sum % 10;
            sb += left;
        }
        while (pre != 0){
            sb += pre % 10;
            pre /= 10;
        }
        char[] result = sb.toCharArray();
        String vlaue = "";
        for (int j = result.length - 1; j >= 0; j--)
            vlaue += result[j];
        return vlaue;
    }

    //将每一个字符反转，便于整数相加
    public static char[] reverse(char[] a){
        char[] b = new char[a.length];

        int i = 0;
        int j = a.length-1;
        for (; j >= 0; j--){
            b[i] = a[j];
            i++;
        }
        return b;
    }
}*/
