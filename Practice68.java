import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 *
 * 示例 1:
 *
 * 输入: S = "loveleetcode", C = 'e'
 * 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 *
 * 说明:
 *
 *     字符串 S 的长度范围为 [1, 10000]。
 *     C 是一个单字符，且保证是字符串 S 里的字符。
 *     S 和 C 中的所有字母均为小写字母。
 */

class Solution {
    public int[] shortestToChar(String S, char C) {
        char[] data = S.toCharArray();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < data.length; i++){
            if(data[i] == C)
                list.add(i);
        }
        int[] res = new int[data.length];
        int k = 0; //下标
        for(int i = 0; i < data.length; i++){
            int min = 0;
            if(list.get(0)-i > 0){
                min = list.get(0) - i;
            }else{
                min = i - list.get(0);
            }
            for(int j = 0; j < list.size(); j++){
                int tmp = 0;
                if(list.get(j)-i > 0){
                    tmp = list.get(j) - i;
                }else{
                    tmp = i - list.get(j);
                }
                if(min > tmp)
                    min = tmp;
            }
            res[k++] = min;
        }
        return res;
    }
}

public class Practice68 {
    public static void main(String[] args) {
        Solution solution = new Solution();
       for(int tmp : solution.shortestToChar("loveleetcode",'e'))
           System.out.print(tmp+" ");
    }
}
