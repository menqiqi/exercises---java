/**
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 */

class Solution {
    public String convertToBase7(int num) {
        if(num == 0)
            return "0";
        String str = "";
        int flag = 1; //标记位，1代表正数，0代表负数
        if(num < 0){
            flag = 0;
            num = Math.abs(num);
        }
        while(num > 0){
            str = str + (num % 7) + "";
            num = num/7;
        }
        //负数计算出来的结果需要倒置一下
        char[] data = str.toCharArray();
        for(int i=0;i<str.length()/2;i++)
        {
            char tmp = data[i];
            data[i] = data[str.length()-1-i];
            data[str.length()-1-i] = tmp;
        }
        str = String.valueOf(data);
        if(flag == 0)
            return "-"+str;
        return str;
    }
}

public class Practice46 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertToBase7(-7));
        System.out.println(solution.convertToBase7(100));
    }
}
