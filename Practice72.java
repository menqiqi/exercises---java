import java.util.Arrays;

/**
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 *
 * 返回重复了 N 次的那个元素。
 *
 *
 *
 * 示例 ：
 *
 * 输入：[1,2,3,3]
 * 输出：3
 */

class Solution {
    public int repeatedNTimes(int[] A) {
        int len = A.length;
        int N = len/2;
        Arrays.sort(A);
        for(int i = 0; i < len; i++){
            if(A[i] == A[i+N-1])
                return A[i];
        }
        return 0;
    }
}

public class Practice72 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = new int[]{2,1,3,3};
        System.out.println(solution.repeatedNTimes(data));
    }
}
