import java.util.Scanner;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 */


class Replacement {
    public String replaceSpace(String iniString, int length) {
        // write code here
        String string = "";
        for(int i = 0; i < length; i++){
            if(iniString.substring(i,i+1).equals(" ")){
                string = string + "%20";
            }else{
                string = string + iniString.substring(i,i+1);
            }
        }
        return string;
    }
}

public class Practice245 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Replacement replacement = new Replacement();
        String str = in.nextLine();
        System.out.println(replacement.replaceSpace(str,str.length()));
    }
}
