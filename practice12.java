package www.bit.java;

/**
 * 给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
 *
 * 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
 *
 * 山羊拉丁文的规则如下：
 *
 *     如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
 *     例如，单词"apple"变为"applema"。
 *
 *     如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 *     例如，单词"goat"变为"oatgma"。
 *
 *     根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
 *     例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
 *
 * 返回将 S 转换为山羊拉丁文后的句子。
 *
 * 示例 :
 *
 * 输入: "I speak Goat Latin"
 * 输出: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 */

class Solution {
    public String toGoatLatin(String S) {
        //将字符串转为字符串数组
        String[] data = S.split(" ");
        String num = "";
        for(int i = 0; i < data.length; i++){
            //获取最后加字母‘a’的个数
            String zimu = "a";
            num = num+zimu;
            //获取字符串的首字母
            if(data[i].charAt(0) == 'a' || data[i].charAt(0) == 'e' || data[i].charAt(0) == 'i' || data[i].charAt(0) == 'o' || data[i].charAt(0) == 'u'|| data[i].charAt(0) == 'A' || data[i].charAt(0) == 'E' || data[i].charAt(0) == 'I' || data[i].charAt(0) == 'O' || data[i].charAt(0) == 'U'){
                data[i] = data[i]+"ma"+num;
            }else{
                //将第一个字符移动到末尾
                char[] tmp = data[i].toCharArray();
                char c = tmp[0];
                for(int j = 0; j < tmp.length-1; j++){
                    tmp[j] = tmp[j+1];
                }
                tmp[tmp.length-1] = c;
                String str = new String(tmp);
                str = str+"ma"+num;
                data[i] = str;
            }
        }
        String res = "";
        for(int m = 0; m < data.length; m++){
            if(m == (data.length-1)){
                res = res + data[m];
            }else{
                res = res + data[m] + " ";
            }
        }
        return res;
    }
}

public class practice12 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.toGoatLatin("I speak Goat Latin"));
    }
}
