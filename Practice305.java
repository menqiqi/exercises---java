/**
 * 请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展 开。此时有1条折痕，突起的⽅向指向纸条的背⾯，这条折痕叫做“下”折痕 ；突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。如果每次都从下边向上⽅ 对折，对折N次。请从上到下计算出所有折痕的⽅向。
 *
 * 给定折的次数n,请返回从上到下的折痕的数组，若为下折痕则对应元素为"down",若为上折痕则为"up".
 */

import java.util.Scanner;

public class Practice305 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            String s=fold(n);
            char[] c=s.toCharArray();
            StringBuffer sb=new StringBuffer("[");
            for(int i=0;i<c.length;i++){
                if(c[i]=='0'){
                    sb.append("\""+"up"+"\"").append(",");
                }else{
                    sb.append("\""+"down"+"\"").append(",");
                }
            }
            System.out.println(sb.substring(0,sb.length()-1)+"]");
        }
        sc.close();
    }

    public static String fold(int n){
        String str="";
        if(n==1){
            str="1";
        }else{
            str=fold(n-1)+"1"+rotation(fold(n-1));
        }
        return str;
    }

    public static String rotation(String s){
        char[] c=s.toCharArray();
        String[] str=new String[c.length];
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<c.length;i++){
            str[i]=String.valueOf(c[c.length-1-i]);
            sb.append(String.valueOf(1-Integer.parseInt(str[i])));
        }
        return sb.toString();
    }
}
