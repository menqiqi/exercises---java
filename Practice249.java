/**
 * 编写一个日期类，要求按xxxx-xx-xx 的格式输出日期，实现加一天的操作。
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice249 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            System.out.println(FormatDate(br.readLine()));
        }

        br.close();
    }

    public static int[] getNextDate(String[] originaldate) {
        int[] MONTH = { 0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] next = new int[3];
        int year = Integer.parseInt(originaldate[0]);
        int month = Integer.parseInt(originaldate[1]);
        int date = Integer.parseInt(originaldate[2]);
        int nextdate = date + 1;
        MONTH[2] = isLeap(year) ? 29 : 28;
        if (nextdate <= MONTH[month]) {
            next[0] = year;
            next[1] = month;
            next[2] = nextdate;
        } else {
            if (month < 12) {
                next[0] = year;
                next[1] = ++month;
                next[2] = 1;
            } else {
                next[0] = year + 1;
                next[1] = 1;
                next[2] = 1;
            }
        }

        return next;
    }

    public static boolean isLeap(int year) {
        return (year % 400 == 0) || (year % 100 != 0 && year % 4 != 0);
    }

    public static String FormatDate(String input) {
        String[] srt = input.split(" ");
        int[] date=getNextDate(srt);
        return date[0] + "-" + toFormat(date[1]) + "-" + toFormat(date[2]);
    }

    public static String toFormat(int num) {
        if (num < 10) {
            return "0" + num;
        }
        return "" + num;
    }
}
