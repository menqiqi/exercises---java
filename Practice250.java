import java.util.Scanner;

/**
 * 输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。
 * 例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”
 */

public class Practice250 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str1.length(); i++){
                if (!str2.contains(String.valueOf(str1.charAt(i))))
                    sb.append(str1.charAt(i));
            }
            System.out.println(sb.toString());
        }
        in.close();
    }
}
