/**
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 */

class Solution {
    public boolean isPowerOfFour(int num) {
        if(num <= 0)
            return false;
        //先判断是否为2的次幂，再判断是否为4的次幂
        //2的次幂的特点：4->100  8->1000
        //100 & 011 = 0    1000 & 0111 = 0
        if((num & num-1) != 0)
            return false;
        //4的次幂的特点：4->100  16->10000
        //1后面加上偶数个0,1的位数一定是奇数位
        //01010101010101010101010101010101
        //00000000000000000000000000000100
        //将4的幂和该数相与的结果一定还是这个数
        if((num & 0x55555555) == num)
            return true;
        return false;
    }
}

public class Practice37 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfFour(64));
        System.out.println(solution.isPowerOfFour(20));
    }
}
