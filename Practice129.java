class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length()-1;
        int len2 = num2.length()-1;
        int flag = 0;  //进位
        StringBuilder sb = new StringBuilder();
        while(len1 >= 0 || len2 >= 0){
            int a = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
            int b = len2 >= 0 ? num2.charAt(len2) - '0' : 0;
            int tmp = a + b + flag;
            if(tmp <= 9){
                sb = sb.append(tmp+"");
                flag = 0;
                len1--;
                len2--;
            }else{
                sb = sb.append((tmp%10)+"");
                flag = tmp/10;
                len1--;
                len2--;
            }
        }

        if (flag > 0)
            sb = sb.append(flag+"");
        return String.valueOf(sb.reverse());
    }
}

public class Practice129 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addStrings("999","1"));
    }
}