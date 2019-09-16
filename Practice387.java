import java.util.Scanner;

/**
 * 求字符串的最长回文子串
 */

public class Practice387 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String maxStr = maxLength(str);
        System.out.println(maxStr);
        in.close();
    }

    public static String maxLength(String str){
        String maxStr = "";  //回文串
        int len = 0, maxLen = 0;  //回文串长度，最长回文串长度
        for (int i = 0; i < str.length(); i++){
            len = 0;
            for (int j = i+1; j <= str.length(); j++){
                String s = str.substring(i,j);
                if (isHuiWen(s)){
                    len = s.length();
                }
                if (len > maxLen){
                    maxLen = len;
                    maxStr = s;
                }
            }
        }
        return maxStr;
    }

    /**
     * 判断是否为回文串
     * @param s
     * @return
     */
    public static boolean isHuiWen(String s){
        int len = s.length();
        for (int i = 0; i < len/2; i++){
            if (!(s.charAt(i) == s.charAt(len-i-1))){
                return false;
            }
        }
        return true;
    }
}
