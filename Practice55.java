/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 *
 * 示例 :
 *
 * 输入: "A"
 * 输出: 1
 */

//二十六进制转十进制
class Solution {
    public int titleToNumber(String s) {
        int len=s.length();
        int res=0;
        for(int i=0;i<len;i++){
            res+=Math.pow(26,len-1-i) * (s.charAt(i)-'A'+1);
        }
        return res;
    }
}

public class Practice55 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.titleToNumber("ABC"));
    }
}
