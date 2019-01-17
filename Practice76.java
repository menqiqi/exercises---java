/**
 * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
 *
 * 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
 *
 * 示例:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 */

class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] data1 = pattern.toCharArray();
        String[] data2 = str.split(" ");
        int len1 = data1.length;
        int len2 = data2.length;
        if(len1 != len2){
            return false;
        }
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len1; j++){
                if(data1[i]==data1[j]){
                    if(!(data2[i].equals(data2[j]))){
                        return false;
                    }
                }
                else if(data1[i]!=data1[j]){
                    if(data2[i].equals(data2[j]))
                        return false;
                }
            }
        }
        return true;
    }
}

public class Practice76 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordPattern("abab","dog dog dog dog"));
        System.out.println(solution.wordPattern("abba","cat dog dog cat"));
    }
}
