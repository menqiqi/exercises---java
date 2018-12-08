/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母
 */

class Solution {
    public char findTheDifference(String s, String t) {
        char[] data1 = s.toCharArray();
        char[] data2 = t.toCharArray();
        for(int i = 0; i < data1.length; i++){
            for(int j = 0; j < data2.length; j++){
                if(data1[i] == data2[j]){
                    data2[j] = '0';
                    break;
                }
            }
        }
        for(int k = 0; k < data2.length; k++){
            if(data2[k] != '0')
                return data2[k];
        }
        return '0';
    }
}

public class Practice39 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTheDifference("abdfr","tbarde"));
    }
}
