import java.util.Scanner;

/**
 * 十六进制转化为十进制
 */

public class Practice319 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String string = scanner.nextLine();//输入十六进制数
        int sum=0;
        for(int i=0;i<string.length();i++)
        {
            int m=string.charAt(i);//将输入的十六进制字符串转化为单个字符
            int num=m>='A'?m-'A'+10:m-'0';//将字符对应的ASCII值转为数值
            sum+=Math.pow(16, string.length()-1-i)*num;
        }
        System.out.println(sum);
    }
}
