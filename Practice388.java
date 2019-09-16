import java.util.Scanner;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 */

public class Practice388 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(",");
        int n = Integer.parseInt(str[1]);
        String string = str[0];
        System.out.println(pailie(string,n));
    }

    public static String pailie(String string, int n){
        if (n == 1){
            return string;
        }
        char[] chars = string.toCharArray();
        int len = chars.length;
        StringBuilder res = new StringBuilder();
        for (int i = 0; (i<n) && (i<len); i++){
            //第一列
            res.append(chars[i]);
            for (int j = i+2*(n-1); (j-2*i)<len||(j<len); j=j+2*(n-1)){
                //中间行
                if (i!=0 && (n-1)!=i){
                    res.append(chars[j-2*i]);
                }
                if (j < len){
                    res.append(chars[j]);
                }
            }
        }
        return res.toString();
    }

}
