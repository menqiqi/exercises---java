/**
 * 将一个英文语句按单词逆序输出。
 */

import java.util.*;

public class Practice322 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        String[] data = string.split(" ");
        String res = "";
        for(int i = data.length-1; i > 0; i--){
            res = res + data[i] + " ";
        }
        res = res + data[0];
        System.out.println(res);

    }
}