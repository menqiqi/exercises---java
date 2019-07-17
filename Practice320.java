/**
 * 空格替换
 * 输入一个字符串，将字符串中所有空格替换为“%20”
 */

import java.util.*;

public class Replacement {
    public String replaceSpace(String iniString, int length) {
        // write code here
        String str = "";
        for(int i = 0; i < length; i++){
            if(iniString.charAt(i) == ' '){
                str = str + "%20";
            }else{
                str = str + iniString.charAt(i);
            }
        }
        return str;
    }
}