package www.bit.java;

/**
 *不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 */

class Solution {
    public int getSum(int a, int b) {
        if((a & b) == 0){
            return a | b;
        }
        return getSum(a^b,(a&b)<<1);
    }
}

public class practice3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getSum(-2,10));
        System.out.println(solution.getSum(20,100));
    }
}
