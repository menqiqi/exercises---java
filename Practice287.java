/**
 * 根据输入的字符串判断字符串中数字的位置。
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice287 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            for (int j = 0; j < word.length(); j++) {
                char str = word.charAt(j);
                if (Character.isDigit(str)) {
                    System.out.print(j+1+" ");
                }
            }
            System.out.println();
        }

    }

}
