/**
 * 小田非常喜欢吃鱼，特别喜欢煎着吃。有一天她抓到了 n 条鱼，她有一个煎锅，
 * 每次可以同时煎 m 条鱼。这个煎锅可以花一分钟的时间煎熟鱼的一面，
 * 当一条鱼的两面都煎熟了它就可以吃了。
 * 现在她想知道最少需要花多少时间能够把所有的鱼都煎熟。
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Practice277 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0])*2;
        int m = Integer.parseInt(str[1]);
        if (n<=m){
            System.out.println(n/4);
            return;
        }
        if (n%m==0){
            System.out.println(n/m);
        }else{
            System.out.println((n/m)+1);
        }
    }
}

