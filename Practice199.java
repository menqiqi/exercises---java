/**
 * 现有一个小写英文字母s和一个包含较短小写英文字母的数组p，判断数组中的每一个属性是否为s的子串。
 *
 * 输入描述：
 * 第一行输入较短小写英文字母p，第二行输入数组的长度n，第三行输入较长英文字母s
 *
 * 输出描述：
 * 输出一个布尔型数组，每个元素代表对应位置上的字符串是否为s的子串
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Substr {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] res = new boolean[n];
        int index = 0;
        for(int i = 0; i < n; i++){
            //判断每一个p[i]是否为s的子串
            //StringBuilder sb = new StringBuilder(s);
            if(s.contains(p[i])){
                res[index++] = true;
            }else {
                res[index++] = false;
            }
        }
        return res;
    }
}


public class Practice199 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] p = bf.readLine().split(" ");
        int n = Integer.parseInt(bf.readLine());
        String s = bf.readLine();
        Substr substr = new Substr();
        boolean[] res = substr.chkSubStr(p,n,s);
        for (boolean t : res)
            System.out.print(t+" ");
    }
}
