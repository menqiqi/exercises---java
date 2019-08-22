/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 */

public class Practice355 {
    public static void main(String[] args) {
        String res1 = countAndSay(1);
        String res2 = countAndSay(4);
        System.out.println(res1);
        System.out.println(res2);
    }

    public static String countAndSay(int n) {
        if (n <= 0){
            return "";
        }
        String[] s = new String[n];
        s[0] = "1";
        for (int i = 1; i < n; i++){
            s[i] = count(s[i-1]);
        }
        return s[n-1];
    }

    public static String count(String str){
        StringBuilder ans = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            // 这一部分是"count", 记录连续出现x个y
            if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                // 这一部分是"say"，将上面"count"的结果"xy"作为下一个数的一部分（若上面记录到2个1，就拼接"21"）
                ans.append(count).append(str.charAt(i));
                count = 1;
            }
        }
        return new String(ans);
    }
}
