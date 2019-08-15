/**
 * 实现Auto函数
 */

public class Practice341 {
    public static void main(String[] args) {

        String str1 = " +0 1233";
        String str2 = "-91283472332";
        int a = myAtoi(str1);
        int b = myAtoi(str2);
        System.out.println(a);
        System.out.println(b);
    }

    public static int myAtoi(String str) {
        String s = str.trim();
        if(s.equals(""))
            return 0;
        int n = s.length();
        String start = s.charAt(0)+"";
        if((!start.equals("-")) && (!start.equals("+")) && (s.charAt(0) < '0' || s.charAt(0) > '9')) {
            return 0;
        }
        for(int i = 1; i < n; i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
                start+=s.charAt(i);
            else
                break;
        }
        if(start.length()==1 && (start.charAt(0) < '0' || start.charAt(0) > '9'))
            return 0;
        boolean flag = true;  //代表正数
        String res = start;
        if(start.charAt(0) == '-'){
            flag = false;  //负数
        }
        int a = 0;
        if(flag){
            try{
                a = Integer.parseInt(res);
            }catch(NumberFormatException e){
                return Integer.MAX_VALUE;
            }
        }else{
            try{
                a = Integer.parseInt(res);
            }catch(NumberFormatException e){
                return Integer.MIN_VALUE;
            }
        }
        return a;
    }
}
