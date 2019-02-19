/**
 *给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 :
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 */

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int flag = 0;

        for(; i >= 0 || j >= 0; i--,j--){
            int a1 = i >= 0 ? a.charAt(i)-'0' : 0;
            int b1 = j >= 0 ? b.charAt(j)-'0' : 0;
            int tmp = a1 + b1 + flag;
            if (tmp < 2){
                sb.append(tmp+"");
                flag = 0;
            }else if (tmp == 2){
                sb.append("0");
                flag = 1;
            }else{
                sb.append("1");
                flag = 1;
            }

        }
        if (flag == 1){
            sb.append("1");
        }
        return String.valueOf(sb.reverse());
    }
}

public class Practice127 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("11","1"));

    }

}
