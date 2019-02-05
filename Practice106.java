import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 你将得到一个字符串数组 A。
 *
 * 如果经过任意次数的移动，S == T，那么两个字符串 S 和 T 是特殊等价的。
 *
 * 一次移动包括选择两个索引 i 和 j，且 i％2 == j％2，并且交换 S[j] 和 S [i]。
 *
 * 现在规定，A 中的特殊等价字符串组是 A 的非空子集 S，这样不在 S 中的任何字符串与 S 中的任何字符串都不是特殊等价的。

 *
 * 返回 A 中特殊等价字符串组的数量。
 *
 * 示例 ：
 *
 * 输入：["abc","acb","bac","bca","cab","cba"]
 * 输出：3
 * 解释：3 组 ["abc","cba"]，["acb","bca"]，["bac","cab"]
 *
 */


/**
 * 解题思路：
 *
 * 题目可以让在 偶数位置的 chars 互换， 也可以让 在 奇数位置的 chars 互换。
 *
 * 　所以为了 return 正确的 group 数量，需要把 那些重复的 给排除掉。
 *
 * 　可以把在 偶数位置的 chars 都拿出来 组成一个 string a， 同样的把 在奇数位置上的 chars 都拿出来组成一个 string b，分别把a 和 b 排序一下，再把两个a 和 b组合并且存入 HashSet。
 *
 * 　最后只要返回 HashSet 的 size 就可以了。
 */

class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> seen = new HashSet<>();
        for(String str: A)
        {
            String evenStr = "";
            String oddStr = "";
            for(int i = 0; i < str.length(); i++)
            {
                if(i % 2 == 0) // even index
                {
                    evenStr += str.charAt(i);
                }
                else // odd index
                {
                    oddStr += str.charAt(i);
                }
            }

            seen.add(sortString(evenStr) + sortString(oddStr));

        }

        return seen.size();
    }

    private String sortString(String s)
    {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}

public class Practice106 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] data = {"abc","acb","bac","bca","cab","cba"};
        System.out.println(solution.numSpecialEquivGroups(data));
    }
}
