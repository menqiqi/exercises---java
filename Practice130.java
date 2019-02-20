/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素。
 *
 * 示例:
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 *
 * 说明:
 * 你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。
 */

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int x = matrix.length;
        int y = matrix.length;
        int len = x * y;
        int index = 0;
        int[] nums = new int[len];
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                nums[index++] = matrix[i][j];
            }
        }
        //插入排序（升序）
        for(int m = 1; m < len; m++){
            int key = nums[m];
            int end = m - 1;
            while(end >= 0 && nums[end] > key){
                nums[end+1] = nums[end];
                end--;
            }
            nums[end+1] = key;
        }
        return nums[k-1];
    }
}

public class Practice130 {
    public static void main(String[] args) {
        int[][] data = {{1,5,9},{10,11,13},{12,13,15}};
        Solution solution = new Solution();
        System.out.println(solution.kthSmallest(data,8));
    }
}
