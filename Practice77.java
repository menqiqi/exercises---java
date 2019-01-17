/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 :
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 */

class Solution {
    public boolean isIsomorphic(String s, String t) {
        for(int i = 0; i < s.length()-1; i++){
            for(int j = i+1; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(t.charAt(i) != t.charAt(j))
                        return false;
                }else{
                    if(t.charAt(i) == t.charAt(j))
                        return false;
                }
            }
        }
        return true;
    }
}

public class Practice77 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isIsomorphic("paper","title"));
        System.out.println(solution.isIsomorphic("foo","bar"));

    }
}
