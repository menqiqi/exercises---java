import java.util.Scanner;

/**
 * 给定一个字符串，在O（n）的时间里给他做一些变形。字符串中有空格，逐个把字符串分开的单词反序，反转每个单词的大小写。
 */

class Solution{
    public String changeStr(String s, int n){
        String newStr = reverseCases(s,n);

        String[] array = null;
        array = newStr.split(" ");
        StringBuffer str = new StringBuffer();
        for (int i = array.length-1; i >= 0; i--) {
            str.append(array[i]+" ");
        }
        return str.toString().trim();
    }

    public static String reverseCases(String s,int n){
        StringBuffer result = new StringBuffer();
        char[] chArray = s.toCharArray();
        String[] ch = new String[chArray.length];
        for(int i=0;i<n;i++){
            if(chArray[i]<97){
                ch[i] = (chArray[i]+"").toLowerCase();
            }else {
                ch[i] = (chArray[i]+"").toUpperCase();
            }
            result.append(ch[i]) ;
        }
        return result.toString().trim();
        //return result.substring(0,n);
    }
}

public class Practice153 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Solution solution = new Solution();
        System.out.println(solution.changeStr(s,s.length()));
    }
}
