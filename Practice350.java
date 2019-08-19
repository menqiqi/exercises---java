/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 */

public class Practice350 {
    public static void main(String[] args) {
        int res1 = strStr("hello","ll");
        int res2 = strStr("aaaaa","bba");
        int res3 = strStr("","");
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }

    public static int strStr(String haystack, String needle) {
        if (needle.equals(""))
            return 0;
        if (!haystack.contains(needle)) {
            return -1;
        }else {
            int n = needle.length();
            char c = needle.charAt(0);
            for(int i = 0; i < haystack.length(); i++){
                if (haystack.charAt(i) == c){
                    int j = 1;
                    for (j = 1; j < n; j++){
                        if (haystack.charAt(i+j) != needle.charAt(j))
                            break;
                    }
                    if (j == n)
                        return i;
                }
            }
        }
        return -1;
    }
}
