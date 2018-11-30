package www.bit.java;

/**
 * 如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
 *
 * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
 *
 * 示例 :
 *
 * 输入:
 * matrix = [
 *   [1,2,3,4],
 *   [5,1,2,3],
 *   [9,5,1,2]
 * ]
 * 输出: True
 */

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix.length == 1 || matrix[0].length == 1){
            return true;
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] != matrix[i-1][j-1]){
                    return false;
                }
            }
        }
        return true;
    }
}

public class Practice22 {
    public static void main(String[] args) {
        int[][] A = new int[][]{
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}};
        Solution solution = new Solution();
        System.out.println(solution.isToeplitzMatrix(A));
    }
}
