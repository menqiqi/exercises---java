/**
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 *
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。
 * 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 *
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 */

class Solution {
    public boolean isMonotonic(int[] A) {
        if(A == null || A.length <= 2) return true;

        return UP(A) || Down(A);
    }

    public boolean UP(int[] A) {
        int length = A.length;
        for(int i = 0; i < length - 1; i++) {
            if(A[i] > A[i + 1])
                return false;
        }
        return true;
    }

    public boolean Down(int []A) {
        int length = A.length;
        for(int i = 0; i < length - 1; i++) {
            if(A[i] < A[i + 1])
                return false;
        }
        return true;
    }
}

public class Practice31 {
    public static void main(String[] args) {
        int[] data = new int[]{1,1,0};
        Solution solution = new Solution();
        System.out.println(solution.isMonotonic(data));
    }
}
