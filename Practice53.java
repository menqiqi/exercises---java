/**
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 * 示例 ：
 *
 * 输入："ab-cd"
 * 输出："dc-ba"
 */

class Solution {
    public String reverseOnlyLetters(String S) {
        char[] data = S.toCharArray();
        int len = data.length;
        char[] res = new char[len]; //最终结果的数组
        int count = 0; //记录字母的个数
        for(int i = 0; i < len; i++){
            if(!(data[i] <= 'z' && data[i] >= 'a' || (data[i] <= 'Z' && data[i] >= 'A'))){
                res[i] = data[i];
            }else{
                count++;
            }
        }
        char[] tmp = new char[count]; //只存储字母
        int k = 0;
        for(int i = 0; i < len; i++){
            if((data[i] <= 'z' && data[i] >= 'a' || (data[i] <= 'Z' && data[i] >= 'A')))
                tmp[k++] = data[i];
        }
        k = 0;
        for(int i = len-1; i >= 0; i--){
            if(res[i] == 0){
                res[i] = tmp[k++];
            }
        }
        String str = String.valueOf(res);
        return str;
    }
}

public class Practice53 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseOnlyLetters("A--sfd+NK!!!"));
    }
}
