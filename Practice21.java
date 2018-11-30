package www.bit.java;

/**
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 *
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 *
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 *
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 示例 :
 *
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 * 输出:
 * [[1,2,3,4]]
 * 解释:
 * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
 */

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        //行
        int row = nums.length;
        //列
        int col = nums[0].length;
        if(row*col != r*c){
            return nums;
        }
        int[][] res = new int[r][c];
        int[] tmp = new int[row*col];
        int k = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                tmp[k] = nums[i][j];
                k++;
            }
        }
        k = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                res[i][j] = tmp[k];
                k++;
            }
        }
        return res;
    }
}

public class Practice21 {
    public static void main(String[] args) {
        int[][] A = new int[][]{{1,2,5,6},{3,4,7,8}};
        Solution solution = new Solution();
        int[][] res = solution.matrixReshape(A,4,2);
        for(int i = 0; i < res.length; i++){
            for(int j = 0; j < res[0].length; j++){
                System.out.print(res[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
