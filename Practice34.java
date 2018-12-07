/**
 * 编写一个程序判断给定的数是否为丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 */

//class Solution {
//    public boolean isUgly(int num) {
//        if(num < 1){
//            return false;
//        }
//        while(num % 2 == 0){
//            num = num/2;
//        }
//        while(num % 3 == 0){
//            num = num/3;
//        }
//        while(num % 5 == 0){
//            num = num/5;
//        }
//        if(num == 1 || num == 2 || num == 3 || num == 5){
//            return true;
//        }else{
//            return false;
//        }
//    }
//}
//
//public class Practice34 {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.isUgly(14));
//        System.out.println(solution.isUgly(8));
//    }
//}
