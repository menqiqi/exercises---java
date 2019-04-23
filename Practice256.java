import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 给出一个仅由大小写字母和‘？’组成的字符串S，和一个仅由大小写字母组成的字符串T，已知‘？’可以由任何一个大小写字母替代，
 * 问S字符串最多可以匹配多少个T字符串，两个不同的匹配之间可以重合，例如S=ababa，T=aba，则S最多同时匹配两个T串。
 */

public class Practice256 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        String t = bf.readLine();
        int count = 0;
        if (!s.contains("?")){
            //不包含问号的情况
            if (!s.contains(t)){
                System.out.println(0);
                return;
            }
            int i = 0;
            while (i <= s.length()-t.length() ){
                if (s.charAt(i) != t.charAt(0)){
                    i++;
                }else {
                    if (s.substring(i,i+t.length()).equals(t)){
                        count++;
                    }
                    i++;
                }
            }
            System.out.println(count);
        } else {
            //包含问号的情况
            int i = 0, j = 0;
            while (i < s.length()){
                if (s.charAt(i) == t.charAt(j) || s.charAt(i) == '?'){
                    i++;
                    j++;
                }else {
                    j = 0;
                    i++;
                }
                if (j == t.length()) {
                    count++;
                    i = i-t.length()+1;
                    j = 0;
                }
            }
            System.out.println(count);
        }
    }
}
