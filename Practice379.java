import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 输入两个字符串，从第一字符串中删除第二个字符串中所包含的字符。
 */

public class Practice379 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str1 = bf.readLine();
        String str2 = bf.readLine();
        if (str1 == ""){
            System.out.println("");
            return;
        }
        if (str2 == ""){
            System.out.println(str1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length(); i++){
            if (!str2.contains(String.valueOf(str1.charAt(i)))){
                sb.append(str1.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
