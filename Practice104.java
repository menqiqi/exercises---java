import java.util.Arrays;

/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *
 * 示例 ：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 */

class Solution {
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        for(int i = 0; i < len; i++){
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }
}

public class Practice104 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data1 = {-4,-1,0,3,10};
        int[] data2 = {-7,-3,2,3,11};
        int[] data3 = {0,1,4,20};
        solution.sortedSquares(data1);
        for (int tmp : data1){
            System.out.print(tmp+"、");
        }
        System.out.println();
        solution.sortedSquares(data2);
        for (int tmp : data2){
            System.out.print(tmp+"、");
        }
        System.out.println();
        solution.sortedSquares(data3);
        for (int tmp : data3){
            System.out.print(tmp+"、");
        }
        System.out.println();
    }
}
