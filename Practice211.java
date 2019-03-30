import java.util.Scanner;

/**
 * 给定一个字符串，求出长度最长且不含有重复字符的子串
 */

public class Practice211 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            String string = str.substring(0,1);
            int max = 1;
            for(int i = 1; i < str.length(); i++){
                String tmp = str.substring(i,i+1);
                if (!string.contains(tmp)){
                    string = string + tmp;
                }else {
                    string = tmp;
                }
                if (string.length() > max)
                    max = string.length();
            }
            System.out.println(max);
        }
        in.close();
    }
}
