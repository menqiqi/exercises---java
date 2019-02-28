import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 对于任意两个正整数x和k,我们定义repeat(x, k)为将x重复写k次形成的数,
 例如repeat(1234, 3) = 123412341234,repeat(20,2) = 2020.
 牛牛现在给出4个整数x1, k1, x2, k2, 其中v1 = (x1, k1), v2 = (x2, k2),请你来比较v1和v2的大小。
 输入描述:

 输入包括一行,一行中有4个正整数x1, k1, x2, k2(1 ≤ x1,x2 ≤ 10^9, 1 ≤ k1,k2 ≤ 50),以空格分割

 输出描述:

 如果v1小于v2输出"Less",v1等于v2输出"Equal",v1大于v2输出"Greater".

 示例1
 输入

 1010 3 101010 2

 输出

 Equal


 */

public class Practice144 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] in = bf.readLine().split(" ");
        String x1 = in[0];
        int k1 = Integer.parseInt(in[1]);
        String x2 = in[2];
        int k2 = Integer.parseInt(in[3]);
        System.out.println(repeat(x1,k1,x2,k2));
    }

    private static String repeat(String x1,int k1,String x2,int k2){
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < k1; i++){
            sb1.append(x1);
        }
        for (int j = 0; j < k2; j++){
            sb2.append(x2);
        }
        String str1 = sb1.toString();
        String str2 = sb2.toString();
        //比较sb1和sb2的大小
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 < len2){
            //str1比较小
            return "Less";
        }else if (len1 > len2){
            //str2比较小
            return "Greater";
        }else {
            //两数的长度一样，从最大位开始比较
            for (int m = 0; m < len1; m++){
                if (str1.charAt(m) - '0' > str2.charAt(m) - '0'){
                    return "Greater";
                }else if (str1.charAt(m) - '0' < str2.charAt(m) - '0'){
                    return "Less";
                }else
                    continue;
            }
        }
        return "Equal";
    }

}
