/**
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 *
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 *
 *     全部字母都是大写，比如"USA"。
 *     单词中所有字母都不是大写，比如"leetcode"。
 *     如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 *
 * 否则，我们定义这个单词没有正确使用大写字母。
 */

class Solution {
    public boolean detectCapitalUse(String word) {
        char[] data = word.toCharArray();
        int len = data.length;
        //只有一个字母
        if(len == 1){
            return true;
        }else{
            //单词的个数不为1
            //判断首字母是否大写
            if(data[0] >= 'A' && data[0] <= 'Z'){
                //判断剩余的字母
                for(int i = 1; i < len; i++){
                    //全大写或全小写都返回true
                    if(data[1] >= 'A' && data[1] <= 'Z'){
                        //剩余的都是大写返回true
                        if(data[i] >= 'a' && data[i] <= 'z')
                            return false;
                    }else{
                        if(data[i] >= 'A' && data[i] <= 'Z')
                            return false;
                    }
                }
            }else{
                //如果首字母小写，只有全小写才返回true
                for(int k = 1; k < len; k++){
                    if(data[k] >= 'A' && data[k] <= 'Z')
                        return false;
                }
            }
        }
        return true;
    }
}

public class Practice45 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.detectCapitalUse("G"));
        System.out.println(solution.detectCapitalUse("Good"));
        System.out.println(solution.detectCapitalUse("leetcode"));
        System.out.println(solution.detectCapitalUse("DWE"));
        System.out.println(solution.detectCapitalUse("iihJl"));
    }
}
