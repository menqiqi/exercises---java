/**
 * 给定两个字符串, A 和 B。
 *
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
 *
 * 示例 :
 * 输入: A = 'abcde', B = 'cdeab'
 * 输出: true
 */

/*
class Solution {
    public boolean rotateString(String A, String B) {
        char[] data = A.toCharArray();
        int len = A.length();
        if(A.equals(B))
            return true;
        for(int i = 0; i < len; i++){
            //旋转
            char tmp = data[0];
            //全体前移一位
            for(int j = 1; j < len; j++){
                data[j-1] = data[j];
            }
            data[len-1] = tmp;
            String str = new String(data);
            if(str.equals(B))
                return true;
        }
        return false;
        //return (A.length()==B.length()) && (A+A).contains(B);
    }
}

public class Practice64 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rotateString("acdfe","dfeca"));
        System.out.println(solution.rotateString("",""));
    }
}
*/
