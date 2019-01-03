/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 :
 *
 * 输入: 2
 * 输出: [0,1,1]
 */

class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i = 0; i <= num; i++){
            int tmp = i;
            int count = 0;
            while(tmp != 0){
                count++;
                tmp = tmp & (tmp-1);
            }
            res[i] = count;
        }
        return res;
    }
}

public class Practice59 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res1 = solution.countBits(2);
        for(int tmp : res1)
            System.out.print(tmp+" ");
        System.out.println();
        int[] res2 = solution.countBits(9);
        for(int tmp : res2)
            System.out.print(tmp+" ");
    }
}
