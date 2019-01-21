import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 *
 * 示例 1:
 *
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 */

/*class Solution {
    public int maxProduct(String[] words) {
        List<Integer> list = new ArrayList<>();
        int len = words.length;
        for(int i = 0; i < len-1; i++){
            for(int j = i+1; j < len; j++){
                int flag = 0; //标记位，判断是否含有公共字母
                char[] data1 = words[i].toCharArray();
                char[] data2 = words[j].toCharArray();
                int len1 = data1.length;
                int len2 = data2.length;
                for(int m = 0; m < len1; m++){
                    for(int n = 0; n < len2; n++){
                        if(data1[m] == data2[n]){
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 1)
                        break;
                }
                if(flag == 1){
                    continue;
                }else{
                    list.add(len1 * len2);
                }
            }
        }
        int max = 0;
        for(int tmp : list){
            if(tmp > max)
                max = tmp;
        }
        return max;
    }
}*/

class Solution {
    public int maxProduct(String[] words) {
        /**
         全是小写字母, 可以用一个32为整数表示一个word中出现的字母,
         hash[i]存放第i个单词出现过的字母, a对应32位整数的最后一位,
         b对应整数的倒数第二位, 依次类推. 时间复杂度O(N^2)
         判断两两单词按位与的结果, 如果结果为0且长度积大于最大积则更新
         **/
        int n = words.length;
        int[] hash = new int[n];
        int max = 0;
        for(int i = 0; i < n; ++i) {
            for(char c : words[i].toCharArray())
                hash[i] |= 1 << (c-'a'); //把一个单词用数组表示出来，有该单词包含的字母的对应位置为1，其余为0
        }

        for(int i = 0; i < n-1; ++i) {
            for(int j = i+1; j < n; ++j) {
                if((hash[i] & hash[j]) == 0) //表示没有公共字母
                    max = Math.max(words[i].length() * words[j].length(), max);
            }
        }
        return max;
    }
}

public class Practice89 {
    public static void main(String[] args) {
        String[] data = new String[]{"a","aa","aaa","aaaa"};
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(data));
    }
}
