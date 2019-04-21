/**
 *  请输入字符串，最多输入4 个字符串，要求后输入的字符串排在前面，例如
 *
 * 输入：EricZ
 *
 * 输出：1=EricZ
 *
 * 输入：David
 *
 * 输出：1=David 2=EricZ
 *
 * 输入：Peter
 *
 * 输出：1=Peter 2=David 3=EricZ
 *
 * 输入：Alan
 *
 * 输出：1=Alan 2=Peter 3=David 4=EricZ
 *
 * 输入：Jane
 *
 * 输出：1=Jane 2=Alan 3=Peter 4=David
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice253 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String arr[] = new String[4];

        //定义输入多少行的字符串
        int m = Integer.parseInt(buf.readLine());
        int end = 0;
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            end = end % 4;
            arr[end] = buf.readLine();
            int k = 1;
            for (int j = end; j >= 0; j--) {
                sb.append(k++ + "=" + arr[j] + " ");
            }
            for (int j = 3; j > end; j--) {
                if (arr[j] == null){
                    continue;
                }
                sb.append(k++ + "=" + arr[j] + " ");
            }
            end++;
            System.out.println(sb.toString());
        }
    }
}
