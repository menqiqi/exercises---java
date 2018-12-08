/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 *
 * 注意：
 *
 * 你可以假设两个字符串均只含有小写字母。
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] data1 = ransomNote.toCharArray();
        char[] data2 = magazine.toCharArray();
        int flag = 0; //标记位，判断ransomNote的字符是否被找到
        for(int i = 0; i <data1.length; i++){
            flag = 0;
            for(int j = 0; j < data2.length; j++){
                if(data1[i] == data2[j]){
                    data2[j] = '0';
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                return false;
            }
        }
        return true;
    }
}

public class Practice38 {
    public static void main(String[] args) {
        String str1 = "aadf";
        String str2 = "aaeffdjk";
        Solution solution = new Solution();
        System.out.println(solution.canConstruct(str1,str2));
    }
}
