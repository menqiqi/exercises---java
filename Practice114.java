/*
import java.util.ArrayList;
import java.util.List;

*/
/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *//*


//回溯法
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String str = "";
        generate(res,str,0,0,n);
        return res;
    }

    private void generate(List<String> res, String str, int count1, int count2, int n){
        //count1代表"("的个数，count2代表")"的个数
        if(count1 > n || count2 > n)
            return;
        if(count1 == n && count2 == n)
            res.add(str);
        if(count1 >= count2){
            String str1 = new String(str);
            generate(res,str+"(",count1+1,count2,n);
            generate(res,str1+")",count1,count2+1,n);
        }
    }
}

public class Practice114 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = solution.generateParenthesis(3);
        for (String str : list){
            System.out.println(str);
        }
    }
}
*/
