/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String str = strs[0];
        for(int i = 1; i < strs.length; i++){
            //indexOf返回指定字符串第一次出现的索引
            while(strs[i].indexOf(str) != 0){
                str = str.substring(0,str.length()-1);
            }
            if(str.isEmpty())
                return "";
        }
        return str;
    }
}

public class Practice116 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{""}));
        System.out.println(solution.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
