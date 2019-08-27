import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 最优打字策略
 *
 * 在英文的输入中，我们经常会遇到大小写切换的问题，频繁切换大小写会增加我们的按键次数，也会降低我们的打字效率。
 *
 * 众所周知，切换大小写有两种方式，一种是按下“caps locks”，也就是大写锁定键，这样一来，之后的输入模式都会被切换。另一种是同时按下shift和需要打印的字母，可以临时切换大小写(算作按下两个键)。
 *
 * 已知初始状态下，打字模式是小写，现在给出需要打印的字符串(区分大小写)，请你计算出最少需按键多少次才能打印出来。
 */

public class Practice358 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String str = bf.readLine();
        System.out.println(minCount(n,str));
    }

    public  static int minCount(int n,String str){
        if (n == 1 && str.charAt(0) >= 'A' && str.charAt(0) <= 'Z'){
            return 2;
        }
        int sum = n;
        boolean flag = false;  //是否用到了大小写字母切换的键
        for (int i = 0; i < n-1; i++){
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z' && flag == false){
                sum += 1;
                if (str.charAt(i+1) >= 'A' && str.charAt(i+1) <= 'Z'){
                    //说明有两个连续的的大写字母
                    flag = true;
                }
            }
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z' && flag == true){
                sum += 1;
                flag = false;
            }
        }
        //对最后一个字母进行判断
        char last = str.charAt(n-1);
        //如果是小写字母并且前面使用了大小写切换键
        if (last >= 'a' && last <= 'z' && flag == true){
            sum += 1;
        }
        //如果是大写字母且前面是小写字母
        if (last >= 'A' && last <= 'Z' && flag == false){
            sum += 1;
        }
        return sum;
    }
}
