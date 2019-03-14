import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  今年的第几天？
 *
 * 输入年、月、日，计算该天是本年的第几天。
 */

public class Practice171 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = bf.readLine().split(" ");
        //String[] str2 = bf.readLine().split(" ");
        System.out.println(days(str1));
        //System.out.println(days(str2));
    }

    private static int days(String[] str){
        int yaer = Integer.parseInt(str[0]);
        int month = Integer.parseInt(str[1]);
        int day = Integer.parseInt(str[2]);
        int res = 0;
        for (int i = 1; i < month; i++){
                if (i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12){
                    res = res + 31;
                }else if (i==2){
                    res = res + 28;
                }else {
                    res = res + 30;
                }
        }
        if (leapYear(yaer)){
            //如果是闰年，二月有29天
            if (res>2){
                res = res + 1 + day;
            }else
                res = res + day;
        }else {
            res = res + day;
        }
        return res;

    }

    private static boolean leapYear(int year){
        //能整除4且不能整除100
        //能整除400
        if (year % 4 == 0 && year % 100 != 0){
            return true;
        }
        if (year % 400 == 0){
            return true;
        }
        return false;
    }
}
