package www.bit.java;

/**
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 *
 * 注意:
 *
 *     给定的整数保证在32位带符号整数的范围内。
 *     你可以假定二进制数不包含前导零位。
 */

class Solution {
    public int findComplement(int num) {
        int i = 0;
        int j = 1;
        int res = 0;
        while(i < 32){
            //最多只有32位
            i++;
            if((1 & num) == 0){
                res += j;
            }
            j = j*2;
            if(num == 1){
                break;
            }
            num = num>>1;
        }
        return res;
    }
}

public class practice6 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findComplement(5));
        System.out.println(solution.findComplement(-1));
    }
}
