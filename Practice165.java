import java.util.Scanner;

/**
 * 写一个程序，接收一个字符串，然后输出其反转之后的字符串。
 */

public class Practice165 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] strings = str.toCharArray();
        int left = 0;
        int right = strings.length-1;
        while (left < right){
            char tmp = strings[left];
            strings[left] = strings[right];
            strings[right] = tmp;
            left++;
            right--;
        }
        String res = new String(strings);
        System.out.println(res);
    }
}



