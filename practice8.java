package www.bit.java;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */

class Solution {
    public String reverseWords(String s) {
        char[] data = s.toCharArray();
        int len = data.length;
        int j = 0; //保存每个单词的首字母的位置
        for(int i = 0; i < len; i++){
            if(data[i] == ' '){
                reverse(j,i-1,data);
                j = i+1;
            }else if(i == len-1){ //最后一个单词，不以空格为结束标志，单独另写
                reverse(j,i,data);
            }
        }
        String str = new String(data);
        return str;
    }

    public char[] reverse(int first, int end,char[] data){
        while(end >= first){
            char tmp = data[first];
            data[first] = data[end];
            data[end] = tmp;
            first++;
            end--;
        }
        return data;
    }
}

public class practice8 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "Let's take leetcode context";
        System.out.println(solution.reverseWords(str));
    }
}
