/**
 * 给定一个十进制的正整数number，选择从里面去掉一部分数字，希望保留下来的数字组成的正整数最大。
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Practice302 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String strs[];
        while((str = bf.readLine())!=null) {
            str = str.trim().toString();
            int n = Integer.parseInt(bf.readLine().trim());
            StringBuffer sb =new StringBuffer();
            sb.append(str.charAt(0));
            for(int i=1;i<str.length() ;i++) {
                int len_2 = sb.length();
                while(len_2>0 && n>0 && sb.charAt(len_2-1)<str.charAt(i)) {
                    sb.deleteCharAt(len_2-1);
                    len_2--;
                    n--;
                }
                sb.append(str.charAt(i));
            }
            while(n>0) {
                sb.deleteCharAt(sb.length()-1);
                n--;
            }
            System.out.println(sb.toString());
        }
    }
}
