import java.util.Arrays;

/**
 *  给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 *
 * 如果不能形成任何面积不为零的三角形，返回 0。
 *
 * 示例 1：
 *
 * 输入：[2,1,2]
 * 输出：5
 *
 * 示例 2：
 *
 * 输入：[1,2,1]
 * 输出：0
 */

class Solution {
    public int largestPerimeter(int[] A) {
        if(A.length < 3){
            return 0;
        }else{
            //数组包含的元素大于等于3的情况
            Arrays.sort(A);
            for(int i = A.length-1; i >= 2; i--){
                int sum = A[i] + A[i-1] + A[i-2];
                if((A[i-2]+A[i-1]) > A[i])
                    return sum;
            }
        }
        return 0;
    }
}

public class Practice110 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestPerimeter(new int[]{1,2,1}));
        System.out.println(solution.largestPerimeter(new int[]{2,1,2}));
    }
}
