/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0){
            return false;
        }
        if((n & (n-1)) == 0){
            return true;
        }else{
            return false;
        }
    }
}

public class Practice57 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfTwo(1));
        System.out.println(solution.isPowerOfTwo(32));
        System.out.println(solution.isPowerOfTwo(30));
    }
}
