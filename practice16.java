package www.bit.java;

/**
 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 */

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int len = A.length;
        int[] res = new int[len];
        int index = 0;
        for(int i = 0; i < len; i++){
            if(A[i]%2 == 0){
                res[index] = A[i];
                index++;
            }
        }
        for(int i = 0; i < len; i++){
            if(A[i]%2 != 0){
                res[index] = A[i];
                index++;
            }
        }
        return res;
    }
}

public class practice16 {
    public static void main(String[] args) {
        int[] A = new int[]{1,3,2,4};
        Solution solution = new Solution();
        int[] B = solution.sortArrayByParity(A);
        for(int num:B){
            System.out.println(num);
        }
    }
}
