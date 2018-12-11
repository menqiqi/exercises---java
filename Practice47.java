/**
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。
 * 如果剩余少于 k 个字符，则将剩余的所有全部反转。
 * 如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 */

class Solution {
    public String reverseStr(String s, int k) {
        char[] data = s.toCharArray();
        int len = data.length;
        int index = 0;
        while(index < len){
            //只要分为字符少于k和大于k即可
            if((len - index) > k){
                //反转前k个字符
                for(int i = index,j = index+k-1; i < j; i++,j--){
                    char tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                }
                index = index + 2*k;
            }else{
                //全部反转
                for(int i = index,j = len-1; i < j; i++,j--){
                    char tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                }
                index = len;
            }
        }
        return String.valueOf(data);
    }
}

public class Practice47 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseStr("abcdefg",3));
    }
}
