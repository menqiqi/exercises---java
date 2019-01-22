import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 *
 * 输入: S = "12345"
 * 输出: ["12345"]
 *
 * 注意：
 *
 *     S 的长度不超过12。
 *     S 仅由数字和字母组成。
 */

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        char[] data = S.toCharArray();
        bkteace(data,list,new StringBuilder(),0);
        return list;
    }
    private void bkteace(char[] s,List<String> list,StringBuilder sb,int k){
        if(k == s.length){
            list.add(sb.toString());
            return;
        }
        char c = s[k];
        if((c>='a'&&c<='z') || (c>='A'&&c<='Z')){
            sb.append(Character.toLowerCase(c));
            bkteace(s,list,sb,k+1);
            sb.deleteCharAt(sb.length()-1);  //删除char在这个序列中的指定位置

            sb.append(Character.toUpperCase(c));
            bkteace(s,list,sb,k+1);
            sb.deleteCharAt(sb.length()-1);
        }else{
            sb.append(c);
            bkteace(s,list,sb,k+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

public class Practice92 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        String S = "a1b2";
        List<String> list = new ArrayList<>();
        list = solution.letterCasePermutation(S);
        for(String tmp : list)
            System.out.println(tmp);
    }
}
