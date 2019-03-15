/**
 * 给一个数组A，求出B数组。
 * 要求：
 * B[i] = A[0]*A[i]*...*A[i-1]*A[i+1]*...
 * 不可以用除法
 */

import java.util.ArrayList;
class Solution {
    public int[] multiply(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        for(int i = 0; i < len; i++){
            int tmp = 1;
            for(int j = 0; j < len; j++){
                   if(j != i) {
                       tmp = tmp * A[j];
                   }
            }
            B[i] = tmp;
        }
        return B;
    }
}

public class Practice174 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {1,2,3,5,7};
        int[] B = solution.multiply(A);
        for (int tmp : B)
            System.out.print(tmp+" ");
    }
}
