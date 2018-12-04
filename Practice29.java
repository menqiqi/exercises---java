/**
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等
 */

class Solution {
    public boolean hasAlternatingBits(int n) {
        int tmp = -1;
        int cur = 0;
        while(n != 0){
            cur = n & 1;
            if(tmp == cur) {
                return false;
            }
            tmp = n & 1;
            n = n >> 1;
        }
        return true;
    }
}

public class Practice29 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasAlternatingBits(5));
    }
}
