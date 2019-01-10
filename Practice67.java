/**
 * 我们要把给定的字符串 S 从左到右写到每一行上，每一行的最大宽度为100个单位，如果我们在写某个字母的时候会使这行超过了100 个单位，那么我们应该把这个字母写到下一行。我们给定了一个数组 widths ，这个数组 widths[0] 代表 'a' 需要的单位， widths[1] 代表 'b' 需要的单位，...， widths[25] 代表 'z' 需要的单位。
 *
 * 现在回答两个问题：至少多少行能放下S，以及最后一行使用的宽度是多少个单位？将你的答案作为长度为2的整数列表返回。
 *
 * 示例 :
 * 输入:
 * widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * S = "abcdefghijklmnopqrstuvwxyz"
 * 输出: [3, 60]
 * 解释:
 * 所有的字符拥有相同的占用单位10。所以书写所有的26个字母，
 * 我们需要2个整行和占用60个单位的一行。
 */

class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        char[] data = S.toCharArray();
        int len = data.length;
        int line = 1; //所需的行数
        int tmp = 0;
        for(int i = 0; i < len; i++){
            tmp = tmp + widths[data[i]-'a'];
            if(tmp > 100){
                line++;
                tmp = widths[data[i]-'a'];
            }
        }
        int[] res = new int[]{line,tmp};
        return res;
    }
}

public class Practice67 {
    public static void main(String[] args) {
        int[] widths = new int[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String str = "abcdefghijklmnopqrstuvwxyz";
        Solution solution = new Solution();
        int[] res = solution.numberOfLines(widths,str);
        for(int tmp : res)
            System.out.println(tmp);
    }
}
