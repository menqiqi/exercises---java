package www.like.java;

//给定一个 32 位有符号整数，将整数中的数字进行反转

class Solution {
    public int reverse(int x) {
        int i = 0;
        while(x != 0){
            int tmp = i*10 + x%10;
            if(tmp/10 != i){
                return 0;
            }
            i = tmp;
            x = x / 10;
        }
        return i;
    }
}


public class exercise1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(120));
    }
}
