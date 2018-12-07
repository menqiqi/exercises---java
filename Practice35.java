/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 */

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0){
            return false;
        }
        while(n % 3 == 0){
            n = n/3;
        }
        if(n == 1){
            return true;
        }
        return false;
    }
}

public class Practice35 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfThree(9));
        System.out.println(solution.isPowerOfThree(15));
    }
}
