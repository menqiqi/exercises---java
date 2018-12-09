/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 */

class Solution {
    public int longestPalindrome(String s) {
        char[] data = s.toCharArray();
        int len = data.length;
        char[] res = new char[len];
        int k = 0;
        for(int i = 0; i < len; i++){
            for(int j = i+1; j < len; j++){
                if(data[i] == data[j] && data[i] != '0'){
                    res[k] = data[i];
                    res[len-1-k] = res[k];
                    k++;
                    data[i] = '0';
                    data[j] = '0';
                    break;
                }
            }
        }
        int count = 0;
        for(int n = 0; n < res.length; n++){
            if(res[n] <= 'Z' && res[n] >='A' || res[n] <='z' && res[n] >='a'){
                count++;
            }
        }
        //判断是否所有的字符都已经在构造的回文字符数组中。
        // 若还有多余的数，挑选一个放在数组的中间，构成最长回文数组
        if(count < len)
            return count+1;
        return count;
    }
}

public class Practice41 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("abccccdd"));
    }
}
