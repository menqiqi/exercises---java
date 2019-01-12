/**
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 *
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 *
 *     如果 S[i] == "I"，那么 A[i] < A[i+1]
 *     如果 S[i] == "D"，那么 A[i] > A[i+1]
 *
 *
 *
 * 示例 ：
 *
 * 输出："IDID"
 * 输出：[0,4,1,3,2]
 */

class Solution {
    public int[] diStringMatch(String S) {
        int a = 0;
        int b = S.length();
        int[] A = new int[S.length()+1];
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == 'I'){
                A[i] = a++;
                if(i == S.length()-1){
                    A[i+1] = a++;
                }
            }
            if(S.charAt(i) == 'D'){
                A[i] = b--;
                if(i == S.length()-1){
                    A[i+1] = b--;
                }
            }
        }
        return A;
    }
}

public class Practice73 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "IDID";
        int[] res = solution.diStringMatch(str);
        for(int tmp : res)
            System.out.print(tmp + " ");
    }
}
