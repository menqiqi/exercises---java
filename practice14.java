package www.bit.java;

/**
 *  我们把符合下列属性的数组 A 称作山脉：
 *
 *  A.length >= 3
 *  存在0<i<A.length-1使得A[0]<A[1]<...A[i-1]<A[i]>A[i+1]>...>A[A.length-1]
 *
 * 给定一个确定为山脉的数组，返回任何满足 A[0]<A[1]<...A[i-1]<A[i]>A[i+1]>...>A[A.length-1]的i的值。
 */

class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int len = A.length;
        int i = 1;
        for(i = 1; i < len-1; i++){
            if((A[i] > A[i-1]) && (A[i] > A[i+1])){
                return i;
            }
        }
        return i;
    }
}

public class practice14 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = new int[]{0,2,1,0};
        System.out.println(solution.peakIndexInMountainArray(A));
    }
}
