package www.bit.java;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意：0 ≤ x, y < 231.
 */

class Solution {
    public int hammingDistance(int x, int y) {
        //异或运算，相同为0，不同为1
        //z中1的个数就是不同的位置的个数
        int z = x ^ y;
        int count = 0;
        while(z != 0){
            z = z&(z-1);
            count++;
        }
        return count;
    }
}

public class practice5 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println( solution.hammingDistance(1,4));
        System.out.println( solution.hammingDistance(-1,0));
    }
}
