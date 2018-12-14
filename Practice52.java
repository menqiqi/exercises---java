/**
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择任意 x 满足 -K <= x <= K，并将 x 加到 A[i] 中。
 *
 * 在此过程之后，我们得到一些数组 B。
 *
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 *
 * 示例 ：
 *
 * 输入：A = [0,10], K = 2
 * 输出：6
 * 解释：B = [2,8]
 *
 * 示例 ：
 *
 * 输入：A = [1,3,6], K = 3
 * 输出：0
 * 解释：B = [3,3,3] 或 B = [4,4,4]
 */

class Solution {
    public int smallestRangeI(int[] A, int K) {
        //判断数组的最大值与最小值的差是不是小于2k，如果小于，那么在和x运算之后一定会相等，否则，结果就为max-min-2k
        int len = A.length;
        if(len == 1)
            return 0;
        int[] res = new int[len];
        int min = A[0];
        int max = A[0];
        for(int i = 0; i < len; i++){
            if(A[i] < min)
                min = A[i];
            if(A[i] > max)
                max = A[i];
        }
        if((max - min) < 2*K){
            return 0;
        }else{
            return max - min - 2 * K;
        }

    }
}

public class Practice52 {
    public static void main(String[] args) {
        int[] data = new int[]{1,3,6};
        Solution solution = new Solution();
        System.out.println(solution.smallestRangeI(data,3));
    }
}
