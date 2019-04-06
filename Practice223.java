import java.util.Scanner;

/**
 * * 密码验证合格程序
 *  * 密码要求：
 *  * 1.长度超过8位
 *  * 2.包括大小写字母、数字、其他符号，以上四种至少三种
 *  * 3.不能有相同长度超过2的子串重复
 *  *
 *  * 输入要求：一组或多组长度超过2的字符串
 *  * 输出要求：OK，否则输出NG
 *  *
 *  * eg：
 *  * 输入：
 *  * 021Abc9000
 *  * 021Abc9Abc1
 *  * 021ABC9000
 *  * 021$bc9000
 *  * 输出：
 *  * OK
 *  * NG
 *  * NG
 *  * OK
 *  *
 */

public class Practice223 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            print(str);
        }
    }

    private static void print(String str){
        //长度超过8位
        if (str.length() <= 8){
            System.out.println("NG");
            return;
        }
        //包括大小写字母、数字、其他符号，以上四种至少三种
        int flag1 = 0,flag2 = 0, flag3 = 0, flag4 = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                flag1 = 1;
            }else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                flag2 = 1;
            }else if ((str.charAt(i)-'0') >= 0 && (str.charAt(i)-'0') <= 9){
                flag3 = 1;
            }else {
                flag4 = 1;
            }
        }
        if (flag1+flag2+flag3+flag4 < 3){
            System.out.println("NG");
            return;
        }
        //不能有相同长度超过2的子串重复
        for (int i = 0; i < str.length(); i++){
            for (int j = i+3; j < str.length(); j++){
                String string1 = str.substring(i,j);
                String string2 = str.substring(j);
                if (string2.contains(string1)){
                    System.out.println("NG");
                    return;
                }
            }
        }
        System.out.println("OK");
    }
}
