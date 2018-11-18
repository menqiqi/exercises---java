package www.bit.java;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。
 */

class Solution {
    public String reverseString(String s) {
        char[] data1 = s.toCharArray();
        int len = data1.length;
        char[] data2 = new char[len];
        for(int i = 0; i < len; i++){
            data2[len-1-i] = data1[i];
        }
        String str = new String(data2);
        return str;
    }


}

public class practice2 {
    public static void main(String[] args) {
        String s = "I am a student";
        Solution solution = new Solution();
        System.out.println(solution.reverseString(s));
    }
}
