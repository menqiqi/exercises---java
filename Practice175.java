import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入一串字符，包含数字[0-9]和小写字母[a-z]，要求按数字从小到大、字母从a到z排序，并且所有数字排在字母后面
 */

public class Practice175 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        //计算数字和字母的个数
        int countletter = 0;
        int countnum = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) <= 'z' && str.charAt(i) >= 'a')
                countletter++;
        }
        countnum = str.length() - countletter;
        char[] num = new char[countnum];
        char[]letter = new char[countletter];
        int m = 0;
        int n = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                letter[m++] = str.charAt(i);
            }else {
                num[n++] = str.charAt(i);
            }
        }
        Arrays.sort(num);
        Arrays.sort(letter);
        String res = "";
        for (int i = 0; i < letter.length; i++){
            res = res+letter[i];
        }
        for (int j = 0; j < num.length; j++){
            res = res + num[j];
        }
        System.out.println(res);
    }
}
