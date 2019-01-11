import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
 *
 * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
 *
 * 返回所有不常用单词的列表。
 *
 * 您可以按任何顺序返回列表。
 *
 *
 *
 * 示例 ：
 *
 * 输入：A = "this apple is sweet", B = "this apple is sour"
 * 输出：["sweet","sour"]
 */

class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        String C = A + " " + B;
        String[] data = C.split(" ");
        List<String> list = new ArrayList<>();
        //先拼接，找出只出现过一次的单词
        for(int i = 0; i < data.length; i++){
            String tmp = data[i];
            int flag = 0;
            for(int j = 0; j < data.length; j++){
                if(tmp.equals(data[j]) && i!=j) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 0)
                list.add(tmp);
        }
        String[] res = new String[list.size()];
        for(int k = 0; k < list.size(); k++){
            res[k] = list.get(k);
        }
        return res;
    }
}

public class Practice71 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] res = solution.uncommonFromSentences("this apple is sweet","this apple is sour");
        for(String tmp : res)
            System.out.print(tmp+" ");
    }
}
