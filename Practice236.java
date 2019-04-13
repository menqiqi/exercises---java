import java.util.Scanner;

/**
 *
 * On a broken keyboard, some of the keys are worn out. So when you type some sentences, the characters
 * corresponding to those keys will not appear on screen.
 *
 * Now given a string that you are supposed to type, and the string that you actually type out, please list those keys
 * which are for sure worn out.
 *
 *
 * 输入描述:
 *
 * Each input file contains one test case. For each case, the 1st line contains the original string, and the 2nd line contains the typed-out string. Each string contains
 * no more than 80 characters which are either English letters [A-Z] (case
 * insensitive), digital numbers [0-9], or "_" (representing the space). It is guaranteed that both strings are non-empty.
 *
 *
 *
 * 输出描述:
 *
 * For each test case, print in one line the keys that are worn out, in the order of being detected. The English letters must be capitalized.
 * Each worn out key must be printed once only. It is guaranteed that there is at least one worn out key.
 *
 *解析：
 * 一个是自己输入的字符，一个是实际输出的字符。
 * 判断键盘上的哪个键有损坏。
 */

public class Practice236 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str1 = in.nextLine().toUpperCase();
            String str2 = in.nextLine().toUpperCase();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < str1.length()){
                if (!str2.contains(String.valueOf(str1.charAt(i))) && !sb.toString().contains(String.valueOf(str1.charAt(i))))
                    sb.append(str1.charAt(i));
                i++;
            }
            System.out.println(sb.toString());
        }
    }
}
